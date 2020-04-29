package Misc;

public class DuplicateZeros {
    public static void duplicateZeros(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }

        int k = 0;
        while (k < arr.length) {
            if (arr[k] == 0 && k < arr.length - 1) {
                for (int m = arr.length - 1; m > k; m--) {
                    arr[m] = arr[m - 1];
                }
                arr[k + 1] = 0;
                // Skip the new zero
                k += 2;
            }
            else {
                k++;
            }
        }
    }
}
