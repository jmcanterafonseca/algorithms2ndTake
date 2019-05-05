package Chapter2;

import java.util.HashSet;
import java.util.Set;

// Cracking the coding interview exercise 2.8
public class Solution_2_8_CCI_Loop {
    public static LinkedListNode<Integer> solution(IntegerLinkedList list) {
        Set<LinkedListNode<Integer>> seenNodes = new HashSet<>();

        LinkedListNode<Integer> current = list.head;

        LinkedListNode<Integer> out = null;

        while (current != null) {
            if (seenNodes.contains(current)) {
                out = current;
                break;
            }
            seenNodes.add(current);
            current = current.next;
        }

        return out;
    }
}
