public class SurroundedRegion {
    public static void main(String[] args) {
        char[][] board = {
                { 'X', 'X', 'X', 'X' },
                { 'X', 'O', 'O', 'X' },
                { 'X', 'X', 'O', 'X' },
                { 'X', 'O', 'X', 'X' } };
        // char[][] board = {
        // {'O','X','X','O','X'},
        // {'X','O','O','X','O'},
        // {'X','O','X','O','X'},
        // {'O','X','O','O','O'},
        // {'X','X','O','X','O'}
        // };
        // char[][] board = {
        // { 'O', 'O', 'O', 'O', 'X', 'X' },
        // { 'O', 'O', 'O', 'O', 'O', 'O' },
        // { 'O', 'X', 'O', 'X', 'O', 'O' },
        // { 'O', 'X', 'O', 'O', 'X', 'O' },
        // { 'O', 'X', 'O', 'X', 'O', 'O' },
        // { 'O', 'X', 'O', 'O', 'O', 'O' }
        // };
        solve(board);
        System.out.println();
    }

    public static void solve(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        int[][] visited = new int[rows][cols];
        for (int i = 0; i < cols; i++) {
            if (board[0][i] == 'O' && visited[0][i] == 0) {
                dfs(board, 0, i, visited, rows, cols);
            }
        }
        for (int i = 0; i < cols; i++) {
            if (board[rows - 1][i] == 'O' && visited[rows - 1][i] == 0) {
                dfs(board, rows - 1, i, visited, rows, cols);
            }
        }
        for (int i = 0; i < rows; i++) {
            if (board[i][0] == 'O' && visited[i][0] == 0) {
                dfs(board, i, 0, visited, rows, cols);
            }
        }
        for (int i = 0; i < rows; i++) {
            if (board[i][cols-1] == 'O' && visited[i][cols-1] == 0) {
                dfs(board, i, cols - 1, visited, rows, cols);
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == '+') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    public static void dfs(char[][] board, int row, int col, int[][] visited, int rows, int cols) {
        visited[row][col] = 1;
        board[row][col] = '+';
        int[] _rows = { -1, 0, 1, 0 };
        int[] _cols = { 0, 1, 0, -1 };
        for (int i = 0; i < 4; i++) {
            int nRow = row + _rows[i];
            int nCol = col + _cols[i];
            if (checkInside(nRow, nCol, rows, cols) && visited[nRow][nCol] == 0 && board[nRow][nCol] == 'O') {
                dfs(board, nRow, nCol, visited, rows, cols);
            }
        }
    }

    public static boolean checkInside(int row, int col, int rows, int cols) {
        return row < rows && col < cols && row >= 0 && col >= 0;
    }
}
