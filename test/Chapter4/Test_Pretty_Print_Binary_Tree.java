package Chapter4;

import org.junit.jupiter.api.Test;


// Tests pretty printing of binary trees
public class Test_Pretty_Print_Binary_Tree {

    @Test
    void test10() {
        String tree = "1";

        TestBinaryTree testTree = TestBinaryTreeBuilder.build(tree);

        System.out.println(BinaryTreePrettyPrinter.print(testTree.root));
    }


    @Test
    void test11() {
        String tree = "1\n1->2,4";

        TestBinaryTree testTree = TestBinaryTreeBuilder.build(tree);

        System.out.println(BinaryTreePrettyPrinter.print(testTree.root));
    }

    @Test
    void test12() {
        String tree = "1\n1->2";

        TestBinaryTree testTree = TestBinaryTreeBuilder.build(tree);

        System.out.println(BinaryTreePrettyPrinter.print(testTree.root));
    }

    @Test
    void test13() {
        String tree = "1\n1->,4";

        TestBinaryTree testTree = TestBinaryTreeBuilder.build(tree);

        System.out.println(BinaryTreePrettyPrinter.print(testTree.root));
    }

    @Test
    void test14() {
        String tree = "1\n1->2,4\n2->3";

        TestBinaryTree testTree = TestBinaryTreeBuilder.build(tree);

        System.out.println(BinaryTreePrettyPrinter.print(testTree.root));
    }

    @Test
    void test15() {
        String tree = "1\n1->2,4\n2->3\n4->,5";

        TestBinaryTree testTree = TestBinaryTreeBuilder.build(tree);

        System.out.println(BinaryTreePrettyPrinter.print(testTree.root));
    }

    @Test
    void test16() {
        String tree = "1\n1->2,4\n2->3\n4->,5\n5->7";

        TestBinaryTree testTree = TestBinaryTreeBuilder.build(tree);

        System.out.println(BinaryTreePrettyPrinter.print(testTree.root));
    }

    @Test
    void test171() {
        String tree = "1\n1->2,4\n2->3\n4->,5\n5->7,78";

        TestBinaryTree testTree = TestBinaryTreeBuilder.build(tree);

        System.out.println(BinaryTreePrettyPrinter.print(testTree.root));
    }

    @Test
    void test121() {
        String tree = "1\n1->,4\n4->,2";

        TestBinaryTree testTree = TestBinaryTreeBuilder.build(tree);

        System.out.println(BinaryTreePrettyPrinter.print(testTree.root));
    }

    @Test
    void test131() {
        String tree = "1\n1->,4\n4->2";

        TestBinaryTree testTree = TestBinaryTreeBuilder.build(tree);

        System.out.println(BinaryTreePrettyPrinter.print(testTree.root));
    }

    @Test
    void test141() {
        String tree = "1\n1->,4\n4->2,3";

        TestBinaryTree testTree = TestBinaryTreeBuilder.build(tree);

        System.out.println(BinaryTreePrettyPrinter.print(testTree.root));
    }

    @Test
    void test151() {
        String tree = "10\n10->,40\n40->12";

        TestBinaryTree testTree = TestBinaryTreeBuilder.build(tree);

        System.out.println(BinaryTreePrettyPrinter.print(testTree.root));
    }

    @Test
    void test161() {
        String tree = "15\n15->,40\n40->12";

        TestBinaryTree testTree = TestBinaryTreeBuilder.build(tree);

        System.out.println(BinaryTreePrettyPrinter.print(testTree.root));
    }

    @Test
    void test17() {
        String tree = "15\n15->10\n10->,17";

        TestBinaryTree testTree = TestBinaryTreeBuilder.build(tree);

        System.out.println(BinaryTreePrettyPrinter.print(testTree.root));
    }

    @Test
    void test18() {
        String tree = "7\n7->6\n6->,8";

        TestBinaryTree testTree = TestBinaryTreeBuilder.build(tree);

        System.out.println(BinaryTreePrettyPrinter.print(testTree.root));
    }

    @Test
    void test19() {
        String tree = "7\n7->,13\n13->6";

        TestBinaryTree testTree = TestBinaryTreeBuilder.build(tree);

        System.out.println(BinaryTreePrettyPrinter.print(testTree.root));
    }

    @Test
    void test20() {
        String tree = "7\n7->,13\n13->9";

        TestBinaryTree testTree = TestBinaryTreeBuilder.build(tree);

        System.out.println(BinaryTreePrettyPrinter.print(testTree.root));
    }

    @Test
    void test21() {
        String tree = "7\n7->5\n5->,6";

        TestBinaryTree testTree = TestBinaryTreeBuilder.build(tree);

        System.out.println(BinaryTreePrettyPrinter.print(testTree.root));
    }

    @Test
    void test22() {
        String tree = "20\n20->15,30\n15->12,19\n19->,25";

        TestBinaryTree testTree = TestBinaryTreeBuilder.build(tree);

        System.out.println(BinaryTreePrettyPrinter.print(testTree.root));
    }

    @Test
    void test23() {
        String tree = "22\n22->9\n9->8,12\n12->7,34";

        TestBinaryTree testTree = TestBinaryTreeBuilder.build(tree);

        System.out.println(BinaryTreePrettyPrinter.print(testTree.root));
    }

    @Test
    void test24() {
        String tree = "22\n22->9\n9->8,12\n12->11,20";

        TestBinaryTree testTree = TestBinaryTreeBuilder.build(tree);

        System.out.println(BinaryTreePrettyPrinter.print(testTree.root));
    }

}
