package tree.problems;

import tree.model.BinaryTreeNode;

public class HeightOfBinaryTree<T> {
    public int recursive(BinaryTreeNode<T> root) {
        if (root == null) {
            return -1;
        }

        return 1 + Math.max(recursive(root.getLeft()), recursive(root.getRight()));
    }

    // for iterative refer MaximumSumAtLevelBinaryTree
}
