package Chapter3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class Test_3_5_CCI_SortStack {

    @Test
    void test10() {
        Solution_3_5_CCI_SortStack stack = new Solution_3_5_CCI_SortStack(10);

        stack.push(8);
        stack.push(-1);

        assertEquals(-1, stack.peek());
    }

    @Test
    void test11() {
        Solution_3_5_CCI_SortStack stack = new Solution_3_5_CCI_SortStack(10);

        stack.push(-1);
        stack.push(8);

        assertEquals(-1, stack.peek());
    }

    @Test
    void test12() {
        Solution_3_5_CCI_SortStack stack = new Solution_3_5_CCI_SortStack(10);

        stack.push(3);
        stack.push(5);
        stack.push(-1);

        assertEquals(-1, stack.peek());
    }

    @Test
    void test13() {
        Solution_3_5_CCI_SortStack stack = new Solution_3_5_CCI_SortStack(10);

        stack.push(-1);
        stack.push(5);
        stack.push(0);

        assertEquals(-1, stack.peek());
    }

    @Test
    void test14() {
        Solution_3_5_CCI_SortStack stack = new Solution_3_5_CCI_SortStack(10);

        stack.push(-1);
        stack.push(5);
        stack.push(0);

        stack.pop();

        assertEquals(0, stack.peek());
    }
}
