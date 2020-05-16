package tree.bstoperation;

import tree.model.BinarySearchTreeNode;

public class BinarySearchTreeRange<T extends Comparable<? super T>> {

    private int count = 0;
    /**
     * Prune nodes that dont lie in start and end
     * @param root
     * @param start
     * @param end
     * @return
     */
    public BinarySearchTreeNode<T> prune(BinarySearchTreeNode<T> root, T start, T end) {
        if (root == null) {
            return null;
        }
        root.setLeft(prune(root.getLeft(), start, end));
        root.setRight(prune(root.getRight(), start, end));

        if (root.getData().compareTo(start) >= 0 || root.getData().compareTo(end) <= 0) {
            return root;
        } else if (root.getData().compareTo(start) < 0) {
            return root.getRight();
        } else {
            return root.getLeft();
        }
    }


    /**
     * count nodes between start and end
     * @param root
     * @param start
     * @param end
     * @return
     */
    public int count(BinarySearchTreeNode<T> root, T start, T end) {
        if (root == null) {
            return 0;
        }
        if (root.getData().compareTo(start) >= 0 && root.getData().compareTo(end) <= 0) {
            return count(root.getLeft(), start, end) + count(root.getRight(), start, end) + 1;
        }
        if (root.getData().compareTo(start) < 0) {
            return count(root.getRight(), start, end);
        }
        return count(root.getLeft(), start, end);
    }
}
