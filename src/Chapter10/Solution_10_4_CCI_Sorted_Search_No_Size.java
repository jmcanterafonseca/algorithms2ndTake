package Chapter10;


import datastr.Listy;

public class Solution_10_4_CCI_Sorted_Search_No_Size {
    public static int solution(int number, Listy list) {
        return search(number, list, 0, number);
    }

    private static int search(int number, Listy list, int start, int end) {
        if (start > end) {
            return -1;
        }

        if (list.elementAt(end) == number) {
            return end;
        }

        int value = list.elementAt(end);
        int newEnd = end;
        while (value == -1 && newEnd > 0) {
            newEnd--;
            value = list.elementAt(newEnd);
        }

        int middle = (start + newEnd) / 2;
        int middleValue = list.elementAt(middle);

        if (middleValue < number) {
            return search(number, list, middle + 1, newEnd);
        }

        return search(number, list, start, middle - 1);
    }
}
