package Chapter2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Test_2_6_CCI_Palindrome {

    @Test
    void test0() {
        String slist = "12->23->12";
        IntegerLinkedList list = TestLinkedListBuilder.build(slist);

        boolean result = Solution_2_6_CCI_Palindrome.solution(list);

        assertEquals(true, result);
    }

    @Test
    void test1() {
        String slist = "12->23";
        IntegerLinkedList list = TestLinkedListBuilder.build(slist);

        boolean result = Solution_2_6_CCI_Palindrome.solution(list);

        assertEquals(false, result);
    }

    @Test
    void test2() {
        String slist = "12->23->12->14";
        IntegerLinkedList list = TestLinkedListBuilder.build(slist);

        boolean result = Solution_2_6_CCI_Palindrome.solution(list);

        assertEquals(false, result);
    }

    @Test
    void test12() {
        String slist = "";
        IntegerLinkedList list = TestLinkedListBuilder.build(slist);

        boolean result = Solution_2_6_CCI_Palindrome.solution(list);

        assertEquals(true, result);
    }
}
