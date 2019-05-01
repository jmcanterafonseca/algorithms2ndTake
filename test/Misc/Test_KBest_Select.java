package Misc;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class Test_KBest_Select {
    @Test
    void test0() {
        Integer[] input = new Integer[]{};

        Integer[] result = Solution_KBest_Select.solution(input, 2);

        assertArrayEquals(input, result);
    }

    @Test
    void test1() {
        Integer[] input = new Integer[]{33, 67, 12, 100, 120};

        Integer[] result = Solution_KBest_Select.solution(input, 2);

        Integer[] expectedResult = new Integer[]{100, 120};

        assertArrayEquals(expectedResult, result);
    }

    @Test
    void test2() {
        Integer[] input = new Integer[]{33, 67, 12, 100, 120};

        Integer[] result = Solution_KBest_Select.solution(input, 8);

        Arrays.sort(input);

        assertArrayEquals(input, result);
    }

    @Test
    void test3() {
        Integer[] input = new Integer[]{33, 67, 12, 100, 120};

        Integer[] result = Solution_KBest_Select.solution(input, 1);

        assertArrayEquals(new Integer[]{120}, result);
    }

    @Test
    void test4() {
        Integer[] input = new Integer[]{33, 67, 12, 100, 120};

        Integer[] result = Solution_KBest_Select.solution(input, 0);

        assertArrayEquals(new Integer[]{}, result);
    }
}
