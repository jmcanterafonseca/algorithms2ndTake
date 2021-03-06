package Chapter10;

import datastr.BinaryTreeNode;

// Implements sorting by keeping a min heap where the min element is always in the root
// of a binary tree
public class HeapSort {
    public static void sort(int[] array) {
        MinHeap heap = new MinHeap();

        for (int num : array) {
            heap.insert(num);
        }

        // Once elements are inserted on the heap we need to remove the root until the end
        for (int j = 0; j < array.length; j++) {
            array[j] = heap.min();
            heap.removeMin();
        }
    }


    private static class MinHeap {
        private BinaryTreeNode<Integer> root;
        private BinaryTreeNode<Integer> insertPoint;

        private BinaryTreeNode<Integer> updateInsertPoint(BinaryTreeNode<Integer> node) {
            BinaryTreeNode<Integer> current = node.parent;

            while (current.left != null) {
                current = current.left;
            }

            return current;
        }

        public int min() {
            return root.value;
        }

        public void insert(int value) {
            if (root == null) {
                root = new BinaryTreeNode<>(value);
                insertPoint = root;
            } else {
                BinaryTreeNode<Integer> newNode = new BinaryTreeNode<>(value);
                BinaryTreeNode<Integer> bubblePoint = insertPoint;

                if (insertPoint.left == null) {
                    insertPoint.left = newNode;
                    newNode.parent = insertPoint;
                } else {
                    insertPoint.right = newNode;
                    newNode.parent = insertPoint;
                    // Now the insert point is updated
                    insertPoint = updateInsertPoint(newNode);
                }

                bubbleUp(bubblePoint);
            }
        }

        public void removeMin() {
            if (insertPoint == root && insertPoint.left == null && insertPoint.right == null) {
                root = null;
                return;
            }

            if (insertPoint.right != null) {
                root.value = insertPoint.right.value;
                insertPoint.right = null;
            } else if (insertPoint.left != null) {
                root.value = insertPoint.left.value;
                insertPoint.left = null;
            } else {
                root.value = insertPoint.value;
                if (insertPoint.parent.left == insertPoint) {
                    insertPoint.parent.left = null;
                }
                if (insertPoint.parent.right == insertPoint) {
                    insertPoint.parent.right = null;
                }
            }

            bubbleDown(root);
        }

        private void bubbleUp(BinaryTreeNode<Integer> fromNode) {
            if (fromNode == null) {
                return;
            }

            if (fromNode.left != null && fromNode.value > fromNode.left.value) {
                int aux = fromNode.left.value;
                fromNode.left.value = fromNode.value;
                fromNode.value = aux;
            }

            if (fromNode.right != null && fromNode.value > fromNode.right.value) {
                int aux = fromNode.right.value;
                fromNode.right.value = fromNode.value;
                fromNode.value = aux;
            }

            bubbleUp(fromNode.parent);
        }

        private void bubbleDown(BinaryTreeNode<Integer> fromNode) {
            if (fromNode == null) {
                return;
            }

            if (fromNode.left != null && fromNode.value > fromNode.left.value) {
                int aux = fromNode.left.value;
                fromNode.left.value = fromNode.value;
                fromNode.value = aux;
                bubbleDown(fromNode.left);
            }

            if (fromNode.right != null && fromNode.value > fromNode.right.value) {
                int aux = fromNode.right.value;
                fromNode.right.value = fromNode.value;
                fromNode.value = aux;

                bubbleDown(fromNode.right);
            }
        }
    }
}
