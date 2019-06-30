package Chapter4;

// Floyd Warshall algorithm
// Takes as input a matrix that indicates the weight from a Node A to a Node B
// Time complexity of the algorithm is O(V^3)
// Idea is that if between vertex i and j there is an intermediate node k which
// allows to go from i to j through k in a shortest (less weight path)
// then the matrix distance is updated properly
public class Floyd_Warshall_Algorithm {
    public static int[][] shortestPathPairs(int[][] graph) {
        int[][] dist = new int[graph.length][graph.length];

        for (int j = 0; j < graph.length; j++) {
            System.arraycopy(graph[j], 0, dist[j], 0, graph[j].length);
        }

        for (int k = 0; k < dist.length; k++) {
            for (int i = 0; i < dist.length; i++) {
                for (int j = 0; j < dist.length; j++) {
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        return dist;
    }
}
