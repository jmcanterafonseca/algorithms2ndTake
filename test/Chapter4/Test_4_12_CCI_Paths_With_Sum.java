package Chapter4;

import datastr.TestBinaryTree;
import datastr.TestBinaryTreeBuilder;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


// Builds a Binary Search Tree (with minimal height) from a sorted array (increasing order)
public class Test_4_12_CCI_Paths_With_Sum {

    @Test
    void test10() {
        String tree = "1";

        TestBinaryTree testTree = TestBinaryTreeBuilder.build(tree);

        assertEquals(1, Solution_4_12_CCI_Paths_With_Sum.solution(testTree, 1));
    }

    @Test
    void test11() {
        String tree = "1\n1->,4\n4->,6";

        TestBinaryTree testTree = TestBinaryTreeBuilder.build(tree);

        assertEquals(0, Solution_4_12_CCI_Paths_With_Sum.solution(testTree, 2));
    }

    @Test
    void test21() {
        String tree = "1\n1->,4\n4->,6";

        TestBinaryTree testTree = TestBinaryTreeBuilder.build(tree);

        assertEquals(1, Solution_4_12_CCI_Paths_With_Sum.solution(testTree, 1));
    }

    @Test
    void test22() {
        String tree = "1\n1->,4\n4->,6";

        TestBinaryTree testTree = TestBinaryTreeBuilder.build(tree);

        assertEquals(1, Solution_4_12_CCI_Paths_With_Sum.solution(testTree, 5));
    }

    @Test
    void test12() {
        String tree = "1\n1->4,\n4->6,";

        TestBinaryTree testTree = TestBinaryTreeBuilder.build(tree);

        assertEquals(1, Solution_4_12_CCI_Paths_With_Sum.solution(testTree, 5));
    }

    @Test
    void test0() {
        String tree = "1\n1->2,3";

        TestBinaryTree testTree = TestBinaryTreeBuilder.build(tree);

        assertEquals(1, Solution_4_12_CCI_Paths_With_Sum.solution(testTree, 2));
    }

    @Test
    void test1() {
        String tree = "1\n1->2,3\n2->4,5";

        TestBinaryTree testTree = TestBinaryTreeBuilder.build(tree);

        assertEquals(2, Solution_4_12_CCI_Paths_With_Sum.solution(testTree, 4));
    }


    @Test
    void test2() {
        String tree = "1\n1->2,3\n2->4,5\n3->6,7\n4->45\n45->80,90";

        TestBinaryTree testTree = TestBinaryTreeBuilder.build(tree);

        assertEquals(2, Solution_4_12_CCI_Paths_With_Sum.solution(testTree, 6));
    }


    @Test
    void test3() {
        String tree = "1\n1->2,3\n2->4,5\n3->6,7";

        TestBinaryTree testTree = TestBinaryTreeBuilder.build(tree);

        assertEquals(0, Solution_4_12_CCI_Paths_With_Sum.solution(testTree, 20));
    }

    @Test
    void test4() {
        String tree = "1\n1->2,3\n2->4,5\n3->6,7\n4->,12\n12->,34";

        TestBinaryTree testTree = TestBinaryTreeBuilder.build(tree);
        assertEquals(1, Solution_4_12_CCI_Paths_With_Sum.solution(testTree, 53));
    }

    @Test
    void test5() {
        String tree = "1\n1->2,3\n2->4,5\n3->6,7\n4->,12\n12->34";

        TestBinaryTree testTree = TestBinaryTreeBuilder.build(tree);
        assertEquals(1, Solution_4_12_CCI_Paths_With_Sum.solution(testTree, 9));
    }

    @Test
    void test6() {
        String tree = "1\n1->2,3\n2->4,5\n3->6,7\n4->0,12\n12->34\n6->99";

        TestBinaryTree testTree = TestBinaryTreeBuilder.build(tree);
        assertEquals(3, Solution_4_12_CCI_Paths_With_Sum.solution(testTree, 4));
    }

    @Test
    void test7() {
        String tree = "1\n1->2,3\n2->4,5\n3->6,7\n4->11,12\n12->34\n6->99";

        TestBinaryTree testTree = TestBinaryTreeBuilder.build(tree);
        assertEquals(3, Solution_4_12_CCI_Paths_With_Sum.solution(testTree, 7));
    }

    @Test
    void test8() {
        String tree = "1\n1->2,3\n2->4,5\n5->,29\n3->6,7\n4->11,12\n12->34\n6->99";

        TestBinaryTree testTree = TestBinaryTreeBuilder.build(tree);
        assertEquals(1, Solution_4_12_CCI_Paths_With_Sum.solution(testTree, 99));
    }

}
