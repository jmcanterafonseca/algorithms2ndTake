package Chapter4;

import datastr.TestBinaryTree;
import datastr.TestBinaryTreeBuilder;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


// Builds a Binary Search Tree (with minimal height) from a sorted array (increasing order)
public class Test_4_5_CCI_Check_BST {

    @Test
    void test10() {
        String tree = "1";

        TestBinaryTree testTree = TestBinaryTreeBuilder.build(tree);

        assertTrue(Solution_4_5_CCI_Check_BST.solution(testTree.root));
    }

    @Test
    void test11() {
        String tree = "1\n1->,4\n4->,6";

        TestBinaryTree testTree = TestBinaryTreeBuilder.build(tree);

        assertTrue(Solution_4_5_CCI_Check_BST.solution(testTree.root));
    }

    @Test
    void test12() {
        String tree = "1\n1->,4\n4->,2";

        TestBinaryTree testTree = TestBinaryTreeBuilder.build(tree);

        assertFalse(Solution_4_5_CCI_Check_BST.solution(testTree.root));
    }

    @Test
    void test13() {
        String tree = "1\n1->,4\n4->2";

        TestBinaryTree testTree = TestBinaryTreeBuilder.build(tree);

        assertTrue(Solution_4_5_CCI_Check_BST.solution(testTree.root));
    }

    @Test
    void test14() {
        String tree = "1\n1->,4\n4->2,3";

        TestBinaryTree testTree = TestBinaryTreeBuilder.build(tree);

        assertFalse(Solution_4_5_CCI_Check_BST.solution(testTree.root));
    }

    @Test
    void test15() {
        String tree = "10\n10->,40\n40->12";

        TestBinaryTree testTree = TestBinaryTreeBuilder.build(tree);

        assertTrue(Solution_4_5_CCI_Check_BST.solution(testTree.root));
    }

    @Test
    void test16() {
        String tree = "15\n15->,40\n40->12";

        TestBinaryTree testTree = TestBinaryTreeBuilder.build(tree);

        assertFalse(Solution_4_5_CCI_Check_BST.solution(testTree.root));
    }

    @Test
    void test17() {
        String tree = "15\n15->10\n10->,17";

        TestBinaryTree testTree = TestBinaryTreeBuilder.build(tree);

        assertFalse(Solution_4_5_CCI_Check_BST.solution(testTree.root));
    }

    @Test
    void test18() {
        String tree = "7\n7->6\n6->,8";

        TestBinaryTree testTree = TestBinaryTreeBuilder.build(tree);

        assertFalse(Solution_4_5_CCI_Check_BST.solution(testTree.root));
    }

    @Test
    void test19() {
        String tree = "7\n7->,13\n13->6";

        TestBinaryTree testTree = TestBinaryTreeBuilder.build(tree);

        assertFalse(Solution_4_5_CCI_Check_BST.solution(testTree.root));
    }

    @Test
    void test20() {
        String tree = "7\n7->,13\n13->9";

        TestBinaryTree testTree = TestBinaryTreeBuilder.build(tree);

        assertTrue(Solution_4_5_CCI_Check_BST.solution(testTree.root));
    }

    @Test
    void test21() {
        String tree = "7\n7->5\n5->,6";

        TestBinaryTree testTree = TestBinaryTreeBuilder.build(tree);

        assertTrue(Solution_4_5_CCI_Check_BST.solution(testTree.root));
    }

    @Test
    void test22() {
        String tree = "20\n20->15,30\n15->12,19\n19->,25";

        TestBinaryTree testTree = TestBinaryTreeBuilder.build(tree);

        assertFalse(Solution_4_5_CCI_Check_BST.solution(testTree.root));
    }

    @Test
    void test23() {
        String tree = "22\n22->9\n9->8,12\n12->7,34";

        TestBinaryTree testTree = TestBinaryTreeBuilder.build(tree);

        assertFalse(Solution_4_5_CCI_Check_BST.solution(testTree.root));
    }

    @Test
    void test24() {
        String tree = "22\n22->9\n9->8,12\n12->11,20";

        TestBinaryTree testTree = TestBinaryTreeBuilder.build(tree);

        assertTrue(Solution_4_5_CCI_Check_BST.solution(testTree.root));
    }
}
