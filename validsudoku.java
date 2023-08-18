class Solution {
    public boolean isValidSudoku(char[][] board) {

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.'){
                    char num = board[i][j];
                    board[i][j] = '.';
                    if (isvalid(board, i, j, num) == false) {
                        return false;
                    }
                    board[i][j] = num;
                }
                
            }
        }
        return true;

    }

    public boolean isvalid(char[][] board, int row, int col, char num) {
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == num) {
                return false;
            }
        }

        for (int i = 0; i < 9; i++) {
            if (board[row][i] == num) {
                return false;
            }
        }

        int mainboxrow = row / 3 * 3;
        int mainboxcol = col / 3 * 3;

        for (int i = mainboxrow; i < mainboxrow + 3; i++) {
            for (int j = mainboxcol; j < mainboxcol + 3; j++) {
                if (board[i][j] == num) {
                    return false;
                }
            }
        }

        return true;
    }
}
