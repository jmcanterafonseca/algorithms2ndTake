package Chapter4;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;

// Builds a graph from a description of its adjacency matrix
// 1->2,3,4
// 2->4,5,6
// 3->6,7
// Also it is able to parse weights for each adjacent node
// A->B|4,C|2
// B->A|2,D|6
public class TestGraphBuilder {

    public static TestGraph<String> buildStr(String input) {
        return doBuild(input, x-> x);
    }

    public static TestGraph<Integer> build(String input) {
        return doBuild(input, x -> Integer.parseInt(x));
    }


    private static <T> TestGraph<T> doBuild(String input, Function<String, Object> parser) {
        // Ensure that nodes are kept in order in the map
        Map<T, GraphNode<T>> nodes = new LinkedHashMap<>();

        String[] lines = input.split("\\R");

        for (int j = 0; j < lines.length; j++) {
            String[] parts = lines[j].split("->");

            T nodeValue = (T)parser.apply(parts[0]);

            GraphNode<T> parentNode = nodes.get(nodeValue);

            if (parentNode == null) {
                parentNode = new GraphNode<>(nodeValue);
                nodes.put(nodeValue, parentNode);
            }

            String[] children = parts[1].split(",");

            for (int k = 0; k < children.length; k++) {
                String[] nodeWeightTuple = children[k].split("\\|");

                T childValue = (T)parser.apply(nodeWeightTuple[0]);

                GraphNode<T> childNode = nodes.get(childValue);
                if (childNode == null) {
                    childNode = new GraphNode<>(childValue);
                    nodes.put(childValue, childNode);
                }

                if (nodeWeightTuple.length == 2) {
                    parentNode.addChild(childNode, Integer.parseInt(nodeWeightTuple[1]));
                }
                else {
                    parentNode.addChild(childNode);
                }
            }
        }

        return new TestGraph<>(nodes);
    }
}
