package Chapter4;

// Checks whether a binary tree is a balanced tree
public class Solution_4_4_CCI_Check_BalancedTree {
    public static boolean solution(BinaryTreeNode<Integer> root) {
        return checkBalanced(root);
    }

    private static boolean checkBalanced(BinaryTreeNode<Integer> subtreeRoot) {
        if (subtreeRoot == null) {
            return true;
        }

        boolean out = isBalanced(subtreeRoot);
        if (out) {
            out = isBalanced(subtreeRoot.left);
        }

        if (out) {
            out = isBalanced(subtreeRoot.right);
        }

        return out;
    }

    public static int calculateHeightSubtree(BinaryTreeNode<Integer> subtree) {
        if (subtree == null) {
            return -1;
        }

        int leftHeight = subtree.leftHeight;
        if (leftHeight == -1) {
            leftHeight = calculateHeightSubtree(subtree.left) + 1;
            subtree.leftHeight = leftHeight;
        }
        int rightHeight = subtree.rightHeight;
        if (rightHeight == -1) {
            rightHeight = calculateHeightSubtree(subtree.right) + 1;
            subtree.rightHeight = rightHeight;
        }

        return Math.max(leftHeight, rightHeight);
    }

    private static boolean isBalanced(BinaryTreeNode<Integer> subtree) {
        if (subtree == null) {
            return true;
        }

        return (Math.abs(calculateHeightSubtree(subtree.left) - calculateHeightSubtree(subtree.right)) <= 1);
    }
}
