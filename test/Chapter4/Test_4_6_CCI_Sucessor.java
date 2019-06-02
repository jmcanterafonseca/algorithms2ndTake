package Chapter4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;


// Test 4.6 CCI Succesor
public class Test_4_6_CCI_Sucessor {

    @Test
    void test10() {
        String tree = "1";

        TestBinaryTree testTree = TestBinaryTreeBuilder.build(tree);

        assertNull(Solution_4_6_CCI_Sucessor.solution(testTree.root));
    }

    @Test
    void test11() {
        String tree = "1\n1->,4\n4->,6";

        TestBinaryTree testTree = TestBinaryTreeBuilder.build(tree);

        assertEquals(6, Solution_4_6_CCI_Sucessor.solution(testTree.nodes.get(4)).value);
    }

    @Test
    void test12() {
        String tree = "1\n1->,4\n4->,6";

        TestBinaryTree testTree = TestBinaryTreeBuilder.build(tree);

        assertNull(Solution_4_6_CCI_Sucessor.solution(testTree.nodes.get(6)));
    }

    @Test
    void test13() {
        String tree = "1\n1->,4\n4->2";

        TestBinaryTree testTree = TestBinaryTreeBuilder.build(tree);

        assertEquals(2, Solution_4_6_CCI_Sucessor.solution(testTree.nodes.get(1)).value);
    }


    @Test
    void test15() {
        String tree = "10\n10->,40\n40->12";

        TestBinaryTree testTree = TestBinaryTreeBuilder.build(tree);
        assertNull(Solution_4_6_CCI_Sucessor.solution(testTree.nodes.get(40)));
    }

    @Test
    void test21() {
        String tree = "7\n7->5\n5->,6";

        TestBinaryTree testTree = TestBinaryTreeBuilder.build(tree);

        assertEquals(7, Solution_4_6_CCI_Sucessor.solution(testTree.nodes.get(6)).value);
    }

    @Test
    void test24() {
        String tree = "22\n22->9\n9->8,12\n12->11,20";

        TestBinaryTree testTree = TestBinaryTreeBuilder.build(tree);

        assertEquals(11, Solution_4_6_CCI_Sucessor.solution(testTree.nodes.get(9)).value);
    }

    @Test
    void test25() {
        String tree = "8\n8->,12\n12->9";

        TestBinaryTree testTree = TestBinaryTreeBuilder.build(tree);

        assertNull(Solution_4_6_CCI_Sucessor.solution(testTree.nodes.get(12)));
    }
}
