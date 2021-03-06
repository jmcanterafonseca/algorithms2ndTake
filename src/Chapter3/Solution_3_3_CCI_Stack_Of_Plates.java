package Chapter3;

import java.util.ArrayList;
import java.util.List;

// CCI 3.3 A Stack of plates
public class Solution_3_3_CCI_Stack_Of_Plates {

    private static int MAX_PLATE_STACK = 4;
    private List<Stack> stackSet;
    private int stackSetIndex = -1;

    public Solution_3_3_CCI_Stack_Of_Plates() {
        stackSet = new ArrayList<>();
    }

    public boolean isEmpty() {
        return stackSetIndex == -1;
    }

    public Plate peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stackset is empty");
        }
        return stackSet.get(stackSetIndex).peek();
    }

    public Plate pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stackset is empty");
        }

        Stack targetStack = stackSet.get(stackSetIndex);

        Plate out = targetStack.pop();

        if (targetStack.isEmpty()) {
            stackSetIndex--;
        }

        return out;
    }

    public void push(Plate p) {
        if (stackSetIndex == -1) {
            if (stackSet.size() - 1 < ++stackSetIndex) {
                stackSet.add(stackSetIndex, new Stack(MAX_PLATE_STACK));
            }
        }

        Stack targetStack = stackSet.get(stackSetIndex);
        if (targetStack.isFull()) {
            if (stackSet.size() - 1 < ++stackSetIndex) {
                targetStack = new Stack(MAX_PLATE_STACK);
                stackSet.add(stackSetIndex, targetStack);
            } else {
                targetStack = stackSet.get(stackSetIndex);
            }
        }

        targetStack.push(p);
    }

    // Pops at the stack which index corresponds to the one passed as parameter
    public Plate popAt(int index) {
        if (index >= stackSet.size()) {
            throw new RuntimeException("Target Stack not found");
        }

        Stack st = stackSet.get(index);

        if (st.isEmpty()) {
            throw new RuntimeException("Target stack is empty");
        }

        Plate out = st.pop();

        // And now we need to rebalance the stacks
        Stack previousStack = st;
        int lastIndex = stackSetIndex;

        for (int j = index; j < lastIndex; j++) {
            Stack nextStack = stackSet.get(j + 1);
            if (nextStack.isEmpty()) {
                stackSetIndex--;
            } else {
                previousStack.push(nextStack.pop());
                if (nextStack.isEmpty()) {
                    stackSetIndex--;
                }
            }
            previousStack = nextStack;
        }

        if (stackSet.get(stackSetIndex).isEmpty()) {
            stackSetIndex--;
        }

        return out;
    }

    public static class Plate {

    }

    private class Stack {
        private int peekIndex = -1;
        private Plate[] elements;

        public Stack(int initialSize) {
            if (initialSize < 1) {
                throw new RuntimeException("Minimum  size is 1");
            }

            elements = new Plate[initialSize];
        }

        public boolean isFull() {
            return peekIndex == elements.length - 1;
        }

        public boolean isEmpty() {
            return peekIndex == -1;
        }

        public Plate peek() {
            if (isEmpty()) {
                throw new RuntimeException("Stack is empty");
            }

            return elements[peekIndex];
        }

        public Plate pop() {
            if (isEmpty()) {
                throw new RuntimeException("Stack is empty");
            }

            Plate out = elements[peekIndex];
            elements[peekIndex] = null;

            peekIndex--;

            return out;
        }

        public void push(Plate p) {
            if (isFull()) {
                throw new RuntimeException("Stack is full");
            }
            elements[++peekIndex] = p;
        }
    }
}
