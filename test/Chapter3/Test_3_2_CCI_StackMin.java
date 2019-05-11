package Chapter3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class Test_3_2_CCI_StackMin {

    @Test
    void test0() {
        Solution_3_2_CCI_StackMin stack = new Solution_3_2_CCI_StackMin(6);

        int[] values = new int[]{-345, 78, 10, -45, 100};

        for (int j = 0; j < values.length; j++) {
            stack.push(values[j]);
        }

        assertEquals(values[0], stack.min());
    }

    @Test
    void test1() {
        Solution_3_2_CCI_StackMin stack = new Solution_3_2_CCI_StackMin(1);

        int[] values = new int[]{-345};

        for (int j = 0; j < values.length; j++) {
            stack.push(values[j]);
        }

        assertEquals(values[0], stack.min());
    }

    @Test
    void test2() {
        Solution_3_2_CCI_StackMin stack = new Solution_3_2_CCI_StackMin(2);

        int[] values = new int[]{-10, 29};

        for (int j = 0; j < values.length; j++) {
            stack.push(values[j]);
        }

        assertEquals(values[0], stack.min());
    }

    @Test
    void test3() {
        Solution_3_2_CCI_StackMin stack = new Solution_3_2_CCI_StackMin(2);

        int[] values = new int[]{29, -10};

        for (int j = 0; j < values.length; j++) {
            stack.push(values[j]);
        }

        assertEquals(values[1], stack.min());
    }

    @Test
    void test4() {
        Solution_3_2_CCI_StackMin stack = new Solution_3_2_CCI_StackMin(4);

        int[] values = new int[]{29, 34, -10, 23};

        for (int j = 0; j < values.length; j++) {
            stack.push(values[j]);
        }

        stack.pop();
        stack.pop();

        assertEquals(values[0], stack.min());
    }
}
