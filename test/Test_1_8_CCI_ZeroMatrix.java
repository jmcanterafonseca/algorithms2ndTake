import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class Test_1_8_CCI_ZeroMatrix {

    private void assertEqualMatrix(int[][] a1, int[][] a2) {
        for (int j = 0; j < a1.length; j++) {
                assertArrayEquals(a1[j], a2[j]);
        }
    }

    @Test
    void test0() {
        int[][] input = {
                {1, 2, 0},
                {4, 5, 6},
                {7, 8, 9}
        };

        int[][] output = {
                {0, 0, 0},
                {4, 5, 0},
                {7, 8, 0}
        };

        int[][] result = Solution_1_8_CCI_ZeroMatrix.solution(input);

        assertEqualMatrix(result, output);
    }

    @Test
    void test1() {
        int[][] input = {
                {1, 0},
                {3, 4}
        };

        int[][] output = {
                {0, 0},
                {3, 0},

        };

        int[][] result = Solution_1_8_CCI_ZeroMatrix.solution(input);

        assertEqualMatrix(output, result);
    }

    @Test
    void test2() {
        int[][] input = {
                {1,  2,  0,  4},
                {5,  6,  7,  8},
                {9,  10, 0, 12},
                {13, 14, 15, 16}
        };

        int[][] output = {
                {0,  0,  0,  0},
                {5,  6,  0,  8},
                {0,  0,  0,  0},
                {13, 14, 0, 16}
        };
        int[][] result = Solution_1_8_CCI_ZeroMatrix.solution(input);

        assertEqualMatrix(output, result);
    }
}
