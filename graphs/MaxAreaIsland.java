public class MaxAreaIsland {
    public static void main(String[] args) {
        int[][] grid = {
            // {0,0,1,0,0,0,0,1,0,0,0,0,0},
            // {0,0,0,0,0,0,0,1,1,1,0,0,0},
            // {0,1,1,0,1,0,0,0,0,0,0,0,0},
            // {0,1,0,0,1,1,0,0,1,0,1,0,0},
            // {0,1,0,0,1,1,0,0,1,1,1,0,0},
            // {0,0,0,0,0,0,0,0,0,0,1,0,0},
            // {0,0,0,0,0,0,0,1,1,1,0,0,0},
            // {0,0,0,0,0,0,0,1,1,0,0,0,0}
            {1,0,1},
            {1,1,1},
            {0,0,1},
        };
        System.out.println(maxAreaOfIsland(grid));
    }

   private static int count = 0;
    public static int maxAreaOfIsland(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] visited = new int[rows][cols];
        int max = 0;
        for (int i = 0; i < rows; i++) {
            for (int j =0 ; j < cols; j++){
                if (visited[i][j] == 0 && grid[i][j] == 1) {
                    count += 1;
                    dfs(grid, visited, i, j, rows, cols);
                    max = Math.max(max, count);
                    count = 0;
                }
            }
        }
        return max;
    }
    private static int[] clockIs = {-1,0,1,0};
    private static int[] clockJs = {0,1,0,-1};
    private static void dfs(int[][] grid, int[][] visited, int row, int col, int rows, int cols) {
        visited[row][col] = 1;
        for (int i = 0; i < 4; i++) {
            int newI = row + clockIs[i];
            int newJ = col + clockJs[i];
            if (isInside(newI, newJ, rows, cols) && visited[newI][newJ] == 0 && grid[newI][newJ] == 1) {
                count += 1;
                dfs(grid, visited, newI, newJ, rows, cols);
            }
        }
    }
    private static boolean isInside(int row, int col, int rows, int cols) {
        return row>=0&&row<rows&&col>=0&&col<cols;
    }
}
