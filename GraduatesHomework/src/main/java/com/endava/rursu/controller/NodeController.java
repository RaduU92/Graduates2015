package com.endava.rursu.controller;

import com.endava.rursu.model.Node;
import com.endava.rursu.service.NodeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/")
public class NodeController {
    public static final String APPLICATION_JSON = "application/json";
    @Autowired
    private NodeService nodeService;

    @Autowired
    private ObjectMapper objectMapper;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<String> printWelcome() {
        String response = "{\"message\" : \"Hello World!\"}";
        return new ResponseEntity<String>(response, HttpStatus.OK);
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public ResponseEntity<String> insert(@RequestBody String json) throws IOException {
        Map<String, Object> jsonMap = objectMapper.readValue(json, Map.class);
        Node root = nodeService.getRoot();
        String response;
        if (root == null) {
            nodeService.insertNode(new Node(objectMapper.writeValueAsString(jsonMap.get("json")), null, new ArrayList<Node>()));
            response = "{\"message\" : \"Inserted new node.\"}";
            return new ResponseEntity<String>(response, HttpStatus.CREATED);
        } else {
            if (jsonMap.get("parentId") == null) {
                nodeService.insertNode(new Node(objectMapper.writeValueAsString(jsonMap.get("json")), root, new ArrayList<Node>()));
                response = "{\"message\" : \"Inserted new node.\"}";
                return new ResponseEntity<String>(response, HttpStatus.CREATED);
            } else {
                if (nodeService.getNode((Integer) jsonMap.get("parentId")).getId() != 0) {
                    nodeService.insertNode(new Node(objectMapper.writeValueAsString(jsonMap.get("json")), nodeService.getNode((Integer) jsonMap.get("parentId")), new ArrayList<Node>()));
                    response = "{\"message\" : \"Inserted new node.\"}";
                    return new ResponseEntity<String>(response, HttpStatus.CREATED);
                } else {
                    response = "{\"message\" : \"Parent node not found!\"}";
                    return new ResponseEntity<String>(response, HttpStatus.NOT_FOUND);
                }
            }
        }
    }

    @RequestMapping(value = "/select/{id}", method = RequestMethod.GET, produces = APPLICATION_JSON)
    @ResponseBody
    public ResponseEntity<String> select(@PathVariable("id") int nodeId) {
        Node node = nodeService.getNode(nodeId);
        String response;
        if (node.getId() != 0) {
            response = "{\"json\":" + node.getJson() + ",\"id\":" + node.getId() + ",\"parentId\":";
            if (node.getParent() != null) {
                response += node.getParent().getId();
            } else {
                response += null;
            }
            response += "}";
            return new ResponseEntity<String>(response, HttpStatus.OK);
        } else {
            response = "{\"json\":" + null + ",\"id\":" + node.getId() + ",\"parentId\":" + null + "}";
            return new ResponseEntity<String>(response, HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity<String> update(@RequestBody String json) throws IOException {
        Map<String, Object> jsonMap = objectMapper.readValue(json, Map.class);
        if (nodeService.getNode((Integer) jsonMap.get("id")).getId() != 0) {
            nodeService.updateNodeInfo((Integer) jsonMap.get("id"), objectMapper.writeValueAsString(jsonMap.get("json")));
            String response = "{\"message\" : \"Updated node.\"}";
            return new ResponseEntity<String>(response, HttpStatus.OK);
        } else {
            return new ResponseEntity<String>("{\"message\" : \"Node was not updated!\"}", HttpStatus.NOT_MODIFIED);
        }
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public ResponseEntity<String> delete(@RequestBody String json) throws IOException {
        Map<String, Object> jsonMap = objectMapper.readValue(json, Map.class);
        if (nodeService.getNode((Integer) jsonMap.get("id")).getId() != 0) {
            nodeService.deleteNode((Integer) jsonMap.get("id"));
            String response = "{\"message\" : \"Deleted node.\"}";
            return new ResponseEntity<String>(response, HttpStatus.OK);
        } else {
            return new ResponseEntity<String>("{\"message\" : \"Node not found to be deleted.\"}", HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/getChildrens/{id}", method = RequestMethod.GET, produces = APPLICATION_JSON)
    @ResponseBody
    public ResponseEntity<String> getChildrens(@PathVariable("id") int nodeId) {
        Node node = nodeService.getNode(nodeId);
        String response = "{\"parent\":";
        if ((nodeService.getRoot() != null) && node.getId() != 0) {
            response += "{\"json\":" + node.getJson() + ",\"id\":" + node.getId() + ",\"parentId\":";
            if (node.getParent() != null) {
                response += node.getParent().getId();
            } else {
                response += null;
            }
            response += "},\"childrens\":[";
            List<Node> nodes = nodeService.getChildrensOfNode(nodeId);
            if (nodes.size() > 0) {
                int i = 0;
                for (Node n : nodes) {
                    response += "{\"json\":" + n.getJson() + ",\"id\":" + n.getId() + ",\"parentId\":";
                    if (n.getParent() != null) {
                        response += n.getParent().getId();
                    } else {
                        response += null;
                    }
                    if (i < nodes.size() - 1) {
                        response += "},";
                    } else {
                        response += "}";
                    }
                    i++;
                }
            }
            response += "]}";
            return new ResponseEntity<String>(response, HttpStatus.OK);
        } else {
            response += null + ",\"childrens\":[]}";
            return new ResponseEntity<String>(response, HttpStatus.NOT_FOUND);
        }

    }

    @RequestMapping(value = "/getParent/{id}", method = RequestMethod.GET, produces = APPLICATION_JSON)
    @ResponseBody
    public ResponseEntity<String> getParent(@PathVariable("id") int nodeId) {
        String response;
        if (nodeService.getNode(nodeId).getId() != 0) {
            if (nodeService.getNode(nodeId).getId() == nodeService.getRoot().getId()) {
                response = "{\"json\":" + null + ",\"id\":" + null + ",\"parentId\":" + null + "}";
            } else {
                Node node = nodeService.getParent(nodeId);
                response = "{\"json\":" + node.getJson() + ",\"id\":" + node.getId() + ",\"parentId\":";
                if (node.getParent() != null) {
                    response += node.getParent().getId();
                } else {
                    response += null;
                }
                response += "}";
            }
            return new ResponseEntity<String>(response, HttpStatus.OK);
        } else {
            return new ResponseEntity<String>("{\"json\":" + null + ",\"id\":" + null + ",\"parentId\":" + null + "}", HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/getRoot", method = RequestMethod.GET, produces = APPLICATION_JSON)
    @ResponseBody
    public ResponseEntity<String> getRoot() {
        Node root = nodeService.getRoot();
        if (root != null) {
            String response = "{\"json\":" + root.getJson() + ",\"id\":" + root.getId() + ",\"parentId\":" + null + "}";
            return new ResponseEntity<String>(response, HttpStatus.OK);
        } else {
            String response = "{\"json\":" + null + ",\"id\":" + null + ",\"parentId\":" + null + "}";
            return new ResponseEntity<String>(response, HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/updateParent", method = RequestMethod.PUT)
    public ResponseEntity<String> updateParent(@RequestBody String json) throws IOException {
        Map<String, Object> jsonMap = objectMapper.readValue(json, Map.class);
        if ((nodeService.getRoot() != null) && (nodeService.getNode((Integer) jsonMap.get("id")).getId() != nodeService.getRoot().getId()) && (nodeService.getNode((Integer) jsonMap.get("id")).getId() != 0) && (nodeService.getNode((Integer) jsonMap.get("parentId")).getId() != 0)) {
            nodeService.updateParentOfNode((Integer) jsonMap.get("id"), (Integer) jsonMap.get("parentId"));
            String response = "{\"message\" : \"Parent updated.\"}";
            return new ResponseEntity<String>(response, HttpStatus.OK);
        } else {
            String response = "{\"message\" : \"Parent not updated.\"}";
            return new ResponseEntity<String>(response, HttpStatus.NOT_MODIFIED);
        }
    }

    @RequestMapping(value = "/bottomUpConfig/idB={idB}&idU={idU}", method = RequestMethod.GET)
    public ResponseEntity<String> bottomUpConfig(@PathVariable("idB") int bottomNodeId, @PathVariable("idU") int upNodeId) {
        String response;
        if ((nodeService.getNode(bottomNodeId).getId() != 0) && (nodeService.getNode(upNodeId).getId() != 0)) {
            List<Node> nodes = nodeService.fetchBottomUpConfiguration(bottomNodeId, upNodeId);
            response = "{\"bottomUp\":[";
            if (nodes.size() > 0) {
                int i = 0;
                for (Node n : nodes) {
                    response += "{\"json\":" + n.getJson() + ",\"id\":" + n.getId() + ",\"parentId\":";
                    if (n.getParent() != null) {
                        response += n.getParent().getId();
                    } else {
                        response += null;
                    }
                    if (i < nodes.size() - 1) {
                        response += "},";
                    } else {
                        response += "}";
                    }
                    i++;
                }
            }
            response += "]}";
            return new ResponseEntity<String>(response, HttpStatus.OK);
        } else {
            response = "{\"bottomUp\":[]}";
            return new ResponseEntity<String>(response, HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/topDownConfig/idT={idT}&idD={idD}", method = RequestMethod.GET)
    public ResponseEntity<String> topDownConfig(@PathVariable("idT") int topNodeId, @PathVariable("idD") int downNodeId) {
        String response;
        if ((nodeService.getNode(topNodeId).getId() != 0) && (nodeService.getNode(downNodeId).getId() != 0)) {
            List<Node> nodes = nodeService.fetchTopDownConfiguration(topNodeId, downNodeId);
            response = "{\"topDown\":[";
            if (nodes.size() > 0) {
                int i = 0;
                for (Node n : nodes) {
                    response += "{\"json\":" + n.getJson() + ",\"id\":" + n.getId() + ",\"parentId\":";
                    if (n.getParent() != null) {
                        response += n.getParent().getId();
                    } else {
                        response += null;
                    }
                    if (i < nodes.size() - 1) {
                        response += "},";
                    } else {
                        response += "}";
                    }
                    i++;
                }
            }
            response += "]}";
            return new ResponseEntity<String>(response, HttpStatus.OK);
        } else {
            response = "{\"topDown\":[]}";
            return new ResponseEntity<String>(response, HttpStatus.NOT_FOUND);
        }
    }
}