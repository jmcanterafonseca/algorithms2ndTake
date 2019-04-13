// Cracking the coding interview. Rotate a square matrix 90 degrees
public class Solution_1_7_CCI_RotateMatrix {
    public static int[][] solution(int[][] input) {
        if (input == null) {
            throw new RuntimeException("Null input");
        }

        if (input.length != input[0].length) {
            throw new RuntimeException("It must be a square matrix");
        }

        if (input.length < 2) {
            throw new RuntimeException("At least the matrix should be 2x2");
        }

        int[][] output = new int[input.length][input.length];

        int target = input.length - 1;
        for (int j = 0; j < input.length; j++) {
            int[] row = input[j];
            for (int k = 0; k < row.length; k++) {
                output[k][target] = row[k];
            }
            target--;
        }

        return output;
    }
}
