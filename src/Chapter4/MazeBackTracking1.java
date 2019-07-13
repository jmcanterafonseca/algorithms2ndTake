package Chapter4;

// The rat can move in the maze downwards and forwards
// Implements a basic Dynamic Programming Backtracking Algorithm
// in which recursively we are trying to find a path from start to end
// The path found is not necessarily the shortest path
// To find the shortest path we would need to use a A* algorithm
// Returns null if no path exist between start point and end point
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
        boolean foundPath = false;

        if (canMove(start.x, start.y, maze)) {
            solution[start.x][start.y] = 1;

            if (start.x == end.x && start.y == end.y) {
                return true;
            }

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
        boolean out = false;

        if (x < maze.length && y < maze.length) {
            out = (maze[x][y] == 1);
        }

        return out;
    }

    public static class Point {
        public int x;
        public int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
