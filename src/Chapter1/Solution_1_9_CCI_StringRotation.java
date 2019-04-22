package Chapter1;

// Cracking the coding interview. 1.9. Detecting that a string is a rotation of another string
// substring it is only allowed to be called one time
// It has a trick!!
public class Solution_1_9_CCI_StringRotation {
    public static boolean solution(String s1, String s2) {
        if (s1 == null || s2 == null) {
            throw new RuntimeException("Input String cannot be null");
        }

        if (s1.length() != s2.length()) {
            return false;
        }

        if (s1.length() == 0) {
            return true;
        }

        // The concatenation of a string rotation should have the original string as a substring :)
        String toTest = s2 + s2;

        return isSubstring(toTest, s1);
    }

    // Checks if s2 is a substring of s1
    public static boolean isSubstring(String s1, String s2) {
        if (s1 == null || s2 == null) {
            throw new RuntimeException("Input String cannot be null");
        }

        boolean out = false;

        int s1Pointer = 0;
        int s2Pointer = 0;

        char[] s1Chars = s1.toCharArray();
        char[] s2Chars = s2.toCharArray();

        if (s2Chars.length > s1Chars.length) {
            return false;
        }

        if (s2Chars.length == 0) {
            return true;
        }

        boolean finish = false;

        char testChar = s2Chars[s2Pointer++];
        while (!finish) {
            // Let's find the testChar in s1
            boolean found = false;
            int nextS1Pointer = s1Pointer;
            while (!found && s1Pointer < s1Chars.length) {
                char s1Char = s1Chars[s1Pointer++];
                if (s1Char == testChar) {
                    found = true;
                    nextS1Pointer = s1Pointer;
                }
            }
            if (found) {
                while (s1Pointer < s1Chars.length && s2Pointer < s2Chars.length
                        && s1Chars[s1Pointer++] == s2Chars[s2Pointer++]);

                if (s2Pointer == s2Chars.length &&
                        s2Chars[s2Pointer - 1] == s1Chars[s1Pointer - 1]) {
                    finish = true;
                    out = true;
                }
                else {
                    // Still continue with the process just in case the substring appears later
                    s2Pointer = 1;
                    s1Pointer = nextS1Pointer;
                }
            } else {
                finish = true;
            }
        }

        return out;
    }
}
