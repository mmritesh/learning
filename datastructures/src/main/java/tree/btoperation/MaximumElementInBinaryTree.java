package tree.btoperation;

import tree.model.BinaryTreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumElementInBinaryTree<T extends Comparable> {

    public T recursive(BinaryTreeNode<T> root) {
        T maxValue = null;
        if (root == null) {
            return maxValue;
        }

        T m1 = recursive(root.getLeft());
        T m2 = recursive(root.getRight());
        maxValue = m1 != null && m1.compareTo(m2) > 0 ? m1 : m2;

        if (maxValue == null || (root.getData() != null && (root.getData()).compareTo(maxValue) > 0)) {
            maxValue = root.getData();
        }

        return maxValue;
    }

    public T iterative(BinaryTreeNode<T> root) {
        if (root == null) {
            return null;
        }
        T maxValue = null;
        Queue<BinaryTreeNode<T>> queue = new LinkedList<>();
        BinaryTreeNode<T> ptr;
        queue.offer(root);

        while (!queue.isEmpty()) {
            ptr = queue.poll();
            if (ptr != null) {
                if (maxValue == null || (ptr.getData() != null && ptr.getData().compareTo(maxValue) > 0)) {
                    maxValue = ptr.getData();
                }
                queue.offer(ptr.getLeft());
                queue.offer(ptr.getRight());
            }
        }
        return maxValue;
    }
}
