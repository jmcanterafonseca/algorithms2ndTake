package datastr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Listy {
    private List<Integer> intList = new ArrayList<>();

    public Listy(int[] array) {
        Arrays.sort(array);

        for (int number : array) {
            intList.add(number);
        }
    }

    public int elementAt(int index) {
        if (index < intList.size()) {
            return intList.get(index);
        }

        return -1;
    }
}
