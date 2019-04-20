import java.util.HashSet;
import java.util.Set;

// Cracking the coding interview. if an element in an MxN matrix is 0, its entire row and column are set to 0
public class Solution_1_8_CCI_ZeroMatrix {
    public static int[][] solution(int[][] input) {
        if (input == null) {
            throw new RuntimeException("Null input");
        }

        if (input.length < 2) {
            throw new RuntimeException("At least the matrix should be 2x2");
        }

        int[][] output = new int[input.length][input[0].length];

        Set<Integer> zeroColums = new HashSet<>();
        Set<Integer> zeroRows = new HashSet<>();

        for (int rowIndex = 0; rowIndex < input.length; rowIndex++) {
            int[] row = input[rowIndex];
            for (int columnIndex = 0; columnIndex < row.length; columnIndex++) {
                if (input[rowIndex][columnIndex] == 0) {
                    if (!zeroRows.contains(columnIndex)) {
                        for (int j = 0; j < row.length; j++) {
                            output[rowIndex][j] = 0;
                        }
                        zeroRows.add(rowIndex);
                    }
                    if (!zeroColums.contains(columnIndex)) {
                        for (int k = 0; k < input.length; k++) {
                            output[k][columnIndex] = 0;
                        }
                        zeroColums.add(columnIndex);
                    }
                    break;
                } else {
                    if (!zeroRows.contains(rowIndex) && !zeroColums.contains(columnIndex)) {
                        output[rowIndex][columnIndex] = input[rowIndex][columnIndex];
                    }
                }
            }
        }

        return output;
    }
}
