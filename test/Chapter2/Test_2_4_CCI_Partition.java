package Chapter2;

import org.junit.jupiter.api.Test;

import static utils.Utils.assertList;


public class Test_2_4_CCI_Partition {

    @Test
    void test0() {
        String slist = "12->23->56->12->88";

        IntegerLinkedList list = TestLinkedListBuilder.build(slist);

        Solution_2_4_CCI_Partition.solution(list, 56);

        assertList(list, new int[]{12, 23, 12, 56, 88});
    }

    @Test
    void test1() {
        String slist = "12->23->56->12->88";

        IntegerLinkedList list = TestLinkedListBuilder.build(slist);

        Solution_2_4_CCI_Partition.solution(list, 12);

        assertList(list, new int[]{23, 56, 88, 12, 12});
    }

    @Test
    void test2() {
        String slist = "12->23->56->12->88";

        IntegerLinkedList list = TestLinkedListBuilder.build(slist);

        Solution_2_4_CCI_Partition.solution(list, 88);

        assertList(list, new int[]{12, 23, 56, 12, 88});
    }

    @Test
    void test3() {
        String slist = "";

        IntegerLinkedList list = TestLinkedListBuilder.build(slist);

        Solution_2_4_CCI_Partition.solution(list, 88);

        assertList(list, new int[]{});
    }

    @Test
    void test20() {
        String slist = "12->23->56->12->88";

        IntegerLinkedList list = TestLinkedListBuilder.build(slist);

        Solution_2_4_CCI_Partition.solution(list, 11);

        assertList(list, new int[]{12, 23, 56, 12, 88});
    }
}
