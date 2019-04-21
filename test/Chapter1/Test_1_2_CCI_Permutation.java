package Chapter1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Test_1_2_CCI_Permutation {
    @Test
    void test0() {
        String str1 = "pale";
        String str2 = "pale";

        assertEquals(true, Solution_1_2_CCI_Permutation.solution(str1,str2));
    }

    @Test
    void test1() {
        String str1 = "alep";
        String str2 = "pale";

        assertEquals(true, Solution_1_2_CCI_Permutation.solution(str1,str2));
    }

    @Test
    void test2() {
        String str1 = "alep";
        String str2 = "plae";

        assertEquals(true, Solution_1_2_CCI_Permutation.solution(str1,str2));
    }

    @Test
    void test3() {
        String str1 = "prle";
        String str2 = "pale";

        assertEquals(false, Solution_1_2_CCI_Permutation.solution(str1,str2));
    }


    @Test
    void test4() {
        String str1 = "";
        String str2 = "p";

        assertEquals(false, Solution_1_2_CCI_Permutation.solution(str1,str2));
    }

    @Test
    void test5() {
        String str1 = "";
        String str2 = "";

        assertEquals(true, Solution_1_2_CCI_Permutation.solution(str1,str2));
    }

    @Test
    void test6() {
        String str1 = "p";
        String str2 = "";

        assertEquals(false, Solution_1_2_CCI_Permutation.solution(str1,str2));
    }

    @Test
    void test7() {
        String str1 = "p";
        String str2 = "px";

        assertEquals(false, Solution_1_2_CCI_Permutation.solution(str1,str2));
    }

    @Test
    void test8() {
        String str1 = "px";
        String str2 = "p";

        assertEquals(false, Solution_1_2_CCI_Permutation.solution(str1,str2));
    }
}
