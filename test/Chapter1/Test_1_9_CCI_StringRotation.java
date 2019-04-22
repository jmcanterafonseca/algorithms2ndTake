package Chapter1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Test_1_9_CCI_StringRotation {

    @Test
    void test0() {
        String s1 = "Hola";
        String s2 = "ola";

        boolean result = Solution_1_9_CCI_StringRotation.isSubstring(s1, s2);

        assertEquals(true, result);
    }

    @Test
    void test01() {
        String s1 = "aa aa ";
        String s2 = "aaa";

        boolean result = Solution_1_9_CCI_StringRotation.isSubstring(s1, s2);

        assertEquals(false, result);
    }

    @Test
    void test1() {
        String s1 = "Hola";
        String s2 = "olas";

        boolean result = Solution_1_9_CCI_StringRotation.isSubstring(s1, s2);

        assertEquals(false, result);
    }

    @Test
    void test2() {
        String s1 = "";
        String s2 = "";

        boolean result = Solution_1_9_CCI_StringRotation.isSubstring(s1, s2);

        assertEquals(true, result);
    }

    @Test
    void test3() {
        String s1 = "";
        String s2 = " ";

        boolean result = Solution_1_9_CCI_StringRotation.isSubstring(s1, s2);

        assertEquals(false, result);
    }

    @Test
    void test4() {
        String s1 = "a";
        String s2 = "";

        boolean result = Solution_1_9_CCI_StringRotation.isSubstring(s1, s2);

        assertEquals(true, result);
    }


    @Test
    void test5() {
        String s1 = "  ";
        String s2 = " ";

        boolean result = Solution_1_9_CCI_StringRotation.isSubstring(s1, s2);

        assertEquals(true, result);
    }

    @Test
    void test6() {
        String s1 = "apearapero";
        String s2 = "apero";

        boolean result = Solution_1_9_CCI_StringRotation.isSubstring(s1, s2);

        assertEquals(true, result);
    }

    @Test
    void test7() {
        String s1 = "apearapero";
        String s2 = "aperos";

        boolean result = Solution_1_9_CCI_StringRotation.isSubstring(s1, s2);

        assertEquals(false, result);
    }

    @Test
    void test8() {
        String s1 = "waterbottle";
        String s2 = "erbottlewat";

        boolean result = Solution_1_9_CCI_StringRotation.solution(s1, s2);

        assertEquals(true, result);
    }

    @Test
    void test9() {
        String s1 = "waterbottle";
        String s2 = "rbottlewat";

        boolean result = Solution_1_9_CCI_StringRotation.solution(s1, s2);

        assertEquals(false, result);
    }

    @Test
    void test10() {
        String s1 = "  ";
        String s2 = "  ";

        boolean result = Solution_1_9_CCI_StringRotation.solution(s1, s2);

        assertEquals(true, result);
    }

    @Test
    void test11() {
        String s1 = "aaa";
        String s2 = "aaa";

        boolean result = Solution_1_9_CCI_StringRotation.solution(s1, s2);

        assertEquals(true, result);
    }

    @Test
    void test12() {
        String s1 = "aaa";
        String s2 = "aa ";

        boolean result = Solution_1_9_CCI_StringRotation.solution(s1, s2);

        assertEquals(false, result);
    }
}