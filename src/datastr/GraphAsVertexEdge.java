package datastr;

import java.util.Collection;

// This is an alternative representation of a Graph in terms of a collection
// of Vertices and Edges (with an optional weight)
public class GraphAsVertexEdge<T> {
    public Collection<GraphVertex<T>> vertices;
    public Collection<GraphEdge<T>> edges;

    public GraphAsVertexEdge(Collection<GraphVertex<T>> vertices, Collection<GraphEdge<T>> edges) {
        this.vertices = vertices;
        this.edges = edges;
    }
}
