package Chapter4;

// CCI 4.2 Builds a Binary Search Tree (with minimal height) from a sorted array (increasing order)
public class Solution_4_2_CCI_Minimal_Height_Tree {
    // The root of the BST created is returned
    public static BinaryTreeNode<Integer> solution(int[] sortedArray) {
        if (sortedArray.length == 0) {
            return null;
        }

        return getBalancedTree(sortedArray, 0, sortedArray.length - 1);
    }

    public static BinaryTreeNode<Integer> getBalancedTree(int[] sortedArray, int start, int end) {
        int middleIndex = start + (end - start) / 2;

        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(sortedArray[middleIndex]);

        if (end - middleIndex > 1) {
            root.right = getBalancedTree(sortedArray, middleIndex + 1, end);
            root.right.parent = root;
        } else if (middleIndex + 1 <= end) {
            root.right = new BinaryTreeNode<>(root, sortedArray[middleIndex + 1]);
        }

        if (middleIndex - start > 1) {
            root.left = getBalancedTree(sortedArray, start, middleIndex - 1);
            root.left.parent = root;
        } else if (middleIndex - 1 >= start) {
            root.left = new BinaryTreeNode<>(root, sortedArray[middleIndex - 1]);
        }

        return root;
    }
}
