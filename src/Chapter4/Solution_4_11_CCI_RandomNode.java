package Chapter4;

import datastr.BinaryTreeNode;
import datastr.TestBinaryTree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Random;

// Cracking the coding interview exercise 4.11
// Binary tree with find, insert, delete, randomNode
// Idea is that if the number of Nodes in the tree is known a priori a random number
// can be obtained between 1 and the number of nodes
// Then it is a matter of traversing the tree using BFS until the number of Nodes
// conveyed by the random number has been reached
public class Solution_4_11_CCI_RandomNode {
    public static BinaryTreeNode<Integer> solution(TestBinaryTree tree) {
        int numNodes = tree.nodes.size();

        if (numNodes == 0) {
            throw new RuntimeException("Empty tree");
        }

        int randomNumber = getRandomNumberInRange(1, numNodes);

        return getNodeNumber(tree.root, randomNumber);
    }

    private static BinaryTreeNode<Integer> getNodeNumber(BinaryTreeNode<Integer> root, int nodeNumber) {
        Deque<BinaryTreeNode<Integer>> nodeList = new ArrayDeque<>();

        nodeList.addFirst(root);

        while (nodeList.size() < nodeNumber) {
            BinaryTreeNode<Integer> nextToProcess = nodeList.peekFirst();

            if (nextToProcess.left != null) {
                nodeList.addFirst(nextToProcess.left);
            }
            if (nextToProcess.right != null && nodeList.size() < nodeNumber) {
                nodeList.addFirst(nextToProcess.right);
            }
        }

        return nodeList.peekFirst();
    }

    private static int getRandomNumberInRange(int min, int max) {
        if (min > max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

}
