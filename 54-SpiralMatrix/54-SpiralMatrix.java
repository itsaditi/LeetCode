class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();

        int rows = matrix.length;
        int cols = matrix[0].length;

        // Boundaries
        int up = 0;
        int down = rows - 1;
        int left = 0;
        int right = cols - 1;

        int resExpectedLength = rows * cols;

        while (res.size() < resExpectedLength) {
            // Traverse left to right
            for (int col = left; col <= right; col ++) {
                res.add(matrix[up][col]);
            }

            // Traverse Top to Bottom
            for (int row = up + 1; row <= down; row++) {
                res.add(matrix[row][right]);
            }

            // Traverse Right to left
            if (up != down) {
                for (int col = right - 1; col >= left; col --) {
                    res.add(matrix[down][col]);
                }
            }

            // Traverse Bottom to Top
            if (right != left) {
                for(int row = down - 1; row > up; row--) {
                    res.add(matrix[row][left]);
                }
            }

            up++;
            down--;
            left++;
            right--;  
        }
        return res;
    }
}