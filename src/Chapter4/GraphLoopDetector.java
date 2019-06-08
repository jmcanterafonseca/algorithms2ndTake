package Chapter4;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// Detects whether there are loops in a Graph i.e. there is a route from one node to itself
public class GraphLoopDetector<T> {

    public boolean verdict(Collection<GraphNode<T>> startNodes) {
        Set<GraphNode<T>> visited = new HashSet<>();

        boolean out = false;

        for (GraphNode<T> node : startNodes) {
            if (!visited.contains(node)) {
                if (isThereLoop(node, visited)) {
                    out = true;
                    break;
                }
            }
        }

        return out;
    }

    private boolean isThereLoop(GraphNode<T> startNode, Set<GraphNode<T>> visited) {
        boolean out = false;

        visited.add(startNode);

        for (GraphNode<T> node : startNode.adjacentNodes) {
            if (!visited.contains(node)) {
                Set<GraphNode<T>> searchVisit = new HashSet<>();
                if (search(node, startNode, searchVisit)) {
                    out = true;
                } else {
                    out = isThereLoop(node, visited);
                }
            }

            if (out) {
                break;
            }
        }

        return out;
    }

    private boolean search(GraphNode<T> n1, GraphNode<T> n2, Set<GraphNode<T>> visited) {
        if (isEqualNode(n1, n2)) {
            return true;
        }

        boolean out = false;

        visited.add(n1);

        for (GraphNode<T> node : n1.adjacentNodes) {
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

    private boolean isEqualNode(GraphNode<T> n1, GraphNode<T> n2) {
        if (n1 == n2) {
            return true;
        }

        return false;
    }
}
