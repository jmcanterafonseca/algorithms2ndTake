package Chapter4;

import datastr.GraphAsMatrix;
import datastr.GraphVertex;
import datastr.TestGraphBuilder;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class Test_Floyd_Warshall_Algorithm_Ext {
    // The definition of this graph has been taken from "Cracking the Coding Interview" page 634
    private String graphStr = "a->b|5,c|3,e|2\nb->d|2\nc->d|1,b|1\nd->a|1,h|1,g|2" +
            "\ne->a|1,h|4,i|7\nf->b|3,g|1\ng->i|2,c|3\nh->g|2,c|2,f|2";

    @Test
    void test1() {
        GraphAsMatrix<String> testGraph = TestGraphBuilder.buildAsMatrix(graphStr);

        List<String> result = Floyd_Warshall_Algorithm_Ext.shortestPath(
                testGraph.vertices.get("i"), testGraph.vertices.get("g"), testGraph);

        assertEquals(0, result.size());
    }


    @Test
    void test2() {
        GraphAsMatrix<String> testGraph = TestGraphBuilder.buildAsMatrix(graphStr);

        List<String> result = Floyd_Warshall_Algorithm_Ext.shortestPath(
                testGraph.vertices.get("e"), testGraph.vertices.get("f"), testGraph);

        assertArrayEquals(new String[]{"e", "h", "f"}, result.toArray(new String[0]));
    }

    @Test
    void test3() {
        GraphAsMatrix<String> testGraph = TestGraphBuilder.buildAsMatrix(graphStr);

        List<String> result = Floyd_Warshall_Algorithm_Ext.shortestPath(
                testGraph.vertices.get("e"), testGraph.vertices.get("i"), testGraph);

        assertArrayEquals(new String[]{"e", "i"}, result.toArray(new String[0]));
    }

    @Test
    void test4() {
        GraphAsMatrix<String> testGraph = TestGraphBuilder.buildAsMatrix(graphStr);

        List<String> result = Floyd_Warshall_Algorithm_Ext.shortestPath(
                testGraph.vertices.get("g"), testGraph.vertices.get("h"), testGraph);

        assertArrayEquals(new String[]{"g", "c", "d", "h"}, result.toArray(new String[0]));
    }

    @Test
    void test5() {
        GraphAsMatrix<String> testGraph = TestGraphBuilder.buildAsMatrix(graphStr);

        List<String> result = Floyd_Warshall_Algorithm_Ext.shortestPath(
                testGraph.vertices.get("a"), testGraph.vertices.get("b"), testGraph);

        assertArrayEquals(new String[]{"a", "c", "b"}, result.toArray(new String[0]));
    }

    @Test
    void test6() {
        GraphAsMatrix<String> testGraph = TestGraphBuilder.buildAsMatrix(graphStr);

        List<String> result = Floyd_Warshall_Algorithm_Ext.shortestPath(
                testGraph.vertices.get("a"), testGraph.vertices.get("i"), testGraph);

        assertArrayEquals(new String[]{"a", "c", "d", "g", "i"}, result.toArray(new String[0]));
    }

    @Test
    void test7() {
        GraphAsMatrix<String> testGraph = TestGraphBuilder.buildAsMatrix(graphStr);

        List<String> result = Floyd_Warshall_Algorithm_Ext.shortestPath(
                testGraph.vertices.get("a"), new GraphVertex<>("z"), testGraph);

        assertEquals(0, result.size());
    }

    @Test
    void test8() {
        GraphAsMatrix<String> testGraph = TestGraphBuilder.buildAsMatrix(graphStr);

        List<String> result = Floyd_Warshall_Algorithm_Ext.shortestPath(
                testGraph.vertices.get("a"), testGraph.vertices.get("a"), testGraph);

        assertArrayEquals(new String[]{"a"}, result.toArray(new String[0]));
    }

    // This test demonstrates why the Dijkstra algorithm fails with
    // Negative edges. The shortest path is {"a", "e", "d"} and the algorithm
    // reports {"a", "b", "c", "d" }
    // The same test using the Bellman-Ford algorithm works perfectly
    @Test
    void test9() {
        String graphTest = "a->b|2,e|8\nb->c|1\nc->d|2\ne->d|-4";

        GraphAsMatrix<String> testGraph = TestGraphBuilder.buildAsMatrix(graphTest);

        List<String> result = Floyd_Warshall_Algorithm_Ext.shortestPath(
                testGraph.vertices.get("a"), testGraph.vertices.get("d"), testGraph);

        assertArrayEquals(new String[]{"a", "e", "d"}, result.toArray(new String[0]));
    }
}
