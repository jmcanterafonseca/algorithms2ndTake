package Chapter4;

// Checks whether a binary tree is a Binary Search Tree (BST)
public class Solution_4_5_CCI_Check_BST {
    public static boolean solution(BinaryTreeNode<Integer> root) {
        return checkTree(root);
    }

    private static boolean checkTree(BinaryTreeNode<Integer> subtree) {
        if (subtree == null) {
            return true;
        }

        boolean out = true;
        if (subtree.left != null) {
            out = (subtree.left.value <= subtree.value);
            if (out) {
                out = isLeftBST(subtree.left, subtree.value);
            }
            if (out) {
                checkTree(subtree.left);
            }
        }

        if (out && subtree.right != null) {
            out = (subtree.right.value >= subtree.value);
            if (out) {
                out = isRightBST(subtree, subtree.value);
            }
            if (out) {
                out = checkTree(subtree.right);
            }
        }

        return out;
    }

    private static boolean isLeftBST(BinaryTreeNode<Integer> subtree, int referenceValue) {
        if (subtree == null) {
            return true;
        }

        boolean out = true;
        if (subtree.left != null) {
            out = (subtree.left.value <= subtree.value);
            if (out) {
                out = subtree.left.value <= referenceValue;
            }
            if (out) {
                out = isLeftBST(subtree.left, referenceValue);
            }
        }

        if (subtree.right != null) {
            out = subtree.right.value >= subtree.value;
            if (out) {
                out = subtree.right.value <= referenceValue;
            }
            if (out) {
                out = isLeftBST(subtree.right, referenceValue);
            }
        }

        return out;
    }

    private static boolean isRightBST(BinaryTreeNode<Integer> subtree, int referenceValue) {
        if (subtree == null) {
            return true;
        }

        boolean out = true;
        if (subtree.left != null) {
            out = (subtree.left.value <= subtree.value);
            if (out) {
                out = subtree.left.value >= referenceValue;
            }
            if (out) {
                out = isRightBST(subtree.left, referenceValue);
            }
        }

        if (subtree.right != null) {
            out = (subtree.right.value >= subtree.value);
            if (out) {
                out = subtree.right.value >= referenceValue;
            }
            if (out) {
                out = isRightBST(subtree.right, referenceValue);
            }
        }

        return out;
    }
}
