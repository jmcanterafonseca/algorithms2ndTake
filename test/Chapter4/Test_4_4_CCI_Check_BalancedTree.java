package Chapter4;

import datastr.TestBinaryTree;
import datastr.TestBinaryTreeBuilder;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


// Builds a Binary Search Tree (with minimal height) from a sorted array (increasing order)
public class Test_4_4_CCI_Check_BalancedTree {

    @Test
    void test10() {
        String tree = "1";

        TestBinaryTree testTree = TestBinaryTreeBuilder.build(tree);

        System.out.println(Solution_4_4_CCI_Check_BalancedTree.calculateHeightSubtree(testTree.root));

        assertTrue(Solution_4_4_CCI_Check_BalancedTree.solution(testTree.root));
    }

    @Test
    void test11() {
        String tree = "1\n1->,4\n4->,6";

        TestBinaryTree testTree = TestBinaryTreeBuilder.build(tree);

        assertFalse(Solution_4_4_CCI_Check_BalancedTree.solution(testTree.root));
    }

    @Test
    void test12() {
        String tree = "1\n1->4,\n4->6,";

        TestBinaryTree testTree = TestBinaryTreeBuilder.build(tree);

        assertFalse(Solution_4_4_CCI_Check_BalancedTree.solution(testTree.root));
    }

    @Test
    void test0() {
        String tree = "1\n1->2,3";

        TestBinaryTree testTree = TestBinaryTreeBuilder.build(tree);

        System.out.println(Solution_4_4_CCI_Check_BalancedTree.calculateHeightSubtree(testTree.root));

        assertTrue(Solution_4_4_CCI_Check_BalancedTree.solution(testTree.root));
    }

    @Test
    void test1() {
        String tree = "1\n1->2,3\n2->4,5";

        TestBinaryTree testTree = TestBinaryTreeBuilder.build(tree);

        assertTrue(Solution_4_4_CCI_Check_BalancedTree.solution(testTree.root));
    }


    @Test
    void test2() {
        String tree = "1\n1->2,3\n2->4,5\n3->6,7\n4->45\n45->80,90";

        TestBinaryTree testTree = TestBinaryTreeBuilder.build(tree);
        assertFalse(Solution_4_4_CCI_Check_BalancedTree.solution(testTree.root));
    }


    @Test
    void test3() {
        String tree = "1\n1->2,3\n2->4,5\n3->6,7";

        TestBinaryTree testTree = TestBinaryTreeBuilder.build(tree);
        assertTrue(Solution_4_4_CCI_Check_BalancedTree.solution(testTree.root));
    }

    @Test
    void test4() {
        String tree = "1\n1->2,3\n2->4,5\n3->6,7\n4->,12\n12->,34";

        TestBinaryTree testTree = TestBinaryTreeBuilder.build(tree);
        assertFalse(Solution_4_4_CCI_Check_BalancedTree.solution(testTree.root));
    }

    @Test
    void test5() {
        String tree = "1\n1->2,3\n2->4,5\n3->6,7\n4->,12\n12->34";

        TestBinaryTree testTree = TestBinaryTreeBuilder.build(tree);
        assertFalse(Solution_4_4_CCI_Check_BalancedTree.solution(testTree.root));
    }

    @Test
    void test6() {
        String tree = "1\n1->2,3\n2->4,5\n3->6,7\n4->,12\n12->34\n6->99";

        TestBinaryTree testTree = TestBinaryTreeBuilder.build(tree);
        assertFalse(Solution_4_4_CCI_Check_BalancedTree.solution(testTree.root));
    }

    @Test
    void test7() {
        String tree = "1\n1->2,3\n2->4,5\n3->6,7\n4->11,12\n12->34\n6->99";

        TestBinaryTree testTree = TestBinaryTreeBuilder.build(tree);
        assertFalse(Solution_4_4_CCI_Check_BalancedTree.solution(testTree.root));
    }

    @Test
    void test8() {
        String tree = "1\n1->2,3\n2->4,5\n5->,29\n3->6,7\n4->11,12\n12->34\n6->99";

        TestBinaryTree testTree = TestBinaryTreeBuilder.build(tree);
        assertTrue(Solution_4_4_CCI_Check_BalancedTree.solution(testTree.root));
    }
}
