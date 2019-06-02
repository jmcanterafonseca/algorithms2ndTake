package Chapter4;

import java.util.HashSet;
import java.util.Set;

// CCI 4.1 Find a route between two nodes in a Graph
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

        for (GraphNode<Integer> node : n1.adjacentNodes) {
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
