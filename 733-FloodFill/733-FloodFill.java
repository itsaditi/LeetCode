class Solution {
    int m = 0, n = 0;
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        /**Plan - BFS with Queue
         * 1. Maintain a queue starting with image[sr][sc]
         * 2. Pop first element -
         *      a. Put its adjacent elements in the queue
         *      b. Update popped element with color value
         */
        if (image[sr][sc] == color) {
            return image;
        }
        int prevColor = image[sr][sc];
        m = image.length;
        n = image[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int[][] directions = new int[][]{{0, -1}, {-1, 0}, {1, 0}, {0, 1}};
        queue.add(new int[]{sr, sc});
                System.out.print(queue);

        while (!queue.isEmpty()) {
            int[] topElement = queue.poll();

            for (int[] direction: directions) {
                int row = topElement[0] + direction[0];
                int col = topElement[1] + direction[1];
                if (isCoorValid(row, col) && image[row][col] == prevColor) {
                    queue.add(new int[]{row, col});
                }                
            }
            image[topElement[0]][topElement[1]] = color;
        }
        return image;
    }

    private boolean isCoorValid(int row, int col) {
        return (row >= 0 && row < m) && (col >= 0 && col < n);
    }
}