// Last updated: 8/4/2025, 4:51:04 PM
class State {
    int row;
    int col;
    int distance;

    State(int i, int j, int dist) {
        row = i;
        col = j;
        distance = dist;
    }
}

class Solution {
    public int getFood(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        Queue<State> queue = new LinkedList<>();
        boolean[][] status = new boolean[n][m];
        int[][] DIRECTIONS = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};


        for (int i = 0 ; i < n ; i++) {
            for (int j = 0 ; j < m ; j++) {
                if (grid[i][j] == '*') {
                    queue.add(new State(i, j, 0));
                    status[i][j] = true;
                    break;
                }
            }
        }

        while (!queue.isEmpty()) {
            State poppedElement = queue.poll();
            int row = poppedElement.row;
            int col = poppedElement.col;
            int distance = poppedElement.distance;

            if (grid[row][col] == '#') {
                return distance;
            }

            for (int[] direction: DIRECTIONS) {
                int adjRow = row + direction[0];
                int adjCol = col + direction[1];

                if (
                    isValid(adjRow, adjCol, n, m) && 
                    grid[adjRow][adjCol] != 'X' &&
                    !status[adjRow][adjCol]
                ) {
                    queue.add(new State(adjRow, adjCol, distance + 1));
                    status[adjRow][adjCol] = true;
                }

            }
        }
        

        return -1;
    }

    private boolean isValid(int r, int c, int n, int m) {
        return (r >= 0 && r < n && c >= 0 && c < m);
    }
}