package Chapter4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

// Builds a Binary Search Tree (with minimal height) from a sorted array (increasing order)
public class Test_4_2_CCI_Minimal_Height_Tree {
    @Test
    void test0() {
        int[] array = {-4};

        BinaryTreeNode<Integer> result = Solution_4_2_CCI_Minimal_Height_Tree.solution(array);

        assertEquals(array[0], result.value);
        assertEquals(null, result.parent);
    }

    @Test
    void test1() {
        int[] array = {-4, 10};

        BinaryTreeNode<Integer> result = Solution_4_2_CCI_Minimal_Height_Tree.solution(array);

        assertEquals(array[0], result.value);
        assertEquals(null, result.parent);
    }

    @Test
    void test2() {
        int[] array = {-4, 10, 30};

        BinaryTreeNode<Integer> result = Solution_4_2_CCI_Minimal_Height_Tree.solution(array);

        assertEquals(array[1], result.value);
        assertEquals(null, result.parent);

        assertEquals(array[0], result.left.value);
        assertEquals(result, result.left.parent);

        assertEquals(array[2], result.right.value);
        assertEquals(result, result.right.parent);
    }

    @Test
    void test3() {
        int[] array = {-4, 10, 30, 40};

        BinaryTreeNode<Integer> result = Solution_4_2_CCI_Minimal_Height_Tree.solution(array);

        assertEquals(array[1], result.value);
        assertEquals(null, result.parent);

        assertEquals(array[0], result.left.value);
        assertEquals(result, result.left.parent);

        assertEquals(array[2], result.right.value);
        assertEquals(result, result.right.parent);

        assertEquals(array[3], result.right.right.value);
        assertEquals(result.right, result.right.right.parent);
    }

    @Test
    void test4() {
        int[] array = {-4, 10, 30, 40, 50};

        BinaryTreeNode<Integer> result = Solution_4_2_CCI_Minimal_Height_Tree.solution(array);

        assertEquals(array[2], result.value);
        assertEquals(null, result.parent);

        assertEquals(array[0], result.left.value);
        assertEquals(result, result.left.parent);

        assertEquals(array[3], result.right.value);
        assertEquals(result, result.right.parent);

        TestBinaryTree tree = new TestBinaryTree(result);

        assertEquals("-4,10,30,40,50", tree.inOrder());
    }

    @Test
    void test5() {
        int[] array = {-4, 10, 30, 40, 50, 60};

        BinaryTreeNode<Integer> result = Solution_4_2_CCI_Minimal_Height_Tree.solution(array);

        assertEquals(array[2], result.value);
        assertEquals(null, result.parent);

        assertEquals(array[0], result.left.value);
        assertEquals(result, result.left.parent);

        assertEquals(array[4], result.right.value);
        assertEquals(result, result.right.parent);

        TestBinaryTree tree = new TestBinaryTree(result);

        assertEquals("-4,10,30,40,50,60", tree.inOrder());
    }
}
