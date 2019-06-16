package Chapter4;


import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

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

    public BinaryTreeNode<Integer> find(int value) {
        return find(value, root);
    }

    // Finds a value in the tree (Depth first search)
    private BinaryTreeNode<Integer> find(int value, BinaryTreeNode<Integer> root) {
        if (root == null) {
            return null;
        }

        if (root.value == value) {
            return root;
        }

        BinaryTreeNode<Integer> node = find(value, root.left);
        if (node == null) {
            node = find(value, root.right);
        }

        return node;
    }

    // Find a free node where to perform an insert of a node
    private BinaryTreeNode<Integer> findFreeNode(BinaryTreeNode<Integer> start) {
        Queue<BinaryTreeNode<Integer>> nodes = new LinkedList<>();

        nodes.add(start);

        boolean found = false;

        BinaryTreeNode<Integer> out = null;

        while (!nodes.isEmpty() && !found) {
            BinaryTreeNode<Integer> node = nodes.remove();

            if (node.left == null) {
                found = true;
                out = node;
            } else if (node.right == null) {
                found = true;
                out = node;
            }

            if (node.left != null) {
                nodes.add(node.left);
            }

            if (node.right != null) {
                nodes.add(node.right);
            }
        }

        return out;
    }


    // Deletes an existing value from the tree
    public void delete(int value) {
        BinaryTreeNode<Integer> node = find(value, root);

        if (node == null) {
            return;
        }

        nodes.remove(value);

        if (node.parent == null) {
            if (node.left != null) {
                node.left.parent = null;
                if (node.right != null) {
                    insert(node.right, node.left);
                    root = node.left;
                }
            } else if (node.right != null) {
                node.right.parent = null;
                root = node.right;
            }
            else {
                root = null;
            }

            return;
        }

        BinaryTreeNode<Integer> parent = node.parent;

        if (parent.left == node) {
            parent.left = null;
        }

        if (parent.right == node) {
            parent.right = null;
        }

        if (node.left != null) {
            insert(node.left, parent);
        }

        if (node.right != null) {
            insert(node.right, parent);
        }
    }

    // Inserts a new node
    public void insert(BinaryTreeNode<Integer> newNode) {
        insert(newNode, root);
    }

    // Inserts a new value by creating a new node
    public void insert(int value) {
        insert(value, root);
    }

    // Inserts a new value in the tree (duplicates are not checked)
    private void insert(int value, BinaryTreeNode<Integer> start) {
        insert(new BinaryTreeNode<>(value), start);
    }

    // Inserts a new value in the tree (duplicates are not checked)
    private void insert(BinaryTreeNode<Integer> newNode, BinaryTreeNode<Integer> start) {
        BinaryTreeNode<Integer> insertPoint = findFreeNode(start);

        if (insertPoint.left == null) {
            insertPoint.left = newNode;
        } else {
            insertPoint.right = newNode;
        }

        newNode.parent = insertPoint;

        nodes.put(newNode.value, newNode);
    }
}
