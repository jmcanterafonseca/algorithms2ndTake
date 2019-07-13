package Chapter4;

import datastr.GraphNode;

import java.util.*;

// Implements the Bellman-Ford Algorithm to find the path with less cost
// between a start Vertex and a destination Vertex in a Graph
// Idea is to calculate less cost path from the starting Vertex to the rest of Vertices, including
// the destination Vertex
// Bellman Ford algorithm has more cost in computational terms but on the other hand is capable of
// dealing with negative edges
// Time complexity of Bellman-Ford is O(VE), being V the number of Vertices and E the number of Edges
// A negative cycle is a graph cycle which sum is negative
public class Bellman_Ford_Algorithm {
    public static List<GraphNode<String>> shortestPath(GraphNode<String> start, GraphNode<String> end) {
        if (start == null || end == null) {
            throw new RuntimeException("start or end cannot be null");
        }

        // Solved Vertices
        Map<String, Vertex> vertices = new HashMap<>();

        //  Queue to extract pending nodes from
        Queue<Vertex> pendingVertexQueue = new LinkedList<>();

        Vertex processedVertex = new Vertex(start, 0, null);

        while (processedVertex != null) {
            if (vertices.get(processedVertex.node.value) == null) {
                vertices.put(processedVertex.node.value, processedVertex);
            }

            int childIndex = 0;
            List<GraphNode<String>> adjacentNodes = processedVertex.node.adjacentNodes;
            List<Integer> distances = processedVertex.node.adjacentNodesWeight;

            int prevDistance = processedVertex.distance;

            for (GraphNode<String> childNode : adjacentNodes) {
                int childDistance = distances.get(childIndex) + prevDistance;
                Vertex pendingChildVertex = vertices.get(childNode.value);

                if (pendingChildVertex == null) {
                    pendingChildVertex = new Vertex(childNode, childDistance, processedVertex.node);

                    vertices.put(pendingChildVertex.node.value, pendingChildVertex);
                    pendingVertexQueue.add(pendingChildVertex);
                } else {
                    if (pendingChildVertex.distance > childDistance) {
                        pendingChildVertex.distance = childDistance;
                        pendingChildVertex.previousNode = processedVertex.node;
                    }
                }

                childIndex++;
            }

            processedVertex = pendingVertexQueue.poll();
        }

        // Last Step to check if there are negative cycles
        Iterator<Vertex> it = vertices.values().iterator();
        while (it.hasNext()) {
            Vertex v = it.next();

            List<Integer> distances = v.node.adjacentNodesWeight;
            int childIndex = 0;

            for (GraphNode child : v.node.adjacentNodes) {
                Vertex childVertex = vertices.get(child.value);
                if (v.distance + distances.get(childIndex) < childVertex.distance) {
                    throw new RuntimeException("negative-cycle");
                }

                childIndex++;
            }
        }

        if (vertices.get(end.value) == null) {
            return Collections.emptyList();
        }

        // Now the solvedNodes Map is processed to obtain the route
        GraphNode<String> routeNode = end;

        Deque<GraphNode<String>> stack = new ArrayDeque<>();

        while (routeNode != null) {
            stack.addFirst(routeNode);
            routeNode = vertices.get(routeNode.value).previousNode;
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
