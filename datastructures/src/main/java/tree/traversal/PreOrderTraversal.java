package tree.traversal;

import tree.model.BinaryTreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreOrderTraversal<T> implements TreeTraversal {
    @Override
    public List<T> recursive(BinaryTreeNode root) {
        List result = new ArrayList();
        recurse(root, result);
        return result;
    }

    private void recurse(BinaryTreeNode root, List result) {
        if (root == null) {
            return;
        }
        result.add(root.getData());
        recurse(root.getLeft(), result);
        recurse(root.getRight(), result);
    }

    @Override
    public List<T> iterative(BinaryTreeNode root) {
        if (root == null) {
            return null;
        }

        Stack<BinaryTreeNode> stack = new Stack<>();
        List<T> result = new ArrayList<>();
        BinaryTreeNode ptr;

        stack.push(root);

        while (!stack.isEmpty()) {
            ptr = stack.pop();
            if (ptr != null) {
                result.add((T)ptr.getData());
                stack.push(ptr.getRight());
                stack.push(ptr.getLeft());
            }
        }
        return result;
    }
}
