package Chapter4;

import java.util.*;

// Floyd Warshall algorithm
// This version takes as input a double hash that holds the distance matrix
// In this version the output of the algorithm is also a double hash that
// contains the min distance between each pair of nodes and the previous node in the path
// Using that double hash the shortest path to be followed between each pair of nodes can be obtained
// See also implementation that just takes as input and adjacency matrix of integers
public class Floyd_Warshall_Algorithm_Ext {
    private static int INF_DISTANCE = 99999;

    public static Map<String, Map<String, VertexDistancePair>> shortestPathPairs(GraphAsMatrix<String> graph) {
        Map<String, Map<String, VertexDistancePair>> out = new HashMap<>();

        Collection<GraphVertex<String>> vertices = graph.vertices.values();

        // Initialize out just in case the shortest path between a and b it is just from a to b
        for (GraphVertex<String> gv : vertices) {
            Map<String, VertexDistancePair> vdistanceMap = new HashMap<>();
            out.put(gv.label, vdistanceMap);

            Collection<String> adjacents = graph.distances.get(gv.label).keySet();
            for (String adjacent : adjacents) {
                vdistanceMap.put(adjacent, new VertexDistancePair(graph.distances.get(gv.label).get(adjacent),
                        null));
            }

            vdistanceMap.put(gv.label, new VertexDistancePair(0, null));
        }

        for (GraphVertex<String> vertexK : vertices) {
            for (GraphVertex<String> vertexI : vertices) {
                for (GraphVertex<String> vertexJ : vertices) {
                    int distanceIJ = getDistance(vertexI, vertexJ, out);
                    int distanceIK = getDistance(vertexI, vertexK, out);
                    int distanceKJ = getDistance(vertexK, vertexJ, out);

                    if (distanceIK + distanceKJ < distanceIJ) {
                        setDistanceThrough(vertexI, vertexJ, vertexK, distanceIK + distanceKJ, out);
                    }
                }
            }
        }

        return out;
    }

    // Here we are calculating the shortest distance pairs for each call to this method
    // ideally we should only do this one time as we are calculating every possible combination
    public static List<String> shortestPath(GraphVertex<String> start, GraphVertex<String> end,
                                            GraphAsMatrix<String> graph) {

        // First all the shortest path pairs are calculated
        Map<String, Map<String, VertexDistancePair>> shortestPairs = shortestPathPairs(graph);

        // Now it is as easy as
        VertexDistancePair vpair = shortestPairs.get(start.label).get(end.label);
        if (vpair == null) {
            return Collections.emptyList();
        }

        Deque<String> stack = new ArrayDeque<>();

        GraphVertex<String> currentVertex = end;

        while (currentVertex != null) {
            stack.push(currentVertex.label);
            currentVertex = shortestPairs.get(start.label).get(currentVertex.label).previousVertex;
        }

        if (start != end) {
            stack.push(start.label);
        }

        List<String> out = new ArrayList<>();
        out.addAll(stack);

        return out;
    }

    private static void setDistanceThrough(GraphVertex<String> gv1, GraphVertex<String> gv2, GraphVertex<String> gv3,
                                           int distance, Map<String, Map<String, VertexDistancePair>> out) {

        Map<String, VertexDistancePair> vtxDistanceMap = out.get(gv1.label);
        if (vtxDistanceMap == null) {
            vtxDistanceMap = new HashMap<>();
            out.put(gv1.label, vtxDistanceMap);
        }
        vtxDistanceMap.put(gv2.label, new VertexDistancePair(distance, gv3));
    }

    private static int getDistance(GraphVertex<String> gv1, GraphVertex<String> gv2,
                                   Map<String, Map<String, VertexDistancePair>> distances) {
        Map<String, VertexDistancePair> distanceHash = distances.get(gv1.label);

        int distance = INF_DISTANCE;

        if (distanceHash.get(gv2.label) != null) {
            distance = distanceHash.get(gv2.label).distance;
        }

        return distance;
    }

    private static class VertexDistancePair {
        public int distance;
        public GraphVertex<String> previousVertex;

        public VertexDistancePair(int distance, GraphVertex<String> previousVertex) {
            this.distance = distance;
            this.previousVertex = previousVertex;
        }
    }
}
