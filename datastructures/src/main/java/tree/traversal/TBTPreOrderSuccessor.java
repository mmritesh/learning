package tree.traversal;

import tree.model.ThreadedBinaryTreeNode;

public class TBTPreOrderSuccessor<T> {
    /**
     * this assumes root node to be a dummy node,
     * which has lTag = 1, left = actual root AND rTag = 1, right = points to itself.
     * @param p
     * @return
     */
    public ThreadedBinaryTreeNode<T> get(ThreadedBinaryTreeNode<T> p) {
        if (p.getlTag() == 1) {
            return p.getLeft();
        }
        ThreadedBinaryTreeNode<T> ptr = p;
        while (ptr.getrTag() == 0) {
            ptr = ptr.getRight();
        }
        return ptr.getRight();
    }
}
