package utils;

import Chapter2.IntegerLinkedList;
import Chapter2.LinkedListNode;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Utils {
    public static void assertList(IntegerLinkedList list, int[] values) {
        LinkedListNode<Integer> current = list.head;

        for (int value : values) {
            assertEquals(value, current.value);
            current = current.next;
        }

        assertEquals(null, current);
    }
}
