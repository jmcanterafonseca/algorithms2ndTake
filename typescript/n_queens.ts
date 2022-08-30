// Calculate all the possible ways of arranging N Queens in a NxN chess board

// Each solution is determined by the position of the queen on a column as there should be one queen per row

const CHESS_BOARD_SIZE = 8;

const result: Array<number>[] = [];

function placeQueens(row: number, boardState: Array<number>, result: Array<number>[]) {
    if (row === CHESS_BOARD_SIZE) {
        result.push(JSON.parse(JSON.stringify(boardState)));
        return;
    }

    for (let col = 0; col < CHESS_BOARD_SIZE; col++) {
            if (isValid(boardState, row, col)) {
                boardState[row] = col;
                placeQueens(row + 1, boardState, result);
            }
        }
    }
}

// columns contains an element per row and that element indicates
// which column of each row is occupied by a queen
// Check if with the current state of the board a queen can be placed on (row1, col1)
function isValid(boardState: Array<number>, row1: number, col1: number): boolean {
    // It is needed to check the previous rows
    for (let row2 = 0; row2 < row1; row2++) {
        // In which column is in row2 the queen
        const col2 = boardState[row2];

        if (col2 === col1) {
            return false;
        }

        const colDistance = Math.abs(col1 - col2);
        const rowDistance = Math.abs(row1 - row2);

        if (colDistance === rowDistance) {
            return false;
        }
    }

    return true;
}

const boardState: Array<number> = [];
placeQueens(0, boardState, result);
console.log(result);
