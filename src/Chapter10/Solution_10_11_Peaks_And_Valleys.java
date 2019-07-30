package Chapter10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution_10_11_Peaks_And_Valleys {
    public static void solution(int[] array) {
        List<Integer> peaks = new ArrayList<>();
        List<Integer> valleys = new ArrayList<>();
        List<Integer> other = new ArrayList<>();

        for (int j = 0; j < array.length; j++) {
            int prev = Integer.MIN_VALUE;
            int next = Integer.MIN_VALUE;

            if (j > 0) {
                prev = array[j - 1];
            }

            if (j < array.length - 1) {
                next = array[j + 1];
            }

            if (prev < array[j] && next < array[j]) {
                peaks.add(array[j]);
            } else {
                if (j == 0) {
                    prev = Integer.MAX_VALUE;
                }

                if (j == array.length - 1) {
                    next = Integer.MAX_VALUE;
                }

                if (prev > array[j] && next > array[j]) {
                    valleys.add(array[j]);
                } else {
                    other.add(array[j]);
                }
            }
        }

        Collections.sort(other);

        int peakIndex = 0;
        int valleyIndex = 0;
        int otherIndex = 0;

        for (int j = 0; j < array.length; j++) {
            if (peakIndex >= peaks.size() && valleyIndex >= valleys.size()) {
                array[j] = other.get(otherIndex++);
                continue;
            }

            if (j % 2 == 0 && peakIndex < peaks.size()) {
                array[j] = peaks.get(peakIndex++);
            } else {
                array[j] = valleys.get(valleyIndex++);
            }
        }
    }
}
