class Solution {
    public String convert(String s, int numRows) {

        if (s.length() == 1 || numRows == 1) return s;
        
        int stringLen = s.length();
        Character[][] matrix = new Character [numRows][stringLen];
        int stringIterator = 0;
        int row = 0;
        int col = 0;
        String res = "";
        boolean incrementRow = false;
        boolean decrementRow = false;

        while (stringIterator != stringLen) {
            matrix[row][col] = s.charAt(stringIterator);

            if (row == 0) {
                incrementRow = true;
                decrementRow = false;
            } else if (row == numRows - 1) {
                decrementRow = true;
                incrementRow = false;
            }

            if (incrementRow) {
                row ++;
            } else if (decrementRow) {
                row--;
                col ++;
            }
            stringIterator ++;
        }

        for (int i = 0 ; i < numRows ; i ++) {
            for (int j = 0 ; j <= col ; j ++) {
                if (matrix[i][j] != null) 
                    res += matrix[i][j];
            }
        }
        
        
        

        return res;
    }
}