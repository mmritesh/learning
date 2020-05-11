package tree.avloperation;

import tree.model.AVLTreeNode;

public class AVLTreeOperationImpl<T extends Comparable<T>> implements AVLTreeOperation<T>, AVLRotation<T> {
    /**
     * Insertion is similar to BST, but we need a rotation logic based on height.
     * @param root
     * @param data
     * @return
     */
    @Override
    public AVLTreeNode<T> insert(AVLTreeNode<T> root, T data) {
        if (root == null) {
            root = new AVLTreeNode<>(data);
        } else {
            if (root.getData().compareTo(data) > 0) {
                root.setLeft(insert(root.getLeft(), data));

                if ( (height(root.getLeft()) - height(root.getRight())) == 2) {
                    if (data.compareTo(root.getLeft().getData()) < 0) {
                        root = singleRotateLeft(root);
                    } else {
                        root = doubleRotationLeft(root);
                    }
                }
            } else if (root.getData().compareTo(data) < 0) {
                root.setRight(insert(root.getRight(), data));
                if ( (height(root.getRight()) - height(root.getLeft())) == 2) {
                    if (data.compareTo(root.getRight().getData()) > 0) {
                        root = singleRotateRight(root);
                    } else {
                        root = doubleRotationRight(root);
                    }
                }
            }
        }
        /* Skipping addition of duplicate node. */
        root.setHeight( Math.max(height(root.getLeft()), height(root.getRight())) + 1 );
        return root;
    }
}
