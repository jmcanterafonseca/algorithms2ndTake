package Chapter4;

import java.util.*;

// Builds a graph from a description of its adjacency matrix
// 1->2,3,4
// 2->4,5,6
// 3->6,7
public class TestGraphBuilder {

    public static TestGraph build(String input) {
        // Ensure that nodes are kept in order in the map
        Map<Integer, GraphNode<Integer>> nodes = new LinkedHashMap<>();

        String[] lines = input.split("\\R");

        for (int j = 0; j < lines.length; j++) {
            String[] parts = lines[j].split("->");

            int nodeValue = Integer.parseInt(parts[0]);

            GraphNode<Integer> parentNode = nodes.get(nodeValue);

            if (parentNode == null) {
                parentNode = new GraphNode<>(nodeValue);
                nodes.put(nodeValue, parentNode);
            }

            String[] children = parts[1].split(",");

            for (int k = 0; k < children.length; k++) {
                int childValue = Integer.parseInt(children[k]);

                GraphNode<Integer> childNode = nodes.get(childValue);
                if (childNode == null) {
                    childNode = new GraphNode<>(childValue);
                    nodes.put(childValue, childNode);
                }

                parentNode.addChild(childNode);
            }
        }

        return new TestGraph(nodes);
    }
}
