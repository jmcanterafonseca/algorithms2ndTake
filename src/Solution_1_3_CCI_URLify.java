public class Solution_1_3_CCI_URLify {
    public static String solution(char[] chars, int inputLength) {
        if (chars == null || inputLength < 0 || chars.length < inputLength) {
            throw new RuntimeException("Invalid input data");
        }

        int headPointer = 0;
        int rearPointer = inputLength - 1;

        char[] subsString = { '%' , '2', '0'};
        int numExtraChars = subsString.length - 1;

        for(int j = 0; j < inputLength; j++) {
            if (chars[headPointer] == ' ') {
                for (int k = rearPointer; k > headPointer; k--) {
                    chars[k + numExtraChars] = chars[k];
                }
                rearPointer += numExtraChars;
                for (int l = 0; l < subsString.length; l++) {
                    chars[headPointer + l] = subsString[l];
                }
                headPointer += subsString.length;
            }
            else {
                headPointer++;
            }
        }

        return new String(chars, 0, rearPointer + 1);
    }
}
