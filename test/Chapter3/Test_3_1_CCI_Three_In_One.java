package Chapter3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class Test_3_1_CCI_Three_In_One {

    @Test
    void test0() {
        try {
            Solution_3_1_CCI_Three_In_One stackSet = new Solution_3_1_CCI_Three_In_One(2);
        } catch (RuntimeException exc) {
            assertTrue(true);
            return;
        }

        fail();
    }

    @Test
    void test1() {
        Solution_3_1_CCI_Three_In_One stackSet = new Solution_3_1_CCI_Three_In_One(3);
        try {
            stackSet.isEmpty(0);
        } catch (RuntimeException exc) {
            assertTrue(true);
            return;
        }

        fail();
    }

    @Test
    void test2() {
        Solution_3_1_CCI_Three_In_One stackSet = new Solution_3_1_CCI_Three_In_One(3);

        assertTrue(stackSet.isEmpty(1));
        assertTrue(stackSet.isEmpty(2));
        assertTrue(stackSet.isEmpty(3));
    }

    @Test
    void test3() {
        Solution_3_1_CCI_Three_In_One stackSet = new Solution_3_1_CCI_Three_In_One(3);

        stackSet.push(1, 34);

        assertTrue(stackSet.isFull(1));
        assertTrue(stackSet.isEmpty(2));
        assertTrue(stackSet.isEmpty(3));
    }

    @Test
    void test4() {
        Solution_3_1_CCI_Three_In_One stackSet = new Solution_3_1_CCI_Three_In_One(3);

        int value = 34;

        stackSet.push(1, value);
        assertEquals(value, stackSet.pop(1));

        assertTrue(stackSet.isEmpty(1));
        assertTrue(stackSet.isEmpty(2));
        assertTrue(stackSet.isEmpty(3));
    }

    @Test
    void test5() {
        Solution_3_1_CCI_Three_In_One stackSet = new Solution_3_1_CCI_Three_In_One(3);

        int value = 34;

        stackSet.push(2, value);
        assertFalse(stackSet.isEmpty(2));
        assertTrue(stackSet.isFull(2));

        assertEquals(value, stackSet.pop(2));

        assertTrue(stackSet.isEmpty(1));
        assertTrue(stackSet.isEmpty(2));
        assertTrue(stackSet.isEmpty(3));
    }

    @Test
    void test6() {
        Solution_3_1_CCI_Three_In_One stackSet = new Solution_3_1_CCI_Three_In_One(3);

        int value = 34;

        stackSet.push(3, value);
        assertFalse(stackSet.isEmpty(3));
        assertTrue(stackSet.isFull(3));

        assertEquals(value, stackSet.pop(3));

        assertTrue(stackSet.isEmpty(1));
        assertTrue(stackSet.isEmpty(2));
        assertTrue(stackSet.isEmpty(3));
    }

    @Test
    void test7() {
        Solution_3_1_CCI_Three_In_One stackSet = new Solution_3_1_CCI_Three_In_One(4);

        int value = 34;

        stackSet.push(3, value);
        assertFalse(stackSet.isEmpty(3));
        assertFalse(stackSet.isFull(3));

        assertEquals(value, stackSet.pop(3));

        assertTrue(stackSet.isEmpty(1));
        assertTrue(stackSet.isEmpty(2));
        assertTrue(stackSet.isEmpty(3));
    }

    @Test
    void test8() {
        Solution_3_1_CCI_Three_In_One stackSet = new Solution_3_1_CCI_Three_In_One(4);

        int value = 34;

        stackSet.push(3, value);
        stackSet.push(3, value);
        assertFalse(stackSet.isEmpty(3));
        assertTrue(stackSet.isFull(3));

        assertEquals(value, stackSet.pop(3));

        assertTrue(stackSet.isEmpty(1));
        assertTrue(stackSet.isEmpty(2));
        assertFalse(stackSet.isEmpty(3));
    }

    @Test
    void test9() {
        Solution_3_1_CCI_Three_In_One stackSet = new Solution_3_1_CCI_Three_In_One(4);

        int value = 34;

        stackSet.push(1, value);
        assertFalse(stackSet.isEmpty(1));
        assertTrue(stackSet.isFull(1));

        assertEquals(value, stackSet.pop(1));

        assertTrue(stackSet.isEmpty(1));
        assertTrue(stackSet.isEmpty(2));
        assertTrue(stackSet.isEmpty(3));
    }

    @Test
    void test10() {
        Solution_3_1_CCI_Three_In_One stackSet = new Solution_3_1_CCI_Three_In_One(4);

        int[] values = new int[]{34, 48, 99};

        for (int j = 0; j < values.length; j++) {
            stackSet.push(j + 1, values[j]);
        }

        for (int j = 0; j < values.length; j++) {
            assertFalse(stackSet.isEmpty(j + 1));
        }

        assertTrue(stackSet.isFull(1));
        assertTrue(stackSet.isFull(2));
        assertFalse(stackSet.isFull(3));

        for (int j = 0; j < values.length; j++) {
            assertEquals(values[j], stackSet.pop(j + 1));
        }

        for (int j = 0; j < values.length; j++) {
            assertTrue(stackSet.isEmpty(j + 1));
        }
    }

    @Test
    void test11() {
        Solution_3_1_CCI_Three_In_One stackSet = new Solution_3_1_CCI_Three_In_One(6);

        int value = 34;

        stackSet.push(1, value);
        assertFalse(stackSet.isEmpty(1));
        assertFalse(stackSet.isFull(1));

        assertEquals(value, stackSet.pop(1));

        assertTrue(stackSet.isEmpty(1));
        assertTrue(stackSet.isEmpty(2));
        assertTrue(stackSet.isEmpty(3));
    }
}
