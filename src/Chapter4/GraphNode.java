package Chapter4;

import java.util.ArrayList;
import java.util.List;

public class GraphNode<T> {
    public T value;
    public List<GraphNode<T>> adjacentNodes;
    public boolean visited = false;

    public GraphNode(T value) {
        this.value = value;
        adjacentNodes = new ArrayList<>();
    }

    public void addChild(GraphNode<T> child) {
        adjacentNodes.add(child);
    }
}
