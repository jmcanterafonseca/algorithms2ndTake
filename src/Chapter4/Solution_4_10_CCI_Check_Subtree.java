package Chapter4;

import datastr.BinaryTreeNode;

import java.util.LinkedList;
import java.util.Queue;

// CCI Check if T2 is a subtree of T1
public class Solution_4_10_CCI_Check_Subtree {

    public static boolean solution(BinaryTreeNode<Integer> rootT1, BinaryTreeNode<Integer> rootT2) {
        boolean out = false;

        BinaryTreeNode<Integer> startNode = findNode(rootT1, rootT2);

        if (startNode != null) {
            out = areTreesEqual(startNode, rootT2);
        }

        return out;
    }

    // A breadth-first search is gonna be done so that we find in T1 the root of T2
    // Returns null if T2 is not found within T1
    private static BinaryTreeNode<Integer> findNode(BinaryTreeNode<Integer> rootT1, BinaryTreeNode<Integer> rootT2) {
        BinaryTreeNode<Integer> out = null;

        Queue<BinaryTreeNode<Integer>> nodes = new LinkedList<>();

        nodes.add(rootT1);

        boolean found = false;

        while (!nodes.isEmpty() && !found) {
            BinaryTreeNode<Integer> node = nodes.remove();

            if (isEqualNode(node, rootT2)) {
                found = true;
                out = node;
            }

            if (node.left != null) {
                nodes.add(node.left);
            }

            if (node.right != null) {
                nodes.add(node.right);
            }
        }

        return out;
    }

    // Compares two trees. Returns true if T2 is equal to T1
    private static boolean areTreesEqual(BinaryTreeNode<Integer> subTreeOfT1, BinaryTreeNode<Integer> T2) {
        Queue<BinaryTreeNode<Integer>> nodes1 = new LinkedList<>();
        Queue<BinaryTreeNode<Integer>> nodes2 = new LinkedList<>();

        nodes1.add(subTreeOfT1);
        nodes2.add(T2);

        boolean inequalityFound = false;

        while (!nodes1.isEmpty() && !nodes2.isEmpty()) {
            BinaryTreeNode<Integer> node1 = nodes1.poll();
            BinaryTreeNode<Integer> node2 = nodes2.poll();

            if (!isEqualNode(node1, node2)) {
                inequalityFound = true;
                break;
            }

            if (node1.left != null) {
                nodes1.add(node1.left);
            }

            if (node2.left != null) {
                nodes2.add(node2.left);
            }


            if (node1.right != null) {
                nodes1.add(node1.right);
            }

            if (node2.right != null) {
                nodes2.add(node2.right);
            }
        }

        if (!nodes1.isEmpty() || !nodes2.isEmpty()) {
            return false;
        }

        return !inequalityFound;
    }

    private static boolean isEqualNode(BinaryTreeNode<Integer> n1, BinaryTreeNode<Integer> n2) {
        boolean out = false;
        if (n1 == n2) {
            out = true;
        }

        if (n1 != null && n2 != null && n1.value == n2.value) {
            if (n1.parent != null && n2.parent != null) {
                if ((n1.parent.left == n1 && n2.parent.left == n2) ||
                        (n1.parent.right == n1 && n2.parent.right == n2)) {
                    out = true;
                }
            }
            // The case where the root node of the second tree appears
            else if (n2.parent == null) {
                out = true;
            }
        }

        return out;
    }
}
