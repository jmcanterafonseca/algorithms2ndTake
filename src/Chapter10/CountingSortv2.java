package Chapter10;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Counting sort is a sorting technique based on keys between a specific range.
// It works by counting the number of objects having distinct key values (kind of hashing).
public class CountingSortv2 {
    // The range is passed as parameter (min, max)
    public static void sort(int[] array, int min, int max) {
        // Length of the interval to store counts
        int intervalLength = Math.abs(min) + Math.abs(max) + 1;

        // Hash to store count
        Map<Integer, List<Integer>> counter = new HashMap<>();

        // The elements in the array are traversed and we count the number of occurrences
        for (int j = 0; j < array.length; j++) {
            int counterIndex = indexOf(array[j], min);

            List<Integer> bucketList = counter.get(counterIndex);
            if (bucketList == null) {
                bucketList = new ArrayList<>();
                counter.put(counterIndex, bucketList);
            }
            bucketList.add(array[j]);
        }

        int index = 0;

        // Now we generate the position of each element
        for (int j = 0; j < intervalLength; j++) {
            List<Integer> bucketList = counter.get(j);

            if (bucketList != null) {
                for (int number : bucketList) {
                    array[index++] = number;
                }
            }
        }
    }

    // Given a number of the interval calculates its index in the count array
    private static int indexOf(int number, int min) {
        return Math.abs(Math.abs(min) + number);
    }
}
