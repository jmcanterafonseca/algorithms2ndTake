package Chapter4;

// Checks whether a binary tree is a Binary Search Tree (BST)
public class Solution_4_5_CCI_Check_BST {
    public static boolean solution(BinaryTreeNode<Integer> root) {
        return checkBST(root);
    }

    private static boolean checkBST(BinaryTreeNode<Integer> tree) {
        boolean out = true;

        if (tree.left != null) {
            out = checkBST(tree.left, Integer.MIN_VALUE, tree.value);
        }

        if (out && tree.right != null) {
            out = checkBST(tree.right, tree.value, Integer.MAX_VALUE);
        }

        return out;
    }

    private static boolean checkBST(BinaryTreeNode<Integer> subtree, int minValue, int maxValue) {
        if (subtree == null) {
            return true;
        }

        boolean out = (subtree.value >= minValue && subtree.value <= maxValue);

        if (out) {
            if (subtree.left != null) {
                out = checkBST(subtree.left, minValue, subtree.value);
            }
        }

        if (out) {
            if (subtree.right != null) {
                out = checkBST(subtree.right, subtree.value, maxValue);
            }
        }

        return out;
    }
}
