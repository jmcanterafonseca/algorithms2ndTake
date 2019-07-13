package Chapter4;

import datastr.BinaryTreeNode;

import java.util.HashMap;
import java.util.Map;

// Builds a binary tree from a string or text file which describes its structure
// First line is the root node
// 1
// 1->2,3
// 2->4,5
// 3->6,7
public class TestBinaryTreeBuilder {
    public static TestBinaryTree build(String input) {
        Map<Integer, BinaryTreeNode<Integer>> nodes = new HashMap<>();

        String[] lines = input.split("\\R");

        // first line it shall contain the root node
        int rootValue = Integer.parseInt(lines[0]);

        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(null, rootValue);
        nodes.put(rootValue, root);

        for (int j = 1; j < lines.length; j++) {
            String[] parts = lines[j].split("->");

            int nodeValue = Integer.parseInt(parts[0]);

            BinaryTreeNode<Integer> node = nodes.get(nodeValue);

            if (node == null) {
                throw new RuntimeException("Cannot find parent of leaf node");
            }

            String[] children = parts[1].split(",");

            for (int k = 0; k < children.length; k++) {
                if (children[k] == null || children[k].trim().length() == 0) {
                    continue;
                }

                int childValue = Integer.parseInt(children[k]);
                BinaryTreeNode<Integer> childNode = new BinaryTreeNode<>(node, childValue);
                if (k == 0) {
                    node.left = childNode;
                }
                else {
                    node.right = childNode;
                }
                nodes.put(childValue, childNode);
            }
        }

        return new TestBinaryTree(root, nodes);
    }
}
