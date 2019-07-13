package Chapter4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

// Obtains "a close to" the shortest path in a binary maze
// It uses the A* algorithm
public class A_Star_BinaryMaze {
    // Returns a matrix with the path to be followed from
    // start to destination. null if no path exists between start and destination
    // The Rat can move in the maze in all directions
    public static int[][] solution(Point start, Point end, int[][] maze) {
        int[][] out = new int[maze.length][maze[0].length];

        NodeInfo[][] result = move(start, end, maze);

        if (result != null) {
            Point currentPoint = result[end.x][end.y].point;
            while (currentPoint != null) {
                out[currentPoint.x][currentPoint.y] = 1;
                currentPoint = result[currentPoint.x][currentPoint.y].previousPoint;
            }

            return out;
        }

        return null;
    }

    // Calculates the solution with A* algorithm using h1 heuristic
    public static NodeInfo[][] move(Point start, Point end, int[][] maze) {
        // The priority queue will allow us to process the nodes properly
        PriorityQueue<NodeInfo> pendingNodes = new PriorityQueue<>(Collections.reverseOrder());

        NodeInfo startNode = new NodeInfo(start, null, 0, h1(start,end));

        pendingNodes.add(startNode);

        boolean targetReached = false;

        NodeInfo[][] out = new NodeInfo[maze.length][maze[0].length];

        while (!pendingNodes.isEmpty() && !targetReached) {
            // Extract the first from the priority queue
            NodeInfo nodeInfo = pendingNodes.poll();

            out[nodeInfo.point.x][nodeInfo.point.y] = nodeInfo;

            if (!isTarget(nodeInfo, end)) {
                List<NodeInfo> nextNodes = generatePaths(nodeInfo, end, maze);

                for (NodeInfo nextNode : nextNodes) {
                    NodeInfo node = out[nextNode.point.x][nextNode.point.y];

                    if (node == null) {
                        pendingNodes.add(nextNode);
                        out[nextNode.point.x][nextNode.point.y] = nextNode;
                    } else {
                        if (node.f > nextNode.f) {
                            out[nodeInfo.point.x][nodeInfo.point.y] = nextNode;
                        }
                    }
                }
            } else {
                targetReached = true;
            }
        }

        if (targetReached) {
            return out;
        } else {
            return null;
        }
    }

    private static boolean isTarget(NodeInfo ni, Point goal) {
        return (ni.point.x == goal.x && ni.point.y == goal.y);
    }

    private static List<Point> checkMove(Point[] points, int[][] maze) {
        List<Point> out = new ArrayList<>();

        for (Point p : points) {
            if (canMove(p.x, p.y, maze)) {
                out.add(p);
            }
        }

        return out;
    }

    // Generates all possible paths from the referred point
    private static List<NodeInfo> generatePaths(NodeInfo ni, Point dest, int[][] maze) {
        List<NodeInfo> out = new ArrayList<>();

        Point p = ni.point;

        // The rat can move in eight directions
        Point[] pointstoBeTested = {
                new Point(p.x + 1, p.y),
                new Point(p.x - 1, p.y),
                new Point(p.x, p.y + 1),
                new Point(p.x, p.y - 1),
                new Point(p.x - 1, p.y - 1),
                new Point(p.x - 1, p.y - 1),
                new Point(p.x - 1, p.y - 1),
                new Point(p.x - 1, p.y - 1)
        };

        // New points to be generated
        List<Point> newPoints = checkMove(pointstoBeTested, maze);

        for (Point newPoint : newPoints) {
            float h = h3(newPoint, dest);
            NodeInfo newNode = new NodeInfo(newPoint, ni.point, ni.f, h);
            out.add(newNode);
        }

        return out;
    }

    // Returns true if the rat can move from position x to position y
    private static boolean canMove(int x, int y, int[][] maze) {
        boolean out = false;

        if (x>= 0 && x < maze.length && y>=0 && y < maze.length) {
            out = (maze[x][y] == 1);
        }

        return out;
    }

    // Heuristic h1 to calculate h from the start point to the end point
    // This heuristic uses the Manhattan distance
    // See https://www.geeksforgeeks.org/a-search-algorithm/
    private static float h1(Point current, Point goal) {
        return Math.abs(current.x - goal.x) + Math.abs(current.y - goal.y);
    }

    // Heuristic h2 to calculate h from the start point to the end point
    // This heuristic uses the Diagonal distance
    // See https://www.geeksforgeeks.org/a-search-algorithm/
    private static float h2(Point current, Point goal) {
        return Math.max(Math.abs(current.x - goal.x), Math.abs(current.y - goal.y));
    }

    // Heuristic h3 to calculate h from the start point to the end point
    // This heuristic uses the Euclidean distance
    // See https://www.geeksforgeeks.org/a-search-algorithm/
    private static float h3(Point current, Point goal) {
        return (float)Math.sqrt(Math.pow(current.x - goal.x, 2) + Math.pow(current.y - goal.y, 2));
    }

    private static class NodeInfo implements Comparable<NodeInfo> {
        public float f;
        public float g;
        public float h;

        public Point point;
        public Point previousPoint;


        public NodeInfo(Point point, Point previousPoint, float g, float h) {
            this.point = point;
            this.previousPoint = previousPoint;

            this.f = g + h;
            this.g = g;
            this.h = h;
        }

        public int compareTo(NodeInfo other) {
            return (int)(this.f - other.f);
        }
    }
}
