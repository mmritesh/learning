package tree.model;

public class ThreadedBinaryTreeNode<T> {
    private T data;
    private int lTag;
    private int rTag;
    private ThreadedBinaryTreeNode<T> left;
    private ThreadedBinaryTreeNode<T> right;

    public ThreadedBinaryTreeNode(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getlTag() {
        return lTag;
    }

    public void setlTag(int lTag) {
        this.lTag = lTag;
    }

    public int getrTag() {
        return rTag;
    }

    public void setrTag(int rTag) {
        this.rTag = rTag;
    }

    public ThreadedBinaryTreeNode<T> getLeft() {
        return left;
    }

    public void setLeft(ThreadedBinaryTreeNode<T> left) {
        this.left = left;
    }

    public ThreadedBinaryTreeNode<T> getRight() {
        return right;
    }

    public void setRight(ThreadedBinaryTreeNode<T> right) {
        this.right = right;
    }
}
