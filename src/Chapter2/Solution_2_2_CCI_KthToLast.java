package Chapter2;

import java.util.ArrayList;
import java.util.List;

// Cracking the coding interview exercise 2.2
public class Solution_2_2_CCI_KthToLast {

    public static int[] solution(IntegerLinkedList list, int k) {
        LinkedListNode<Integer> current = list.head;

        int numSkipped = 0;

        List<Integer> outList = new ArrayList<>();

        while (current != null) {
            if (numSkipped >= k - 1) {
                outList.add(current.value);
            } else {
                numSkipped++;
            }
            current = current.next;
        }

        return outList.stream().mapToInt(i -> i).toArray();
    }
}
