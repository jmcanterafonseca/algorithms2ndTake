package Chapter4;

import datastr.GraphNode;

import java.util.Collection;

// Detects whether there are loops in a Graph i.e. there is a route from one node to itself
public class Solution_Detect_Graph_Loops {
    public static boolean solution(Collection<GraphNode<Integer>> startNodes) {
        GraphLoopDetector detector = new GraphLoopDetector<Integer>();

        return detector.verdict(startNodes);
    }
}
