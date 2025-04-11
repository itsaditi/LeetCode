// Last updated: 4/11/2025, 9:47:49 AM
class Solution {
    int n = 0;
    public boolean isValidSudoku(char[][] board) {
        n = board.length;

        // Check Across

        for (int i = 0 ; i < n ; i++) {
            if (!checkAcross(board, i)) return false;
        }

        HashMap<Integer, Set<Character>> blockMap = new HashMap<>();

        for (int i = 0 ; i < n ; i++) {
            for (int j = 0 ; j < n ; j++) {
                char ch = board[i][j];
                if (ch == '.') continue;

                int blockIndex = (i / 3) * 3 + j / 3;

                if (!blockMap.containsKey(blockIndex)) {
                    blockMap.put(blockIndex, new HashSet<>());
                }

                if (blockMap.get(blockIndex).contains(ch)) {
                    return false;
                }

                blockMap.get(blockIndex).add(ch);
            }
        }

        return true;
    }

    private boolean checkAcross(char[][] board, int i) {
        HashSet<Character> vertical = new HashSet<>();

        for (int index = 0 ; index < n ; index++) {
            char ch = board[index][i];

            if (ch == '.') continue;

            if (vertical.contains(ch)) return false;

            vertical.add(ch);
        }

        HashSet<Character> horizontal = new HashSet<>();

        for (int index = 0 ; index < n ; index++) {
            char ch = board[i][index];
            if (ch == '.') continue;

            if (horizontal.contains(ch)) return false;

            horizontal.add(ch);
        }

        return true;
    }
}