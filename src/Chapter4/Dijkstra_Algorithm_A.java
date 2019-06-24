package Chapter4;

import java.util.*;

// Implements the Dijkstra Algorithm to find the path with less cost
// between a start Vertex and a destination Vertex in a Graph
// Edge Weights are always positive
// Idea is to calculate less cost path from the starting Vertex to the rest of Vertices, including
// the destination Vertex
public class Dijkstra_Algorithm_A {
    public static List<GraphNode<String>> shortestPath(GraphNode<String> start, GraphNode<String> end) {
        if (start == null || end == null) {
            throw new RuntimeException("start or end cannot be null");
        }

        // Solved Vertices
        Map<String, Vertex> solvedVertices = new HashMap<>();
        // Pending Vertices
        Map<String, Vertex> pendingVertices = new HashMap<>();

        // Priority queue to extract pending nodes from
        PriorityQueue<Vertex> pendingVertexQueue = new PriorityQueue<>();

        Vertex processedVertex = new Vertex(start, 0, null);

        while (processedVertex != null && processedVertex.node != end) {
            if (solvedVertices.get(processedVertex.node.value) == null) {
                solvedVertices.put(processedVertex.node.value, processedVertex);
                pendingVertices.remove(processedVertex.node.value);

                int prevDistance = processedVertex.distance;
                int childIndex = 0;
                List<GraphNode<String>> adjacentNodes = processedVertex.node.adjacentNodes;
                List<Integer> distances = processedVertex.node.adjacentNodesWeight;

                for (GraphNode<String> childNode : adjacentNodes) {
                    if (solvedVertices.get(childNode.value) == null) {
                        int childDistance = distances.get(childIndex) + prevDistance;

                        Vertex pendingChildVertex = pendingVertices.get(childNode.value);
                        if (pendingChildVertex == null) {
                            pendingChildVertex = new Vertex(childNode, childDistance, processedVertex.node);

                            pendingVertices.put(pendingChildVertex.node.value, pendingChildVertex);
                            pendingVertexQueue.add(pendingChildVertex);
                        } else {
                            if (pendingChildVertex.distance > childDistance) {
                                pendingChildVertex.distance = childDistance;
                                pendingChildVertex.previousNode = processedVertex.node;
                            }
                        }
                    }

                    childIndex++;
                }
            }

            processedVertex = pendingVertexQueue.poll();
        }

        if (processedVertex == null) {
            return Collections.emptyList();
        }

        solvedVertices.put(processedVertex.node.value, processedVertex);

        // Now the solvedNodes Map is processed to obtain the route
        GraphNode<String> routeNode = end;

        Deque<GraphNode<String>> stack = new ArrayDeque<>();

        while (routeNode != null) {
            stack.addFirst(routeNode);
            routeNode = solvedVertices.get(routeNode.value).previousNode;
        }

        List<GraphNode<String>> out = new ArrayList<>();
        out.addAll(stack);

        return out;
    }

    // Entries stored in the solved nodes and in the priority queue
    private static class Vertex implements Comparable<Vertex> {
        public GraphNode<String> node;
        public int distance;
        public GraphNode<String> previousNode;

        public Vertex(GraphNode<String> node, int distance, GraphNode<String> previousNode) {
            this.node = node;
            this.distance = distance;
            this.previousNode = previousNode;
        }

        public int compareTo(Vertex other) {
            return this.distance - other.distance;
        }
    }

}
