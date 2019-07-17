package Chapter10;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class Test_SelectionSort {
    int[] arr = {-3, 10, -5, 7, 1, 22, -8};

    int[] solution = {-8, -5, -3, 1, 7, 10, 22};

    @Test
    void test1() {
        SelectionSort.sort(arr);

        assertArrayEquals(solution, arr);
    }

    @Test
    void test2() {
        int[] arr = {};

        SelectionSort.sort(arr);

        int[] solution = {};

        assertArrayEquals(solution, arr);
    }

    @Test
    void test3() {
        int[] arr = {1};

        SelectionSort.sort(arr);

        int[] solution = {1};

        assertArrayEquals(solution, arr);
    }
}
