package Chapter2;

import java.util.HashSet;
import java.util.Set;

// Cracking the coding interview exercise 2.1
public class Solution_2_1_CCI_RemoveDups {
    public static void solution(IntegerLinkedList list) {
        Set<Integer> occurrences = new HashSet<>();

        LinkedListNode<Integer> current = list.head;
        LinkedListNode<Integer> previous = list.head;

        while(current != null) {
            int value = current.value;

            if (occurrences.contains(value)) {
                previous.next = current.next;
                current = previous.next;
            }
            else {
                previous = current;
                current = current.next;

                occurrences.add(value);
            }
        }
    }
}
