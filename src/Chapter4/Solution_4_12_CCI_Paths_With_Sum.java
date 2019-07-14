package Chapter4;

import datastr.BinaryTreeNode;
import datastr.TestBinaryTree;

// This solution only works if the path starts with the root node
public class Solution_4_12_CCI_Paths_With_Sum {
    public static int solution(TestBinaryTree tree, int targetSum) {
        IntegerHolder holder = new IntegerHolder();

        checkSumPaths(tree.root, targetSum, holder);

        return holder.value;
    }

    private static void checkSumPaths(BinaryTreeNode<Integer> node, int targetSum, IntegerHolder totalPaths) {
        if (node == null) {
            return;
        }

        checkSumFrom(node, 0, targetSum, totalPaths);

        checkSumPaths(node.left, targetSum, totalPaths);
        checkSumPaths(node.right, targetSum, totalPaths);
    }

    private static void checkSumFrom(BinaryTreeNode<Integer> node, int accSum, int targetSum, IntegerHolder totalPaths) {
        if (node == null) {
            return;
        }

        int newSum = accSum + node.value;
        if (newSum == targetSum) {
            totalPaths.value++;
        }

        checkSumFrom(node.left, newSum, targetSum, totalPaths);
        checkSumFrom(node.right, newSum, targetSum, totalPaths);
    }

    // aux class to put hold the number of paths
    private static class IntegerHolder {
        public int value;
    }
}
