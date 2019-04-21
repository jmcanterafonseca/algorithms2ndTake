package Chapter1;

import Chapter1.Solution_1_7_CCI_RotateMatrix;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Test_1_7_CCI_RotateMatrix {

    private void assertEqualMatrix(int[][] a1, int[][] a2) {
        for (int j = 0; j < a1.length; j++) {
                assertArrayEquals(a1[j], a2[j]);
        }
    }

    @Test
    void test0() {
        int[][] input = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        int[][] output = {
                {7, 4, 1},
                {8, 5, 2},
                {9, 6, 3}
        };

        int[][] result = Solution_1_7_CCI_RotateMatrix.solution(input);

        assertEqualMatrix(result, output);
    }

    @Test
    void test1() {
        int[][] input = {
                {1, 2},
                {3, 4}
        };

        int[][] output = {
                {3, 1},
                {4, 2},

        };

        int[][] result = Solution_1_7_CCI_RotateMatrix.solution(input);

        assertEqualMatrix(output, result);
    }

    @Test
    void test2() {
        int[][] input = {
                {1,  2,  3,  4},
                {5,  6,  7,  8},
                {9,  10, 11, 12},
                {13, 14, 15, 16}
        };

        int[][] output = {
                {13, 9,  5,  1},
                {14, 10, 6,  2},
                {15, 11, 7,  3},
                {16, 12, 8,  4}
        };
        int[][] result = Solution_1_7_CCI_RotateMatrix.solution(input);

        assertEqualMatrix(output, result);
    }
}
