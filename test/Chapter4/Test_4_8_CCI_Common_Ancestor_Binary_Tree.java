package Chapter4;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class Test_4_8_CCI_Common_Ancestor_Binary_Tree {

    private String tree = "1\n1->2,3\n2->4,5\n3->6,7\n4->45\n45->80,90";

    @Test
    void test0() {
        TestBinaryTree testTree = TestBinaryTreeBuilder.build(tree);

        BinaryTreeNode<Integer> root = testTree.root;

        // Check that the tree has been correctly built
        assertEquals("1,2,4,45,80,90,5,3,6,7", testTree.preOrder());

        BinaryTreeNode<Integer> result = Solution_4_8_CCI_Common_Ancestor_Binary_Tree.solution(root, root);

        assertEquals(root.value, result.value);
    }

    @Test
    void test1() {
        TestBinaryTree t = TestBinaryTreeBuilder.build(tree);
        BinaryTreeNode<Integer> root = t.root;

        BinaryTreeNode<Integer> n2 = t.nodes.get(5);

        BinaryTreeNode<Integer> result = Solution_4_8_CCI_Common_Ancestor_Binary_Tree.solution(root, n2);

        assertEquals(root.value, result.value);
    }

    @Test
    void test2() {
        TestBinaryTree t = TestBinaryTreeBuilder.build(tree);

        BinaryTreeNode<Integer> n1 = t.nodes.get(5);
        BinaryTreeNode<Integer> n2 = t.nodes.get(45);

        BinaryTreeNode<Integer> result = Solution_4_8_CCI_Common_Ancestor_Binary_Tree.solution(n1, n2);

        assertEquals(2, result.value);
    }

    @Test
    void test3() {
        TestBinaryTree t = TestBinaryTreeBuilder.build(tree);

        BinaryTreeNode<Integer> n1 = t.nodes.get(6);
        BinaryTreeNode<Integer> n2 = t.nodes.get(7);

        BinaryTreeNode<Integer> result = Solution_4_8_CCI_Common_Ancestor_Binary_Tree.solution(n1, n2);

        assertEquals(3, result.value);
    }

    @Test
    void test4() {
        TestBinaryTree t = TestBinaryTreeBuilder.build(tree);

        BinaryTreeNode<Integer> n1 = t.nodes.get(6);
        BinaryTreeNode<Integer> n2 = t.nodes.get(7);

        BinaryTreeNode<Integer> result = Solution_4_8_CCI_Common_Ancestor_Binary_Tree.solution(n2, n1);

        assertEquals(3, result.value);
    }

    @Test
    void test5() {
        TestBinaryTree t = TestBinaryTreeBuilder.build(tree);

        BinaryTreeNode<Integer> n1 = t.nodes.get(80);
        BinaryTreeNode<Integer> n2 = t.nodes.get(90);

        BinaryTreeNode<Integer> result = Solution_4_8_CCI_Common_Ancestor_Binary_Tree.solution(n2, n1);

        assertEquals(45, result.value);
    }

    @Test
    void test6() {
        TestBinaryTree t = TestBinaryTreeBuilder.build(tree);

        BinaryTreeNode<Integer> n1 = t.nodes.get(7);
        BinaryTreeNode<Integer> n2 = t.nodes.get(90);

        BinaryTreeNode<Integer> result = Solution_4_8_CCI_Common_Ancestor_Binary_Tree.solution(n1, n2);

        assertEquals(1, result.value);
    }
}
