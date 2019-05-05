package Chapter2;

import org.junit.jupiter.api.Test;

import static utils.Utils.assertList;


public class Test_Reverse_List {

    @Test
    void test0() {
        String slist1 = "1->5->6";

        IntegerLinkedList list1 = TestLinkedListBuilder.build(slist1);

        IntegerLinkedList result = Solution_Reverse_List.solution(list1);

        assertList(result, new int[]{6, 5, 1});
    }

    @Test
    void test1() {
        String slist1 = "";

        IntegerLinkedList list1 = TestLinkedListBuilder.build(slist1);

        IntegerLinkedList result = Solution_Reverse_List.solution(list1);

        assertList(result, new int[]{});
    }

    @Test
    void test2() {
        String slist1 = "4";

        IntegerLinkedList list1 = TestLinkedListBuilder.build(slist1);

        IntegerLinkedList result = Solution_Reverse_List.solution(list1);

        assertList(result, new int[]{4});
    }

    @Test
    void test3() {
        String slist1 = "4->1";

        IntegerLinkedList list1 = TestLinkedListBuilder.build(slist1);

        IntegerLinkedList result = Solution_Reverse_List.solution(list1);

        assertList(result, new int[]{1, 4});
    }
}
