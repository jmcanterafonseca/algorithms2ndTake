package Chapter4;

import java.util.ArrayList;
import java.util.List;

public class GraphNode<T> {
    public T value;
    public List<GraphNode<T>> adjacentNodes;
    public List<Integer> adjacentNodesWeight;

    public boolean visited = false;

    public GraphNode(T value) {
        this.value = value;
        adjacentNodes = new ArrayList<>();
        adjacentNodesWeight = new ArrayList<>();
    }

    public void addChild(GraphNode<T> child) {
        adjacentNodes.add(child);
    }

    public void addChild(GraphNode<T> child, int weight) {
        addChild(child);
        adjacentNodesWeight.add(weight);
    }
}
