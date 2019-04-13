public class Solution_1_6_CCI_StringCompression {
    public static String solution(String s) {
        if (s == null) {
            throw new RuntimeException("Null input");
        }

        String i = s.trim();

        if (i.length() == 0) {
            return i;
        }

        // Output array at most of equal length of input string
        int outputLength = 0;
        char[] output = new char[i.length()];

        char[] input = i.toCharArray();
        int inputLength = input.length;

        int numRepeatedChars = 0;
        char previousChar = input[0];

        boolean stringProcessed = false;
        int numCharsProcessed = 0;

        while (!stringProcessed && outputLength < inputLength) {
            char c;
            if (numCharsProcessed < inputLength) {
                c = input[numCharsProcessed];
            } else {
                c = (char) -1;
            }

            if (c != previousChar) {
                char[] countAsString = String.valueOf(numRepeatedChars).toCharArray();
                // Only this is performed if there is room in the array
                if (outputLength + countAsString.length + 1 < inputLength) {
                    output[outputLength] = previousChar;
                    System.arraycopy(countAsString, 0, output, outputLength + 1, countAsString.length);
                }
                previousChar = c;
                outputLength += (countAsString.length + 1);
                numRepeatedChars = 1;

            } else {
                numRepeatedChars++;
            }

            numCharsProcessed++;
            if (numCharsProcessed == inputLength + 1) {
                stringProcessed = true;
            }
        }

        String out = i;

        if (outputLength < inputLength && stringProcessed) {
            out = new String(output, 0, outputLength);
        }

        return out;
    }
}
