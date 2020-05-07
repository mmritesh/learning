package tree.traversal;

import tree.model.BinaryTreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InorderTraversal<T> implements TreeTraversal {

    @Override
    public List<T> recursive(BinaryTreeNode root) {
        List<T> result = new ArrayList<>();
        recurse(root, result);
        return result;
    }

    private void recurse(BinaryTreeNode root, List<T> result) {
        if (root == null) {
            return;
        }
        recurse(root.getLeft(), result);
        result.add((T)root.getData());
        recurse(root.getRight(), result);
    }

    @Override
    public List iterative(BinaryTreeNode root) {
        if (root == null) {
            return null;
        }

        Stack<BinaryTreeNode> stack = new Stack<>();
        List result = new ArrayList<>();
        BinaryTreeNode ptr = root;

        while (true) {
            while (ptr != null) {
                stack.push(ptr);
                ptr = ptr.getLeft();
                continue;
            }
            if (stack.isEmpty()) {
                break;
            }
            ptr = stack.pop();
            result.add(ptr.getData());
            ptr = ptr.getRight();
        }
        return result;
    }
}
