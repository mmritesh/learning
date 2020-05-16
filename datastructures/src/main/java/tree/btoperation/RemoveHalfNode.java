package tree.btoperation;

import tree.model.BinaryTreeNode;

public class RemoveHalfNode<T> {
    public BinaryTreeNode<T> remove(BinaryTreeNode<T> root) {
        if (root == null) {
            return null;
        }
        root.setLeft(remove(root.getLeft()));
        root.setRight(remove(root.getRight()));
        if (root.getLeft() == null && root.getRight() == null) {
            return root;
        }
        if (root.getLeft() == null) {
            return root.getRight();
        }
        if (root.getRight() == null) {
            return root.getLeft();
        }
        return root;

    }
}
