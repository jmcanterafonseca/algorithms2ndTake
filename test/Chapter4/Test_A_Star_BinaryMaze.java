package Chapter4;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class Test_A_Star_BinaryMaze {
    // Example taken from https://www.geeksforgeeks.org/rat-in-a-maze-backtracking-2/
    private int[][] maze = {
            {1, 0, 0, 0},
            {1, 1, 0, 1},
            {0, 1, 0, 0},
            {1, 1, 1, 1}
    };

    private int[][] complexMaze = {
            {1, 0, 1, 1, 1, 1, 0, 1, 1, 1},
            {1, 1, 1, 0, 1, 1, 1, 0, 1, 1},
            {1, 1, 1, 0, 1, 1, 0, 1, 0, 1},
            {0, 0, 1, 0, 1, 0, 0, 0, 0, 1},
            {1, 1, 1, 0, 1, 1, 1, 0, 1, 0},
            {1, 0, 1, 1, 1, 1, 0, 1, 0, 0},
            {1, 0, 0, 0, 0, 1, 0, 0, 0, 1},
            {1, 0, 1, 1, 1, 1, 0, 1, 1, 1},
            {1, 1, 1, 0, 0, 0, 1, 0, 0, 1}
    };

    @Test
    public void test1() {
        Point start = new Point(0, 0);
        Point end = new Point(3, 3);

        int[][] expectedResult = {
                {1, 0, 0, 0},
                {1, 1, 0, 0},
                {0, 1, 0, 0},
                {0, 1, 1, 1}
        };

        int[][] result = A_Star_BinaryMaze.solution(start, end, maze);

        assertArrayEquals(expectedResult, result);
    }

    @Test
    public void test2() {
        Point start = new Point(0, 0);
        Point end = new Point(3, 1);

        int[][] expectedResult = {
                {1, 0, 0, 0},
                {1, 1, 0, 0},
                {0, 1, 0, 0},
                {0, 1, 0, 0}
        };

        int[][] result = A_Star_BinaryMaze.solution(start, end, maze);

        assertArrayEquals(expectedResult, result);
    }

    @Test
    public void test3() {
        Point start = new Point(0, 0);
        Point end = new Point(2, 2);

        int[][] result = A_Star_BinaryMaze.solution(start, end, maze);

        assertNull(result);
    }

    @Test
    public void test4() {
        Point start = new Point(0, 0);
        Point end = new Point(5, 5);

        int[][] result = A_Star_BinaryMaze.solution(start, end, complexMaze);

        for (int[] arr : result) {
            System.out.println(Arrays.toString(arr));
        }

    }
}
