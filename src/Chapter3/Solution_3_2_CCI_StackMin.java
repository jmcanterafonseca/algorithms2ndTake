package Chapter3;

// CCI 3.2 A Stack capable of keeping the minimum element
public class Solution_3_2_CCI_StackMin {

    private StackNode[] elements;
    private int peekIndex = -1;

    public Solution_3_2_CCI_StackMin(int initialTotalSize) {
        if (initialTotalSize < 1) {
            throw new RuntimeException("Minimum total size is 1");
        }

        elements = new StackNode[initialTotalSize];
    }

    public int min() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }

        return peekNode().minSubstack;
    }

    public boolean isFull() {
        return peekIndex == elements.length - 1;
    }

    public boolean isEmpty() {
        return peekIndex == -1;
    }

    public Integer peek() {
        return peekNode().value;
    }

    private StackNode peekNode() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }

        return elements[peekIndex];
    }

    public Integer pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }

        Integer out = elements[peekIndex].value;

        peekIndex--;

        return out;
    }

    public void push(Integer value) {
        if (isFull()) {
            throw new RuntimeException("Stack is full");
        }

        int referenceMin = Integer.MAX_VALUE;
        if (!isEmpty()) {
            referenceMin = peekNode().minSubstack;
        }

        int currentMin = Math.min(referenceMin, value);

        elements[++peekIndex] = new StackNode(value, currentMin);
    }

    private class StackNode {
        public Integer value;
        public int minSubstack = Integer.MAX_VALUE;

        public StackNode(int value, int minSubStack) {
            this.value = value;
            this.minSubstack = minSubStack;
        }
    }
}
