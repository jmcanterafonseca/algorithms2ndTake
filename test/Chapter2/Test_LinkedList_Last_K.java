package Chapter2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class Test_LinkedList_Last_K {

    @Test
    void test0() {
        // Test proper building of the list
        String slist = "12->23->56->12->88";

        IntegerLinkedList list = TestLinkedListBuilder.build(slist);

        int[] result = Solution_LinkedList_Last_K.solution(list, 2);

        assertEquals(result.length, 2);
        assertArrayEquals(new int[]{12, 88}, result);
    }

    @Test
    void test1() {
        // Test proper building of the list
        String slist = "88";

        IntegerLinkedList list = TestLinkedListBuilder.build(slist);

        int[] result = Solution_LinkedList_Last_K.solution(list, 1);

        assertEquals(1, result.length);
        assertArrayEquals(new int[]{88}, result);
    }

    @Test
    void test11() {
        // Test proper building of the list
        String slist = "88";

        IntegerLinkedList list = TestLinkedListBuilder.build(slist);

        int[] result = Solution_LinkedList_Last_K.solution(list, 4);

        assertEquals(1, result.length);
        assertArrayEquals(new int[]{88}, result);
    }

    @Test
    void test2() {
        // Test proper building of the list
        String slist = "88->100";

        IntegerLinkedList list = TestLinkedListBuilder.build(slist);

        int[] result = Solution_LinkedList_Last_K.solution(list, 1);

        assertEquals(1, result.length);
        assertArrayEquals(new int[]{100}, result);
    }

    @Test
    void test3() {
        // Test proper building of the list
        String slist = "88->100";

        IntegerLinkedList list = TestLinkedListBuilder.build(slist);

        int[] result = Solution_LinkedList_Last_K.solution(list, 2);

        assertEquals(2, result.length);
        assertArrayEquals(new int[]{88, 100}, result);
    }

    @Test
    void test4() {
        // Test proper building of the list
        String slist = "88->100";

        IntegerLinkedList list = TestLinkedListBuilder.build(slist);

        int[] result = Solution_LinkedList_Last_K.solution(list, 3);

        assertEquals(2, result.length);
        assertArrayEquals(new int[]{88, 100}, result);
    }

    @Test
    void test5() {
        // Test proper building of the list
        String slist = "88->100";

        IntegerLinkedList list = TestLinkedListBuilder.build(slist);

        int[] result = Solution_LinkedList_Last_K.solution(list, 0);

        assertEquals(0, result.length);
        assertArrayEquals(new int[]{}, result);
    }

    @Test
    void test6() {
        // Test proper building of the list
        String slist = "";

        IntegerLinkedList list = TestLinkedListBuilder.build(slist);

        int[] result = Solution_LinkedList_Last_K.solution(list, 3);

        assertEquals(0, result.length);
        assertArrayEquals(new int[]{}, result);
    }
}
