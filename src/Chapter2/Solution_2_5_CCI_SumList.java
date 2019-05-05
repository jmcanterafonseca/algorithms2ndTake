package Chapter2;

// Cracking the coding interview exercise 2.5
public class Solution_2_5_CCI_SumList {
    public static IntegerLinkedList solution(IntegerLinkedList list1, IntegerLinkedList list2) {
        if (list1.isEmpty() && list2.isEmpty()) {
            return new IntegerLinkedList();
        }

        LinkedListNode<Integer> current1 = list1.head;
        LinkedListNode<Integer> current2 = list2.head;
        LinkedListNode<Integer> headSum = null;
        LinkedListNode<Integer> currentSum = headSum;

        int previousSum = 0;

        while (current1 != null && current2 != null) {
            if (current1.value > 9 || current2.value > 9 || current1.value < 0 || current2.value < 0) {
                throw new RuntimeException("List values shall be single, positive digits");
            }
            int sum = current1.value + current2.value;

            int totalValue = previousSum + sum;

            int newSum = totalValue;

            if (totalValue > 9) {
                newSum = totalValue % 10;
                previousSum = 1;
            } else {
                previousSum = 0;
            }

            if (headSum == null) {
                currentSum = headSum = new LinkedListNode<>(newSum);
            } else {
                currentSum.next = new LinkedListNode<>(newSum);
                currentSum = currentSum.next;
            }

            current1 = current1.next;
            current2 = current2.next;
        }

        // Processing the remainder of the list
        LinkedListNode<Integer> remainder = current1;
        if (current2 != null) {
            remainder = current2;
        }

        if (previousSum != 0) {
            int addedValue = 0;
            if (remainder != null) {
                addedValue = remainder.value;
                remainder = remainder.next;
            }
            currentSum.next = new LinkedListNode<>(previousSum + addedValue);
            currentSum = currentSum.next;
        }

        LinkedListNode<Integer> iterRemainder = remainder;

        boolean allZeros = true;
        while (iterRemainder != null) {
            if (iterRemainder.value != 0) {
                allZeros = false;
                break;
            }
            iterRemainder = iterRemainder.next;
        }

        if (!allZeros) {
            if (currentSum == null) {
                currentSum = headSum = remainder;
            } else {
                currentSum.next = remainder;
            }
        } else {
            if (currentSum == null) {
                currentSum = headSum = new LinkedListNode<>(0);
            }
        }

        IntegerLinkedList out = new IntegerLinkedList();
        out.head = headSum;

        return out;
    }
}
