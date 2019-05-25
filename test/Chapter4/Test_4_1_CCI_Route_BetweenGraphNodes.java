package Chapter4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class Test_4_1_CCI_Route_BetweenGraphNodes {

    private String graph = "1->2,3,4\n2->4,5,6\n3->6,7\n4->45\n45->80,90";

    @Test
    void test0() {
        TestGraph testGraph = TestGraphBuilder.build(graph);

        assertEquals("1,2,4,45,80,90,5,6,3,7", testGraph.listFirstDepth());

        GraphNode<Integer> start = testGraph.start();
        boolean result = Solution_4_1_CCI_Route_BetweenGraphNodes.solution(start, start);
        assertTrue(result);
    }

    @Test
    void test1() {
        TestGraph testGraph = TestGraphBuilder.build(graph);

        GraphNode<Integer> start = testGraph.start();

        boolean result = Solution_4_1_CCI_Route_BetweenGraphNodes.solution(start, testGraph.nodes.get(6));

        assertTrue(result);
    }

    @Test
    void test2() {
        TestGraph testGraph = TestGraphBuilder.build(graph);

        boolean result = Solution_4_1_CCI_Route_BetweenGraphNodes.solution(testGraph.nodes.get(2), testGraph.nodes.get(45));

        assertTrue(result);
    }

    @Test
    void test3() {
        TestGraph testGraph = TestGraphBuilder.build(graph);

        boolean result = Solution_4_1_CCI_Route_BetweenGraphNodes.solution(testGraph.nodes.get(5), testGraph.nodes.get(45));

        assertTrue(!result);
    }
}
