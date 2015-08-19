package com.endava.rursu.dao;

import com.endava.rursu.model.Node;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
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
        if (nodeId != parentNodeId) {
            Node parent = getNode(parentNodeId);
            Node node = getNode(nodeId);
            Node root = getRoot();
            boolean ok = false;
            Node aux = parent;
//            while ((aux != root) && (ok == false) && (aux != parent)) {
            while ((aux.getId() != root.getId()) && (ok == false)) {
                aux = getParent(aux.getId());
                if (aux.getId() == node.getId()) {
                    ok = true;
                }
                System.out.println("id aux : " + aux.getId());
            }
            if (ok) {
                Node nodeParent = getParent(nodeId);
                parent.setParent(nodeParent);
                sessionFactory.getCurrentSession().merge(parent);
                System.out.println("id parinte: " + getParent(nodeId).getId());
            }
            node.setParent(parent);
            sessionFactory.getCurrentSession().merge(node);
        }
    }

    //    Configuratia top-down
    @Override
    public List<Node> fetchTopDownConfiguration(int topNodeId, int downNodeId) {
        Node topNode = getNode(topNodeId);
        Node downNode = getNode(downNodeId);
        Node root = getRoot();
        List<Node> nodes = new ArrayList<Node>();

        if (downNode != root) {
            ArrayList<Node> auxNodes = new ArrayList<Node>();
            boolean ok;
            Node nodAux = downNode;
            auxNodes.add(downNode);
            while ((nodAux.getId() != topNode.getId()) && (nodAux.getId() != root.getId())) {
                nodAux = getParent(nodAux.getId());
                auxNodes.add(nodAux);
            }

            for (int i = auxNodes.size() - 1; i >= 0; i--) {
                ok = true;
                for (Node node : nodes) {
                    if (node.getJson().equals(auxNodes.get(i).getJson())) {
                        ok = false;
                    }
                }
                if (ok) {
                    nodes.add(auxNodes.get(i));
                }
            }
        }
        return nodes;
    }

    //    Configuratia bottom-up
    @Override
    public List<Node> fetchBottomUpConfiguration(int bottomNodeId, int upNodeId) {
        Node bottomNode = getNode(bottomNodeId);
        Node upNode = getNode(upNodeId);
        Node root = getRoot();
        List<Node> nodes = new ArrayList<Node>();
        nodes.add(bottomNode);
        if (bottomNode != getRoot()) {
            boolean ok;
            Node nodAux = bottomNode;
            while ((nodAux.getId() != upNode.getId()) && (nodAux.getId() != root.getId())) {
                ok = true;
                nodAux = getParent(nodAux.getId());
                for (Node node : nodes) {
                    if (node.getJson().equals(nodAux.getJson())) {
                        ok = false;
                    }
                }
                if (ok) {
                    nodes.add(nodAux);
                }
            }
        }
        return nodes;
    }
}
