package tree.model;

public class GenericTreeNode<T> {
    private T data;
    private GenericTreeNode<T> nextSibling;
    private GenericTreeNode<T> firstChild;

    public GenericTreeNode(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public GenericTreeNode<T> getNextSibling() {
        return nextSibling;
    }

    public void setNextSibling(GenericTreeNode<T> nextSibling) {
        this.nextSibling = nextSibling;
    }

    public GenericTreeNode<T> getFirstChild() {
        return firstChild;
    }

    public void setFirstChild(GenericTreeNode<T> firstChild) {
        this.firstChild = firstChild;
    }
}
