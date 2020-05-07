package tree.traversal;

import tree.model.BinaryTreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Algorithm:
 * 1. create an empty stack.
 * 2. while root != null
 *       push right child and then root to the stack.
 *       root = root.left
 * 3. root = pop()
 * 4. if root's right child matches with top of stack
 *       pop the item from top of stack
 *       push root to stack
 *       set root to root's right child.
 * 5. else
 *       print data in root.
 *       set root = null
 * 6. do 2,3,4,5 till stack is empty.
 *
 */
public class PostOrderTraversal implements TreeTraversal {
    @Override
    public List recursive(BinaryTreeNode root) {
        List result = new ArrayList();
        recurse(root, result);
        return result;
    }

    private void recurse(BinaryTreeNode root, List result) {
        if (root == null) {
            return;
        }
        recurse(root.getLeft(), result);
        recurse(root.getRight(), result);
        result.add(root.getData());
    }

    @Override
    public List iterative(BinaryTreeNode root) {
        if (root == null) {
            return null;
        }
        List result = new ArrayList();
        Stack<BinaryTreeNode> stack = new Stack<>();
        BinaryTreeNode prev, curr = root, temp;

        do {
            while (curr != null) {
                if (curr.getRight() != null) {
                    stack.push(curr.getRight());
                }
                stack.push(curr);
                curr = curr.getLeft();
                continue;
            }
            curr = stack.pop();
            if (!stack.isEmpty() && curr.getRight() == stack.peek()) {
                temp = stack.pop();
                stack.push(curr);
                curr = temp;
            } else {
                result.add(curr.getData());
                curr = null;
            }
        } while (!stack.isEmpty());
        return result;
    }
}
