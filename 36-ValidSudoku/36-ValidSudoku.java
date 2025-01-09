class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashMap<Integer, HashSet<Character>> map = new HashMap<>();

        for (int i = 0 ; i < board.length ; i++) {
            Set<Character> val = new HashSet<>();
            for (int j = 0; j < board[0].length ; j++) {
                char ch = board[i][j];

                // MOST IMPORTANT PIECE
                int index = (i / 3) * 3 + j / 3;

                if (!map.containsKey(index)) map.put(index, new HashSet<>());

                if (ch != '.') {
                    if (val.contains(ch)) return false;
                    val.add(ch);

                    if (map.get(index).contains(ch)) return false;

                    map.get(index).add(ch);
                }

                
            }
            
        }

        for (int i = 0 ; i < board.length ; i++) {
            Set<Character> val = new HashSet<>();
            for (int j = 0; j < board[0].length ; j++) {
                char ch = board[j][i];
                if (ch != '.') {
                    if (val.contains(ch)) return false;
                    val.add(ch);
                }
            }
        }

        return true;

    }
}