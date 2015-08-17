import java.util.ArrayList;

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
        if (node != null) {
            System.out.println(node.getData());
            if (node.getChildren() != null) {
                for (Node<T> nod : node.getChildren()) {
                    display(nod);
                }
            }
        } else {
            System.out.println("Nothing to display!");
        }
    }

    // afisarea continutului si a copiilor nodului "node" impreuna cu copii fiecarui nod
    public void displayNodesWithChildrens(Node<T> node) {
        if (node != null) {
            System.out.print(node.getData() + " :");
            for (Node<T> x : node.getChildren()) {
                System.out.print(" " + x.getData());
            }
            System.out.println("\n");
            if (node.getChildren() != null) {
                for (Node<T> nod : node.getChildren()) {
                    displayNodesWithChildrens(nod);
                }
            }
        } else {
            System.out.println("Nothing to display!");
        }
    }

    // returneaza nodul cu continutul nodeData, pornind cautarea de la nodul head
    public Node<T> getNodeByKey(T nodeData, Node<T> head, Node<T> node) {
//        System.out.println(head.getData());
//        if (head.getData() == nodeData) {
        if (head != null) {
            if (head.getData().equals(nodeData)) {
                node = head;
//            System.out.println(" gasit!!!");
//            System.out.println("Parinte: " + node.getParent().getData());
            } else {
                if (head.getChildren() != null) {
                    for (Node<T> nod : head.getChildren()) {
                        node = getNodeByKey(nodeData, nod, node);
                    }
                }
            }
        }
        return node;
    }

    // adauga un nod cu valoarea childData nodului parinte "parent"
    public void addNodesToParent(T childData, Node<T> parent) {
        Node<T> child = new Node<T>();
        child.setChildren(new ArrayList<Node<T>>());
        child.setData(childData);
        child.setParent(parent);
        if (parent == null) {
            //Node<T> oldRoot = new Node<T>(this.root.getData(), this.root.getParent(), this.root.getChildren());
            child.getChildren().add(this.getRoot());
            this.getRoot().setParent(child);
            setRoot(child);
            //oldRoot.setParent(child);
        } else {
            parent.getChildren().add(child);
        }
    }

    // adauga un nod cu valoarea childData nodului parinte  ce contine informatia "parentData"
    public void addNodesToParentByKey(T childData, T parentData) {
        Node<T> parent = getNodeByKey(parentData, this.root, new Node<T>());
        Node<T> child = new Node<T>();
        child.setChildren(new ArrayList<Node<T>>());
        child.setData(childData);
        child.setParent(parent);
        if (parent == null) {
            //Node<T> oldRoot = new Node<T>(this.root.getData(), this.root.getParent(), this.root.getChildren());
            child.getChildren().add(this.getRoot());
            this.getRoot().setParent(child);
            setRoot(child);
            //oldRoot.setParent(child);s
        } else {
            parent.getChildren().add(child);
        }
    }

    // Sterge un nod specificat, cu toti copiii acestuia
    public void removeNode(Node<T> node) {
        if (node.equals(this.getRoot())) {
            setRoot(null);
        } else {
            Node<T> parrent = node.getParent();
            parrent.getChildren().remove(node);
            node = null;
        }
    }

    // Verifica daca nodul parent se afla pe un nivel superior nodului child
    public boolean isUpper(Node<T> child, Node<T> parent) {
        boolean ok = false;
        if (child != null) {
            Node<T> node = child;
            while ((node.getParent() != null) && (ok == false)) {
                node = node.getParent();
//                System.out.println("nod: " + node.getData() + " ---- parinte: " + parent.getData());
//                if (node.getParent() != null) {
//                    System.out.println(" NodeParent: " + node.getParent().getData());
//                }
                if (node == parent) {
                    ok = true;
//                    System.out.println("este!");
                }
            }
        }
        return ok;
    }

    // Modifica valoarea din nodul "node" la valoarea "info"
    public void updateNodeInfo(Node<T> node, T info) {
        if (node != null) {
            node.setData(info);
        }
    }

    public void changeParentOfNode(Node<T> node, Node<T> newParent) {
        // Cazul in care newParent nu este copilul nodului node
        if ((node != newParent) && (newParent != null) && (node != null)) {
            System.out.println("node: " + node.getData() + " parent: " + newParent.getData());
            if (isUpper(newParent, node)) {
                Node<T> aux = newParent;
                newParent.getParent().getChildren().remove(newParent);
                aux.setParent(node.getParent());
                node.getParent().getChildren().add(aux);
                Node<T> auxChildren = node;
                node.getParent().getChildren().remove(node);
                auxChildren.setParent(aux);
                aux.getChildren().add(auxChildren);
                System.out.println("IF!!!!!!!!!==============================");

            } else {
                System.out.println("ELSE!!!!!!!!!==============================");
                Node<T> aux = node;
                node.getParent().getChildren().remove(node);
                aux.setParent(newParent);
                newParent.getChildren().add(aux);
            }
        }
    }
}
