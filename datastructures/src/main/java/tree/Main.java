package tree;

import tree.avloperation.AVLTreeOperation;
import tree.avloperation.AVLTreeOperationImpl;
import tree.btoperation.RemoveHalfNode;
import tree.model.AVLTreeNode;
import tree.model.BinarySearchTreeNode;
import tree.model.BinaryTreeNode;
import tree.bstoperation.BinarySearchTreeOperation;
import tree.bstoperation.BinarySearchTreeOperationImpl;
import tree.btoperation.ConvertTreeToMirrorImage;
import tree.btoperation.FormTreeFromInOrderAndPreOrder;
import tree.btoperation.PathToLeafNodes;
import tree.btoperation.HeightOfBinaryTree;
import tree.btoperation.InsertElementInBinaryTree;
import tree.btoperation.MaximumElementInBinaryTree;
import tree.btoperation.MaximumSumAtLevelInBinaryTree;
import tree.traversal.InorderTraversal;
import tree.traversal.LevelOrderTraversal;
import tree.traversal.PostOrderTraversal;
import tree.traversal.PreOrderTraversal;
import tree.traversal.TreeTraversal;

import static java.lang.System.out;
import static tree.util.Util.getBinarySearchTree1;
import static tree.util.Util.getTree1;
import static tree.util.Util.print;

public class Main {
    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = getTree1();

        TreeTraversal<Integer> inorderTraversal = new InorderTraversal<>();
        print("Recursive Inorder: ", inorderTraversal.recursive(root));
        print("Iterative Inorder: ", inorderTraversal.iterative(root));

        TreeTraversal<Integer> preOrderTraversal = new PreOrderTraversal();
        print("Recursive PreOrder: ", preOrderTraversal.recursive(root));
        print("Iterative PreOrder: ", preOrderTraversal.iterative(root));

        TreeTraversal<Integer> postOrderTraversal = new PostOrderTraversal();
        print("Recursive PostOrder: ", postOrderTraversal.recursive(root));
        print("Iterative PostOrder: ", postOrderTraversal.iterative(root));

        TreeTraversal<Integer> levelOrderTraversal = new LevelOrderTraversal<>();
        print("Iterative LevelOrder: ", levelOrderTraversal.iterative(root));

        MaximumElementInBinaryTree<Integer> maximumElementInBinaryTree = new MaximumElementInBinaryTree<>();
        print("Recursive Max Element in Tree: ", maximumElementInBinaryTree.recursive(root));
        print("Iterative Max Element in Tree : ", maximumElementInBinaryTree.iterative(root));

        HeightOfBinaryTree<Integer> heightOfBinaryTree = new HeightOfBinaryTree<>();
        print("Recursive Height of Tree: ", heightOfBinaryTree.recursive(root));

        InsertElementInBinaryTree<Integer> insertElementInBinaryTree = new InsertElementInBinaryTree<>();
        print("Before Insertion: ", levelOrderTraversal.iterative(root));
        insertElementInBinaryTree.insert(root, 10);
        print("After Insertion: ", levelOrderTraversal.iterative(root));

        MaximumSumAtLevelInBinaryTree maximumSumAtLevelInBinaryTree = new MaximumSumAtLevelInBinaryTree();
        root = getTree1();
        print("Max Sum at level: ", maximumSumAtLevelInBinaryTree.iterative(root));

        PathToLeafNodes<Integer> pathToLeafNodes = new PathToLeafNodes<>();
        insertElementInBinaryTree.insert(root, 10);
        out.println("All path leaf nodes: ");
        pathToLeafNodes.allPathToLeaves(root).forEach(out::println);
        int sum = 12;
        print("Has Path with sum = " + sum + ": ", pathToLeafNodes.hasPathSum(root, sum));

        ConvertTreeToMirrorImage<Integer> convertTreeToMirrorImage = new ConvertTreeToMirrorImage<>();
        root = getTree1();
        print("Tree before mirroring: ", levelOrderTraversal.iterative(root));
        root = convertTreeToMirrorImage.recursive(root);
        print("Tree after mirroring: ", levelOrderTraversal.iterative(root));

        FormTreeFromInOrderAndPreOrder<Integer> formTreeFromInOrderAndPreOrder = new FormTreeFromInOrderAndPreOrder<>();
        BinaryTreeNode<Integer> formed = formTreeFromInOrderAndPreOrder.recursive(inorderTraversal.recursive(root), preOrderTraversal.recursive(root));
        out.println("Tree Formed: " + levelOrderTraversal.iterative(formed) + " | expected: " + levelOrderTraversal.iterative(root));

        //--------------------
        BinarySearchTreeNode<Integer> bstRoot = getBinarySearchTree1();
        BinarySearchTreeOperation<Integer> operation = new BinarySearchTreeOperationImpl<>();
        print("Binary Search Tree (LevelOrder): ", levelOrderTraversal.iterative(bstRoot));
        print("Binary Search Tree (InOrder): ", inorderTraversal.iterative(bstRoot));
        //deleting a leaf node
        bstRoot = operation.delete(bstRoot, 18);
        print("BST after deleting leaf node (18) (LevelOrder): ", levelOrderTraversal.iterative(bstRoot));
        bstRoot = operation.insert(bstRoot, 18);

        //deleting a node having both left and right child
        operation.delete(bstRoot, 15);
        print("BST after deleting intermediate node (15) (LevelOrder): ", levelOrderTraversal.iterative(bstRoot));

        //--------------------

        AVLTreeNode<Integer> avlRoot = null;
        AVLTreeOperation<Integer> avlTreeOperation = new AVLTreeOperationImpl<>();
        avlRoot = avlTreeOperation.insert(avlRoot, 4 );
        avlRoot = avlTreeOperation.insert(avlRoot, 9 );
        avlRoot = avlTreeOperation.insert(avlRoot, 6 );
        avlRoot = avlTreeOperation.insert(avlRoot, 2 );
        avlRoot = avlTreeOperation.insert(avlRoot, 3 );
        print("AVL Tree (LevelOrder): ", levelOrderTraversal.iterative(avlRoot));

        //-------------------

        root = new BinaryTreeNode<>(1);
        root.setLeft(new BinaryTreeNode<>(2));
        root.getLeft().setLeft(new BinaryTreeNode<>(3));
        print("Before removing half nodes: ", levelOrderTraversal.iterative(root));
        RemoveHalfNode<Integer> removeHalfNode = new RemoveHalfNode<>();
        root = removeHalfNode.remove(root);
        print("Before removing half nodes: ", levelOrderTraversal.iterative(root));
    }
}
