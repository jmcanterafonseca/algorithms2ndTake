package Chapter2;

import org.junit.jupiter.api.Test;

import static utils.Utils.assertList;


public class Test_2_1_CCI_RemoveDups {

    @Test
    void test0() {
        String slist = "12->23->56->12->88";

        IntegerLinkedList list = TestLinkedListBuilder.build(slist);

        Solution_2_1_CCI_RemoveDups.solution(list);

        assertList(list, new int[]{12, 23, 56, 88});
    }

    @Test
    void test1() {
        String slist = "12->12";

        IntegerLinkedList list = TestLinkedListBuilder.build(slist);

        Solution_2_1_CCI_RemoveDups.solution(list);

        assertList(list, new int[]{12});
    }

    @Test
    void test2() {
        String slist = "12->23->56";

        IntegerLinkedList list = TestLinkedListBuilder.build(slist);

        Solution_2_1_CCI_RemoveDups.solution(list);

        assertList(list, new int[]{12, 23, 56});
    }

    @Test
    void test3() {
        String slist = "12->23->56->56->56";

        IntegerLinkedList list = TestLinkedListBuilder.build(slist);

        Solution_2_1_CCI_RemoveDups.solution(list);

        assertList(list, new int[]{12, 23, 56});
    }

    @Test
    void test4() {
        String slist = "12->23->23->23->56";

        IntegerLinkedList list = TestLinkedListBuilder.build(slist);

        Solution_2_1_CCI_RemoveDups.solution(list);

        assertList(list, new int[]{12, 23, 56});
    }
}
