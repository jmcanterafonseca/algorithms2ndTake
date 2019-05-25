package Chapter4;

import java.util.ArrayList;
import java.util.List;

public class GraphNode<T> {
    public T value;
    public List<GraphNode<T>> children;

    public GraphNode(T value) {
        this.value = value;
        children = new ArrayList<>();
    }

    public void addChild(GraphNode<T> child) {
        children.add(child);
    }
}
