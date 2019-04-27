package Chapter2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Test_TestLinkedListBuilder {
    @Test
    void test0() {
        // Test proper building of the list
        String slist = "12->23->56";

        IntegerLinkedList list = TestLinkedListBuilder.build(slist);

        int[] values = {12, 23, 56};
        LinkedListNode<Integer> current = list.head;

        for (int value : values) {
            assertEquals(value, current.value);
            current = current.next;
        }
    }

    @Test
    void test1() {
        // Test proper building of the list
        String slist = "";

        IntegerLinkedList list = TestLinkedListBuilder.build(slist);

        assertEquals(true, list.isEmpty());
    }

    @Test
    void test2() {
        // Test proper building of the list
        String slist = "34";

        IntegerLinkedList list = TestLinkedListBuilder.build(slist);

        assertEquals(34, list.head.value);
        assertEquals(null, list.head.next);
    }

    @Test
    void test3() {
        // Test proper building of the list
        String slist = "34->";

        IntegerLinkedList list = TestLinkedListBuilder.build(slist);

        assertEquals(34, list.head.value);
        assertEquals(null, list.head.next);
    }

    @Test
    void test5() {
        // Test proper building of the list
        String slist = "->";

        IntegerLinkedList list = TestLinkedListBuilder.build(slist);
        assertTrue(list.isEmpty());
    }

    @Test
    void test6() {
        // Test proper building of the list
        String slist = "ggggh";

        try {
            IntegerLinkedList list = TestLinkedListBuilder.build(slist);
        } catch (Throwable thr) {
            assertTrue(true);
            return;
        }

        fail("No exception thrown");
    }

    @Test
    void test7() {
        // Test proper building of the list
        String slist = "a->b";

        try {
            IntegerLinkedList list = TestLinkedListBuilder.build(slist);
        } catch (Throwable thr) {
            assertTrue(true);
            return;
        }

        fail("No exception thrown");
    }
}
