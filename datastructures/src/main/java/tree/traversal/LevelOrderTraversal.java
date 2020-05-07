package tree.traversal;

import tree.model.BinaryTreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal<T> implements TreeTraversal {
    @Override
    public List recursive(BinaryTreeNode root) {
        return null;
    }

    @Override
    public List iterative(BinaryTreeNode root) {
        if (root == null) {
            return null;
        }
        List result = new ArrayList();
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.offer(root);
        BinaryTreeNode ptr = null;

        while (!queue.isEmpty()) {
            ptr = queue.poll();
            if (ptr != null) {
                result.add(ptr.getData());
                queue.offer(ptr.getLeft());
                queue.offer(ptr.getRight());
            }
        }
        return result;
    }
}
