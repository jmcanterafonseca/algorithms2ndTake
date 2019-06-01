package Chapter4;

public class BinaryTreeNode<T> {
    // Left and right child
    public BinaryTreeNode left;
    public BinaryTreeNode right;

    // If parent == null then it is the root node
    public BinaryTreeNode parent;

    // Height of the left subtree (Added for 4.4)
    public int leftHeight = -1;
    // Height of the right subtree (Added for 4.4)
    public int rightHeight = -1;

    // Value of the node
    public T value;
    // Whether the node has been visited or not
    public boolean visited;

    public BinaryTreeNode(BinaryTreeNode<T> parent, T value) {
        this.value = value;
        this.parent = parent;
    }

    public BinaryTreeNode(T value) {
        this.value = value;
    }
}
