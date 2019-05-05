package Chapter2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class Test_2_7_CCI_Intersection {

    @Test
    void test0() {
        String slist = "12->23";
        IntegerLinkedList list = TestLinkedListBuilder.build(slist);
        String slist2 = "35->48";
        IntegerLinkedList list2 = TestLinkedListBuilder.build(slist2);

        list.head.next.next = list2.head;

        LinkedListNode<Integer> intersection = Solution_2_7_CCI_Intersection.solution(list, list2);

        assertNotNull(intersection);

        assertEquals(list2.head, intersection);
    }

    @Test
    void test1() {
        String slist = "12->23";
        IntegerLinkedList list = TestLinkedListBuilder.build(slist);
        String slist2 = "35->48";
        IntegerLinkedList list2 = TestLinkedListBuilder.build(slist2);

        list2.head.next.next = list.head;
        list.head = list2.head;

        LinkedListNode<Integer> intersection = Solution_2_7_CCI_Intersection.solution(list, list2);

        assertNotNull(intersection);

        assertEquals(list2.head, intersection);
    }

    @Test
    void test2() {
        String slist = "12->23";
        IntegerLinkedList list = TestLinkedListBuilder.build(slist);

        LinkedListNode<Integer> intersection = Solution_2_7_CCI_Intersection.solution(list, list);

        assertNotNull(intersection);

        assertEquals(list.head, intersection);
    }

    @Test
    void test10() {
        String slist = "12->23";
        IntegerLinkedList list = TestLinkedListBuilder.build(slist);
        String slist2 = "35->48";
        IntegerLinkedList list2 = TestLinkedListBuilder.build(slist2);

        LinkedListNode<Integer> intersection = Solution_2_7_CCI_Intersection.solution(list, list2);

        assertEquals(null, intersection);
    }

    @Test
    void test11() {
        String slist = "12->23";
        IntegerLinkedList list = TestLinkedListBuilder.build(slist);
        String slist2 = "";
        IntegerLinkedList list2 = TestLinkedListBuilder.build(slist2);

        LinkedListNode<Integer> intersection = Solution_2_7_CCI_Intersection.solution(list, list2);

        assertEquals(null, intersection);
    }

    @Test
    void test12() {
        String slist = "";
        IntegerLinkedList list = TestLinkedListBuilder.build(slist);
        String slist2 = "";
        IntegerLinkedList list2 = TestLinkedListBuilder.build(slist2);

        LinkedListNode<Integer> intersection = Solution_2_7_CCI_Intersection.solution(list, list2);

        assertEquals(null, intersection);
    }
}
