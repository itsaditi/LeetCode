// Last updated: 8/4/2025, 4:50:23 PM
class Solution {

    int n = 0, m = 0;

    // BFS - O(m * n)
    public int[][] highestPeak(int[][] isWater) {
        int[][] DIRECTIONS = new int[][]{{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
        n = isWater.length;
        m = isWater[0].length;

        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0 ; i < n ; i++) {
            for (int j = 0 ; j < m ; j++) {
                if (isWater[i][j] == 1) {
                    queue.add(new int[]{i,j});
                }
                isWater[i][j]--;
            }
        }

        while (!queue.isEmpty()) {
            int[] poppedElement = queue.poll();
            int r = poppedElement[0];
            int c = poppedElement[1];


            for (int[] direction: DIRECTIONS) {
                int i = r + direction[0];
                int j = c + direction[1];
                if (!isValid(i, j)) continue;
                
                if (isWater[i][j] < 0) {
                    isWater[i][j] = isWater[r][c] + 1;
                    queue.add(new int[]{i, j});
                }
            }
        }

        return isWater;
    }

    private boolean isValid(int i, int j) {
        return ((i >= 0 && i < n) && (j >= 0 && j < m));
    }

}