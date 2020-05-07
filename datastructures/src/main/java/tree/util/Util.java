package tree.util;

import tree.model.BinaryTreeNode;

public class Util {

    public static BinaryTreeNode<Integer> getTree1() {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(1);
        root.setLeft(new BinaryTreeNode<>(2));
        root.setRight(new BinaryTreeNode<>(3));
        root.getLeft().setLeft(new BinaryTreeNode<>(4));
        root.getLeft().setRight(new BinaryTreeNode<>(5));
        root.getRight().setLeft(new BinaryTreeNode<>(6));
        root.getRight().setRight(new BinaryTreeNode<>(7));
        return root;
    }

    public static void print(String msg, Object obj) {
        System.out.println(msg + obj);
    }
}
