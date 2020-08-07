package tree.traversal;

import tree.model.BinaryTreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ZigzagTraversal<T> implements TreeTraversal<T> {
    @Override
    public List<T> recursive(BinaryTreeNode<T> root) {
        return null;
    }

    @Override
    public List<T> iterative(BinaryTreeNode<T> root) {
        List<T> result = new ArrayList<>();
        Stack<BinaryTreeNode<T>> currentLevel = new Stack<>();
        Stack<BinaryTreeNode<T>> nextLevel = new Stack<>();
        BinaryTreeNode<T> ptr;
        currentLevel.push(root);
        boolean leftToRight = true;

        while(!currentLevel.isEmpty()) {

            ptr = currentLevel.pop();
            result.add(ptr.getData());

            if(leftToRight) {
                pushIfNotNull(nextLevel, ptr.getLeft());
                pushIfNotNull(nextLevel, ptr.getRight());
            } else {
                pushIfNotNull(nextLevel, ptr.getRight());
                pushIfNotNull(nextLevel, ptr.getLeft());
            }
            if (currentLevel.empty()) {
                leftToRight = !leftToRight;
                Stack<BinaryTreeNode<T>> temp = currentLevel;
                currentLevel = nextLevel;
                nextLevel = temp;
            }
        }
        return result;
    }

    private void pushIfNotNull(Stack<BinaryTreeNode<T>> nextLevel, BinaryTreeNode<T> node) {
        if (node != null) {
            nextLevel.push(node);
        }
    }
}
