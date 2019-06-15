package Chapter4;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreePrettyPrinter {
    private static BinaryTreeNode<Integer> DUMMY_NODE = new BinaryTreeNode<>(Integer.MIN_VALUE);

    // page width in columns
    private static int PAGE_WIDTH = 80;
    private static int LEVEL_INCREMENT = 8;

    public static String print(BinaryTreeNode<Integer> root) {
        return processTree(root);
    }

    private static String processTree(BinaryTreeNode<Integer> root) {
        StringBuffer out = new StringBuffer();

        Queue<BinaryTreeNode<Integer>> queue = new LinkedList<>();

        queue.add(root);

        int level = 0;
        int startPrint = PAGE_WIDTH / 2;

        int numElementsProcessed = 0;
        int numElementsInThisLevel = 1;
        int indexInThisLevel = 0;

        int marginIncrement = -1;

        int numDummyElementsInThisLevel = 0;

        while (!queue.isEmpty()) {
            // Process the element in the queue
            BinaryTreeNode<Integer> element = queue.poll();

            if (element == DUMMY_NODE) {
                numDummyElementsInThisLevel++;
                if (numDummyElementsInThisLevel == numElementsInThisLevel) {
                    break;
                }
            }

            if (indexInThisLevel == 0) {
                printNode(startPrint - level * LEVEL_INCREMENT, element, out);
            } else {
                printNode(marginIncrement, element, out);
            }

            numElementsProcessed++;
            indexInThisLevel++;

            BinaryTreeNode<Integer> leftElement = element.left;
            if (leftElement == null) {
                leftElement = DUMMY_NODE;
            }

            BinaryTreeNode<Integer> rightElement = element.right;
            if (rightElement == null) {
                rightElement = DUMMY_NODE;
            }

            queue.add(leftElement);
            queue.add(rightElement);

            if (numElementsProcessed == numElementsInThisLevel) {
                out.append("\n");
                level += 1;
                numElementsInThisLevel <<= 1;
                indexInThisLevel = 0;
                numElementsProcessed = 0;
                marginIncrement = ((level * LEVEL_INCREMENT) * 2) / (numElementsInThisLevel - 1);
                numDummyElementsInThisLevel = 0;
            }
        }

        return out.toString();
    }

    private static void printNode(int margin, BinaryTreeNode<Integer> node, StringBuffer out) {
        String str = String.valueOf(node.value);
        if (node == DUMMY_NODE) {
            str = "";
        }

        printWithMargin(margin, str, out);
    }

    private static void printWithMargin(int margin, String str, StringBuffer out) {
        for (int j = 0; j < margin; j++) {
            out.append(" ");
        }

        out.append(str);
    }
}
