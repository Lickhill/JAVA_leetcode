class Solution {
        public List<List<String>> solveNQueens(int n) {
            Character board[][] = new Character[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    board[i][j] = '.';
                }
            }

            List<List<String>> ans = new ArrayList<>();
            nqueens(board, 0, ans);
            return ans;
        }

        private static void nqueens(Character[][] board, int row, List<List<String>> st) {
            int n = board.length;
            if (row == n) {
                List<String> sen = new ArrayList<>();
                for (int i = 0; i < n; i++) {
                    String f = "";
                    for (int j = 0; j < n; j++) {
                        f += board[i][j];
                    }
                    sen.add(f);
                }
                st.add(sen);
                return;
            }

            for (int i = 0; i < n; i++) {
                if (isSafe(row, i, board)) {
                    board[row][i] = 'Q';
                    nqueens(board, row + 1, st);
                    board[row][i] = '.';
                }
            }
        }

        private static boolean isSafe(int rows, int column, Character[][] board) {
            int n = board.length;
            int row = rows;
            int col = column;

            for (int i = 0; i < n; i++)// cheecking rows
            {
                if (board[row][i] == 'Q') {
                    return false;
                }
            }

            for (int i = 0; i < n; i++)// checking cols
            {
                if (board[i][col] == 'Q') {
                    return false;
                }
            }

            row = rows;
            col = column;
            while (row >= 0 && col < n)// chechking in the north east
            {
                if (board[row][col] == 'Q')
                    return false;
                row--;
                col++;
            }

            row = rows;
            col = column;
            while (row >= 0 && col >= 0)// chechking in the north west
            {
                if (board[row][col] == 'Q')
                    return false;
                row--;
                col--;
            }

            row = rows;
            col = column;
            while (row < n && col >= 0)// chechking in the south west
            {
                if (board[row][col] == 'Q')
                    return false;
                row++;
                col--;
            }

            return true;
        }
    }
