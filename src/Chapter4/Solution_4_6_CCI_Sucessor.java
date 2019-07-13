package Chapter4;

import datastr.BinaryTreeNode;

// Finds the "next node" (i.e. in-order successor) of a given node in a BST
public class Solution_4_6_CCI_Sucessor {
    public static BinaryTreeNode<Integer> solution(BinaryTreeNode<Integer> target) {
        BinaryTreeNode<Integer> out = null;

        // The leftmost to the right of the target will be the successor
        if (target.right != null) {
            out = target.right;
            while (out.left != null) {
                out = out.left;
            }
        } else {
            BinaryTreeNode<Integer> parent = target.parent;
            if (parent != null) {
                // The target is already at the right of the parent so no further successor
                if (parent.right == target) {
                    out = null;
                    if (parent.parent != null && parent.parent.left == parent) {
                        out = parent.parent;
                    }
                } else {
                    // parent.left == target
                    // The leftmost to the right of the parent will be the successor
                    out = parent.right;
                    while (out != null) {
                        out = out.left;
                    }
                }
            }
        }

        return out;
    }

}
