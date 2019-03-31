import java.util.ArrayList;
import java.util.List;

// Cracking the coding interview exercise 1.4
public class Solution_1_4_CCI_Palindrome {

    public static boolean solution(String str1) {
        if (str1 == null) {
            throw new RuntimeException("Input string cannot be null");
        }

        boolean out = false;

        List<String> permutations = permutations(str1.toLowerCase());

        for(String p:permutations) {
            if (isPalindrome(p)) {
                out = true;
                break;
            }
        }

        return out;
    }


    private static boolean isPalindrome(String str) {
        char[] chars = str.toCharArray();

        boolean out = true;
        int k = chars.length - 1;
        int j = 0;

        while(j < k && j < chars.length && k >= 0) {
            while(chars[k] == ' ' && k > 0 && k > j) {
                k--;
            }

            while(chars[j] == ' ' && j < chars.length && k > j) {
                j++;
            }

            if (chars[j] != chars[k]) {
                out = false;
                break;
            }

            k--;
            j++;
        }

        return out;
    }


    /**
     *
     *   Recursive permutation implementation
     *
     *   P("abc") = a.P("bc") U b.P("ac") U c.P("ab")
     *
     *
     * @param s
     * @return
     */
    private static List<String> permutations(String s) {
        List<String> out = new ArrayList<>();

        if (s.length() == 1) {
            out.add(s);
            return out;
        }

        for (int j = 0; j < s.length(); j++) {
            char c = s.charAt(j);

            String leftStr = s.substring(0, j);
            String rightStr =  s.substring(j + 1);

            List<String> partials = permutations(leftStr + rightStr);
            for (String p : partials) {
                out.add(new String(c + p));
            }
        }

        return out;
    }
}