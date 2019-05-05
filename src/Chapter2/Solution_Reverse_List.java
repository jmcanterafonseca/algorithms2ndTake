package Chapter2;

// Reverse a list
public class Solution_Reverse_List {
    public static IntegerLinkedList solution(IntegerLinkedList list) {
        LinkedListNode<Integer> current = list.head;

        LinkedListNode<Integer> newHead;
        LinkedListNode<Integer> currentReverse;
        LinkedListNode<Integer> previousReverse = null;

        while (current != null) {
            currentReverse = new LinkedListNode<>(current.value);
            currentReverse.next = previousReverse;

            previousReverse = currentReverse;
            current = current.next;
        }

        newHead = previousReverse;

        IntegerLinkedList out = new IntegerLinkedList();
        out.head = newHead;

        return out;
    }
}
