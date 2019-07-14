package Chapter4;

import datastr.BinaryTreeNode;
import datastr.TestBinaryTree;
import datastr.TestBinaryTreeBuilder;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class Test_4_11_CCI_RandomNode {

    @Test
    void test0() {
        String tree1 = "2\n";

        TestBinaryTree testTree = TestBinaryTreeBuilder.build(tree1);

        BinaryTreeNode<Integer> root = testTree.root;

        assertEquals(testTree.find(2), root);
    }

    @Test
    void test01() {
        String tree1 = "2\n";

        TestBinaryTree testTree = TestBinaryTreeBuilder.build(tree1);

        testTree.insert(34);

        System.out.println(testTree.prettyPrint());
    }


    @Test
    void test1() {
        String tree1 = "2\n2->3,4\n3->,5";

        TestBinaryTree testTree = TestBinaryTreeBuilder.build(tree1);

        assertEquals(testTree.find(5), testTree.nodes.get(5));
    }


    @Test
    void test2() {
        String tree1 = "2\n2->3,4\n3->,5";

        TestBinaryTree testTree = TestBinaryTreeBuilder.build(tree1);

        assertEquals(testTree.find(15), null);
    }


    @Test
    void test3() {
        String tree1 = "2\n2->3,4\n3->,5";

        TestBinaryTree testTree = TestBinaryTreeBuilder.build(tree1);

        testTree.insert(34);

        System.out.println(testTree.prettyPrint());
    }


    @Test
    void test4() {
        String tree1 = "2\n2->3,4\n3->,5";

        TestBinaryTree testTree = TestBinaryTreeBuilder.build(tree1);

        testTree.delete(5);

        System.out.println(testTree.prettyPrint());
    }

    @Test
    void test5() {
        String tree1 = "2\n2->3,4\n3->,5";

        TestBinaryTree testTree = TestBinaryTreeBuilder.build(tree1);
        testTree.delete(15);

        System.out.println(testTree.prettyPrint());
    }

    @Test
    void test6() {
        String tree1 = "2\n2->3,4\n3->,5";

        TestBinaryTree testTree = TestBinaryTreeBuilder.build(tree1);

        testTree.delete(3);

        System.out.println(testTree.prettyPrint());
    }

    @Test
    void test7() {
        String tree1 = "2\n2->3,4\n3->,5";

        TestBinaryTree testTree = TestBinaryTreeBuilder.build(tree1);

        testTree.delete(4);

        System.out.println(testTree.prettyPrint());
    }

    @Test
    void test8() {
        String tree1 = "2\n2->3,4\n3->,5";

        TestBinaryTree testTree = TestBinaryTreeBuilder.build(tree1);

        testTree.delete(2);

        assertEquals(testTree.root, testTree.nodes.get(3));

        System.out.println(testTree.prettyPrint());
    }

    @Test
    void test9() {
        String tree1 = "2\n2->,4\n4->,5";

        TestBinaryTree testTree = TestBinaryTreeBuilder.build(tree1);

        testTree.delete(2);

        assertEquals(testTree.root, testTree.nodes.get(4));

        System.out.println(testTree.prettyPrint());
    }

    @Test
    void test10() {
        String tree1 = "2\n";

        TestBinaryTree testTree = TestBinaryTreeBuilder.build(tree1);

        testTree.delete(2);

        assertEquals(null, testTree.root);
    }

    @Test
    void test11() {
        String tree1 = "2\n";

        TestBinaryTree testTree = TestBinaryTreeBuilder.build(tree1);

        BinaryTreeNode<Integer> out = Solution_4_11_CCI_RandomNode.solution(testTree);

        assertEquals(out, testTree.root);
    }

    @Test
    void test12() {
        String tree1 = "2\n2->,4\n4->,5";

        TestBinaryTree testTree = TestBinaryTreeBuilder.build(tree1);

        BinaryTreeNode<Integer> out = Solution_4_11_CCI_RandomNode.solution(testTree);

        System.out.println(out.value);
    }
}
