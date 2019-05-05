package Chapter2;

// Cracking the coding interview exercise 2.5 (forward mode)
public class Solution_2_5_CCI_SumList_Forward {
    public static IntegerLinkedList solution(IntegerLinkedList list1, IntegerLinkedList list2) {
        if (list1.isEmpty() && list2.isEmpty()) {
            return new IntegerLinkedList();
        }

        IntegerLinkedList rlist1 = Solution_Reverse_List.solution(list1);
        IntegerLinkedList rlist2 = Solution_Reverse_List.solution(list2);

        IntegerLinkedList rsum = Solution_2_5_CCI_SumList.solution(rlist1, rlist2);

        // Lists are reversed, sum is performed and finally result is reversed one more time
        return Solution_Reverse_List.solution(rsum);
    }
}
