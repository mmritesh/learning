package tree.avloperation;

import tree.model.AVLTreeNode;

/**
 * Helper mothods for tree rotation.
 */
public interface AVLRotation<T> {

    /**
     *       X              Y
     *       /\             /\
     *      Y  (c)  ->   (A)  X
     *      /\                /\
     *   (A)  (B)           (B) (c)
     * @param x
     * @return
     */
    default AVLTreeNode<T> singleRotateLeft(AVLTreeNode<T> x) {
        AVLTreeNode<T> y = x.getLeft();
        x.setLeft(y.getRight());
        y.setRight(x);
        x.setHeight(Math.max(height(x.getLeft()), height(x.getRight())) + 1);
        y.setHeight(Math.max(height(y.getLeft()), x.getHeight()));
        return y;
    }

    /**
     *       X                         Y
     *       /\                        /\
     *   (c)   Y        ->            X  (B)
     *         /\                    /\
     *      (A)  (B)              (c)  (A)
     * @param x
     * @return
     */
    default AVLTreeNode<T> singleRotateRight(AVLTreeNode<T> x) {
        AVLTreeNode<T> y = x.getRight();
        x.setRight(y.getLeft());
        y.setLeft(x);
        x.setHeight(Math.max(height(x.getLeft()), height(x.getRight())) + 1);
        y.setHeight(Math.max(x.getHeight(), height(y.getRight())) + 1);
        return y;
    }

    /**
     *        z                   z                   X
     *       /\                   /\                 /  \
     *      Y  (D)     ->        X  (D)    ->      Y     z
     *      /\                  /\                / \    / \
     *   (A)  X                Y  (c)           (A) (B) (c) (D)
     *        /\              /\
     *      (B) (c)         (A) (B)
     */
    default AVLTreeNode<T> doubleRotationLeft(AVLTreeNode<T> z) {
        z.setLeft(singleRotateRight(z.getLeft()));
        return singleRotateLeft(z);
    }

    /**
     *        z                    z                 X
     *       / \                  / \              /  \
     *     (A)  Y     ->        (A)  X    ->      z    Y
     *         / \                  / \          / \   / \
     *        X  (D)              (B)  Y       (A) (B) (c) (D)
     *       / \                      / \
     *      (B) (c)                 (C) (D)
     */
    default AVLTreeNode<T> doubleRotationRight(AVLTreeNode<T> z) {
        z.setRight(singleRotateLeft(z.getRight()));
        return singleRotateRight(z);
    }

    default int height(AVLTreeNode<T> root) {
        if (root == null) {
            return -1;
        }
        return root.getHeight();
    }
}
