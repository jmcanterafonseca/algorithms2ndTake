package Chapter4;

import java.util.*;

public class TestGraph {
    public Map<Integer, GraphNode<Integer>> nodes;

    public TestGraph(Map<Integer, GraphNode<Integer>> nodes) {
        this.nodes = nodes;
    }

    public GraphNode<Integer> start() {
        return nodes.values().iterator().next();
    }

    public String listDepthFirst() {
        StringBuffer out = new StringBuffer();
        Set<GraphNode<Integer>> visited = new HashSet<>();

        listDepthFirst(start(), out, visited);

        return out.toString();
    }

    private void listDepthFirst(GraphNode<Integer> start, StringBuffer out, Set<GraphNode<Integer>> visited) {
        visit(start, out, visited);

        for (GraphNode<Integer> node : start.children) {
            if (!visited.contains(node)) {
                listDepthFirst(node, out, visited);
                out.append(",");
            }
        }

        out.deleteCharAt(out.length() - 1);
    }

    public String listBreadthFirst() {
        StringBuffer out = new StringBuffer();
        Set<GraphNode<Integer>> visited = new HashSet<>();

        Queue<GraphNode<Integer>> toVisit = new LinkedList<>();

        toVisit.add(start());

        while (!toVisit.isEmpty()) {
            GraphNode<Integer> next = toVisit.remove();
            if (!visited.contains(next)) {
                visit(next, out, visited);
            }
            for (GraphNode<Integer> node : next.children) {
                toVisit.add(node);
            }
        }

        return out.substring(0, out.length() - 1);
    }

    private void visit(GraphNode<Integer> node, StringBuffer out, Set<GraphNode<Integer>> visited) {
        out.append(node.value);
        out.append(",");

        visited.add(node);
    }
}
