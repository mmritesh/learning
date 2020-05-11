package tree.btoperation;

import tree.model.BinaryTreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class InsertElementInBinaryTree<T> {
    //Insertion by level order

    public BinaryTreeNode<T> insert(BinaryTreeNode<T> root, T element) {
        Queue<BinaryTreeNode<T>> queue = new LinkedList<>();
        BinaryTreeNode<T> ptr = null;
        queue.offer(root);

        while (!queue.isEmpty()) {
            ptr = queue.poll();
            if (ptr.getLeft() != null) {
                queue.offer(ptr.getLeft());
            } else {
                ptr.setLeft(new BinaryTreeNode<>(element));
                return root;
            }
            if (ptr.getRight() != null) {
                queue.offer(ptr.getRight());
            } else {
                ptr.setRight(new BinaryTreeNode<>(element));
                return root;
            }
        }
        return root;
    }
}
