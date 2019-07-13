package Chapter4;

import datastr.GraphNode;

import java.util.*;

// Finds the "next node" (i.e. in-order successor) of a given node in a BST
public class Solution_4_7_CCI_BuildOrder {
    public static String[] solution(String[] projects, String[][] dependencies) {
        List<String> orderList = new ArrayList<>();

        Map<String, GraphNode<String>> projectMap = buildDependencyGraph(projects, dependencies);

        Collection<GraphNode<String>> nodes = projectMap.values();

        GraphLoopDetector<String> detector = new GraphLoopDetector<>();
        if (detector.verdict(nodes)) {
            throw new CircularDependencyDetected("The graph has loops");
        }

        for (GraphNode<String> node : nodes) {
            if (!node.visited) {
                List<String> deps = findDependencies(node);
                orderList.addAll(deps);
                orderList.add(node.value);
            }
        }

        return orderList.toArray(new String[0]);
    }

    private static List<String> findDependencies(GraphNode<String> startNode) {
        if (startNode == null || startNode.visited) {
            return new ArrayList<>();
        }

        startNode.visited = true;

        List<String> out = new ArrayList<>();

        for (GraphNode<String> node : startNode.adjacentNodes) {
            if (!node.visited) {
                out.addAll(findDependencies(node));
                out.add(node.value);
            }
        }

        return out;
    }

    // Builds the dependency graph that will be used later to calculate the build order of projects
    private static Map<String, GraphNode<String>> buildDependencyGraph(String[] projects, String[][] dependencies) {
        Map<String, GraphNode<String>> projectMap = new HashMap<>();

        // First we need to build the dependency graph
        for (String project : projects) {
            GraphNode<String> projectNode = projectMap.get(project);
            if (projectNode == null) {
                projectNode = new GraphNode<>(project);
                projectMap.put(project, projectNode);
            }
        }

        for (String[] dependency : dependencies) {
            if (dependency.length < 2) {
                throw new RuntimeException("Dependencies shall be an array of two elements");
            }

            if (dependency[0].equals(dependency[1])) {
                throw new RuntimeException("A project cannot be self-dependant");
            }

            GraphNode<String> projectNode = projectMap.get(dependency[0]);

            if (projectNode == null) {
                throw new RuntimeException("Project not found: " + dependency[0]);
            }

            GraphNode<String> projectNode2 = projectMap.get(dependency[1]);

            if (projectNode2 == null) {
                throw new RuntimeException("Project not found: " + dependency[1]);
            }

            projectNode.addChild(projectNode2);
        }

        return projectMap;
    }
}
