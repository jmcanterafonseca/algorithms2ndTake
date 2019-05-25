package Chapter4;

// Given a directed graph design an algorithm to check whether there is a path between a pair of nodes
// Assumption is that both nodes actually exist within the graph
public class Solution_4_1_CCI_Route_BetweenGraphNodes {
    public static boolean solution(GraphNode<Integer> n1, GraphNode<Integer> n2) {
        return true;
    }

    private static boolean isEqualNode(BinaryTreeNode<Integer> n1, BinaryTreeNode<Integer> n2) {
        if (n1 == n2) {
            return true;
        }

        return false;
    }
}
