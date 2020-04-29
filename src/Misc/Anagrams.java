package Misc;

import java.util.*;

/*
 *  Solution to the Sherlock and Anagrams challenge at HackerRank
 *
 *
 */
public class Anagrams {

    // Complete the sherlockAndAnagrams function below.
    public static int sherlockAndAnagrams(String s) {
        int totalAnagrams = 0;

        if (s == null || s.length() == 0) {
            return totalAnagrams;
        }

        // Array that is going to hold s's substrings indexed by substring length
        List<String>[] substrings = generateAllSubstrings(s);

        // For each length
        for(List<String> list : substrings) {
            // For each substring
            for (int k = 0; k < list.size() - 1; k++) {
                for (int m = k + 1; m < list.size(); m++) {
                    if (isAnagram(list.get(k), list.get(m))) {
                        totalAnagrams++;
                    }
                }
            }
        }

        return totalAnagrams;
    }

    private static boolean isAnagram(String s1, String s2) {
        boolean result = true;

        int[] occurrences1 = new int[128];
        int[] occurrences2 = new int[128];

        for (int k = 0; k < s1.length(); k++) {
            occurrences1[s1.charAt(k) - 'a']++;
        }

        for (int k = 0; k < s2.length(); k++) {
            occurrences2[s2.charAt(k) - 'a']++;
        }

        for (int k = 0; k < 128; k++) {
            if (occurrences1[k] != occurrences2[k]) {
                result = false;
                break;
            }
        }

        return result;
    }

    private static List<String>[] generateAllSubstrings(String s) {
        // To get access to the array of chars without making copies of the string
        char[] chars = s.toCharArray();

        // Initialization of the array of Lists to hold the different substrings
        List<String>[] substrings = new ArrayList[s.length()];
        for (int k = 0; k < s.length(); k++) {
            substrings[k] = new ArrayList<>();
        }

        // We start from the reference char
        // and move the pointer one till the end of the string
        for (int k = 0; k < s.length(); k++) {
            substrings[0].add(new String(chars, k, 1));

            for (int m = k + 1; m < s.length(); m++) {
                substrings[m - k].add(new String(chars, k, (m + 1) - k));
            }
        }

        return substrings;
    }

}
