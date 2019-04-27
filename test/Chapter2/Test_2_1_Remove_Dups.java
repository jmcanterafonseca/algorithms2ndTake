package Chapter2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class Test_2_1_Remove_Dups {

    void assertList(IntegerLinkedList list, int[] values) {
        LinkedListNode<Integer> current = list.head;

        for (int value : values) {
            assertEquals(value, current.value);
            current = current.next;
        }
    }

    @Test
    void test0() {
        // Test proper building of the list
        String slist = "12->23->56->12->88";

        IntegerLinkedList list = TestLinkedListBuilder.build(slist);

        Solution_2_1_Remove_Dups.solution(list);

        assertList(list, new int[]{12, 23, 56, 88});
    }

    @Test
    void test1() {
        // Test proper building of the list
        String slist = "12->12";

        IntegerLinkedList list = TestLinkedListBuilder.build(slist);

        Solution_2_1_Remove_Dups.solution(list);

        assertList(list, new int[]{12});
    }

    @Test
    void test2() {
        // Test proper building of the list
        String slist = "12->23->56";

        IntegerLinkedList list = TestLinkedListBuilder.build(slist);

        Solution_2_1_Remove_Dups.solution(list);

        assertList(list, new int[]{12, 23, 56});
    }

    @Test
    void test3() {
        // Test proper building of the list
        String slist = "12->23->56->56->56";

        IntegerLinkedList list = TestLinkedListBuilder.build(slist);

        Solution_2_1_Remove_Dups.solution(list);

        assertList(list, new int[]{12, 23, 56});
    }

    @Test
    void test4() {
        // Test proper building of the list
        String slist = "12->23->23->23->56";

        IntegerLinkedList list = TestLinkedListBuilder.build(slist);

        Solution_2_1_Remove_Dups.solution(list);

        assertList(list, new int[]{12, 23, 56});
    }
}
