package Chapter4;

// The rat can move in the maze downwards and forwards
public class MazeBackTracking1 {
    public static int[][] solution(Point start, Point end, int[][] maze) {
        int[][] out = new int[maze.length][maze.length];

        if (move(start, end, maze, out)) {
            return out;
        } else {
            return null;
        }

    }

    private static boolean move(Point start, Point end, int[][] maze, int[][] solution) {
        if (start.x == end.x && start.y == end.y) {
            solution[start.x][start.y] = 1;
            return true;
        }

        boolean foundPath = false;

        if (canMove(start.x, start.y, maze)) {
            solution[start.x][start.y] = 1;


            foundPath = move(new Point(start.x + 1, start.y), end, maze, solution);

            if (!foundPath) {
                foundPath = move(new Point(start.x, start.y + 1), end, maze, solution);
            }

            if (!foundPath) {
                // Backtracking is done
                solution[start.x][start.y] = 0;
            }
        }

        return foundPath;
    }

    // Returns true if the rat can move from position x to position y
    private static boolean canMove(int x, int y, int[][] maze) {
        return maze[x][y] == 1;
    }

    private static class Point {
        public int x;
        public int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
