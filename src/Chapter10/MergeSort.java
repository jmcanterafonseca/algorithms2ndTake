package Chapter10;

public class MergeSort {
    public static void sort(int[] array) {
        // The helper array is used to swap elements when doing the merge

        int[] helper = new int[array.length];

        // At the end of the process array will be a sorted array
        mergesort(array, helper, 0, array.length - 1);
    }

    private static void mergesort(int[] array, int[] helper, int low, int high) {
        if (low < high) {
            int middle = (low + high) / 2;

            // Sort the left half of the array
            mergesort(array, helper, low, middle);
            // Sort the right half of the array
            mergesort(array, helper, middle + 1, high);

            // Merge both halves
            merge(array, helper, low, middle, high);
        }
    }


    // This method has to merge both halves and as a result
    // needs to know where the left half starts and where the right half starts
    // From low to middle. From middle to high
    private static void merge(int[] array, int[] helper, int low, int middle, int high) {
        // First both halves of the array are copied to the helper
        for(int j = low; j <= high; j++) {
            helper[j] = array[j];
        }

        int helperLeft = low;
        int helperRight = middle + 1;
        int current = low;

        // The key to do the merge
        // The merge of course is done in the target array by using the helper
        while(helperLeft <= middle && helperRight <= high) {
            if (helper[helperLeft] <= helper[helperRight]) {
                array[current] = helper[helperLeft];
                helperLeft++;
            }
            else {
                array[current] = helper[helperRight];
                helperRight++;
            }

            current++;
        }

        // And now the remaining part (including i.e <= be careful!)
        int remaining = middle - helperLeft;
        for (int j = 0; j <= remaining; j++) {
            array[current + j] = helper[helperLeft + j];
        }
    }
}
