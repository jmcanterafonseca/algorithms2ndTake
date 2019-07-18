package Chapter10;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class Test_MergeSort {
    private int[] arr = {-3, 10, -5, 7, 1, 22, -8};

    private int[] solution = {-8, -5, -3, 1, 7, 10, 22};

    @Test
    void test1() {
        MergeSort.sort(arr);

        assertArrayEquals(solution, arr);
    }

    @Test
    void test2() {
        int[] arr = {};

        MergeSort.sort(arr);

        int[] solution = {};

        assertArrayEquals(solution, arr);
    }

    @Test
    void test3() {
        int[] arr = {1};

        MergeSort.sort(arr);

        int[] solution = {1};

        assertArrayEquals(solution, arr);
    }
}
