package Chapter4;

import datastr.BinaryTreeNode;
import datastr.TestBinaryTree;
import datastr.TestBinaryTreeBuilder;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

// Builds a Binary Search Tree (with minimal height) from a sorted array (increasing order)
public class Test_4_3_CCI_List_Of_Depths {
    private String tree = "1\n1->2,3\n2->4,5\n3->6,7\n4->45\n45->80,90";

    private void assertList(List<LinkedList<BinaryTreeNode<Integer>>> list, int size, int[] sizes, int[][] values) {
        assertEquals(size, list.size());

        for (int j = 0; j < sizes.length; j++) {
            assertEquals(sizes[j], list.get(j).size());
        }

        for (int j = 0; j < values.length; j++) {
            LinkedList<BinaryTreeNode<Integer>> nodeList = list.get(j);
            Iterator<BinaryTreeNode<Integer>> it = nodeList.iterator();
            int arrayIndex = 0;
            while (it.hasNext()) {
                assertEquals(values[j][arrayIndex++], it.next().value);
            }
        }
    }

    @Test
    void test0() {
        TestBinaryTree testTree = TestBinaryTreeBuilder.build(tree);

        BinaryTreeNode<Integer> root = testTree.root;

        // Check that the tree has been correctly built
        assertEquals("1,2,4,45,80,90,5,3,6,7", testTree.preOrder());

        List<LinkedList<BinaryTreeNode<Integer>>> list = Solution_4_3_CCI_List_Of_Depths.solution(root);

        int[] sizes = {1, 2, 4, 1, 2};
        int[][] values = {{1}, {2, 3}, {4, 5, 6, 7}, {45}, {80, 90}};

        assertList(list, 5, sizes, values);
    }

    @Test
    void test1() {
        String tree = "1";
        TestBinaryTree testTree = TestBinaryTreeBuilder.build(tree);

        BinaryTreeNode<Integer> root = testTree.root;

        List<LinkedList<BinaryTreeNode<Integer>>> list = Solution_4_3_CCI_List_Of_Depths.solution(root);

        int[] sizes = {1};
        int[][] values = {{1}};

        assertList(list, 1, sizes, values);
    }

    @Test
    void test2() {
        String tree = "1\n1->2\n2->3\n3->4";
        TestBinaryTree testTree = TestBinaryTreeBuilder.build(tree);

        BinaryTreeNode<Integer> root = testTree.root;

        List<LinkedList<BinaryTreeNode<Integer>>> list = Solution_4_3_CCI_List_Of_Depths.solution(root);

        int[] sizes = {1, 1, 1, 1};
        int[][] values = {{1}, {2}, {3}, {4}};

        assertList(list, 4, sizes, values);
    }
}
