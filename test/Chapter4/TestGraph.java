package Chapter4;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TestGraph {
    public  Map<Integer,GraphNode<Integer>> nodes;

    public TestGraph(Map<Integer,GraphNode<Integer>> nodes) {
        this.nodes = nodes;
    }

    public GraphNode<Integer> start() {
        return nodes.values().iterator().next();
    }

    public String listFirstDepth() {
        StringBuffer out = new StringBuffer();
        Set<GraphNode<Integer>> visited = new HashSet<>();

        listFirstDepth(start(), out, visited);

        return out.toString();
    }

    private void listFirstDepth(GraphNode<Integer> start, StringBuffer out, Set<GraphNode<Integer>> visited) {
        out.append(start.value);
        out.append(",");
        visited.add(start);

        for(GraphNode<Integer> node: start.children) {
            if (!visited.contains(node)) {
                listFirstDepth(node, out, visited);
                out.append(",");
            }
        }

        out.deleteCharAt(out.length() - 1);
    }
}
