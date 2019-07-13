package Chapter4;

import datastr.GraphNode;
import org.junit.jupiter.api.Test;

import java.util.*;


public class Test_Floyd_Warshall_Algorithm {
    // The definition of this graph has been taken from GeeksforGeeks
    private String graphStr = "a->b|5,d|10\nb->c|3\nc->d|1";

    private static int INF_DISTANCE = 9999;

    // Transforms from a Graph to a graph matrix representation
    // useful for the Floyd-Warshall algorithm
    private static int[][] fromGraphToMatrix(TestGraph<String> testGraph) {
        int matrixRows = testGraph.nodes.size();

        int[][] graphMatrix = new int[matrixRows][matrixRows];

        // Initialize Matrix
        for (int j = 0; j < graphMatrix.length; j++) {
            for (int k = 0; k < graphMatrix.length; k++) {
                if (j == k) {
                    graphMatrix[j][k] = 0;
                } else {
                    graphMatrix[j][k] = INF_DISTANCE;
                }
            }
        }

        Iterator<GraphNode<String>> it = testGraph.nodes.values().iterator();

        // Maps each Node to an index
        Map<String, Integer> mapNodes = new HashMap<>();
        int mapIndex = 0;

        while (it.hasNext()) {
            GraphNode<String> node = it.next();

            if (mapNodes.get(node.value) == null) {
                mapNodes.put(node.value, mapIndex++);
            }

            int nodeIndex = mapNodes.get(node.value);

            int distanceIndex = 0;
            List<Integer> distances = node.adjacentNodesWeight;
            for (GraphNode<String> child : node.adjacentNodes) {
                if (mapNodes.get(child.value) == null) {
                    mapNodes.put(child.value, mapIndex++);
                }

                int childIndex = mapNodes.get(child.value);

                graphMatrix[nodeIndex][childIndex] = distances.get(distanceIndex++);
            }
        }

        return graphMatrix;
    }

    @Test
    void test1() {
        TestGraph<String> testGraph = TestGraphBuilder.buildStr(graphStr);

        int[][] distanceMatrix = fromGraphToMatrix(testGraph);

        printArray(distanceMatrix);

        printArray(Floyd_Warshall_Algorithm.shortestPathPairs(distanceMatrix));
    }

    private static void printArray(int[][] arr) {
        for (int j = 0; j < arr.length; j++) {
            System.out.println(Arrays.toString(arr[j]));
        }
    }
}
