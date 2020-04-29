package Misc;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Test_Anagrams {
    @Test
    void test0() {
        String str = "a";

        int result = Anagrams.sherlockAndAnagrams(str);

        assertEquals(0, result);
    }

    @Test
    void test1() {
        String str = "ab";

        int result = Anagrams.sherlockAndAnagrams(str);

        assertEquals(0, result);
    }

    @Test
    void test2() {
        String str = "abba";

        int result = Anagrams.sherlockAndAnagrams(str);

        assertEquals(4, result);
    }
}
