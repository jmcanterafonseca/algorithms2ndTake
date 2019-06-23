package Chapter4;

import java.util.*;

// Implements the Dijkstra Algorithm to find the path with less cost
// between a start Node and a destination Node in a Graph
// Node Weights are always positive
// Idea is to calculate less cost path from the starting node to the rest of nodes, including
// the destination Node
public class Dijkstra_Algorithm_A {
    public static List<GraphNode<String>> shortestPath(GraphNode<String> start, GraphNode<String> end) {
        if (start == null || end == null) {
            throw new RuntimeException("start or end cannot be null");
        }

        // Solved Nodes
        Map<String, Node> solvedNodes = new HashMap<>();

        // Priority queue to extract pending nodes from
        PriorityQueue<Node> pendingNodes = new PriorityQueue<>();

        Node processedNode = new Node(start, 0, null);

        while (processedNode != null && processedNode.node != end) {
            if (solvedNodes.get(processedNode.node.value) == null) {
                solvedNodes.put(processedNode.node.value, processedNode);

                int prevDistance = processedNode.distance;
                int childIndex = 0;
                List<GraphNode<String>> adjacentNodes = processedNode.node.adjacentNodes;
                List<Integer> distances = processedNode.node.adjacentNodesWeight;

                for (GraphNode<String> childNode : adjacentNodes) {
                    if (solvedNodes.get(childNode.value) == null) {
                        int childDistance = distances.get(childIndex) + prevDistance;

                        Node pendingChildNode = new Node(childNode, childDistance, processedNode.node);
                        pendingNodes.add(pendingChildNode);
                    }

                    childIndex++;
                }
            }

            processedNode = pendingNodes.poll();
        }

        if (processedNode == null) {
            return Collections.emptyList();
        }

        solvedNodes.put(processedNode.node.value, processedNode);

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

    // Entries stored in the solved nodes and in the priority queue
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
