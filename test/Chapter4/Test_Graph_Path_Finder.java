package Chapter4;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNull;


public class Test_Graph_Path_Finder {

    private String graphStr = "1->2,3,4\n2->4,5,6\n3->6,7\n4->45\n45->80,90";

    @Test
    void test0() {
        TestGraph testGraph = TestGraphBuilder.build(graphStr);


        GraphNode<Integer> start = testGraph.start();
        List<Integer> result = new GraphPathFinder<Integer>().calculate(start, start);

        Integer[] expectedresult = {};
        assertArrayEquals(expectedresult, result.toArray());
    }


    @Test
    void test1() {
        TestGraph testGraph = TestGraphBuilder.build(graphStr);

        GraphNode<Integer> start = testGraph.start();
        List<Integer> result = new GraphPathFinder<Integer>().calculate(start, testGraph.nodes.get(6));

        Integer[] expectedresult = {1, 2, 6};
        assertArrayEquals(expectedresult, result.toArray());
    }


    @Test
    void test2() {
        TestGraph testGraph = TestGraphBuilder.build(graphStr);

        GraphNode<Integer> start = testGraph.start();
        List<Integer> result = new GraphPathFinder<Integer>().calculate(testGraph.nodes.get(2), testGraph.nodes.get(45));

        Integer[] expectedresult = {2, 4, 45};
        assertArrayEquals(expectedresult, result.toArray());
    }

    @Test
    void test3() {
        TestGraph testGraph = TestGraphBuilder.build(graphStr);

        GraphNode<Integer> start = testGraph.start();
        List<Integer> result = new GraphPathFinder<Integer>().calculate(testGraph.nodes.get(5), testGraph.nodes.get(45));

        assertNull(result);
    }


    @Test
    void test4() {
        TestGraph testGraph = TestGraphBuilder.build(graphStr);

        GraphNode<Integer> start = testGraph.start();
        List<Integer> result = new GraphPathFinder<Integer>().calculate(testGraph.nodes.get(80), testGraph.nodes.get(90));

        assertNull(result);
    }

    @Test
    void test5() {
        TestGraph testGraph = TestGraphBuilder.build(graphStr);

        GraphNode<Integer> start = testGraph.start();
        List<Integer> result = new GraphPathFinder<Integer>().calculate(testGraph.start(), testGraph.nodes.get(45));

        Integer[] expectedresult = {1, 2, 4, 45};
        assertArrayEquals(expectedresult, result.toArray());
    }

    @Test
    void test6() {
        TestGraph testGraph = TestGraphBuilder.build(graphStr);

        GraphNode<Integer> start = testGraph.start();
        List<Integer> result = new GraphPathFinder<Integer>().calculate(testGraph.nodes.get(4), testGraph.nodes.get(5));

        assertNull(result);
    }

    @Test
    void test7() {
        String graphStr = "1->2,3\n3->45,2\n2->11";

        TestGraph testGraph = TestGraphBuilder.build(graphStr);

        GraphNode<Integer> start = testGraph.start();
        List<Integer> result = new GraphPathFinder<Integer>().calculate(testGraph.nodes.get(3), testGraph.nodes.get(11));

        Integer[] expectedresult = {3, 2, 11};
        assertArrayEquals(expectedresult, result.toArray());
    }
}
