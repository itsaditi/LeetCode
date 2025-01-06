class Solution {
    int m = 0, n = 0;
    int minNoOfMinutes = -1;
    Queue<Pair<Integer, Integer>> queue2 = new LinkedList<>();

    int[][] directions = new int[][]{{0, -1}, {-1, 0}, {1, 0}, {0, 1}};

    public int orangesRotting(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int numOfFreshOranges = 0;
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < m ; i++) {
            for (int j = 0 ; j < n ; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new int[]{i, j, 0});
                } else if (grid[i][j] == 1) {
                    numOfFreshOranges++;
                }
            }
        }
        int numOfMinutes = -1;

        // If all cells are empty -
        if (numOfFreshOranges == 0 && queue.isEmpty()) return 0;
        

        while (!queue.isEmpty()) {
            int[] poppedElem = queue.poll();
            int r = poppedElem[0];
            int c = poppedElem[1];
            int minPassed = poppedElem[2];

            if (minPassed > numOfMinutes) numOfMinutes = minPassed;

            for (int[] direction: directions) {
                int neighborRow = r + direction[0];
                int neighborCol = c + direction[1];
                if (isValidCoor(grid, neighborRow, neighborCol)) {
                    if (grid[neighborRow][neighborCol] == 1) {
                        queue.add(new int[]{neighborRow, neighborCol, minPassed + 1});
                        grid[neighborRow][neighborCol] = 2;
                        numOfFreshOranges--;
                    }
                }
            }
        }
        return numOfFreshOranges == 0 ? numOfMinutes : -1;






    }



    public int orangesRotting__(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int numOfFreshOranges = 0;

        for (int i = 0 ; i < m ; i++) {
            for (int j = 0 ; j < n ; j++) {
                if (grid[i][j] == 2) {
                    queue2.add(new Pair(i, j));
                } else if (grid[i][j] == 1) {
                    numOfFreshOranges++;
                }
            }
        }

        // Marks the round
        queue2.add(new Pair(-1, -1));

        while(!queue2.isEmpty()) {
            Pair<Integer, Integer> poppedElem = queue2.remove();
            int row = poppedElem.getKey();
            int col = poppedElem.getValue();

            if (row == -1) {
                // Finished one round
                minNoOfMinutes ++;

                // To avoid enless loop
                if(!queue2.isEmpty()) {
                    queue2.add(new Pair(-1, -1));
                } 
            } else {
                // Process neighbors of rotten orange
                for (int[] direction: directions) {
                    int neighborRow = row + direction[0];
                    int neighborCol = col + direction[1];

                    if(isValidCoor(grid, neighborRow, neighborCol)) {
                        if (grid[neighborRow][neighborCol] == 1){
                            queue2.add(new Pair(neighborRow, neighborCol));
                            grid[neighborRow][neighborCol] = 2;
                            numOfFreshOranges --;
                        }
                    }
                }
            }
        }
        

        return numOfFreshOranges == 0 ? minNoOfMinutes : -1;
    }

    private boolean isValidCoor(int[][] grid, int i, int j) {
        return (i >= 0 && i < m) && (j >= 0 && j < n);
    }
}