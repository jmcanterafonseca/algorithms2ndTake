package Chapter10;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class Test_Solution_10_11_Peaks_And_Valleys {
    private int[] arr = {5, 3, 1, 2, 3};

    private int[] solution = {5, 1, 3, 2, 3};

    @Test
    void test1() {
        Solution_10_11_Peaks_And_Valleys.solution(arr);

        assertArrayEquals(solution, arr);
    }

    @Test
    void test2() {
        int[] arr = {};

        Solution_10_11_Peaks_And_Valleys.solution(arr);

        assertArrayEquals(new int[]{}, arr);
    }

    @Test
    void test3() {
        int[] arr = {5, 8, 6, 2, 3, 4, 6};
        int[] solution = {8, 5, 6, 2, 3, 4, 6};

        Solution_10_11_Peaks_And_Valleys.solution(arr);

        assertArrayEquals(solution, arr);
    }
}
