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
import java.util.Map;

@Controller
@RequestMapping("/node")
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
        nodeService.insertNode(new Node(objectMapper.writeValueAsString(jsonMap.get("json")), (Integer) jsonMap.get("parentId")));
        String message = "Inserted node with json: " + objectMapper.writeValueAsString(jsonMap.get("json")) + " and parrent id: " + jsonMap.get("parentId");
        model.addAttribute("message", message);
        return "insertNode";
    }

    @RequestMapping(value = "/select/{id}", method = RequestMethod.GET)
    public String select(ModelMap model, @PathVariable("id") int nodeId) {
        Node node = nodeService.getNode(nodeId);
        String message = node.getJson();
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
}