package Chapter4;

import java.util.ArrayList;
import java.util.List;

// CCI 4.1 Finds a path between two nodes in a graph (not necessarily the shortest path)
// Returns empty list if there is no a path
public class GraphPathFinder<T> {
    public List<T> calculate(GraphNode<T> n1, GraphNode<T> n2) {
        return getPath(n1, n2);
    }

    private List<T> getPath(GraphNode<T> n1, GraphNode<T> n2) {
        if (isEqualNode(n1, n2)) {
            return new ArrayList<>();
        }

        return searchPath(n1, n2);
    }

    private List<T> searchPath(GraphNode<T> n1, GraphNode<T> n2) {
        List<T> out = null;

        if (isEqualNode(n1, n2)) {
            out = new ArrayList<>();

            out.add(n2.value);
            return out;
        }

        n1.visited = true;

        for (GraphNode<T> node : n1.adjacentNodes) {
            if (!node.visited) {
                List<T> subPath = searchPath(node, n2);
                if (subPath != null) {
                    out = new ArrayList<>();
                    out.add(n1.value);
                    out.addAll(subPath);
                    break;
                }
            }
        }

        return out;
    }

    private boolean isEqualNode(GraphNode<T> n1, GraphNode<T> n2) {
        if (n1 == n2) {
            return true;
        }

        return false;
    }
}
