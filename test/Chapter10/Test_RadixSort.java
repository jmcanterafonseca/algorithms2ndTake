package Chapter10;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class Test_RadixSort {
    private int[] arr = {3, 1, 20, 33, 18, 123};

    private int[] solution = {1, 3, 18, 20, 33, 123};

    @Test
    void test1() {
        RadixSort.sort(arr, 200);

        assertArrayEquals(solution, arr);
    }

    @Test
    void test2() {
        int[] arr = {};

        RadixSort.sort(arr, 200);

        int[] solution = {};

        assertArrayEquals(solution, arr);
    }

    @Test
    void test3() {
        int[] arr = {1};

        RadixSort.sort(arr, 200);

        int[] solution = {1};

        assertArrayEquals(solution, arr);
    }
}
