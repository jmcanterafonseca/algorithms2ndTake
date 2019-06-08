package Chapter4;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Test_Detect_Graph_Loops {

    private String graphStr = "1->2,3,4\n2->4,5";

    @Test
    void test0() {
        TestGraph testGraph = TestGraphBuilder.build(graphStr);

        GraphNode<Integer> start = testGraph.start();
        List<GraphNode<Integer>> nodes = new ArrayList<>();
        nodes.add(start);

        boolean result = Solution_Detect_Graph_Loops.solution(nodes);
        assertFalse(result);
    }

    @Test
    void test1() {
        String graphStr = "1->2,3,4\n2->4,5\n4->1";

        TestGraph testGraph = TestGraphBuilder.build(graphStr);

        GraphNode<Integer> start = testGraph.start();
        List<GraphNode<Integer>> nodes = new ArrayList<>();
        nodes.add(start);

        boolean result = Solution_Detect_Graph_Loops.solution(nodes);
        assertTrue(result);
    }

    @Test
    void test2() {
        String graphStr = "1->2,3,4\n2->4,5\n4->3";

        TestGraph testGraph = TestGraphBuilder.build(graphStr);

        GraphNode<Integer> start = testGraph.start();
        List<GraphNode<Integer>> nodes = new ArrayList<>();
        nodes.add(start);

        boolean result = Solution_Detect_Graph_Loops.solution(nodes);
        assertFalse(result);
    }

    @Test
    void test3() {
        String graphStr = "1->2\n2->3\n3->4\n4->1";

        TestGraph testGraph = TestGraphBuilder.build(graphStr);

        GraphNode<Integer> start = testGraph.start();
        List<GraphNode<Integer>> nodes = new ArrayList<>();
        nodes.add(start);

        boolean result = Solution_Detect_Graph_Loops.solution(nodes);
        assertTrue(result);
    }

    @Test
    void test4() {
        String graphStr = "1->2\n2->3\n3->4\n4->2";

        TestGraph testGraph = TestGraphBuilder.build(graphStr);

        GraphNode<Integer> start = testGraph.start();
        List<GraphNode<Integer>> nodes = new ArrayList<>();
        nodes.add(start);

        boolean result = Solution_Detect_Graph_Loops.solution(nodes);
        assertTrue(result);
    }

}
