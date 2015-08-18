package com.endava.rursu.service;

import com.endava.rursu.dao.NodeDao;
import com.endava.rursu.model.Node;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by rursu on 8/18/2015.
 */
@Service
public class NodeServiceImpl implements NodeService {

    @Autowired
    private NodeDao nodeDao;

    @Override
    @Transactional
    public void insertNode(Node node) {
        nodeDao.insertNode(node);
    }

    @Override
    @Transactional
    public Node getNode(int nodeId) {
        return nodeDao.getNode(nodeId);
    }

    @Override
    @Transactional
    public void updateNodeInfo(int nodeId, String json) {
        nodeDao.updateNodeInfo(nodeId, json);
    }

    @Override
    @Transactional
    public void deleteNode(int nodeId) {
        nodeDao.deleteNode(nodeId);
    }
}
