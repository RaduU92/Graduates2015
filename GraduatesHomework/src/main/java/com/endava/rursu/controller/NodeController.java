package com.endava.rursu.controller;

import com.endava.rursu.model.Node;
import com.endava.rursu.service.NodeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
//@Controller
//@RequestMapping("/node")
@RequestMapping("/")
public class NodeController {
    public static final String APPLICATION_JSON = "application/json";
    @Autowired
    private NodeService nodeService;

    @Autowired
    private ObjectMapper objectMapper;

    @RequestMapping(method = RequestMethod.GET)
    public String printWelcome() {
        return "{\"message\" : \"Hello World!\"}";
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
        return "{\"message\" : \"Inserted new node.\"}";
    }

    @RequestMapping(value = "/select/{id}", method = RequestMethod.GET, produces = APPLICATION_JSON)
    @ResponseBody
//    public String select(ModelMap model, @PathVariable("id") int nodeId) {
    public Map<String, String> select(@PathVariable("id") int nodeId) throws IOException {
//    public Node select(@PathVariable("id") int nodeId) throws IOException {
        Node node = nodeService.getNode(nodeId);
        Map map = objectMapper.readValue(node.getJson(), Map.class);
        map.put("nodeId: ", node.getId());
        if (node.getParent() != null) {
            map.put("parentId: ", node.getParent().getId());
        } else {
            map.put("parentId: ", null);
        }
        return map;
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public String update(@RequestBody String json) throws IOException {
        Map<String, Object> jsonMap = objectMapper.readValue(json, Map.class);
        nodeService.updateNodeInfo((Integer) jsonMap.get("id"), objectMapper.writeValueAsString(jsonMap.get("json")));
        return "{\"message\" : \"Updated node.\"}";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public String delete(@RequestBody String json) throws IOException {
        Map<String, Object> jsonMap = objectMapper.readValue(json, Map.class);
        nodeService.deleteNode((Integer) jsonMap.get("id"));
        return "{\"message\" : \"Deleted node.\"}";
    }

    //    @RequestMapping(value = "/getChildrens/{id}", method = RequestMethod.GET)
    @RequestMapping(value = "/getChildrens/{id}", method = RequestMethod.GET, produces = APPLICATION_JSON)
    @ResponseBody
    public Map<String, String> getChildrens(@PathVariable("id") int nodeId) throws IOException {
//    public String getChildrens(@PathVariable("id") int nodeId) throws IOException {
        List<Node> nodes = nodeService.getChildrensOfNode(nodeId);

        Map map = objectMapper.readValue(nodes.get(0).getJson(), Map.class);
        map.put("nodeId: ", nodes.get(0).getId());
        map.put("parentId: ", nodes.get(0).getParent().getId());

//        for (Node n : nodes) {
//            System.out.println(n.getId() + " " + n.getJson());
//        }
        return map;
//        return objectMapper.writeValueAsString(nodes);
    }

    @RequestMapping(value = "/getParent/{id}", method = RequestMethod.GET, produces = APPLICATION_JSON)
    @ResponseBody
    public Map<String, String> getParent(@PathVariable("id") int nodeId) throws IOException {
        if (nodeService.getNode(nodeId).getId() == nodeService.getRoot().getId()) {
            Map map = new HashMap();
            map.put("message: ", "Acesta este nodul radacina si nu are parinte!");
            return map;
        } else {
            Node node = nodeService.getParent(nodeId);
            Map map = objectMapper.readValue(node.getJson(), Map.class);
            map.put("nodeId: ", node.getId());
            if (node.getParent() != null) {
                map.put("parentId: ", node.getParent().getId());
            } else {
                map.put("parentId: ", null);
            }
            return map;
        }
    }

    @RequestMapping(value = "/getRoot", method = RequestMethod.GET, produces = APPLICATION_JSON)
    @ResponseBody
    public Map<String, String> getRoot() throws IOException {
        Node root = nodeService.getRoot();
        Map map = objectMapper.readValue(root.getJson(), Map.class);
        map.put("nodeId: ", root.getId());
        map.put("parentId: ", null);
        return map;
    }

    @RequestMapping(value = "/updateParent", method = RequestMethod.PUT)
    public String updateParent(@RequestBody String json) throws IOException {
        Map<String, Object> jsonMap = objectMapper.readValue(json, Map.class);
        nodeService.updateParentOfNode((Integer) jsonMap.get("id"), (Integer) jsonMap.get("parentId"));
        return "{\"message\" : \"Parent updated.\"}";
    }

    @RequestMapping(value = "/bottomUpConfig/idB={idB}&idU={idU}", method = RequestMethod.GET)
    public String bottomUpConfig(ModelMap model, @PathVariable("idB") int bottomNodeId,
                                 @PathVariable("idU") int upNodeId) {
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
    public String topDownConfig(ModelMap model, @PathVariable("idT") int topNodeId,
                                @PathVariable("idD") int downNodeId) {
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