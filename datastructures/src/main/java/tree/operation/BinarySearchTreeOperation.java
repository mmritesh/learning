package tree.operation;

import tree.model.BinarySearchTreeNode;

public interface BinarySearchTreeOperation<T> {
    BinarySearchTreeNode<T> insert(BinarySearchTreeNode<T> root, T data);
    BinarySearchTreeNode<T> delete(BinarySearchTreeNode<T> root, T data);
    BinarySearchTreeNode<T> findMin(BinarySearchTreeNode<T> root);
    BinarySearchTreeNode<T> findMax(BinarySearchTreeNode<T> root);
    BinarySearchTreeNode<T> find(BinarySearchTreeNode<T> root, T data);
}
