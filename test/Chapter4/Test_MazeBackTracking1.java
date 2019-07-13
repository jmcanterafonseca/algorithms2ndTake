package Chapter4;

import org.junit.jupiter.api.Test;

import static Chapter4.MazeBackTracking1.Point;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class Test_MazeBackTracking1 {
    // Example taken from https://www.geeksforgeeks.org/rat-in-a-maze-backtracking-2/
    private int[][] maze = {
            {1, 0, 0, 0},
            {1, 1, 0, 1},
            {0, 1, 0, 0},
            {1, 1, 1, 1}
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

        int[][] result = MazeBackTracking1.solution(start, end, maze);

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

        int[][] result = MazeBackTracking1.solution(start, end, maze);

        assertArrayEquals(expectedResult, result);
    }

    @Test
    public void test3() {
        Point start = new Point(0, 0);
        Point end = new Point(2, 2);

        int[][] result = MazeBackTracking1.solution(start, end, maze);

        assertNull(result);
    }
}
