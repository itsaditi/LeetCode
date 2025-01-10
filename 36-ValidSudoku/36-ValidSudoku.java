public static boolean isValidSudoku(char[][] board) {
    int R = board.length, C = board[0].length;

    int[] cols = new int[9];
    int[] boxes = new int[9];

    for (int r = 0; r < R; r++) {
        int rowFlag = 0;

        for (int c = 0; c < C; c++) {
            char letter = board[r][c];
            if (letter == '.') continue;
            int v = letter - '0';

            // Verify row
            if (((1 << v) & rowFlag) > 0) return false;
            rowFlag |= 1 << v;

            // Verify col
            if (((1 << v) & cols[c]) > 0) return false;
            cols[c] |= (1 << v);

            // Verify box
            int boxR = r / 3, boxC = c / 3;
            int boxI = boxR * 3 + boxC;
            int boxFlag = boxes[boxI];
            if ((boxFlag & (1 << v)) > 0) return false;
            boxes[boxI] |= 1 << v;
        }
    }

    return true;
}