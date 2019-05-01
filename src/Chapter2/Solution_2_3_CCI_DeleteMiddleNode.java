package Chapter2;

import java.util.HashSet;
import java.util.Set;

// Cracking the coding interview exercise 2.1
public class Solution_2_3_CCI_DeleteMiddleNode {
    public static void solution(IntegerLinkedList list, LinkedListNode<Integer> middleNode) {
        if (list.isEmpty()) {
            return;
        }

        LinkedListNode<Integer> current = list.head;
        LinkedListNode<Integer> previous = null;

        while (current != null && current.value != middleNode.value) {
            previous = current;
            current = current.next;
        }

        if (current != null) {
            if (previous != null) {
                previous.next = current.next;
            }
            else {
                // First element has been removed
                list.head = current.next;
            }
        }
    }
}
