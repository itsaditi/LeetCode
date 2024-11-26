class Solution {
    int row = 0, col = 0;
    String mainWord;
    boolean wordFound = false;
    public boolean exist(char[][] board, String word) {
        mainWord =  word;
        row = board.length;
        col = board[0].length;

        for(int i = 0 ; i < board.length ; i ++) {
            for (int j = 0 ; j < board[0].length ; j ++) {
                if (backtrack(board, i, j, 0)) return true;

                // bfs(board, i, j, new HashSet<String>(), "");
                // if (wordFound) break;
            }
        }
        return false;
    }
    private boolean backtrack(
        char[][] board,
        int i,
        int j,
        int index
    ) {
        if(index >= mainWord.length()) return true;

        if (
            (i < 0 || i >= row) || 
            (j < 0 || j >= col) ||
            (board[i][j] != mainWord.charAt(index))
        ) return false;

        // Mark visited
        board[i][j] = '#';

        boolean res = false;
        int[] rowOffSet = {0, 1, 0, -1};
        int[] colOffSet = {1, 0, -1, 0};
        for (int d = 0 ; d < 4 ; d++) {
            res = backtrack(
                board,
                i + rowOffSet[d],
                j + colOffSet[d],
                index + 1
            );
            if (res) break;
        }

        board[i][j] = mainWord.charAt(index);
        return res;

    }

    // Time Limit Exceed
    // private void bfs(char[][] board, int i, int j, HashSet<String> visited, String traversedWord) {
    //     if ((i < 0 || i >= row) || (j < 0 || j >= col)) return;

    //     if (visited.contains(String.valueOf(i) +  String.valueOf(j))) {
    //         return;
    //     }

    //     traversedWord += board[i][j];
    //     visited.add(String.valueOf(i) +  String.valueOf(j));

    //     if (traversedWord.equals(mainWord) || traversedWord.contains(mainWord)) {

    //         wordFound = true;
    //         return;
    //     }

    //     if (!wordFound) bfs(board, i + 1, j, new HashSet<String>(visited), traversedWord);
    //     if (!wordFound) bfs(board, i - 1, j, new HashSet<String>(visited), traversedWord);
    //     if (!wordFound) bfs(board, i, j + 1, new HashSet<String>(visited), traversedWord);
    //     if (!wordFound) bfs(board, i, j - 1, new HashSet<String>(visited), traversedWord);

    //     return;

    // }
}