package Misc;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class Test_WordSquare {
    @Test
    void test0() {
        String[] words = {"ab", "ba"};

        List<List<String>> out = WordSquare.wordSquares(words);

        for (List<String> res : out) {
            System.out.println(Arrays.toString(res.toArray(new String[0])));
        }
    }

    @Test
    void test1() {
        String[] words = {"area", "lead", "wall", "lady", "ball"};

        List<List<String>> out = WordSquare.wordSquares(words);

        for (List<String> res : out) {
            System.out.println(Arrays.toString(res.toArray(new String[0])));
        }
    }
}
