package tree.util;

import tree.model.AVLTreeNode;
import tree.model.BinarySearchTreeNode;
import tree.model.BinaryTreeNode;
import tree.bstoperation.BinarySearchTreeOperation;
import tree.bstoperation.BinarySearchTreeOperationImpl;

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

    public static BinarySearchTreeNode<Integer> getBinarySearchTree1() {
        BinarySearchTreeNode<Integer> root = new BinarySearchTreeNode<>(10);

        BinarySearchTreeOperation<Integer> operation = new BinarySearchTreeOperationImpl<>();
        operation.insert(root, 5);
        operation.insert(root, 15);
        operation.insert(root, 6);
        operation.insert(root, 12);
        operation.insert(root, 14);
        operation.insert(root, 13);
        operation.insert(root, 4);
        operation.insert(root, 18);
        return root;
    }

//    public static AVLTreeNode<Integer> getAVLTree1() {
//        avlRoot = avlTreeOperation.insert(avlRoot, 4 );
//
//    }
    public static void print(String msg, Object obj) {
        System.out.println(msg + obj);
    }
}
