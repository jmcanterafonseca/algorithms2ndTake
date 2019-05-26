package Chapter4;

import java.util.HashSet;
import java.util.Set;

// Given a directed graph design an algorithm to check whether there is a path between a pair of nodes
// Assumption is that both nodes actually exist within the graph
public class Solution_4_1_CCI_Route_BetweenGraphNodes {
    public static boolean solution(GraphNode<Integer> n1, GraphNode<Integer> n2) {
        Set<GraphNode<Integer>> visited = new HashSet<>();

        return search(n1, n2, visited);
    }

    private static boolean search(GraphNode<Integer> n1, GraphNode<Integer> n2, Set<GraphNode<Integer>> visited) {
        if (isEqualNode(n1, n2)) {
            return true;
        }

        boolean out = false;

        visited.add(n1);

        for (GraphNode<Integer> node : n1.children) {
            if (!visited.contains(node)) {
                if (isEqualNode(node, n2)) {
                    out = true;
                    break;
                } else {
                    out = search(node, n2, visited);
                    if (out) {
                        break;
                    }
                }
            }
        }

        return out;
    }

    private static boolean isEqualNode(GraphNode<Integer> n1, GraphNode<Integer> n2) {
        if (n1 == n2) {
            return true;
        }

        return false;
    }
}
