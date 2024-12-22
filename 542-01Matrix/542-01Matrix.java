class State {
    int row;
    int column;
    int distance;
    State(int row, int column, int distance) {
        this.row = row;
        this.column = column;
        this.distance = distance;
    }
}

class Solution {
    int m = 0;
    int n = 0;
    
    // DP
    // TC and SC - O(n * m)
    public int[][] updateMatrix_UsingDP(int[][] mat) {
        n = mat.length;
        m = mat[0].length;

        int[][] dp = new int[n][m];

        // Create a copy of mat in dp
        for (int i = 0 ; i < n; i++) {
            for (int j = 0; j < m ; j++) {
                dp[i][j] = mat[i][j];
            }
        }

        for (int row = 0; row < n ; row++) {
            for (int col = 0 ; col < m ; col++) {
                // Do not update 0 cell
                if (dp[row][col] == 0) continue;
                int minNeighbor = n * m;

                if (row > 0) {
                    minNeighbor = Math.min(minNeighbor, dp[row - 1][col]);
                }

                if (col > 0) {
                    minNeighbor = Math.min(minNeighbor, dp[row][col - 1]);
                }

                dp[row][col] = minNeighbor + 1;
            }
        }

        for (int row = n - 1 ; row >= 0; row--) {
            for (int col = m - 1 ; col >= 0 ; col--) {
                if (dp[row][col] == 0) continue;

                int minNeighbor = n * m;
                if (row < n - 1) {
                    minNeighbor = Math.min(minNeighbor, dp[row + 1][col]);
                }

                if (col < m - 1) {
                    minNeighbor = Math.min(minNeighbor, dp[row][col + 1]);
                }

                dp[row][col] = Math.min(dp[row][col], minNeighbor + 1);
            }
        }

        return dp;
    }
 
    // BFS
    // TC and SC- O(n * m)
    public int[][] updateMatrix(int[][] mat) {
        m = mat.length;
        n = mat[0].length;
        int[][] res = new int[m][n];
        boolean[][] seen = new boolean[m][n];
        Queue<State> queue = new LinkedList<>();
        int[][] distanceMap = new int[][]{{0,1}, {1,0}, {0,-1}, {-1,0}};

        for (int i = 0 ; i < m ; i ++) {
            for (int j = 0; j < n; j ++) {
                if (mat[i][j] == 0) {
                    queue.add(new State(i, j, 0));
                    seen[i][j] = true;
                }
            }
        }

        
        while (!queue.isEmpty()) {
            State topElem = queue.remove();
            int row = topElem.row;
            int column = topElem.column;
            int distance = topElem.distance;

            for (int[]dist: distanceMap) {
                int newRow = row + dist[0];
                int newCol = column + dist[1];

                if (isValid(newRow, newCol) && !seen[newRow][newCol]) {
                    seen[newRow][newCol] = true;
                    queue.add(new State(newRow, newCol, distance + 1));
                    res[newRow][newCol] = distance + 1;
                }

            }
        }

        return res;
    }

    private boolean isValid(int row, int col) {
        return row >= 0 && row < m && col >= 0 && col < n;
    }
}