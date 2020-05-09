package tree.problems;

import tree.model.BinaryTreeNode;

import java.util.List;

public class FormTreeFromInOrderAndPreOrder<T> {

    public BinaryTreeNode<T> recursive(List<T> inOrder, List<T> preOrder) {
        if (inOrder.size() == 0 || inOrder.size() != preOrder.size()) {
            return null;
        }
        return recurse(inOrder, 0, inOrder.size() - 1, preOrder, 0, preOrder.size() - 1);
    }

    private BinaryTreeNode<T> recurse(List<T> inOrder, int inStart, int inEnd, List<T> preOrder, int preStart, int preEnd) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        T data = preOrder.get(preStart);
        int offset;
        BinaryTreeNode<T> root = new BinaryTreeNode<>(data);

        for (offset = inStart; offset < inEnd; offset++) {
            if (inOrder.get(offset) == data) {
                break;
            }
        }
        root.setLeft(recurse(inOrder, inStart, offset - 1, preOrder, preStart + 1, (preStart + (offset - inStart)) ));
        root.setRight(recurse(inOrder, offset + 1, inEnd, preOrder, preStart + offset - inStart + 1, preEnd));
        return root;
    }
}
