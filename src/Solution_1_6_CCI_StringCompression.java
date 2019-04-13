public class Solution_1_6_CCI_StringCompression {
    public static String solution(String s) {
        if (s == null) {
            throw new RuntimeException("Null input");
        }

        String i = s.trim();

        if (i.length() == 0) {
            return i;
        }

        // Worst case is that output array doubles the size of input array
        int outputLength = 0;
        char[] output = new char[i.length() * 2];

        char[] input = i.toCharArray();

        int numRepeatedChars = 0;
        char previousChar = input[0];

        boolean stringProcessed = false;
        int numCharsProcessed = 0;

        while(!stringProcessed) {
            char c;
            if (numCharsProcessed < input.length) {
                c = input[numCharsProcessed];
            }
            else {
                c = (char)-1;
            }

            if (c != previousChar) {
                output[outputLength] = previousChar;
                char[] countAsString = String.valueOf(numRepeatedChars).toCharArray();

                System.arraycopy(countAsString, 0, output, outputLength + 1, countAsString.length);

                previousChar = c;
                outputLength += (countAsString.length + 1);
                numRepeatedChars = 1;
            }
            else {
                numRepeatedChars++;
            }

            numCharsProcessed++;
            if (numCharsProcessed == input.length + 1) {
                stringProcessed = true;
            }
        }

        String out = i;

        if (outputLength < input.length) {
            out = new String(output, 0, outputLength);
        }

        return out;
    }
}
