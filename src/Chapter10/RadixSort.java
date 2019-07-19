package Chapter10;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Implements the radix sort sorting algorithm
// O(kn) which k is the number of passes
public class RadixSort {
    public static void sort(int[] array, int max) {
        for (int divider = 1; (max / divider) > 0; divider *= 10) {
            radixSort(array, divider);
        }
    }

    // Performs the counting sort taking only into account
    private static void radixSort(int[] array, int divider) {
        // The different buckets
        Map<Integer, List<Integer>> buckets = new HashMap<>();

        // The elements in the array are traversed and we count the number of occurrences
        for (int j = 0; j < array.length; j++) {
            int digit = (array[j] / divider) % 10;
            List<Integer> list = buckets.get(digit);

            if (list == null) {
                list = new ArrayList<>();
                buckets.put(digit, list);
            }
            list.add(array[j]);
        }

        int index = 0;
        for (int j = 0; j < 10; j++) {
            List<Integer> bucketList = buckets.get(j);
            if (bucketList != null) {
                for (Integer number : bucketList) {
                    array[index++] = number;
                }
            }
        }
    }
}
