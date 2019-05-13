package Chapter3;

import org.junit.jupiter.api.Test;

import static Chapter3.Solution_3_3_CCI_Stack_Of_Plates.Plate;
import static org.junit.jupiter.api.Assertions.*;


public class Test_3_3_CCI_Stack_Of_Plates {

    @Test
    void test0() {
        Solution_3_3_CCI_Stack_Of_Plates stackSet = new Solution_3_3_CCI_Stack_Of_Plates();

        try {
            stackSet.peek();
        } catch (RuntimeException rte) {
            assertTrue(true);
            return;
        }

        fail();
    }

    @Test
    void test1() {
        Solution_3_3_CCI_Stack_Of_Plates stackSet = new Solution_3_3_CCI_Stack_Of_Plates();

        try {
            stackSet.pop();
        } catch (RuntimeException rte) {
            assertTrue(true);
            return;
        }

        fail();
    }

    @Test
    void test2() {
        Solution_3_3_CCI_Stack_Of_Plates stackSet = new Solution_3_3_CCI_Stack_Of_Plates();

        assertTrue(stackSet.isEmpty());
    }

    @Test
    void test3() {
        Solution_3_3_CCI_Stack_Of_Plates stackSet = new Solution_3_3_CCI_Stack_Of_Plates();

        Plate p = new Plate();
        stackSet.push(p);

        assertEquals(p, stackSet.peek());
        assertEquals(p, stackSet.pop());
    }

    @Test
    void test4() {
        Solution_3_3_CCI_Stack_Of_Plates stackSet = new Solution_3_3_CCI_Stack_Of_Plates();
        Plate[] plates = new Plate[5];

        for (int j = 0; j < 5; j++) {
            plates[j] = new Plate();
            stackSet.push(plates[j]);
        }

        assertEquals(plates[4], stackSet.peek());
    }

    @Test
    void test5() {
        Solution_3_3_CCI_Stack_Of_Plates stackSet = new Solution_3_3_CCI_Stack_Of_Plates();
        Plate[] plates = new Plate[5];

        for (int j = 0; j < 5; j++) {
            plates[j] = new Plate();
            stackSet.push(plates[j]);
        }

        assertEquals(plates[4], stackSet.pop());
        assertEquals(plates[3], stackSet.peek());
    }

    @Test
    void test6() {
        Solution_3_3_CCI_Stack_Of_Plates stackSet = new Solution_3_3_CCI_Stack_Of_Plates();
        Plate[] plates = new Plate[5];

        for (int j = 0; j < 5; j++) {
            plates[j] = new Plate();
            stackSet.push(plates[j]);
        }

        for (int j = 0, k = 4; j < 5; j++, k--) {
            assertEquals(plates[k], stackSet.pop());
        }

        assertTrue(stackSet.isEmpty());
    }

    @Test
    void test7() {
        Solution_3_3_CCI_Stack_Of_Plates stackSet = new Solution_3_3_CCI_Stack_Of_Plates();
        Plate[] plates = new Plate[5];

        for (int j = 0; j < 5; j++) {
            plates[j] = new Plate();
            stackSet.push(plates[j]);
        }

        for (int j = 0; j < 5; j++) {
            stackSet.pop();
        }

        for (int j = 0; j < 5; j++) {
            plates[j] = new Plate();
            stackSet.push(plates[j]);
        }

        assertEquals(plates[4], stackSet.pop());
        assertEquals(plates[3], stackSet.peek());
    }

    @Test
    void test8() {
        Solution_3_3_CCI_Stack_Of_Plates stackSet = new Solution_3_3_CCI_Stack_Of_Plates();
        Plate[] plates = new Plate[5];

        for (int j = 0; j < 5; j++) {
            plates[j] = new Plate();
            stackSet.push(plates[j]);
        }

        try {
            stackSet.popAt(2);
        } catch (RuntimeException rte) {
            assertTrue(true);
            return;
        }

        fail();
    }

    @Test
    void test9() {
        Solution_3_3_CCI_Stack_Of_Plates stackSet = new Solution_3_3_CCI_Stack_Of_Plates();
        Plate[] plates = new Plate[5];

        for (int j = 0; j < 5; j++) {
            plates[j] = new Plate();
            stackSet.push(plates[j]);
        }

        stackSet.popAt(0);

        assertEquals(plates[4], stackSet.peek());
    }

    @Test
    void test10() {
        Solution_3_3_CCI_Stack_Of_Plates stackSet = new Solution_3_3_CCI_Stack_Of_Plates();
        Plate[] plates = new Plate[5];

        for (int j = 0; j < 5; j++) {
            plates[j] = new Plate();
            stackSet.push(plates[j]);
        }

        stackSet.popAt(1);

        assertEquals(plates[3], stackSet.peek());
    }

    @Test
    void test11() {
        Solution_3_3_CCI_Stack_Of_Plates stackSet = new Solution_3_3_CCI_Stack_Of_Plates();
        Plate[] plates = new Plate[15];

        for (int j = 0; j < 15; j++) {
            plates[j] = new Plate();
            stackSet.push(plates[j]);
        }

        stackSet.popAt(1);

        assertEquals(plates[13], stackSet.peek());
    }

    @Test
    void test12() {
        Solution_3_3_CCI_Stack_Of_Plates stackSet = new Solution_3_3_CCI_Stack_Of_Plates();
        Plate[] plates = new Plate[15];

        for (int j = 0; j < 15; j++) {
            plates[j] = new Plate();
            stackSet.push(plates[j]);
        }

        stackSet.popAt(2);

        assertEquals(plates[13], stackSet.peek());
    }

    @Test
    void test13() {
        Solution_3_3_CCI_Stack_Of_Plates stackSet = new Solution_3_3_CCI_Stack_Of_Plates();
        Plate[] plates = new Plate[15];

        for (int j = 0; j < 15; j++) {
            plates[j] = new Plate();
            stackSet.push(plates[j]);
        }

        stackSet.popAt(0);
        stackSet.popAt(1);

        assertEquals(plates[12], stackSet.peek());
    }
}
