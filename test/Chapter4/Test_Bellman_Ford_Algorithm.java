package Chapter4;

import datastr.GraphNode;
import datastr.TestGraph;
import datastr.TestGraphBuilder;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class Test_Bellman_Ford_Algorithm {

    // The definition of this graph has been taken from "Cracking the Coding Interview" page 634
    private String graphStr = "a->b|5,c|3,e|2\nb->d|2\nc->d|1,b|1\nd->a|1,h|1,g|2" +
            "\ne->a|1,h|4,i|7\nf->b|3,g|1\ng->i|2,c|3\nh->g|2,c|2,f|2";

    private static String[] result2Array(List<GraphNode<String>> res) {
        String[] out = new String[res.size()];

        int j = 0;
        for (GraphNode<String> node : res) {
            out[j++] = node.value;
        }

        return out;
    }

    @Test
    void test1() {
        TestGraph<String> testGraph = TestGraphBuilder.buildStr(graphStr);


        List<GraphNode<String>> result = Bellman_Ford_Algorithm.shortestPath(
                testGraph.nodes.get("i"), testGraph.nodes.get("g"));

        assertEquals(0, result.size());
    }

    @Test
    void test2() {
        TestGraph<String> testGraph = TestGraphBuilder.buildStr(graphStr);


        List<GraphNode<String>> result = Bellman_Ford_Algorithm.shortestPath(
                testGraph.nodes.get("e"), testGraph.nodes.get("f"));

        assertArrayEquals(new String[]{"e", "h", "f"}, result2Array(result));
    }

    @Test
    void test3() {
        TestGraph<String> testGraph = TestGraphBuilder.buildStr(graphStr);


        List<GraphNode<String>> result = Bellman_Ford_Algorithm.shortestPath(
                testGraph.nodes.get("e"), testGraph.nodes.get("i"));

        assertArrayEquals(new String[]{"e", "i"}, result2Array(result));
    }

    @Test
    void test4() {
        TestGraph<String> testGraph = TestGraphBuilder.buildStr(graphStr);


        List<GraphNode<String>> result = Bellman_Ford_Algorithm.shortestPath(
                testGraph.nodes.get("g"), testGraph.nodes.get("h"));

        assertArrayEquals(new String[]{"g", "c", "d", "h"}, result2Array(result));
    }


    @Test
    void test5() {
        TestGraph<String> testGraph = TestGraphBuilder.buildStr(graphStr);


        List<GraphNode<String>> result = Bellman_Ford_Algorithm.shortestPath(
                testGraph.nodes.get("a"), testGraph.nodes.get("b"));

        assertArrayEquals(new String[]{"a", "c", "b"}, result2Array(result));
    }

    @Test
    void test6() {
        TestGraph<String> testGraph = TestGraphBuilder.buildStr(graphStr);


        List<GraphNode<String>> result = Bellman_Ford_Algorithm.shortestPath(
                testGraph.nodes.get("a"), testGraph.nodes.get("i"));

        assertArrayEquals(new String[]{"a", "c", "d", "g", "i"}, result2Array(result));
    }

    @Test
    void test7() {
        TestGraph<String> testGraph = TestGraphBuilder.buildStr(graphStr);


        List<GraphNode<String>> result = Bellman_Ford_Algorithm.shortestPath(
                testGraph.nodes.get("a"), new GraphNode<>("z"));

        assertEquals(0, result.size());
    }

    @Test
    void test8() {
        TestGraph<String> testGraph = TestGraphBuilder.buildStr(graphStr);


        List<GraphNode<String>> result = Bellman_Ford_Algorithm.shortestPath(
                testGraph.nodes.get("a"), testGraph.nodes.get("a"));

        assertArrayEquals(new String[]{"a"}, result2Array(result));
    }


    @Test
    void test9() {
        // There is a negative cycle that is detected
        String graphTest = "a->b|1\nb->c|-1\nc->d|-1\nd->a|-1";

        TestGraph<String> testGraph = TestGraphBuilder.buildStr(graphTest);


        try {
            List<GraphNode<String>> result = Bellman_Ford_Algorithm.shortestPath(
                    testGraph.nodes.get("a"), testGraph.nodes.get("c"));
        } catch (RuntimeException rte) {
            assertEquals("negative-cycle", rte.getMessage());
            return;
        }

        assertTrue(false);
    }

    @Test
    void test10() {
        // There is a negative cycle that is detected
        String graphTest = "a->b|1\nb->c|2\nc->b|-3";

        TestGraph<String> testGraph = TestGraphBuilder.buildStr(graphTest);

        try {

            List<GraphNode<String>> result = Bellman_Ford_Algorithm.shortestPath(
                    testGraph.nodes.get("a"), testGraph.nodes.get("c"));
        } catch (RuntimeException rte) {
            assertEquals("negative-cycle", rte.getMessage());
            return;
        }

        assertTrue(false);
    }

    // This test using the Bellman-Ford algorithm works
    // However it does not work when using the Dijkstra Algorithm
    @Test
    void test11() {
        String graphTest = "a->b|2,e|8\nb->c|1\nc->d|2\ne->d|-4";

        TestGraph<String> testGraph = TestGraphBuilder.buildStr(graphTest);


        List<GraphNode<String>> result = Bellman_Ford_Algorithm.shortestPath(
                testGraph.nodes.get("a"), testGraph.nodes.get("d"));

        assertArrayEquals(new String[]{"a", "e", "d"}, result2Array(result));
    }
}
