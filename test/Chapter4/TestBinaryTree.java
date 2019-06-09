package Chapter4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class TestBinaryTree {
    public Map<Integer, BinaryTreeNode<Integer>> nodes;
    public BinaryTreeNode<Integer> root;

    public TestBinaryTree(BinaryTreeNode<Integer> root, Map<Integer, BinaryTreeNode<Integer>> nodes) {
        this.nodes = nodes;
        this.root = root;
    }

    public TestBinaryTree(BinaryTreeNode<Integer> root) {
        this.root = root;
    }

    // Just for testing that the tree is correctly built by the builder
    public String preOrder() {
        String aux = doPreOrder(this.root);
        return aux.substring(0, aux.length() - 1);
    }

    // Just for testing that the tree is correctly built by the builder
    private String doPreOrder(BinaryTreeNode<Integer> root) {
        StringBuffer buffer = new StringBuffer();

        buffer.append(root.value).append(",");

        if (root.left != null) {
            buffer.append(doPreOrder(root.left));
        }

        if (root.right != null) {
            buffer.append(doPreOrder(root.right));
        }

        return buffer.substring(0, buffer.length());
    }

    public String inOrder() {
        String aux = doInOrder(this.root);
        return aux.substring(0, aux.length() - 1);
    }

    // Just for testing that the tree is correctly built by the builder
    private String doInOrder(BinaryTreeNode<Integer> root) {
        StringBuffer buffer = new StringBuffer();

        if (root.left != null) {
            buffer.append(doInOrder(root.left));
        }

        buffer.append(root.value).append(",");

        if (root.right != null) {
            buffer.append(doInOrder(root.right));
        }

        return buffer.substring(0, buffer.length());
    }

    public String prettyPrint() {
        return prettyPrint(root) + "\n";
    }

    private String prettyPrint(BinaryTreeNode<Integer> node) {
        StringBuffer out = new StringBuffer();
        out.append(node.value);

        out.append("->");
        if (node.left != null) {
            out.append(node.left.value);
        }
        out.append(",");
        if (node.right != null) {
            out.append(node.right.value);
        }


        if (node.left != null) {
            out.append("\n");
            out.append(prettyPrint(node.left));
        }

        if (node.right != null) {
            out.append("\n");
            out.append(prettyPrint(node.right));
        }

        return out.toString();
    }

    private List<LinkedList<BinaryTreeNode<Integer>>> createTreeLevelsList(BinaryTreeNode<Integer> root) {
        List<LinkedList<BinaryTreeNode<Integer>>> out = new ArrayList<>();

        LinkedList<BinaryTreeNode<Integer>> list = new LinkedList<>();

        out.add(0, list);
        list.add(root);

        if (root.left != null || root.right != null) {
            processNode(root, 1, out);
        }

        return out;
    }

    private void processNode(BinaryTreeNode<Integer> node, int level, List<LinkedList<BinaryTreeNode<Integer>>> lists) {
        if (node == null) {
            return;
        }

        LinkedList<BinaryTreeNode<Integer>> list = null;
        if (lists.size() <= level) {
            list = new LinkedList<>();
            lists.add(level, list);
        } else {
            list = lists.get(level);
        }

        if (node.left == null) {
            list.add(new BinaryTreeNode<>(-1));
        } else {
            list.add(node.left);
        }

        if (node.right == null) {
            list.add(new BinaryTreeNode<>(-1));
        } else {
            list.add(node.right);
        }

        processNode(node.left, level + 1, lists);
        processNode(node.right, level + 1, lists);
    }


    public String prettyPrintAsAsciiArt() {
        List<LinkedList<BinaryTreeNode<Integer>>> nodeLists = createTreeLevelsList(root);

        System.out.println(nodeLists.size());

        int margin = 40;
        int nodeMargin = 5 * (nodeLists.size() - 1);

        StringBuffer out = new StringBuffer();

        int level = 1;
        for (LinkedList<BinaryTreeNode<Integer>> list : nodeLists) {
            StringBuffer strBuffer = new StringBuffer();
            printWithMargin(margin - nodeMargin / level, "", strBuffer);

            for (BinaryTreeNode<Integer> node : list) {
                String value = String.valueOf(node.value);
                if (node.value == -1) {
                    value = "";
                }

                printWithMargin(nodeMargin / level, value, strBuffer);
            }
            // Every time tree level is increased margin decreases
            margin -= 5;
            out.append(strBuffer).append("\n");

            level++;
        }

        return out.toString();
    }

    private void printWithMargin(int margin, String str, StringBuffer out) {
        for (int j = 0; j < margin; j++) {
            out.append(" ");
        }

        out.append(str);
    }
}
