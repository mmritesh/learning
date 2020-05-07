package tree.problems;

import tree.model.BinaryTreeNode;

public class ConvertTreeToMirrorImage<T> {

    public BinaryTreeNode<T> recursive(BinaryTreeNode<T> root) {
        if (root == null) {
            return null;
        }
        BinaryTreeNode<T> temp = root.getLeft();
        root.setLeft(root.getRight());
        root.setRight(temp);
        recursive(root.getLeft());
        recursive(root.getRight());
        return root;
    }
}
