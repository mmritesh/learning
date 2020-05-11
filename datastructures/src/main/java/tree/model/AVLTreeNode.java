package tree.model;

/**
 * HB(K), if k = (Height of Left subtree - Height of right subtree) = at most equals to 1.
 * Number of nodes N(h) = N(h-1) + N(h-2) + 1 = 1.44 * logn
 * @param <T>
 */
public class AVLTreeNode<T> extends BinarySearchTreeNode<T> {
    private T data;
    private AVLTreeNode<T> left;
    private AVLTreeNode<T> right;
    private int height;

    public AVLTreeNode() {
    }

    public AVLTreeNode(T data) {
        this.data = data;
        this.left = null;
        this.right = null;
        this.height = 0;
    }

    @Override
    public T getData() {
        return data;
    }

    @Override
    public void setData(T data) {
        this.data = data;
    }

    @Override
    public AVLTreeNode<T> getLeft() {
        return left;
    }

    public void setLeft(AVLTreeNode<T> left) {
        this.left = left;
    }

    @Override
    public AVLTreeNode<T> getRight() {
        return right;
    }

    public void setRight(AVLTreeNode<T> right) {
        this.right = right;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
