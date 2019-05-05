package Chapter2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;


public class Test_2_2_CCI_KthToLast {

    @Test
    void test0() {
        String slist = "12->23->56->12->88";

        IntegerLinkedList list = TestLinkedListBuilder.build(slist);

        int[] result = Solution_2_2_CCI_KthToLast.solution(list, 2);

        assertArrayEquals(new int[]{23, 56, 12, 88}, result);
    }

    @Test
    void test1() {
        String slist = "12->23->56->12->88";

        IntegerLinkedList list = TestLinkedListBuilder.build(slist);

        int[] result = Solution_2_2_CCI_KthToLast.solution(list, 1);

        assertArrayEquals(new int[]{12, 23, 56, 12, 88}, result);
    }

    @Test
    void test2() {
        String slist = "12";

        IntegerLinkedList list = TestLinkedListBuilder.build(slist);

        int[] result = Solution_2_2_CCI_KthToLast.solution(list, 1);

        assertArrayEquals(new int[]{12}, result);
    }

    @Test
    void test3() {
        String slist = "12";

        IntegerLinkedList list = TestLinkedListBuilder.build(slist);

        int[] result = Solution_2_2_CCI_KthToLast.solution(list, 2);

        assertArrayEquals(new int[0], result);
    }

    @Test
    void test4() {
        String slist = "12->23";

        IntegerLinkedList list = TestLinkedListBuilder.build(slist);

        int[] result = Solution_2_2_CCI_KthToLast.solution(list, 2);

        assertArrayEquals(new int[]{23}, result);
    }

    @Test
    void test5() {
        String slist = "";

        IntegerLinkedList list = TestLinkedListBuilder.build(slist);

        int[] result = Solution_2_2_CCI_KthToLast.solution(list, 2);

        assertArrayEquals(new int[0], result);
    }
}
