// Cracking the coding interview exercise 1.5
public class Solution_1_5_CCI_One_Away {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.err.println("Please provide two strings");
            System.exit(-1);
        }

        String str1 = args[0];
        String str2 = args[1];

        System.out.println(solution(str1, str2));
    }

    public static boolean solution(String str1, String str2) {
        if (str1 == null || str2 == null) {
            throw new RuntimeException("Input strings cannot be null");
        }

        int length1 = str1.length();
        int length2 = str2.length();

        String string1 = str1, string2 = str2;

        if (length2 > length1) {
            string2 = str1;
            string1 = str2;

            int aux = length1;
            length1 = length2;
            length2 = aux;
        }

        int difference = Math.abs(length1 - length2);

        // If the length different is greater than one then we have finished
        if (difference > 1) {
            return false;
        }

        // Reference string is str1
        int numDifferences = 0;

        // Proposed algorithm is check character by character of str

        char c1 = 0, c2 = 0;

        int index1 = 0;
        int index2 = 0;

        while (index2 < length2 && index1 < length1) {
            c1 = string1.charAt(index1++);
            c2 = string2.charAt(index2++);

            if (c1 != c2) {
                numDifferences++;
                if (length1 > length2) {
                    index1++;
                }
            }
        }

        return numDifferences <= 1;
    }
}
