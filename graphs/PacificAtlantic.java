import java.util.ArrayList;
import java.util.List;

public class PacificAtlantic {
    public static void main(String[] args) {
        int[][] heights = new int[][] {
                { 1, 2, 2, 3, 5 },
                { 3, 2, 3, 4, 4 },
                { 2, 4, 5, 3, 1 },
                { 6, 7, 1, 4, 5 },
                { 5, 1, 1, 2, 4 }
        };
        // int[][] heights = new int[][] {
        // { 1, 2, 2, 3 },
        // { 3, 2, 3, 4 },
        // { 2, 4, 5, 3 },
        // { 6, 7, 1, 4 }
        // };
        System.out.println(pacificAtlantic(heights));
    }

    public static List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        int rows = heights.length;
        int cols = heights[0].length;
        int[][] visited1 = new int[rows][cols];
        int[][] visited2 = new int[rows][cols];
        for (int i = 0; i < cols; i++) {
            dfs(heights, rows, cols, 0, i, visited1);
            dfs(heights, rows, cols, rows - 1, i, visited2);
        }
        for (int i = 0; i < rows; i++) {
            dfs(heights, rows, cols, i, 0, visited1);
            dfs(heights, rows, cols, i, cols - 1, visited2);
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (visited1[i][j] == 1 && visited2[i][j] == 1) {
                    // System.out.println("i: " + i + " " + "j: " + j);
                    List<Integer> innerList = new ArrayList<>();
                    innerList.add(i);
                    innerList.add(j);
                    result.add(innerList);
                }
            }
        }
        return result;
    }

    public static void dfs(int[][] heights, int rows, int cols, int row, int col, int[][] visited) {
        visited[row][col] = 1;
        int[] dirI = { -1, 0, 1, 0 };
        int[] dirJ = { 0, 1, 0, -1 };

        for (int dir = 0; dir < 4; dir++) {
            int iDir = row + dirI[dir];
            int jDir = col + dirJ[dir];

            if (isValid(iDir, jDir, rows, cols) && visited[iDir][jDir] == 0
                    && heights[iDir][jDir] >= heights[row][col]) {
                dfs(heights, rows, cols, iDir, jDir, visited);
            }
        }
    }

    public static List<List<Integer>> pacificAtlantic1(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        int rows = heights.length;
        int cols = heights[0].length;
        int[][] visited = new int[rows][cols];
        int[][][] reachOcean = new int[rows][cols][2];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                visited[i][j] = -1;
                reachOcean[i][j][0] = -1;
                reachOcean[i][j][1] = -1;
            }
        }
        reachOcean[0][rows - 1][0] = 1;
        reachOcean[0][rows - 1][1] = 1;
        reachOcean[cols - 1][0][0] = 1;
        reachOcean[cols - 1][0][1] = 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (visited[i][j] == -1) {
                    dfs(heights, rows, cols, i, j, visited);
                }
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (reachOcean[i][j][0] == 1 && reachOcean[i][j][1] == 1) {
                    System.out.println("i: " + i + " and " + j);
                }
            }
        }
        return result;
    }

    public static void dfs1(int[][] heights, int rows, int cols, int row, int col, int[][] visited,
            int[][][] reachOcean) {
        visited[row][col] = 1;
        int[] dirI = { -1, 0, 1, 0 };
        int[] dirJ = { 0, 1, 0, -1 };

        for (int dir = 0; dir < 4; dir++) {
            int iDir = row + dirI[dir];
            int jDir = col + dirJ[dir];

            if (isValid(iDir, jDir, rows, cols) && visited[iDir][jDir] == -1
                    && heights[iDir][jDir] <= heights[row][col]) {
                if (reachOcean[iDir][jDir][0] == 1 && reachOcean[iDir][jDir][1] == 1) {
                    reachOcean[row][col][0] = 1;
                    reachOcean[row][col][1] = 1;
                    continue;
                }
                if (iDir == 0 || jDir == 0) {
                    reachOcean[row][col][0] = 1;
                }
                if (iDir == rows - 1 || jDir == cols - 1) {
                    reachOcean[row][col][1] = 1;
                }
                dfs1(heights, rows, cols, iDir, jDir, visited, reachOcean);
            }
        }
    }

    public static boolean isValid(int i, int j, int rows, int cols) {
        return i >= 0 && j >= 0 && i < rows && j < cols;
    }
}