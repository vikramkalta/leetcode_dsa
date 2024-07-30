import java.util.ArrayList;

public class MinPathSum {
    public static void main(String args[]) {
        // int[][] grid = { { 1, 3, 1 }, { 1, 5, 1 }, { 4, 2, 1 } };
        int[][] grid = { { 1, 2, 3 }, { 4, 5, 6 } };
        System.out.println(minPathSum(grid));
    }

    public static int minPathSum(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        for (int i = rows - 2; i >= 0; i--) {
            grid[i][cols - 1] = grid[i + 1][cols - 1] + grid[i][cols - 1];
        }
        for (int i = cols - 2; i >= 0; i--) {
            grid[rows - 1][i] = grid[rows - 1][i + 1] + grid[rows - 1][i];
        }
        for (int i = rows - 2; i >= 0; i--) {
            for (int j = cols - 2; j >= 0; j--) {
                int rightSum = grid[i][j] + grid[i][j + 1];
                int bottomSum = grid[i][j] + grid[i + 1][j];
                grid[i][j] = Math.min(rightSum, bottomSum);
            }
        }
        return grid[0][0];
    }

    public static int sum = 0;

    public static void getMinPathSum(int[][] grid, int i, int j, ArrayList<ArrayList<Integer>> dp) {
        if (i >= grid.length || j >= grid[0].length) {
            return;
        }
        sum += grid[i][j];
        dp.get(i).set(j, Math.min(dp.get(i).get(j), sum));
        getMinPathSum(grid, i + 1, j, dp);
        getMinPathSum(grid, i, j + 1, dp);
        sum -= grid[i][j];
    }
}
