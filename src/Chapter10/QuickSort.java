package Chapter10;

// Quick Sort algorithm
// Average case is O(n log(n))
// Worst case is O(n^2).
public class QuickSort {
    public static void sort(int[] array) {
        quicksort(array, 0, array.length - 1);
    }

    private static void quicksort(int[] array, int left, int right) {
        if (right < left) {
            return;
        }

        int index = partition(array, left, right);

        if (left < index - 1) {
            quicksort(array, left, index - 1);
        }

        if (index < right) {
            quicksort(array, index, right);
        }
    }

    private static int partition(int[] array, int left, int right) {
        // pivot point
        int pivot = array[(left + right) / 2];

        int leftPointer = left;
        int rightPointer = right;

        while (leftPointer <= rightPointer) {

            // Find element on left that should be on right
            while (array[leftPointer] < pivot) leftPointer++;

            // Find element on right that should be on left
            while (array[rightPointer] > pivot) rightPointer--;

            // And now it is necessary to swap elements as it happens with all sorting
            // algorithms
            if (leftPointer <= rightPointer) {
                // Elements are swapped
                int aux = array[leftPointer];
                array[leftPointer] = array[rightPointer];
                array[rightPointer] = aux;

                leftPointer++;
                rightPointer--;
            }
        }

        return leftPointer;
    }
}
