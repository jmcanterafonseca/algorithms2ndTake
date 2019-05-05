package Chapter2;

// Returns the last k elements of a Linked List
// Different than CCI 2.2 which returns from the kth element to the last
public class Solution_LinkedList_Last_K {
    public static int[] solution(IntegerLinkedList list, int k) {
        if (k == 0 || list.isEmpty()) {
            return new int[0];
        }

        LinkedListNode<Integer> headLastK = list.head;
        LinkedListNode<Integer> tailLastK = list.head;

        LinkedListNode<Integer> current = list.head.next;

        int outListSize = 1;

        while (current != null) {
            LinkedListNode<Integer> newNode = new LinkedListNode<>(current.value);
            if (outListSize < k) {
                outListSize++;
            } else {
                headLastK = headLastK.next;
            }

            tailLastK.next = newNode;
            tailLastK = newNode;

            current = current.next;
        }

        int[] out = new int[outListSize];
        int index = 0;
        while (headLastK != null) {
            out[index++] = headLastK.value;
            headLastK = headLastK.next;
        }

        return out;
    }
}
