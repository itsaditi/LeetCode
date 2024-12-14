    private static final int[] d = {0, 1, 0, -1, 0};
    public int[][] highestPeak(int[][] A) {
        int m = A.length, n = A[0].length;
        Queue<int[]> q = new LinkedList<>();
        for (int r = 0; r < m; ++r) {
            for (int c = 0; c < n; ++c) {
                if (A[r][c] == 1) {
                    q.offer(new int[]{r, c}); // put its position into Queue as one of the starting points of BFS.
                }
                --A[r][c]; // Set the height to 0, the land by -1.
            }
        }
        while (!q.isEmpty()) { // BFS starts here.
            int[] pos = q.poll(); // Current position.
            int r = pos[0], c = pos[1];
            for (int k = 0; k < 4; ++k) { // Traverse its neighbors.
                int x = r + d[k], y = c + d[k + 1];
                if (0 <= x && x < m && 0 <= y && y < n && A[x][y] < 0) {
                    A[x][y] = A[r][c] + 1; // assign corresponding height value.
                    q.offer(new int[]{x, y}); // put its position into Queue for next round of BFS.
                }            
            }
        }
        return A;
    }