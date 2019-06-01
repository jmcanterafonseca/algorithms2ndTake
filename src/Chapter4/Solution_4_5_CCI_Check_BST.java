package Chapter4;

// Given two nodes of a binary tree finds the common ancestor
// Assumption is that both nodes actually exist within the tree
public class Solution_4_5_CCI_Check_BST {
    public static boolean solution(BinaryTreeNode<Integer> root) {
        return checkBST(root);
    }

    private static boolean checkBST(BinaryTreeNode<Integer> subtreeRoot) {
        if (subtreeRoot == null) {
            return true;
        }

        boolean out = isBST(subtreeRoot);
        if (out) {
            out = isBST(subtreeRoot.left);
        }

        if (out) {
            out = isBST(subtreeRoot.right);
        }

        return out;
    }

    private static boolean isBST(BinaryTreeNode<Integer> subtree) {
        if (subtree == null) {
            return true;
        }

        BinaryTreeNode<Integer> parent = subtree.parent;

        boolean out = true;
        if (subtree.left != null) {
            out = (subtree.left.value < subtree.value);
            if (out && parent != null && parent.left == subtree) {
                out = (parent.value > subtree.left.value);
            }
            if (out && parent != null && parent.right == subtree) {
                out = (parent.value < subtree.left.value);
            }
        }
        if (subtree.right != null && out) {
            out = (subtree.right.value > subtree.value);
            if (out && parent != null && parent.right == subtree) {
                out = (parent.value < subtree.right.value);
            }
            if (out && parent != null && parent.left == subtree) {
                out = (parent.value > subtree.right.value);
            }
        }

        return out;
    }
}
