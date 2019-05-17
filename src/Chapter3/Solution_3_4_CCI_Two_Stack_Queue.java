package Chapter3;


// CCI 3.3 A Stack of plates
public class Solution_3_4_CCI_Two_Stack_Queue<T> {

    private Stack<T> stack1 = null;
    private Stack<T> stack2 = null;

    public Solution_3_4_CCI_Two_Stack_Queue(int size) {
        stack1 = new Stack<>(size);
        stack2 = new Stack<>(size);
    }

    public void add(QueueNode<T> node) {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }

        stack1.push(node);

        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
    }

    public QueueNode<T> remove() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }

        return stack1.pop();
    }

    public boolean isEmpty() {
        return stack1.isEmpty();
    }

    public QueueNode<T> head() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        return stack1.peek();
    }

    public int size() {
        return stack1.size();
    }

    public static class QueueNode<T> {
        public T value;

        public QueueNode(T value) {
            this.value = value;
        }
    }

    private class Stack<T> {
        private int peekIndex = -1;
        private QueueNode<T>[] elements;

        public Stack(int initialSize) {
            if (initialSize < 1) {
                throw new RuntimeException("Minimum  size is 1");
            }

            elements = new QueueNode[initialSize];
        }

        public boolean isFull() {
            return peekIndex == elements.length - 1;
        }

        public boolean isEmpty() {
            return peekIndex == -1;
        }

        public QueueNode<T> peek() {
            if (isEmpty()) {
                throw new RuntimeException("Stack is empty");
            }

            return elements[peekIndex];
        }

        public QueueNode<T> pop() {
            if (isEmpty()) {
                throw new RuntimeException("Stack is empty");
            }

            QueueNode<T> out = elements[peekIndex];
            elements[peekIndex] = null;

            peekIndex--;

            return out;
        }

        public void push(QueueNode<T> p) {
            if (isFull()) {
                throw new RuntimeException("Stack is full");
            }
            elements[++peekIndex] = p;
        }

        public int size() {
            return peekIndex + 1;
        }
    }
}
