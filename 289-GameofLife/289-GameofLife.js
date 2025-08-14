// Last updated: 8/14/2025, 6:31:02 AM
/**
 * @param {number[][]} board
 * @return {void} Do not return anything, modify board in-place instead.
 */

class Computed {
    constructor(type, live, dead) {
        this.live = live;
        this.dead = dead;
        this.type = type;
    }
}

const TypeOfCell = {
    LIVE: 'L',
    DEAD: 'D'
}

const DIRECTIONS = [[0, 1], [1, 0], [-1, 0], [0, -1], [-1, -1], [1, 1], [-1, 1], [1, -1]];

var gameOfLife = function(board) {
    const map = new Map();

    function computeNeighbours(r, c) {
        let typeOfCell = board[r][c] === 0 ? TypeOfCell.DEAD : TypeOfCell.LIVE;
        let liveCells = 0;
        let deadCells = 0;

        for (let direction of DIRECTIONS) {
            let neighbourRow = r + direction[0];
            let neighbourCol = c + direction[1];

            if (isValid(neighbourRow, neighbourCol)) {
                if (board[neighbourRow][neighbourCol] === 0) {
                    deadCells++;
                } else {
                    liveCells++;
                }
            }
        }

        return new Computed(typeOfCell, liveCells, deadCells);
        
    }

    // isValid function
    function isValid(row, col) {
        return row >= 0 && row < board.length && col >= 0 && col < board[0].length;
    }


    for (let i = 0 ; i < board.length ; i ++) {
        for (let j = 0 ; j < board[0].length ; j ++) {
            map.set([i, j], computeNeighbours(i, j));
        }
    }

    // console.log(map);


    // Apply rules

    for (const [key, val] of map) {
        const cellRow = key[0];
        const cellCol = key[1];

        const typeOfCell = val.type;
        const liveCells = val.live;
        const deadCells = val.dead;

        if (typeOfCell === TypeOfCell.LIVE) {
            if (liveCells < 2 || liveCells > 3) {
                board[cellRow][cellCol] = 0;
            } else if (liveCells === 2 || liveCells === 3) {
                continue;
            }
        } else {
            if (liveCells === 3) {
                board[cellRow][cellCol] = 1;
            }
        }
    }


};

/*
Live - 1
Dead - 0

Eight neighbours

(0,0) - live: 1, dead: 2
(1,0) - live: 1, dead: 4
*/

