package tree.avloperation;

import tree.model.AVLTreeNode;

public interface AVLTreeOperation<T> {
    AVLTreeNode<T> insert(AVLTreeNode<T> root, T data);
}
