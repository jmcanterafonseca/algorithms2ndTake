package Chapter10;

import datastr.Listy;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Test_Solution_10_4_Sorted_Search_No_Size {
    private int[] arr = {10, 22, 44, 5, 12, 18, 2};

    private Listy listy = new Listy(arr);

    @Test
    void test1() {
        int index = Solution_10_4_CCI_Sorted_Search_No_Size.solution(10, listy);

        assertEquals(2, index);
    }

    @Test
    void test2() {
        int index = Solution_10_4_CCI_Sorted_Search_No_Size.solution(11, listy);

        assertEquals(-1, index);
    }

    @Test
    void test3() {
        int[] array = {};
        Listy listy2 = new Listy(array);

        int index = Solution_10_4_CCI_Sorted_Search_No_Size.solution(11, listy2);

        assertEquals(-1, index);
    }
}

