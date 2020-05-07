package tree.problems;

import tree.model.BinaryTreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumSumAtLevelInBinaryTree {
    public int iterative(BinaryTreeNode<Integer> root) {
        int maxSum = Integer.MIN_VALUE, currentSum = 0;
        BinaryTreeNode<Integer> ptr;
        Queue<BinaryTreeNode<Integer>> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(null);

        while (!queue.isEmpty()) {
            ptr = queue.poll();
            if (ptr != null) {
                currentSum += ptr.getData();
                if (ptr.getLeft() != null) {
                    queue.offer(ptr.getLeft());
                }
                if (ptr.getRight() != null) {
                    queue.offer(ptr.getRight());
                }
            } else {
                maxSum = Math.max(currentSum, maxSum);
                currentSum = 0;
                if (!queue.isEmpty()) {
                    queue.offer(null);
                }
            }
        }

        return maxSum;
    }
}
