package Misc;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class Test_DuplicateZeros {
    @Test
    void test0() {
        int[] array = {4, 0, 7, 0};

        DuplicateZeros.duplicateZeros(array);

        assertArrayEquals(new int[]{4,0,0,7}, array);
    }

    @Test
    void test1() {
        int[] array = {4, 1, 1};

        DuplicateZeros.duplicateZeros(array);

        assertArrayEquals(new int[]{4, 1, 1}, array);
    }

    @Test
    void test2() {
        int[] array = {4, 0, 1};

        DuplicateZeros.duplicateZeros(array);

        assertArrayEquals(new int[]{4, 0, 0}, array);
    }

    @Test
    void test3() {
        int[] array = {0, 0, 1};

        DuplicateZeros.duplicateZeros(array);

        assertArrayEquals(new int[]{0, 0, 0}, array);
    }

    @Test
    void test4() {
        int[] array = {4, 0, 0, 8, 7};

        DuplicateZeros.duplicateZeros(array);

        assertArrayEquals(new int[]{4, 0, 0, 0, 0}, array);
    }
}
