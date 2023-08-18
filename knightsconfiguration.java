class Solution {
    public boolean checkValidGrid(int[][] grid) {

        if (grid[0][0] != 0)
            return false;

        return isavailable(grid, 0, 0, 0);
    }

    public boolean isavailable(int[][] grid, int row, int col, int num) {
        int n = grid.length;

        if (num == n * n - 1) {
            return true;
        }

        // top right
        int i = row;
        int j = col;
        i = i - 2;
        j++;
        if (i >= 0 && j < n) {

            if (grid[i][j] == num + 1) {
                System.out.println(num);

                return isavailable(grid, i, j, num + 1);
            }
        }

        // top left
        i = row;
        j = col;
        i = i - 2;
        j--;
        if (i >= 0 && j >= 0) {

            if (grid[i][j] == num + 1) {
                System.out.println(num);

                return isavailable(grid, i, j, num + 1);
            }
        }

        // bottom right
        i = row;
        j = col;
        i = i + 2;
        j++;
        if (i < n && j < n) {

            if (grid[i][j] == num + 1) {
                System.out.println(num);

                return isavailable(grid, i, j, num + 1);
            }
        }

        // bottom left
        i = row;
        j = col;
        i = i + 2;
        j--;
        if (i < n && j >= 0) {

            if (grid[i][j] == num + 1) {
                System.out.println(num);
                return isavailable(grid, i, j, num + 1);
            }
        }

        // left top
        i = row;
        j = col;
        j = j - 2;
        i--;
        if (i >= 0 && j >= 0) {

            if (grid[i][j] == num + 1) {
                System.out.println(num);

                return isavailable(grid, i, j, num + 1);
            }
        }

        // left bottom
        i = row;
        j = col;
        j = j - 2;
        i++;
        if (i < n && j >= 0) {

            if (grid[i][j] == num + 1) {
                System.out.println(num);

                return isavailable(grid, i, j, num + 1);
            }
        }

        // right top
        i = row;
        j = col;
        j = j + 2;
        i--;
        if (i >= 0 && j < n) {

            if (grid[i][j] == num + 1) {
                System.out.println(num);

                return isavailable(grid, i, j, num + 1);
            }
        }

        // right bottom
        i = row;
        j = col;
        j = j + 2;
        i++;
        if (i < n && j < n) {

            if (grid[i][j] == num + 1) {
                System.out.println(num);

                return isavailable(grid, i, j, num + 1);
            }
        }
        return false;
    }
}
