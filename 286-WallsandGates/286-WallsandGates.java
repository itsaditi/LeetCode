
public class State {
    public int row;
    public int col;
    public int distance;

    public State(int r, int c, int dist) {
        this.row = r;
        this.col = c;
        this.distance = dist;
    }
}

class Solution {

    int[][] DIRECTIONS = new int[][]{{0, -1}, {-1, 0}, {0, 1}, {1, 0}};

    public void wallsAndGates(int[][] rooms) {
        // Using BFS
        Queue<State> queue = new LinkedList<>();
        int m = rooms.length;
        int n = rooms[0].length;

        boolean[][] visited = new boolean[m][n];
        int[][] result = new int[m][n];

        for (int row = 0 ; row < rooms.length ; row++) {
            for (int col = 0 ; col < rooms[0].length ; col++) {
                if (rooms[row][col] == 0) {
                    queue.add(new State(row, col, 0));
                    visited[row][col] = true;
                }
            }
        }

        while (!queue.isEmpty()) {
            State poppedElem = queue.poll();
            int row = poppedElem.row;
            int col = poppedElem.col;
            int distance = poppedElem.distance;
            rooms[row][col] = distance;

            for (int[] direction: DIRECTIONS) {
                int neighbourRow = row + direction[0];
                int neighbourCol = col + direction[1];

                if (!isValid(neighbourRow, neighbourCol, m, n)) continue;

                if (visited[neighbourRow][neighbourCol]) continue;

                if (rooms[neighbourRow][neighbourCol] != -1) {
                    queue.add(new State(neighbourRow, neighbourCol, distance + 1));
                    visited[neighbourRow][neighbourCol] = true;
                }
            }
        }
    }

    private boolean isValid(int r, int c, int row, int col) {
        return (r >= 0 && r < row) && (c >= 0 && c < col);
    }
}