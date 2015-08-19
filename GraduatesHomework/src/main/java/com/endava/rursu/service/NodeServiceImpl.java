package com.endava.rursu.service;

import com.endava.rursu.dao.NodeDao;
import com.endava.rursu.model.Node;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    @Override
    @Transactional
    public List<Node> getChildrensOfNode(int nodeId) {
        return nodeDao.getChildrensOfNode(nodeId);
    }

    @Override
    @Transactional
    public Node getParent(int nodeId) {
        return nodeDao.getParent(nodeId);
    }

    @Override
    @Transactional
    public Node getRoot() {
        return nodeDao.getRoot();
    }

    @Override
    @Transactional
    public void updateParentOfNode(int nodeId, int parentNodeId) {
        nodeDao.updateParentOfNode(nodeId, parentNodeId);
    }

    @Override
    @Transactional
    public List<Node> fetchTopDownConfiguration(int topNodeId, int downNodeId) {
        return nodeDao.fetchTopDownConfiguration(topNodeId, downNodeId);
    }

    @Override
    @Transactional
    public List<Node> fetchBottomUpConfiguration(int bottomNodeId, int upNodeId) {
        return nodeDao.fetchBottomUpConfiguration(bottomNodeId, upNodeId);
    }
}
