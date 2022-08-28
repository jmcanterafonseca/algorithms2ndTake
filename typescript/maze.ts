const maze: number[][] = [
    [1, 1, 0, 1],
    [1, 1, 1, 0],
    [0, 1, 1, 1],
    [1, 1, 1, 1]
];

interface Point {
    r: Number;
    c: Number;
};

const path: Array<Point> = new Array();

function getPath(maze: number[][], path: Array<Point>): boolean {
    if (!Array.isArray(maze) || maze.length === 0 || !Array.isArray(maze[0]) || maze[0].length === 0) {
        return false;
    }

    const unfeasiblePoints: Set<Point> = new Set();

    return findPath(maze, maze.length - 1, maze[0].length - 1, path, unfeasiblePoints);
}

function findPath(maze: number[][], row: number, col: number, path: Array<Point>, unfeasiblePoints: Set<Point>): boolean {
    if (row < 0 || col < 0) {
        return false;
    }

    if (maze[row][col] === 0) {
        unfeasiblePoints.add({ r: row, c: col });
        return false;
    }

    if (row === 0 && col === 0) {
        return true;
    }

    // If we can find a path starting from the row above or from the col on the left
    if (!unfeasiblePoints.has({ r: row - 1, c: col }) && findPath(maze, row - 1, col, path, unfeasiblePoints) ||
        !unfeasiblePoints.has({ r: row, c: col - 1}) && findPath(maze, row, col - 1, path, unfeasiblePoints)) {
        path.push({ r: row, c: col });
        return true;
    }

    unfeasiblePoints.add({ r: row, c: col });
    return false;
}

const isTherePath = getPath(maze, path);
if (isTherePath) {
    path.unshift({ r: 0, c: 0 });
    console.log(path);
}
else {
    console.log("There is no path");
}
