package tree.traversal;

import tree.model.ThreadedBinaryTreeNode;

public class TBTInOrderSuccessorFor<T> {

    /**
     * this assumes root node to be a dummy node,
     * which has lTag = 1, left = actual root AND rTag = 1, right = points to itself.
     * @param p
     * @return
     */
    public ThreadedBinaryTreeNode<T> get(ThreadedBinaryTreeNode<T> p) {
        if (p.getrTag() == 0) {
            return p.getRight();
        }
        ThreadedBinaryTreeNode<T> ptr = p;
        while (ptr.getlTag() == 1) {
            ptr = ptr.getLeft();
        }
        return ptr;
    }
}
