package Misc;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Test_ParlorFlavours {
    @Test
    void test0() {
       int[] costs = { 1, 4, 5, 3, 2};

        ParlorFlavours.whatFlavors(costs, 4);

        assertTrue(true);
    }

    @Test
    void test1() {
        int[] costs = { 7, 2, 5, 4, 11 };

        ParlorFlavours.whatFlavors(costs, 12);

        assertTrue(true);
    }

    @Test
    void test2() {
        int[] costs = { 2, 2, 4, 3};

        ParlorFlavours.whatFlavors(costs, 4);

        assertTrue(true);
    }
}
