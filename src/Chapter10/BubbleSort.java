package Chapter10;

// Implements the bubble sort algorithm
// O(n^2)
public class BubbleSort {
    public static void sort(int[] list) {
        if (list == null) {
            return;
        }

        for (int j = 0; j < list.length; j++) {
            for (int k = j + 1; k < list.length; k++) {
                if (list[j] > list[k]) {
                    int aux = list[j];
                    list[j] = list[k];
                    list[k] = aux;
                }
            }
        }
    }
}
