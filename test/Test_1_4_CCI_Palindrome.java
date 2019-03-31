import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Test_1_4_CCI_Palindrome {
    @Test
    void test0() {
        String str1 = "Tact Coa";

        assertEquals(true, Solution_1_4_CCI_Palindrome.solution(str1));
    }

    @Test
    void test1() {
        String str1 = "ab c";

        assertEquals(false, Solution_1_4_CCI_Palindrome.solution(str1));
    }

    @Test
    void test2() {
        String str1 = "TaTa";

        assertEquals(true, Solution_1_4_CCI_Palindrome.solution(str1));
    }

    @Test
    void test3() {
        String str1 = "TaTa TaTa";

        assertEquals(true, Solution_1_4_CCI_Palindrome.solution(str1));
    }

    @Test
    void test4() {
        String str1 = "Abc   cbA";

        assertEquals(true, Solution_1_4_CCI_Palindrome.solution(str1));
    }
}
