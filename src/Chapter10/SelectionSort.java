package Chapter10;

// Implements the selection sort algorithm
// O(n^2)
public class SelectionSort {
    public static void sort(int[] list) {
        if (list == null) {
            return;
        }

        for (int j = 0; j < list.length; j++) {
            int min = Integer.MAX_VALUE;
            int minIndex = -1;

            for (int k = j; k < list.length; k++) {
                if (list[k] < min) {
                    min = list[k];
                    minIndex = k;
                }
            }

            int aux = list[j];
            list[j] = min;
            list[minIndex] = aux;
        }
    }
}
