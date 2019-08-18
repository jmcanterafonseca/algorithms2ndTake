package Misc;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class Test_HaystackNeedle {
    @Test
    void test0() {
        int result = HaystackNeedle.solution("", "abc");

        assertEquals(-1, result);
    }

    @Test
    void test1() {
        int result = HaystackNeedle.solution("abc", "");

        assertEquals(0, result);
    }


    @Test
    void test2() {
        int result = HaystackNeedle.solution("abc", "h");

        assertEquals(-1, result);
    }

    @Test
    void test3() {
        int result = HaystackNeedle.solution("abc", "c");

        assertEquals(2, result);
    }

    @Test
    void test4() {
        int result = HaystackNeedle.solution("ababc", "abc");

        assertEquals(2, result);
    }
}
