package Misc;

import java.util.*;

public class Anagrams2 {
    public static String isValid(String s) {
        int[] frequencies = new int[128];

        for(int k = 0; k < s.length(); k++) {
            frequencies[s.charAt(k) - 'a']++;
        }

        Map<Integer,Integer> freqMap = new HashMap<>();

        for (int k = 0; k < frequencies.length; k++) {
            if (frequencies[k] > 0) {
                if (freqMap.get(frequencies[k]) == null) {
                    freqMap.put(frequencies[k], 0);
                }
                freqMap.put(frequencies[k], freqMap.get(frequencies[k]) + 1);
            }
        }

        if (freqMap.size() != 1) {
            if (freqMap.size() > 2) {
                return "NO";
            }
            else {
                Integer[] freqs = freqMap.keySet().toArray(new Integer[0]);

                if (Math.abs(freqs[0] - freqs[1]) > 1 &&
                        !(freqs[0] == 1 && freqMap.get(freqs[0]) == 1
                                || freqs[1] == 1 && freqMap.get(freqs[1]) == 1)) {
                    return "NO";
                }
                if (freqMap.get(freqs[0]) != 1 && freqMap.get(freqs[1]) != 1) {
                    return "NO";
                }
            }
        }

        return "YES";
    }
}
