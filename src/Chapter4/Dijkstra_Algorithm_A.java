package Chapter4;

import java.util.*;

// Implements the Dijkstra Algorithm to find the path with less cost
// between a start Node and a destination Node in a Graph
// Node Weights are always positive
// Idea is to calculate less cost path from the starting node to the rest of nodes, including
// the destination Node
public class Dijkstra_Algorithm_A {
    public static List<GraphNode<String>> shortestPath(GraphNode<String> start, GraphNode<String> end) {
        // Solved Nodes
        Map<String, SolvedNode> solvedNodes = new HashMap<>();

        // Priority queue to extract pending nodes from
        PriorityQueue<PendingNode> pendingNodes = new PriorityQueue<>();

        // The start node starts in pending
        pendingNodes.add(new PendingNode(start, 0));

        GraphNode<String> previousNode = null;

        while (true) {
            PendingNode pendingNode = pendingNodes.remove();

            SolvedNode solvedNode = new SolvedNode(pendingNode, previousNode);

            int prevDistance = solvedNode.distance;


            if (solvedNodes.get(pendingNode.node.value) == null) {
                solvedNodes.put(solvedNode.node.value, solvedNode);

                if (solvedNode.node == end) {
                    break;
                }

                int childIndex = 0;
                List<GraphNode<String>> adjacentNodes = solvedNode.node.adjacentNodes;
                List<Integer> distances = solvedNode.node.adjacentNodesWeight;

                for (GraphNode<String> childNode : adjacentNodes) {
                    if (solvedNodes.get(childNode.value) == null) {
                        PendingNode pendingChildNode = new PendingNode(childNode,
                                distances.get(childIndex) + prevDistance);
                        pendingNodes.add(pendingChildNode);
                    }

                    childIndex++;
                }
            }

            previousNode = pendingNode.node;
        }

        // Now the solvedNodes Map is processed to obtain the route
        GraphNode<String> routeNode = end;

        Deque<GraphNode<String>> stack = new ArrayDeque<>();

        while (routeNode != null) {
            stack.addFirst(routeNode);
            routeNode = solvedNodes.get(routeNode.value).previousNode;
        }

        List<GraphNode<String>> out = new ArrayList<>();
        out.addAll(stack);

        return out;
    }

    private static class SolvedNode {
        public GraphNode<String> node;
        public int distance;
        public GraphNode<String> previousNode;

        public SolvedNode(PendingNode pendingNode, GraphNode<String> previousNode) {
            this.node = pendingNode.node;
            this.distance = pendingNode.distance;
            this.previousNode = previousNode;
        }
    }

    private static class PendingNode implements Comparable<PendingNode> {
        public GraphNode<String> node;
        public int distance;

        public PendingNode(GraphNode<String> node, int distance) {
            this.node = node;
            this.distance = distance;
        }

        public int compareTo(PendingNode other) {
            return this.distance - other.distance;
        }
    }
}
