package Chapter3;


// CCI 3.5 A sort stack
public class Solution_3_5_CCI_SortStack {

    private Stack stack1;
    private Stack stack2;

    public Solution_3_5_CCI_SortStack(int initialSize) {
        stack1 = new Stack(initialSize);
        stack2 = new Stack(initialSize);
    }

    public boolean isFull() {
        return stack1.isFull();
    }

    public void push(int number) {
        while (!stack1.isEmpty() && number > peek()) {
            int popNumber = stack1.pop();
            stack2.push(popNumber);
        }

        stack1.push(number);
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
    }

    public int peek() {
        return stack1.peek();
    }

    public int pop() {
        return stack1.pop();
    }

    public int size() {
        return stack1.size();
    }

    public static class Stack {
        private int peekIndex = -1;
        private Integer[] elements;

        public Stack(int initialSize) {
            if (initialSize < 1) {
                throw new RuntimeException("Minimum  size is 1");
            }

            elements = new Integer[initialSize];
        }

        public boolean isFull() {
            return peekIndex == elements.length - 1;
        }

        public boolean isEmpty() {
            return peekIndex == -1;
        }

        public int peek() {
            if (isEmpty()) {
                throw new RuntimeException("Stack is empty");
            }

            return elements[peekIndex];
        }

        public int pop() {
            if (isEmpty()) {
                throw new RuntimeException("Stack is empty");
            }

            int out = elements[peekIndex];
            elements[peekIndex] = null;

            peekIndex--;

            return out;
        }

        public void push(int number) {
            if (isFull()) {
                throw new RuntimeException("Stack is full");
            }
            elements[++peekIndex] = number;
        }

        public int size() {
            return peekIndex + 1;
        }
    }
}
