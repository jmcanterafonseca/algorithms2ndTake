// Cracking the coding interview exercise 1.2
public class Solution_1_2_CCI_Permutation {
    public static boolean solution(String str1, String str2) {
        if (str1 == null || str2 == null) {
            throw new RuntimeException("Invalid input data");
        }

        // It will mark those chars that are found on input strings
        int[] charMark = new int[128];

        int length1 = str1.length();
        int length2 = str2.length();

        int numCharsNotZero = length1;

        for (int j = 0; j < length1; j++) {
            charMark[str1.charAt(j)]++;
        }

        for (int j = 0; j < length2; j++) {
            char c = str2.charAt(j);

            charMark[c]--;
            if (charMark[c] == 0) {
                numCharsNotZero--;
            }
            else {
                numCharsNotZero++;
            }
        }

        return numCharsNotZero == 0;
    }
}
