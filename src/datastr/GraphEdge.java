package datastr;

public class GraphEdge<T> {
    public GraphVertex<T> src;
    public GraphVertex<T> dest;

    public int weight;

    public GraphEdge(GraphVertex<T> src, GraphVertex<T> dest) {
        this.src = src;
        this.dest = dest;
    }

    public GraphEdge(GraphVertex<T> src, GraphVertex<T> dest, int weight) {
        this.src = src;
        this.dest = dest;

        this.weight = weight;
    }
}
