package tree;

import tree.model.BinaryTreeNode;
import tree.problems.HeightOfBinaryTree;
import tree.problems.MaximumElementInBinaryTree;
import tree.traversal.InorderTraversal;
import tree.traversal.LevelOrderTraversal;
import tree.traversal.PostOrderTraversal;
import tree.traversal.PreOrderTraversal;
import tree.traversal.TreeTraversal;

import static tree.util.Util.getTree1;
import static tree.util.Util.print;

public class Main {
    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = getTree1();
        TreeTraversal inorderTraversal = new InorderTraversal<>();
        print("Recursive Inorder: ", inorderTraversal.recursive(root));
        print("Iterative Inorder: ", inorderTraversal.iterative(root));

        TreeTraversal preOrderTraversal = new PreOrderTraversal();
        print("Recursive PreOrder: ", preOrderTraversal.recursive(root));
        print("Iterative PreOrder: ", preOrderTraversal.iterative(root));

        TreeTraversal postOrderTraversal = new PostOrderTraversal();
        print("Recursive PostOrder: ", postOrderTraversal.recursive(root));
        print("Iterative PostOrder: ", postOrderTraversal.iterative(root));

        TreeTraversal levelOrderTraversal = new LevelOrderTraversal();
        print("Iterative LevelOrder: ", levelOrderTraversal.iterative(root));

        MaximumElementInBinaryTree<Integer> maximumElementInBinaryTree = new MaximumElementInBinaryTree<>();
        print("Recursive Max Element in Tree: ", maximumElementInBinaryTree.recursive(root));
        print("Iterative Max Element in Tree : ", maximumElementInBinaryTree.iterative(root));

        HeightOfBinaryTree<Integer> heightOfBinaryTree = new HeightOfBinaryTree<>();
        print("Recursive Height of Tree: ", heightOfBinaryTree.recursive(root));
    }
}
