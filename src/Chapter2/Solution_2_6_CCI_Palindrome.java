package Chapter2;

// Cracking the coding interview exercise 2.6
public class Solution_2_6_CCI_Palindrome {
    public static boolean solution(IntegerLinkedList list) {
        IntegerLinkedList reversed = Solution_Reverse_List.solution(list);

        LinkedListNode<Integer> current = list.head;
        LinkedListNode<Integer> currentReverse = reversed.head;


        boolean out = false;

        while (current != null && currentReverse != null) {
            if (current.value != currentReverse.value) {
                break;
            }

            current = current.next;
            currentReverse = currentReverse.next;
        }

        if (current == null && currentReverse == null) {
            out = true;
        }

        return out;
    }
}
