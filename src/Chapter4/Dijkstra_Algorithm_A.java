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
        Map<String, Node> solvedNodes = new HashMap<>();

        // Priority queue to extract pending nodes from
        PriorityQueue<Node> pendingNodes = new PriorityQueue<>();

        // The start node starts in pending
        pendingNodes.add(new Node(start, 0, null));

        while (true) {
            Node node = pendingNodes.remove();

            int prevDistance = node.distance;


            if (solvedNodes.get(node.node.value) == null) {
                solvedNodes.put(node.node.value, node);

                if (node.node == end) {
                    break;
                }

                int childIndex = 0;
                List<GraphNode<String>> adjacentNodes = node.node.adjacentNodes;
                List<Integer> distances = node.node.adjacentNodesWeight;

                for (GraphNode<String> childNode : adjacentNodes) {
                    if (solvedNodes.get(childNode.value) == null) {
                        Node pendingChildNode = new Node(childNode,
                                distances.get(childIndex) + prevDistance, node.node);
                        pendingNodes.add(pendingChildNode);
                    }

                    childIndex++;
                }
            }
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

    private static class Node implements Comparable<Node> {
        public GraphNode<String> node;
        public int distance;
        public GraphNode<String> previousNode;

        public Node(GraphNode<String> node, int distance, GraphNode<String> previousNode) {
            this.node = node;
            this.distance = distance;
            this.previousNode = previousNode;
        }

        public int compareTo(Node other) {
            return this.distance - other.distance;
        }
    }

}
