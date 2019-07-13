package Chapter4;

import datastr.*;

import java.util.*;
import java.util.function.Function;

// Builds a graph from a description of its adjacency matrix
// 1->2,3,4
// 2->4,5,6
// 3->6,7
// Also it is able to parse weights for each adjacent node
// A->B|4,C|2
// B->A|2,D|6
// Different Graph representations can be obtained
// GraphNode with adjacenct nodes (children)
// GraphVertex and GraphEdge collections
// GraphMatrix containing adjacencies between each pair of nodes as a double hash
// GraphMatrix containing adjacencies between each pair of nodes as an int matrix
public class TestGraphBuilder {

    public static TestGraph<String> buildStr(String input) {
        return doBuild(input, x -> x);
    }

    public static TestGraph<Integer> build(String input) {
        return doBuild(input, x -> Integer.parseInt(x));
    }

    public static GraphAsVertexEdge<String> buildAsVertexEdge(String input) {
        return doBuildGraphAsVertexEdge(input, x -> x);
    }

    public static GraphAsMatrix<String> buildAsMatrix(String input) {
        return doBuildGraphAsMatrix(input, x -> x);
    }

    private static <T> TestGraph<T> doBuild(String input, Function<String, Object> parser) {
        // Ensure that nodes are kept in order in the map
        Map<T, GraphNode<T>> nodes = new LinkedHashMap<>();

        String[] lines = input.split("\\R");

        for (int j = 0; j < lines.length; j++) {
            String[] parts = lines[j].split("->");

            T nodeValue = (T) parser.apply(parts[0]);

            GraphNode<T> parentNode = nodes.get(nodeValue);

            if (parentNode == null) {
                parentNode = new GraphNode<>(nodeValue);
                nodes.put(nodeValue, parentNode);
            }

            String[] children = parts[1].split(",");

            for (int k = 0; k < children.length; k++) {
                String[] nodeWeightTuple = children[k].split("\\|");

                T childValue = (T) parser.apply(nodeWeightTuple[0]);

                GraphNode<T> childNode = nodes.get(childValue);
                if (childNode == null) {
                    childNode = new GraphNode<>(childValue);
                    nodes.put(childValue, childNode);
                }

                if (nodeWeightTuple.length == 2) {
                    parentNode.addChild(childNode, Integer.parseInt(nodeWeightTuple[1]));
                } else {
                    parentNode.addChild(childNode);
                }
            }
        }

        return new TestGraph<>(nodes);
    }

    // Builds a Graph from a textual description as a collection of vertices and edges
    private static <T> GraphAsVertexEdge<T> doBuildGraphAsVertexEdge(String input, Function<String, Object> parser) {
        // Ensure that nodes are kept in order in the map
        Map<T, GraphVertex<T>> vertices = new LinkedHashMap<>();
        List<GraphEdge<T>> edges = new ArrayList<>();

        String[] lines = input.split("\\R");

        for (int j = 0; j < lines.length; j++) {
            String[] parts = lines[j].split("->");

            T vertexLabel = (T) parser.apply(parts[0]);

            GraphVertex<T> parentVertex = vertices.get(vertexLabel);

            if (parentVertex == null) {
                parentVertex = new GraphVertex<>(vertexLabel);
                vertices.put(vertexLabel, parentVertex);
            }

            String[] children = parts[1].split(",");

            for (int k = 0; k < children.length; k++) {
                String[] nodeWeightTuple = children[k].split("\\|");

                T childVertexValue = (T) parser.apply(nodeWeightTuple[0]);

                GraphVertex<T> childVertex = vertices.get(childVertexValue);
                if (childVertex == null) {
                    childVertex = new GraphVertex<>(childVertexValue);
                    vertices.put(childVertexValue, childVertex);
                }

                if (nodeWeightTuple.length == 2) {
                    GraphEdge<T> edge = new GraphEdge<>(parentVertex, childVertex, Integer.parseInt(nodeWeightTuple[1]));
                    edges.add(edge);
                } else {
                    GraphEdge<T> edge = new GraphEdge<>(parentVertex, childVertex);
                    edges.add(edge);
                }
            }
        }

        return new GraphAsVertexEdge<>(vertices.values(), edges);
    }

    // Builds a Graph from a textual description as a collection of vertices and edges
    private static <T> GraphAsMatrix<T> doBuildGraphAsMatrix(String input, Function<String, Object> parser) {
        // Ensure that nodes are kept in order in the map
        Map<T, GraphVertex<T>> vertices = new LinkedHashMap<>();
        Map<T, Map<T, Integer>> distances = new HashMap<>();

        String[] lines = input.split("\\R");

        for (int j = 0; j < lines.length; j++) {
            String[] parts = lines[j].split("->");

            T vertexLabel = (T) parser.apply(parts[0]);

            GraphVertex<T> parentVertex = vertices.get(vertexLabel);

            if (parentVertex == null) {
                parentVertex = new GraphVertex<>(vertexLabel);
                vertices.put(vertexLabel, parentVertex);

                // We ensure that a hash entry for the vertex at least exist
                // in the distances hash (even if it could be empty
                distances.put(vertexLabel, new HashMap<>());
            }

            String[] children = parts[1].split(",");

            for (int k = 0; k < children.length; k++) {
                String[] nodeWeightTuple = children[k].split("\\|");

                T childVertexValue = (T) parser.apply(nodeWeightTuple[0]);

                GraphVertex<T> childVertex = vertices.get(childVertexValue);
                if (childVertex == null) {
                    childVertex = new GraphVertex<>(childVertexValue);
                    vertices.put(childVertexValue, childVertex);
                    distances.put(childVertexValue, new HashMap<>());
                }

                if (nodeWeightTuple.length == 2) {
                    distances.get(parentVertex.label).put(childVertex.label, Integer.parseInt(nodeWeightTuple[1]));
                } else {
                    throw new RuntimeException("Weight has not been provided for " +
                            parentVertex.label + "/" + childVertex.label);
                }
            }
        }

        return new GraphAsMatrix<T>(vertices, distances);
    }
}
