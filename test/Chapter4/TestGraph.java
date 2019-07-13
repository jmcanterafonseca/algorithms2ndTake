package Chapter4;

import datastr.GraphNode;

import java.util.*;

public class TestGraph<T> {
    public Map<T, GraphNode<T>> nodes;

    public TestGraph(Map<T, GraphNode<T>> nodes) {
        this.nodes = nodes;
    }

    public GraphNode<T> start() {
        return nodes.values().iterator().next();
    }

    public String listDepthFirst() {
        StringBuffer out = new StringBuffer();
        Set<GraphNode<T>> visited = new HashSet<>();

        listDepthFirst(start(), out, visited);

        return out.toString();
    }

    private void listDepthFirst(GraphNode<T> start, StringBuffer out, Set<GraphNode<T>> visited) {
        visit(start, out, visited);

        for (GraphNode<T> node : start.adjacentNodes) {
            if (!visited.contains(node)) {
                listDepthFirst(node, out, visited);
                out.append(",");
            }
        }

        out.deleteCharAt(out.length() - 1);
    }

    public String listBreadthFirst() {
        StringBuffer out = new StringBuffer();
        Set<GraphNode<T>> visited = new HashSet<>();

        Queue<GraphNode<T>> toVisit = new LinkedList<>();

        toVisit.add(start());

        while (!toVisit.isEmpty()) {
            GraphNode<T> next = toVisit.remove();
            if (!visited.contains(next)) {
                visit(next, out, visited);
            }
            for (GraphNode<T> node : next.adjacentNodes) {
                toVisit.add(node);
            }
        }

        return out.substring(0, out.length() - 1);
    }

    private void visit(GraphNode<T> node, StringBuffer out, Set<GraphNode<T>> visited) {
        out.append(node.value);
        out.append(",");

        visited.add(node);
    }
}
