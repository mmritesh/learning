package tree.operation;

import tree.model.BinarySearchTreeNode;

public class BinarySearchTreeOperationImpl<T extends Comparable<T>> implements BinarySearchTreeOperation<T> {

    @Override
    public BinarySearchTreeNode<T> insert(BinarySearchTreeNode<T> root, T data) {
        if (root == null) {
            root = new BinarySearchTreeNode<>(data);
        } else {
            if (root.getData().compareTo(data) > 0) {
                root.setLeft(insert(root.getLeft(), data));
            } else if (root.getData().compareTo(data) < 0) {
                root.setRight(insert(root.getRight(), data));
            }
        }
        return root;
    }

    @Override
    public BinarySearchTreeNode<T> delete(BinarySearchTreeNode<T> root, T data) {
        if (root == null) {
            return null;
        }
        if (root.getData().compareTo(data) > 0) {
            root.setLeft(delete(root.getLeft(), data));
        } else if (root.getData().compareTo(data) < 0) {
            root.setRight(delete(root.getRight(), data));
        } else {
            // to delete such node, we assign the max elemt from the left subtree to root,
            // and recursively delete that element from the left subtree
            if (root.getRight() != null && root.getLeft() != null) {
                BinarySearchTreeNode<T> ptr = findMax(root.getLeft());
                root.setData(ptr.getData());
                root.setLeft(delete(root.getLeft(), root.getData()));
            } else {
                if (root.getLeft() == null) {
                    root = root.getRight();
                } else if (root.getRight() == null) {
                    root = root.getLeft();
                }
            }
        }
        return root;
    }

    @Override
    public BinarySearchTreeNode<T> findMin(BinarySearchTreeNode<T> root) {
        if (root == null) {
            return null;
        }
        if (root.getLeft() != null) {
            root = findMin(root.getLeft());
        }
        return root;
    }

    @Override
    public BinarySearchTreeNode<T> findMax(BinarySearchTreeNode<T> root) {
        if (root == null) {
            return null;
        }
        if (root.getRight() != null) {
            return findMax(root.getRight());
        }
        return root;
    }

    @Override
    public BinarySearchTreeNode<T> find(BinarySearchTreeNode<T> root, T data) {
        if (root == null) {
            return null;
        }
        if (root.getData().compareTo(data) > 0) {
            find(root.getLeft(), data);
        } else if (root.getData().compareTo(data) < 0) {
            find(root.getRight(), data);
        }
        return root;
    }


}
