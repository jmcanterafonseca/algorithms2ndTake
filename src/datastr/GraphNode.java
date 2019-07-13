package datastr;

import java.util.ArrayList;
import java.util.List;

// Here the GraphNode holds a list of adjacent nodes
// And a list of weights for the path between the GraphNode and its adjacent nodes
// The size of the adjacentNodes list and the adjacenNodesWeight list has to be the same
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
