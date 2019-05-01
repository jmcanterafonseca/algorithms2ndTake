package Misc;

import java.util.Arrays;
import java.util.PriorityQueue;

// Selects the k best elements from an array
// Implements an algorithm based on a min heap (a priority heap in Java)
public class Solution_KBest_Select {
    public static Integer[] solution(Integer[] elements, int k) {
        if (k == 0) {
            return new Integer[]{};
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        int min = Integer.MIN_VALUE;

        for (int element: elements) {
            if (minHeap.size() == k) {
                if (element > min) {
                    // Removes the min element
                    minHeap.poll();

                    minHeap.add(element);
                    // Obtains the new min element
                    min = minHeap.peek();
                }
            }
            else if (minHeap.size() < k) {
                minHeap.add(element);
                min = minHeap.peek();
            }
        }

        Integer[] out = minHeap.toArray(new Integer[]{});
        // It is important to sort the best k elements
        Arrays.sort(out);

        return out;
    }
}
