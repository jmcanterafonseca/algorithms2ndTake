package Chapter4;

import datastr.BinaryTreeNode;

// Given two nodes of a binary tree finds the common ancestor
// Assumption is that both nodes actually exist within the tree
public class Solution_4_8_CCI_Common_Ancestor_Binary_Tree {
    public static BinaryTreeNode<Integer> solution(BinaryTreeNode<Integer> n1, BinaryTreeNode<Integer> n2) {
        return commonAncestor(n1, n2);
    }

    private static BinaryTreeNode<Integer> commonAncestor(BinaryTreeNode<Integer> n1, BinaryTreeNode<Integer> n2) {
        if (n1.parent == null) {
            return n1;
        }

        if (n2.parent == null) {
            return n2;
        }

        if (n1 == n2) {
            return n1.parent;
        }

        boolean found = find(n1.parent, n2);

        if (found) {
            return n1.parent;
        }

        return commonAncestor(n1.parent, n2);
    }

    private static boolean find(BinaryTreeNode<Integer> start, BinaryTreeNode<Integer> target) {
        if (isEqualNode(start, target)) {
            return true;
        }

        boolean found = false;

        if (start.left != null && !start.left.visited) {
            found = find(start.left, target);
            start.left.visited = true;
        }

        if (!found && start.right != null && !start.right.visited) {
            found = find(start.right, target);
            start.right.visited = true;
        }

        return found;
    }

    private static boolean isEqualNode(BinaryTreeNode<Integer> n1, BinaryTreeNode<Integer> n2) {
        if (n1 == n2) {
            return true;
        }

        return false;
    }
}
