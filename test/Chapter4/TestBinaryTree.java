package Chapter4;

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
}
