package tree.btoperation;

import tree.model.BinaryTreeNode;

import java.util.ArrayList;
import java.util.List;

public class PathToLeafNodes<T> {

    List<List<T>> result = new ArrayList<>();

    public List<List<T>> allPathToLeaves(BinaryTreeNode<T> root) {
        allPathToLeaves(root, new ArrayList<>());
        return result;
    }

    private void allPathToLeaves(BinaryTreeNode<T> root, List<T> path) {
        if (root == null) {
            return;
        }
        path.add(root.getData());
        if (!root.hasLeft() && !root.hasRight()) {
            result.add(new ArrayList<>(path));
        } else {
            allPathToLeaves(root.getLeft(), path);
            allPathToLeaves(root.getRight(), path);
        }
        path.remove(path.size() - 1);
    }

    public boolean hasPathSum(BinaryTreeNode<Integer> root, int sum) {
        if (root == null) {
            return false;
        }
        if (!root.hasLeft() && !root.hasRight() && root.getData().equals(sum)) {
            return true;
        }
        return hasPathSum(root.getLeft(), sum - root.getData()) ||
                hasPathSum(root.getRight(), sum - root.getData());
    }

}
