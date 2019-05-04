package Chapter2;

// Cracking the coding interview exercise 2.5
public class Solution_2_5_CCI_SumList {
    public static IntegerLinkedList solution(IntegerLinkedList list1, IntegerLinkedList list2) {
        if (list1.isEmpty() && list2.isEmpty()) {
            return new IntegerLinkedList();
        }
        else if(list2.isEmpty()) {
            return list1;
        }
        else if(list1.isEmpty()) {
            return list2;
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
            }
            else {
                previousSum = 0;
            }

            if (headSum == null) {
                currentSum = headSum = new LinkedListNode<>(newSum);
            }
            else {
               currentSum.next = new LinkedListNode<>(newSum);
               currentSum = currentSum.next;
            }

            current1 = current1.next;
            current2 = current2.next;
        }

        if (previousSum != 0) {
            currentSum.next = new LinkedListNode<>(previousSum);
        }

        // Processing the remainder of the list
        LinkedListNode<Integer> remainder = current1;
        if (current2 != null) {
            remainder = current2;
        }

        while(remainder != null) {
            if (remainder.value != 0) {
                currentSum.next = new LinkedListNode<>(remainder.value);
                currentSum = currentSum.next;
            }

            remainder = remainder.next;
        }

        IntegerLinkedList out = new IntegerLinkedList();
        out.head = headSum;

        return out;
    }
}
