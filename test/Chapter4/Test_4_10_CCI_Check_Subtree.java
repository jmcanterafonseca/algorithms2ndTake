package Chapter4;

import datastr.BinaryTreeNode;
import datastr.TestBinaryTree;
import datastr.TestBinaryTreeBuilder;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class Test_4_10_CCI_Check_Subtree {

    @Test
    void test0() {
        String tree1 = "2\n";

        TestBinaryTree testTree = TestBinaryTreeBuilder.build(tree1);

        BinaryTreeNode<Integer> root = testTree.root;

        assertTrue(Solution_4_10_CCI_Check_Subtree.solution(root, root));
    }

    @Test
    void test1() {
        String tree1 = "2\n2->3,4\n3->,5";

        TestBinaryTree testTree = TestBinaryTreeBuilder.build(tree1);

        BinaryTreeNode<Integer> root = testTree.root;

        assertTrue(Solution_4_10_CCI_Check_Subtree.solution(root, testTree.nodes.get(3)));
    }

    @Test
    void test2() {
        String tree1 = "2\n2->3,4\n3->,5";

        TestBinaryTree testTree = TestBinaryTreeBuilder.build(tree1);

        BinaryTreeNode<Integer> root = testTree.root;

        assertTrue(Solution_4_10_CCI_Check_Subtree.solution(root, testTree.nodes.get(5)));
    }

    @Test
    void test3() {
        String tree1 = "2\n2->3,4\n3->,5";

        TestBinaryTree testTree = TestBinaryTreeBuilder.build(tree1);

        BinaryTreeNode<Integer> root = testTree.root;

        assertTrue(Solution_4_10_CCI_Check_Subtree.solution(root, testTree.nodes.get(5)));
    }

    @Test
    void test4() {
        String tree1 = "18\n18->2\n2->3,4\n3->,5";
        String tree2 = "2\n2->3,4\n3->,5";

        TestBinaryTree testTree1 = TestBinaryTreeBuilder.build(tree1);
        TestBinaryTree testTree2 = TestBinaryTreeBuilder.build(tree2);

        assertTrue(Solution_4_10_CCI_Check_Subtree.solution(testTree1.root, testTree2.root));
    }

    @Test
    void test5() {
        String tree1 = "18\n18->2\n2->3,4\n3->,5";
        String tree2 = "2\n2->3,4\n3->12,5";

        TestBinaryTree testTree1 = TestBinaryTreeBuilder.build(tree1);
        TestBinaryTree testTree2 = TestBinaryTreeBuilder.build(tree2);

        assertFalse(Solution_4_10_CCI_Check_Subtree.solution(testTree1.root, testTree2.root));
    }

    @Test
    void test6() {
        String tree1 = "2\n";
        String tree2 = "2\n";

        TestBinaryTree testTree1 = TestBinaryTreeBuilder.build(tree1);
        TestBinaryTree testTree2 = TestBinaryTreeBuilder.build(tree2);

        assertTrue(Solution_4_10_CCI_Check_Subtree.solution(testTree1.root, testTree2.root));
    }

    @Test
    void test7() {
        String tree1 = "2\n";
        String tree2 = "3\n";

        TestBinaryTree testTree1 = TestBinaryTreeBuilder.build(tree1);
        TestBinaryTree testTree2 = TestBinaryTreeBuilder.build(tree2);

        assertFalse(Solution_4_10_CCI_Check_Subtree.solution(testTree1.root, testTree2.root));
    }

    @Test
    void test8() {
        String tree1 = "2\n";
        String tree2 = "2\n2->,3";

        TestBinaryTree testTree1 = TestBinaryTreeBuilder.build(tree1);
        TestBinaryTree testTree2 = TestBinaryTreeBuilder.build(tree2);

        assertFalse(Solution_4_10_CCI_Check_Subtree.solution(testTree1.root, testTree2.root));
    }

    @Test
    void test9() {
        String tree1 = "2\n2->,3";
        String tree2 = "2\n";

        TestBinaryTree testTree1 = TestBinaryTreeBuilder.build(tree1);
        TestBinaryTree testTree2 = TestBinaryTreeBuilder.build(tree2);

        assertFalse(Solution_4_10_CCI_Check_Subtree.solution(testTree1.root, testTree2.root));
    }
}
