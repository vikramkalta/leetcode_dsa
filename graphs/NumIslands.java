public class NumIslands {
    public static void main(String[] args) {
        // char[][] grid = {
        // { '1', '1', '1', '1', '0' },
        // { '1', '1', '0', '1', '0' },
        // { '1', '1', '0', '0', '0' },
        // { '0', '0', '0', '0', '0' }
        // };
        char[][] grid = {
                { '1', '1', '0', '0', '0' },
                { '1', '1', '0', '0', '0' },
                { '0', '0', '1', '0', '0' },
                { '0', '0', '0', '1', '1' }
        };
        System.out.println(numIslands(grid));
    }

    public static int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] visited = new int[rows][cols];

        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (visited[i][j] == 0 && grid[i][j] == '1') {
                    dfs(grid, visited, rows, cols, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    static int[] rowIs = { -1, 0, 1, 0 };
    static int[] colsJs = { 0, 1, 0, -1 };

    public static void dfs(char[][] grid, int[][] visited, int rows, int cols, int i, int j) {
        visited[i][j] = 1;
        for (int k = 0; k < 4; k++) {
            int _i = i + rowIs[k];
            int _j = j + colsJs[k];
            if (checkIfInside(rows, cols, _i, _j) && visited[_i][_j] == 0 && grid[_i][_j] == '1' ) {
                dfs(grid, visited, rows, cols, _i, _j);
            }
        }
    }

    public static boolean checkIfInside(int rows, int cols, int i, int j) {
        return i < rows && j < cols && i >= 0 && j >= 0;
    }
}
