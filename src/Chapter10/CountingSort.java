package Chapter10;

// Counting sort is a sorting technique based on keys between a specific range.
// It works by counting the number of objects having distinct key values (kind of hashing).
// Then doing some arithmetic to calculate the position of each object in the output sequence.
public class CountingSort {
    // The range is passed as parameter
    public static void sort(int[] array, int min, int max) {
        // Length of the interval to store counts
        int intervalLength = Math.abs(min) + Math.abs(max) + 1;
        int[] counter = new int[intervalLength];

        // The elements in the array are traversed and we count the number of occurrences
        for (int j = 0; j < array.length; j++) {
            int counterIndex = indexOf(array[j], min);
            counter[counterIndex]++;
        }

        // Now we accumulate the counts
        for (int j = 1; j < intervalLength; j++) {
            counter[j] += counter[j - 1];
        }

        // Now we generate the position of each element
        for (int j = 0; j < intervalLength; j++) {
            int number = numberOf(j, min);

            int position = counter[j];
            int nextElementCount;

            if (j == 0) {
                nextElementCount = 0;
            } else {
                nextElementCount = counter[j - 1];
            }

            while (position > 0 && position > nextElementCount) {
                array[position - 1] = number;
                position--;
            }
        }
    }

    // Given a number of the interval calculates its index in the count array
    private static int indexOf(int number, int min) {
        return Math.abs(Math.abs(min) + number);
    }

    // given an index in the count array obtains the corresponding number
    private static int numberOf(int index, int min) {
        return min + index;
    }
}
