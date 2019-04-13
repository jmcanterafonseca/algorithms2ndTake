import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Test_1_6_CCI_StringCompression {

    @Test
    void test0() {
        String input = "";
        String output = "";

        assertEquals(output, Solution_1_6_CCI_StringCompression.solution(input));
    }

    @Test
    void test1() {
        String input = "  ";
        String output = "";

        assertEquals(output, Solution_1_6_CCI_StringCompression.solution(input));
    }

    @Test
    void test2() {
        String input = "aaabbb";
        String output = "a3b3";

        assertEquals(output, Solution_1_6_CCI_StringCompression.solution(input));
    }

    @Test
    void test21() {
        String input = "aaa";
        String output = "a3";

        assertEquals(output, Solution_1_6_CCI_StringCompression.solution(input));
    }

    @Test
    void test22() {
        String input = "aaab";
        String output = "aaab";

        assertEquals(output, Solution_1_6_CCI_StringCompression.solution(input));
    }

    @Test
    void test3() {
        String input = "a";
        String output = "a";

        assertEquals(output, Solution_1_6_CCI_StringCompression.solution(input));
    }

    @Test
    void test4() {
        String input = "ab";
        String output = "ab";

        assertEquals(output, Solution_1_6_CCI_StringCompression.solution(input));
    }

    @Test
    void test5() {
        String input = "abc";
        String output = "abc";

        assertEquals(output, Solution_1_6_CCI_StringCompression.solution(input));
    }

    @Test
    void test6() {
        String input = "aaaaaaaaaaaaaaaaa";
        String output = "a17";

        assertEquals(output, Solution_1_6_CCI_StringCompression.solution(input));
    }

    @Test
    void test7() {
        String input = "aaaaaaaaaaaaaaaaabc";
        String output = "a17b1c1";

        assertEquals(output, Solution_1_6_CCI_StringCompression.solution(input));
    }
}
