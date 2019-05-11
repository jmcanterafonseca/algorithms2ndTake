package Chapter3;

// Assumption is that three stacks are same size
public class Solution_3_1_CCI_Three_In_One {

    private Integer[] elements;
    private int[] peekIndex = new int[3];
    private int[] maxIndex = new int[3];
    private int[] startIndex = new int[3];

    public Solution_3_1_CCI_Three_In_One(int initialTotalSize) {
        if (initialTotalSize < 3) {
            throw new RuntimeException("Minimum total size is 3");
        }

        elements = new Integer[initialTotalSize];

        int partitionSize = initialTotalSize / 3;
        startIndex[0] = 0;
        maxIndex[0] = startIndex[0] + partitionSize - 1;

        startIndex[1] = maxIndex[0] + 1;
        maxIndex[1] = startIndex[1] + partitionSize - 1;

        startIndex[2] = maxIndex[1] + 1;
        maxIndex[2] = initialTotalSize - 1;

        peekIndex[0] = peekIndex[1] = peekIndex[2] = -1;
    }

    private int stackIndex(int stackNumber) {
        if (stackNumber < 1 || stackNumber > 3) {
            throw new RuntimeException("Stack number must between 1 and 3");
        }

        return stackNumber - 1;
    }

    public boolean isFull(int stackNumber) {
        return peekIndex[stackIndex(stackNumber)] == maxIndex[stackIndex(stackNumber)];
    }

    public boolean isEmpty(int stackNumber) {
        return peekIndex[stackIndex(stackNumber)] == -1;
    }

    public Integer peek(int stackNumber) {
        return elements[peekIndex[stackIndex(stackNumber)]];
    }

    public Integer pop(int stackNumber) {
        if (isEmpty(stackNumber)) {
            throw new RuntimeException("Stack is empty");
        }

        Integer out = peek(stackNumber);

        peekIndex[stackIndex(stackNumber)]--;

        if (peekIndex[stackIndex(stackNumber)] < startIndex[stackIndex(stackNumber)]) {
            peekIndex[stackIndex(stackNumber)] = -1;
        }

        return out;
    }

    public void push(int stackNumber, Integer value) {
        if (isFull(stackNumber)) {
            throw new RuntimeException("Stack is full");
        }

        int insertIndex;
        if (isEmpty(stackNumber)) {
            insertIndex = startIndex[stackIndex(stackNumber)];
            peekIndex[stackIndex(stackNumber)] = insertIndex;
        } else {
            insertIndex = ++peekIndex[stackIndex(stackNumber)];
        }

        elements[insertIndex] = value;

    }
}
