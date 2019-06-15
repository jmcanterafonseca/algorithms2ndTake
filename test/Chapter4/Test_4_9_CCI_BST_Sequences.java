package Chapter4;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class Test_4_9_CCI_BST_Sequences {

    @Test
    void test0() {
        String tree = "2\n";

        TestBinaryTree testTree = TestBinaryTreeBuilder.build(tree);

        BinaryTreeNode<Integer> root = testTree.root;

        System.out.println(Arrays.toString(Solution_4_9_BST_Sequence.solution(root).toArray()));
    }

    @Test
    void test1() {
        String tree = "2\n2->1,3";

        TestBinaryTree testTree = TestBinaryTreeBuilder.build(tree);

        BinaryTreeNode<Integer> root = testTree.root;

        System.out.println(Arrays.toString(Solution_4_9_BST_Sequence.solution(root).toArray()));
    }


    @Test
    void test2() {
        String tree = "7\n7->5,10\n5->3,6\n";

        TestBinaryTree testTree = TestBinaryTreeBuilder.build(tree);

        BinaryTreeNode<Integer> root = testTree.root;

        System.out.println(Arrays.toString(Solution_4_9_BST_Sequence.solution(root).toArray()));
    }

    @Test
    void test3() {
        String tree = "6\n6->5\n5->4";

        TestBinaryTree testTree = TestBinaryTreeBuilder.build(tree);

        BinaryTreeNode<Integer> root = testTree.root;

        System.out.println(Arrays.toString(Solution_4_9_BST_Sequence.solution(root).toArray()));
    }

    @Test
    void test4() {
        String tree = "6\n6->10\n10->14";

        TestBinaryTree testTree = TestBinaryTreeBuilder.build(tree);

        BinaryTreeNode<Integer> root = testTree.root;

        System.out.println(Arrays.toString(Solution_4_9_BST_Sequence.solution(root).toArray()));
    }

    @Test
    void test5() {
        String tree = "6\n6->10\n10->14\n14->11,15";

        TestBinaryTree testTree = TestBinaryTreeBuilder.build(tree);

        BinaryTreeNode<Integer> root = testTree.root;

        System.out.println(Arrays.toString(Solution_4_9_BST_Sequence.solution(root).toArray()));
    }
}
