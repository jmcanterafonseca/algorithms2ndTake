package Chapter4;

public class BinaryTreeNode<T> {
    // Left and right child
    public BinaryTreeNode left;
    public BinaryTreeNode right;

    // If parent == null then it is the root node
    public BinaryTreeNode parent;

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
