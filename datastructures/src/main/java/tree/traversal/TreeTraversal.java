package tree.traversal;

import tree.model.BinaryTreeNode;

import java.util.List;

public interface TreeTraversal<T> {
    List<T> recursive(BinaryTreeNode<T> root);
    List<T> iterative(BinaryTreeNode<T> root);
}
