import java.util.ArrayList;
import java.util.List;

/**
 * Created by rursu on 8/12/2015.
 */
public class Tree<T> {
    private Node<T> root;

    public Tree(T rootData) {
        Node<T> node = new Node<T>(rootData, null, new ArrayList<Node<T>>());
        this.root = node;
    }

    public Node<T> getRoot() {
        return root;
    }

    // setarea radacinii
    public void setRoot(Node<T> node) {
        this.root = node;
    }

    // afisarea continutului si a copiilor nodului "node"
    public void display(Node<T> node) {
        System.out.println(node.getData());
        if (node.getChildren() != null) {
            for (Node<T> nod : node.getChildren()) {
                display(nod);
            }
        }
    }

    // returneaza nodul cu continutul nodeData, pornind cautarea de la nodul head
    public Node<T> getNodeByKey(T nodeData, Node<T> head) {
        Node<T> node = new Node<T>();
        if (head.getData().equals(nodeData)) {
            node = head;
        }// else {
        if (head.getChildren() != null) {
            for (Node<T> nod : head.getChildren()) {
                getNodeByKey(nodeData, nod);
            }
        }
        //}
        return node;
    }

    // adauga un nod cu valoarea childData nodului parinte "parent"
    public void addNodesToParent(T childData, Node<T> parent) {
        Node<T> child = new Node<T>();
        child.setChildren(new ArrayList<Node<T>>());
        child.setData(childData);
        child.setParent(parent);
        if (parent == null) {
            Node<T> oldRoot = new Node<T>(this.root.getData(),this.root.getParent(),this.root.getChildren());
            child.addChildren(oldRoot);
            oldRoot.setParent(child);
            setRoot(child);
        } else {
            parent.addChildren(child);
        }
    }

    // adauga un nod cu valoarea childData nodului parinte  ce contine informatia "parentData"
    public void addNodesToParentByKey(T childData, T parentData) {
        Node<T> parent = getNodeByKey(parentData, this.root);
        Node<T> child = new Node<T>();
        child.setChildren(new ArrayList<Node<T>>());
        child.setData(childData);
        child.setParent(parent);
        if (parent == null) {
            Node<T> oldRoot = new Node<T>(this.root.getData(),this.root.getParent(),this.root.getChildren());
            child.addChildren(oldRoot);
            oldRoot.setParent(child);
            setRoot(child);
        } else {
            parent.addChildren(child);
        }
    }
}
