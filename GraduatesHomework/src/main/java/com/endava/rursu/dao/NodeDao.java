package com.endava.rursu.dao;

import com.endava.rursu.model.Node;

/**
 * Created by rursu on 8/18/2015.
 */
public interface NodeDao {
    void insertNode(Node node);

    Node getNode(int nodeId);

    void updateNodeInfo(int nodeId, String json);

    void deleteNode(int nodeId);
}
