package Chapter4;

import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class Test_Dijkstra_Algorithm_A {

    private String graphStr = "a->b|5,c|3,e|2\nb->d|2\nc->d|1,b|1\nd->a|1,h|1,g|2" +
            "\ne->a|1,h|4,i|7\nf->b|3,g|1\ng->i|2\nh->g|2,c|2,f|2";

    @Test
    void test6() {
        TestGraph<String> testGraph = TestGraphBuilder.buildStr(graphStr);


        List<GraphNode<String>> result = Dijkstra_Algorithm_A.shortestPath(
                testGraph.nodes.get("a"), testGraph.nodes.get("i"));

        System.out.println(result.size());

        Iterator<GraphNode<String>> it = result.iterator();
        while (it.hasNext()) {
            System.out.println(it.next().value);
        }
    }

    @Test
    void test7() {
        TestGraph<String> testGraph = TestGraphBuilder.buildStr(graphStr);


        List<GraphNode<String>> result = Dijkstra_Algorithm_A.shortestPath(
                testGraph.nodes.get("a"), new GraphNode<>("z"));

        assertEquals(0, result.size());
    }
}
