package Chapter4;

import java.util.Collection;
import java.util.Map;

// Represents a Graph as a matrix with direct adjacencies between vertices
public class GraphAsMatrix<T> {
    public Map<T,GraphVertex<T>> vertices;
    public Map<T, Map<T, Integer>> distances;

    public GraphAsMatrix(Map<T,GraphVertex<T>> vertices, Map<T, Map<T, Integer>> distances) {
        this.vertices = vertices;
        this.distances = distances;
    }
}
