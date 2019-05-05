package Chapter2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class Test_2_8_CCI_Loop {

    @Test
    void test0() {
        String slist = "12->23";
        IntegerLinkedList list = TestLinkedListBuilder.build(slist);

        list.head.next.next = list.head;

        LinkedListNode<Integer> loop = Solution_2_8_CCI_Loop.solution(list);

        assertNotNull(loop);

        assertEquals(list.head, loop);
    }

    @Test
    void test1() {
        String slist = "12->23";
        IntegerLinkedList list = TestLinkedListBuilder.build(slist);

        list.head.next.next = list.head.next;

        LinkedListNode<Integer> loop = Solution_2_8_CCI_Loop.solution(list);

        assertNotNull(loop);

        assertEquals(list.head.next, loop);
    }

    @Test
    void test10() {
        String slist = "12->23";
        IntegerLinkedList list = TestLinkedListBuilder.build(slist);

        LinkedListNode<Integer> loop = Solution_2_8_CCI_Loop.solution(list);

        assertEquals(null, loop);
    }

    @Test
    void test12() {
        String slist = "";
        IntegerLinkedList list = TestLinkedListBuilder.build(slist);

        LinkedListNode<Integer> loop = Solution_2_8_CCI_Loop.solution(list);

        assertEquals(null, loop);
    }
}
