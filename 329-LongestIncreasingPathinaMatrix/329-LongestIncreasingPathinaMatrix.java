// Last updated: 5/5/2025, 4:29:18 PM
// DFS + Memoization
// Time complexity : O(mn). 
//  Each vertex/cell will be calculated once and only once, 
//  and each edge will be visited once and only once. 
//  The total time complexity is then O(V+E). 
//  V is the total number of vertices and 
//  E is the total number of edges. In our problem, O(V)=O(mn), O(E)=O(4V)=O(mn).

// Space complexity : O(mn). The cache dominates the space complexity.

class Solution {
    int m = 0, n = 0;
    int[][] DIRECTIONS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int longestIncreasingPath(int[][] matrix) {
        m = matrix.length;
        n = matrix[0].length;
        int longestIncreasingPath = 0;
        int[][] memo = new int[m][n];

        for (int i = 0 ; i < m ; i ++) {
            for (int j = 0 ; j < n ; j ++) {
                int pathLen = dfs(i, j, matrix, memo);
                longestIncreasingPath = Math.max(longestIncreasingPath, pathLen);
            }
        }
        
        return longestIncreasingPath;
    }

    private int dfs(int row, int col, int[][] matrix, int[][] memo) {
        if (memo[row][col] != 0) return memo[row][col];

        for (int[] direction: DIRECTIONS) {
            int neighbourRow = row + direction[0];
            int neighbourCol = col + direction[1];

            if (!isValid(neighbourRow, neighbourCol)) continue;

            if (matrix[neighbourRow][neighbourCol] > matrix[row][col] ) {
                memo[row][col] = Math.max(memo[row][col], dfs(neighbourRow, neighbourCol, matrix, memo));
            }
        }
        // need the incremented value immediately.
        return ++memo[row][col];
    }

    private boolean isValid(int r, int c) {
        return (r >= 0 && r < m) && (c >= 0 && c < n);
    }
}