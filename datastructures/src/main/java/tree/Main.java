package tree;

import tree.model.BinaryTreeNode;
import tree.problems.ConvertTreeToMirrorImage;
import tree.problems.FormTreeFromInOrderAndPreOrder;
import tree.problems.PathToLeafNodes;
import tree.problems.HeightOfBinaryTree;
import tree.problems.InsertElementInBinaryTree;
import tree.problems.MaximumElementInBinaryTree;
import tree.problems.MaximumSumAtLevelInBinaryTree;
import tree.traversal.InorderTraversal;
import tree.traversal.LevelOrderTraversal;
import tree.traversal.PostOrderTraversal;
import tree.traversal.PreOrderTraversal;
import tree.traversal.TreeTraversal;

import static java.lang.System.out;
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
//        root = formTreeFromInOrderAndPreOrder.recursive(new Integer[]{4,2,5,1,6,3,7}, new Integer[]{1,2,4,5,3,6,7});
        BinaryTreeNode<Integer> formed = formTreeFromInOrderAndPreOrder.recursive(inorderTraversal.recursive(root), preOrderTraversal.recursive(root));
        out.println("Tree Formed: " + levelOrderTraversal.iterative(formed) + " | expected: " + levelOrderTraversal.iterative(root));
    }
}
