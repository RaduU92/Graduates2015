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

    //    Adauga un nod nou
    @Override
    public void insertNode(Node node) {
        sessionFactory.getCurrentSession().saveOrUpdate(node);
        sessionFactory.getCurrentSession().flush();
    }

    //    Returneaza nodul cu id-ul specificat
    @Override
    public Node getNode(int nodeId) {
        Node node = new Node();
        List<Node> nodes = sessionFactory.getCurrentSession().createCriteria(Node.class).add(Restrictions.eq("id", nodeId)).list();
        if (nodes.size() == 1) {
            node.setId(nodes.get(0).getId());
            node.setJson(nodes.get(0).getJson());
            node.setParent(nodes.get(0).getParent());
        } else {
            if (nodes.size() < 1) {
                node.setId(0);
                node.setJson("Nu exista acest nod!");
                node.setParent(null);
            } else {
                node.setId(0);
                node.setJson("Exista mai multe noduri cu acest ID!");
                node.setParent(null);
            }
        }
        return node;
    }

    //    Modifica continutul unui nod
    @Override
    public void updateNodeInfo(int nodeId, String json) {
        List<Node> nodes = sessionFactory.getCurrentSession().createCriteria(Node.class).add(Restrictions.eq("id", nodeId)).list();
        Node node = nodes.get(0);
        node.setJson(json);
        sessionFactory.getCurrentSession().update(node);
    }

    //    Sterge nodul (in plus, deoarece e pusa constrangerea de ON DELETE CASCADE, se vor sterge si copiii)
    @Override
    public void deleteNode(int nodeId) {
        Node node = (Node) sessionFactory.getCurrentSession().createCriteria(Node.class).add(Restrictions.eq("id", nodeId)).uniqueResult();
        if (node != null) {
            sessionFactory.getCurrentSession().delete(node);
        }
    }

    //    Returneaza copiii unui nod
    @Override
    public List<Node> getChildrensOfNode(int nodeId) {
        Node node = getNode(nodeId);
        List<Node> nodes = sessionFactory.getCurrentSession().createCriteria(Node.class).add(Restrictions.eq("parent", node)).list();
        return nodes;
    }

    //    Returneaza parintele unui nod
    @Override
    public Node getParent(int nodeId) {
        Node parent = new Node();
        Node child = getNode(nodeId);
        if (child.getParent().getId() != 0) {
            parent = child.getParent();
        }
        return parent;
    }

    //    Returneaza nodul radacina
    @Override
    public Node getRoot() {
        Node root = (Node) sessionFactory.getCurrentSession().createCriteria(Node.class).add(Restrictions.isNull("parent")).uniqueResult();
        return root;
    }

    //    Schimba parintele uni nod
    @Override
    public void updateParentOfNode(int nodeId, int parentNodeId) {
        Node node = (Node) sessionFactory.getCurrentSession().createCriteria(Node.class).add(Restrictions.eq("id", nodeId)).uniqueResult();
        node.setParent(getNode(parentNodeId));
        sessionFactory.getCurrentSession().update(node);
    }

    @Override
    public List<Node> fetchTopDownConfiguration(int topNodeId, int downNodeId) {
        return null;
    }

    @Override
    public List<Node> fetchBottomUpConfiguration(int bottomNodeId, int upNodeId) {
        return null;
    }
}
