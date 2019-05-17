package Chapter3;

import org.junit.jupiter.api.Test;

import static Chapter3.Solution_3_4_CCI_Two_Stack_Queue.QueueNode;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class Test_3_4_CCI_Two_Stack_Queue {

    @Test
    void test10() {
        Solution_3_4_CCI_Two_Stack_Queue<Integer> queue = new Solution_3_4_CCI_Two_Stack_Queue<>(10);

        queue.add(new QueueNode<>(4));
        queue.add(new QueueNode<>(8));

        assertEquals(4, queue.head().value);
    }

    @Test
    void test11() {
        Solution_3_4_CCI_Two_Stack_Queue<Integer> queue = new Solution_3_4_CCI_Two_Stack_Queue<>(10);

        assertTrue(queue.isEmpty());
    }

    @Test
    void test12() {
        Solution_3_4_CCI_Two_Stack_Queue<Integer> queue = new Solution_3_4_CCI_Two_Stack_Queue<>(10);

        assertTrue(queue.isEmpty());
    }

    @Test
    void test13() {
        Solution_3_4_CCI_Two_Stack_Queue<Integer> queue = new Solution_3_4_CCI_Two_Stack_Queue<>(10);

        queue.add(new QueueNode<>(4));
        queue.add(new QueueNode<>(8));

        assertEquals(4, queue.remove().value);
        assertEquals(8, queue.head().value);
    }

    @Test
    void test14() {
        Solution_3_4_CCI_Two_Stack_Queue<Integer> queue = new Solution_3_4_CCI_Two_Stack_Queue<>(10);

        queue.add(new QueueNode<>(4));
        queue.add(new QueueNode<>(8));

        assertEquals(4, queue.remove().value);
        assertEquals(8, queue.remove().value);

        assertTrue(queue.isEmpty());
        assertEquals(0, queue.size());
    }

    @Test
    void test15() {
        Solution_3_4_CCI_Two_Stack_Queue<Integer> queue = new Solution_3_4_CCI_Two_Stack_Queue<>(10);

        queue.add(new QueueNode<>(4));
        queue.add(new QueueNode<>(8));
        queue.add(new QueueNode<>(15));

        assertEquals(4, queue.remove().value);
        assertEquals(8, queue.head().value);

        assertEquals(2, queue.size());
    }
}
