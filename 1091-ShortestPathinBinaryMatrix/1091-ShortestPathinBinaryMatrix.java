// Last updated: 7/8/2025, 9:52:53 AM
class Solution {
    int[][] DIRECTIONS = new int[][]{{0, 1}, {0, -1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}, {1, 0}, {-1, 0},};
    int row = 0, col = 0;
    int shortDistance = Integer.MAX_VALUE;

    // BFS
    // TC - O(row  * col) (TC for BFS is O(vertices + edges))
    /** Things to remember -
     * * Use boolean array to mark nodes as visited.
     * * Mark node as visited right after adding to the queue.
     * * Check if grid value is 0 once, as enqueuing condition.
     * * Return the distance immediately upon reaching the target cell
     */

    public int shortestPathBinaryMatrix(int[][] grid) {

        row = grid.length;
        col = grid[0].length;

        if (grid[0][0] == 1 || grid[row - 1][col - 1] == 1) return -1;

        int shortestDistance = Integer.MAX_VALUE;

        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visitedDP = new boolean[row][col];

        // Start BFS from the top-left cell
        queue.add(new int[]{0, 0, 1});
        visitedDP[0][0] = true;

        while (!queue.isEmpty()) {
            int[] poppedEle = queue.poll();
            int r = poppedEle[0];
            int c = poppedEle[1];
            int distance = poppedEle[2];
    
            if (r == row - 1 && c == col - 1) {
                return distance;
            }

            for (int[] direction: DIRECTIONS) {
                int neighborRow = r + direction[0];
                int neighborCol = c + direction[1];
                if (
                    isValid(neighborRow, neighborCol) &&
                    grid[neighborRow][neighborCol] == 0 &&
                    !visitedDP[neighborRow][neighborCol]
                ) {
                    queue.add(new int[]{neighborRow, neighborCol, distance + 1});
                    visitedDP[neighborRow][neighborCol] = true;
                }
            }
            
        }

        return -1;
    }

    private boolean isValid(int i, int j) {
        return (i >= 0 && i < row) && (j >= 0 && j < col);
    }
}