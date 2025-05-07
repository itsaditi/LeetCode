// Last updated: 5/6/2025, 11:15:11 PM
class Solution {
    int[][] DIRECTIONS = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    int m, n, totalHouses ;
    
    // Time Complexity - O(M^2 N^2)
    // Space Complexity - O(M N)

    public int shortestDistance(int[][] grid) {
        m = grid.length;
        n = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
        totalHouses = 0;
        int shortestDistance = Integer.MAX_VALUE;

        for (int i = 0 ; i < m ; i++) {
            for (int j = 0 ; j < n ; j++) {
                if (grid[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    totalHouses++;
                }
            }
        }

        while(!queue.isEmpty()) {
            int[] poppedElement = queue.poll();

            shortestDistance = Math.min(
                shortestDistance, 
                distance(grid, poppedElement[0], poppedElement[1])
            );
        }

        
        return shortestDistance != Integer.MAX_VALUE ? shortestDistance : -1;


    }

    private int distance(int[][] grid, int row, int col) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];

        queue.offer(new int[]{row, col, 0});
        int resDistance = 0;
        int housesVisited = 0;

        while (!queue.isEmpty()) {
            int[] poppedElement = queue.poll();

            int r = poppedElement[0];
            int c = poppedElement[1];
            int distance = poppedElement[2];
        
            if (grid[r][c] == 1) {
                resDistance += distance;
                housesVisited++;
                continue;
            }

            for (int[] dir: DIRECTIONS) {
                int neighbourRow = r + dir[0];
                int neighbourCol = c + dir[1];

                if (!isValid(neighbourRow, neighbourCol)) continue;

                if (grid[neighbourRow][neighbourCol] == 2 ) continue;

                if (visited[neighbourRow][neighbourCol]) continue;

                queue.add(new int[]{neighbourRow, neighbourCol, distance + 1});
                visited[neighbourRow][neighbourCol] = true;
                
            }
        }

        return housesVisited == totalHouses ? resDistance : Integer.MAX_VALUE;
    }

    private boolean isValid(int r, int c) {
        return (r >= 0 && r < m) && (c >= 0 && c < n);
    }
}