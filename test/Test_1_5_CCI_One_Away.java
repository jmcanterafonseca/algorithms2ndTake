import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Test_1_5_CCI_One_Away {
    @Test
    void test0() {
        String str1 = "pale";
        String str2 = "pale";

        assertEquals(true, Solution_1_5_CCI_One_Away.solution(str1,str2));
    }

    @Test
    void test1() {
        String str1 = "pale";
        String str2 = "ple";

        assertEquals(true, Solution_1_5_CCI_One_Away.solution(str1,str2));
    }

    @Test
    void test2() {
        String str1 = "pales";
        String str2 = "pale";

        assertEquals(true, Solution_1_5_CCI_One_Away.solution(str1,str2));
    }

    @Test
    void test3() {
        String str1 = "pale";
        String str2 = "bale";

        assertEquals(true, Solution_1_5_CCI_One_Away.solution(str1,str2));
    }

    @Test
    void test4() {
        String str1 = "pale";
        String str2 = "bake";

        assertEquals(false, Solution_1_5_CCI_One_Away.solution(str1,str2));
    }

    @Test
    void test5() {
        String str1 = "pale";
        String str2 = "baleghj";

        assertEquals(false, Solution_1_5_CCI_One_Away.solution(str1,str2));
    }

    @Test
    void test6() {
        String str1 = "";
        String str2 = "b";

        assertEquals(true, Solution_1_5_CCI_One_Away.solution(str1,str2));
    }

    @Test
    void test7() {
        String str1 = "b";
        String str2 = "";

        assertEquals(true, Solution_1_5_CCI_One_Away.solution(str1,str2));
    }

    @Test
    void test8() {
        String str1 = "";
        String str2 = "";

        assertEquals(true, Solution_1_5_CCI_One_Away.solution(str1,str2));
    }

    @Test
    void test9() {
        String str1 = "ab";
        String str2 = "";

        assertEquals(false, Solution_1_5_CCI_One_Away.solution(str1,str2));
    }
}
