import java.util.List;

/**
 * Created by rursu on 8/12/2015.
 */
public class Node<T> {
    private T data;
    private Node<T> parent;
    private List<Node<T>> children;

    public Node(T data, Node<T> parent, List<Node<T>> children) {
        this.data = data;
        this.parent = parent;
        this.children = children;
    }

    public Node() {

    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node<T> getParent() {
        return parent;
    }

    public void setParent(Node<T> parent) {
        this.parent = parent;
    }

    public List<Node<T>> getChildren() {
        return children;
    }

    public void setChildren(List<Node<T>> children) {
        this.children = children;
    }

    public void addChildren(Node<T> child) {
        this.children.add(child);
    }
}
