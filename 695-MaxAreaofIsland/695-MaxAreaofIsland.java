class Solution {
    int maxArea = 0;
    int area = 0;
    int row = 0, col = 0;
    public int maxAreaOfIsland(int[][] grid) {
        row = grid.length;
        col = grid[0].length;
        for (int i = 0 ; i < grid.length ; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    area = 0;
                    bfs(grid, i, j);
                    maxArea = Math.max(area, maxArea);
                }
            }
        }
        return maxArea;
    }

    private void bfs(int[][] grid, int i, int j) {
        if ((i < 0 || i >= row) || (j < 0 || j >= col)) return;

        if (grid[i][j] == 0) return;

        if (grid[i][j] == 1){
            grid[i][j] = 0;
            area++;
        }
        

        bfs(grid, i + 1, j);
        bfs(grid, i, j + 1);
        bfs(grid, i - 1, j);
        bfs(grid, i, j - 1);

        return;
    }
}