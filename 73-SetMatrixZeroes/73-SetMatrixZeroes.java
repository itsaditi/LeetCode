class Solution {
    int n = 0, m = 0;
    public void setZeroes(int[][] matrix) {
        n = matrix.length;
        m = matrix[0].length;

        if (n == 1 && m == 1) return;

        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();

        for (int i = 0 ; i < n ; i++) {
            for (int j = 0 ; j < m ; j++) {
                if (matrix[i][j] == 0) {
                    queue.add(new Pair(i, j));
                }
            }
        }

        while (!queue.isEmpty()) {
            Pair<Integer, Integer> poppedElement = queue.poll();
            int r = poppedElement.getKey();
            int c = poppedElement.getValue();

            for (int i = 0 ; i <= n; i ++) {
                matrix[i % n][c] = 0;
            }

            for (int i = 0 ; i <= m; i ++) {
                matrix[r][i % m] = 0;
            }
        }
    }

}