package com.endava.rursu.dao;

import com.endava.rursu.model.Node;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by rursu on 8/18/2015.
 */
@Repository
public class NodeDaoImpl implements NodeDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void insertNode(Node node) {
        sessionFactory.getCurrentSession().saveOrUpdate(node);
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public Node getNode(int nodeId) {
        Node node = new Node();
        List<Node> nodes = sessionFactory.getCurrentSession().createCriteria(Node.class).add(Restrictions.eq("id", nodeId)).list();
        if (nodes.size() == 1) {
            node.setId(nodes.get(0).getId());
            node.setJson(nodes.get(0).getJson());
            node.setParentId(nodes.get(0).getParentId());
        } else {
            if (nodes.size() < 1) {
                node.setId(0);
                node.setJson("Nu exista acest nod!");
                node.setParentId(0);
            } else {
                node.setId(0);
                node.setJson("Exista mai multe noduri cu acest ID!");
                node.setParentId(0);
            }
        }
        return node;
    }

    @Override
    public void updateNodeInfo(int nodeId, String json) {
        List<Node> nodes = sessionFactory.getCurrentSession().createCriteria(Node.class).add(Restrictions.eq("id", nodeId)).list();
        Node node = nodes.get(0);
        node.setJson(json);
        sessionFactory.getCurrentSession().update(node);
    }

    @Override
    public void deleteNode(int nodeId) {
        Node node = (Node) sessionFactory.getCurrentSession().createCriteria(Node.class).add(Restrictions.eq("id", nodeId)).uniqueResult();
        if (node != null) {
//            List<Node> nodes = sessionFactory.getCurrentSession().createCriteria(Node.class).add(Restrictions.eq("parentId", nodeId)).list();
//            for (Node n : nodes) {
//                deleteNode(n.getId());
//            }
            sessionFactory.getCurrentSession().delete(node);
        }
    }

    @Override
    public List<Node> getChildrensOfNode(int nodeId) {
        List<Node> nodes = sessionFactory.getCurrentSession().createCriteria(Node.class).add(Restrictions.eq("parentId", nodeId)).list();
        return nodes;
    }

    @Override
    public Node getParent(int nodeId) {
        Node parent = new Node();
        Node child = getNode(nodeId);
        if (child.getParentId() != 0) {
            parent = getNode(child.getParentId());
        }
        return parent;
    }

    @Override
    public Node getRoot() {
        Node root = (Node) sessionFactory.getCurrentSession().createCriteria(Node.class).add(Restrictions.eq("parentId", 0)).uniqueResult();
        return root;
    }
}
