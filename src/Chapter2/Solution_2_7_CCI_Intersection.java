package Chapter2;

import java.util.HashSet;
import java.util.Set;

// Cracking the coding interview exercise 2.7
public class Solution_2_7_CCI_Intersection {
    public static LinkedListNode<Integer> solution(IntegerLinkedList list1, IntegerLinkedList list2) {
        Set<LinkedListNode<Integer>> seenNodes = new HashSet<>();

        LinkedListNode<Integer> current1 = list1.head;
        LinkedListNode<Integer> current2 = list2.head;

        while (current2 != null) {
            seenNodes.add(current2);
            current2 = current2.next;
        }

        LinkedListNode<Integer> out = null;

        while (current1 != null) {
            if (seenNodes.contains(current1)) {
                out = current1;
                break;
            }
            current1 = current1.next;
        }

        return out;
    }
}
