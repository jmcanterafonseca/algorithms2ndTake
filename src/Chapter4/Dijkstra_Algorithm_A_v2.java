package Chapter4;

import java.util.*;

// Implements the Dijkstra Algorithm to find the path with less cost
// between a start Vertex and a destination Vertex in a Graph
// Edge Weights are always positive, otherwise it does not work
// Idea is to calculate less cost path from the starting Vertex to the rest of Vertices, including
// the destination Vertex
// The time complexity of Dijkstra Algorithm is O(V LOG V)
public class Dijkstra_Algorithm_A_v2 {
    public static List<GraphNode<String>> shortestPath(GraphNode<String> start, GraphNode<String> end) {
        if (start == null || end == null) {
            throw new RuntimeException("start or end cannot be null");
        }

        // Solved Vertices
        Map<String, Vertex> solvedVertices = new HashMap<>();
        // Pending Vertices used to have O(1) access to pending vertices which are
        // on the priority queue
        Map<String, Vertex> vertices = new HashMap<>();

        // Priority queue to extract pending nodes from
        PriorityQueue<Vertex> pendingVertexQueue = new PriorityQueue<>();

        Vertex processedVertex = new Vertex(start, 0, null);
        pendingVertexQueue.add(processedVertex);
        vertices.put(start.value, processedVertex);

        boolean targetFound = false;

        while (!pendingVertexQueue.isEmpty() && !targetFound) {
            Vertex nextVertex = pendingVertexQueue.poll();

            solvedVertices.put(nextVertex.node.value, nextVertex);

            if (nextVertex.node != end) {
                int prevDistance = nextVertex.distance;
                int childIndex = 0;
                List<GraphNode<String>> adjacentNodes = nextVertex.node.adjacentNodes;
                List<Integer> distances = nextVertex.node.adjacentNodesWeight;

                for (GraphNode<String> childNode : adjacentNodes) {
                    int childDistance = distances.get(childIndex) + prevDistance;

                    Vertex pendingChildVertex = vertices.get(childNode.value);
                    if (pendingChildVertex == null) {
                        pendingChildVertex = new Vertex(childNode, childDistance, nextVertex.node);

                        vertices.put(pendingChildVertex.node.value, pendingChildVertex);
                        pendingVertexQueue.add(pendingChildVertex);
                    } else {
                        if (pendingChildVertex.distance > childDistance) {
                            pendingChildVertex.distance = childDistance;
                            pendingChildVertex.previousNode = nextVertex.node;
                        }
                    }

                    childIndex++;
                }
            } else {
                targetFound = true;
            }
        }

        if (!targetFound) {
            return Collections.emptyList();
        }

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
