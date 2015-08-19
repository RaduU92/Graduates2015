package com.endava.rursu.controller;

import com.endava.rursu.model.Node;
import com.endava.rursu.service.NodeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
//@RequestMapping("/node")
@RequestMapping("/")
public class NodeController {

    @Autowired
    private NodeService nodeService;

    @Autowired
    private ObjectMapper objectMapper;

    @RequestMapping(method = RequestMethod.GET)
    public String printWelcome(ModelMap model) {
        model.addAttribute("message", "Hello world!");
        return "hello";
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public String insert(ModelMap model, @RequestBody String json) throws IOException {
        Map<String, Object> jsonMap = objectMapper.readValue(json, Map.class);
        Node root = nodeService.getRoot();
        if (root == null) {
            nodeService.insertNode(new Node(objectMapper.writeValueAsString(jsonMap.get("json")), null, new ArrayList<Node>()));
        } else {
            if (jsonMap.get("parentId") != null) {
                nodeService.insertNode(new Node(objectMapper.writeValueAsString(jsonMap.get("json")), nodeService.getNode((Integer) jsonMap.get("parentId")), new ArrayList<Node>()));
            } else {
                nodeService.insertNode(new Node(objectMapper.writeValueAsString(jsonMap.get("json")), root, new ArrayList<Node>()));
            }
        }
        String message = "Inserted node with json: " + objectMapper.writeValueAsString(jsonMap.get("json")) + " and parrent id: " + jsonMap.get("parentId");
        model.addAttribute("message", message);
        return "insertNode";
    }

    @RequestMapping(value = "/select/{id}", method = RequestMethod.GET)
    public String select(ModelMap model, @PathVariable("id") int nodeId) {
        Node node = nodeService.getNode(nodeId);
        String message = "id: " + node.getId() + " , json: " + node.getJson();
        model.addAttribute("message", message);
        return "showNode";
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public String update(ModelMap model, @RequestBody String json) throws IOException {
        Map<String, Object> jsonMap = objectMapper.readValue(json, Map.class);
        nodeService.updateNodeInfo((Integer) jsonMap.get("id"), objectMapper.writeValueAsString(jsonMap.get("json")));
        String message = "Updated node with id: " + jsonMap.get("id");
        model.addAttribute("message", message);
        return "updateNodeInfo";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public String delete(ModelMap model, @RequestBody String json) throws IOException {
        Map<String, Object> jsonMap = objectMapper.readValue(json, Map.class);
        nodeService.deleteNode((Integer) jsonMap.get("id"));
        String message = "Deleted node with id: " + jsonMap.get("id");
        model.addAttribute("message", message);
        return "deleteNode";
    }

    @RequestMapping(value = "/getChildrens/{id}", method = RequestMethod.GET)
    public String getChildrens(ModelMap model, @PathVariable("id") int nodeId) {
        List<Node> nodes = nodeService.getChildrensOfNode(nodeId);
        String message = "Copii nodului cu id-ul " + nodeId + " sunt:\n<ul>";
        for (Node n : nodes) {
            message += "<li>id: " + n.getId() + " , json:" + n.getJson() + "</li>";
        }
        message += "</ul>";
        model.addAttribute("message", message);
        return "getChildrensOfNode";
    }

    @RequestMapping(value = "/getParent/{id}", method = RequestMethod.GET)
    public String getParent(ModelMap model, @PathVariable("id") int nodeId) {
        String message;
        if (nodeService.getNode(nodeId).getId() == nodeService.getRoot().getId()) {
            message = "Acesta este nodul radacina si nu are parinte!";
        } else {
            Node node = nodeService.getParent(nodeId);
            message = "Parintele nodului cu id-ul " + nodeId + " are id-ul: " + node.getId() + " si informatia: " + node.getJson();
        }
        model.addAttribute("message", message);
        return "getParent";
    }

    @RequestMapping(value = "/getRoot", method = RequestMethod.GET)
    public String getRoot(ModelMap model) {
        Node root = nodeService.getRoot();
        String message = "Nodul radacina are urmatoarele informatii: id: " + root.getId() + ", json: " + root.getJson();
        model.addAttribute("message", message);
        return "getRoot";
    }

    @RequestMapping(value = "/updateParent", method = RequestMethod.PUT)
    public String updateParent(ModelMap model, @RequestBody String json) throws IOException {
        Map<String, Object> jsonMap = objectMapper.readValue(json, Map.class);
        nodeService.updateParentOfNode((Integer) jsonMap.get("id"), (Integer) jsonMap.get("parentId"));
        String message = "Updated parent of node with id: " + jsonMap.get("id");
        model.addAttribute("message", message);
        return "updateParent";
    }

    @RequestMapping(value = "/bottomUpConfig/idB={idB}&idU={idU}", method = RequestMethod.GET)
    public String bottomUpConfig(ModelMap model, @PathVariable("idB") int bottomNodeId, @PathVariable("idU") int upNodeId) {
        List<Node> nodes = nodeService.fetchBottomUpConfiguration(bottomNodeId, upNodeId);
        String message = "Configuratia bottom-up:\n<ul>";
        for (Node n : nodes) {
            message += "<li>id: " + n.getId() + " , json:" + n.getJson() + "</li>";
        }
        message += "</ul>";
        model.addAttribute("message", message);
        System.out.println("bottom: " + bottomNodeId + " , up: " + upNodeId);
        return "bottomUpConfig";
    }

    @RequestMapping(value = "/topDownConfig/idT={idT}&idD={idD}", method = RequestMethod.GET)
    public String topDownConfig(ModelMap model, @PathVariable("idT") int topNodeId, @PathVariable("idD") int downNodeId) {
        List<Node> nodes = nodeService.fetchTopDownConfiguration(topNodeId, downNodeId);
        String message = "Configuratia top-down:\n<ul>";
        for (Node n : nodes) {
            message += "<li>id: " + n.getId() + " , json:" + n.getJson() + "</li>";
        }
        message += "</ul>";
        model.addAttribute("message", message);
        System.out.println("top: " + topNodeId + " , down: " + downNodeId);
        return "topDownConfig";
    }
}