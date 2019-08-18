package Misc;

public class HaystackNeedle {
    public static int solution(String haystack, String needle) {
        int hi = 0;
        int ni = 0;
        int out = -1;
        int candidate = -1;

        if (haystack == null || haystack.length() == 0) {
            return -1;
        }

        if (needle == null || needle.length() == 0) {
            return 0;
        }

        while(hi < haystack.length() && out == -1) {
            if (haystack.charAt(hi) == needle.charAt(ni)) {
                if (ni == 0) {
                    candidate = hi;
                }
                if (ni == needle.length() - 1) {
                    out = candidate;
                }
                hi++;
                ni++;
            }
            else {
                if (candidate != -1) {
                    candidate = -1;
                    ni = 0;
                }
                else {
                    hi++;
                }
            }
        }

        return out;
    }
}
