import java.util.ArrayList;

public class UniquePaths2 {
    public static void main(String args[]) {
        // int[][] arr = { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } };
        int[][] arr = {{0,0},{1,1},{0,0}};
        // int[][] arr = {
        // {0,0,0,0},
        // {0,1,0,0},
        // {0,0,0,0},
        // {0,0,1,0},
        // {0,0,0,0}};
        // int[][] arr = {
        // {0,0,0,0,0},
        // {0,0,0,0,1},
        // {0,0,0,1,0},
        // {0,0,1,0,0}
        // };
        // int[][] arr = {
        //     { 0, 0, 0, 0, 0 },
        //     { 0, 0, 0, 0, 1 },
        //     { 0, 0, 0, 1, 0 },
        //     { 0, 0, 0, 0, 0 } };
        ArrayList<ArrayList<Integer>> A = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            ArrayList<Integer> innerList = new ArrayList<>();
            for (int j = 0; j < arr[i].length; j++) {
                innerList.add(arr[i][j]);
            }
            A.add(innerList);
        }
        System.out.println(uniquePathsWithObstacles(arr));
    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int rows = obstacleGrid.length;
        int cols = obstacleGrid[0].length;
        if (obstacleGrid[0][0] == 1 || obstacleGrid[rows - 1][cols - 1] == 1) {
            return 0;
        }
        obstacleGrid[0][0] = 1;
        for (int i = 1; i < rows; i++) {
            if (obstacleGrid[i][0] == 1 || obstacleGrid[i - 1][0] == -1) {
                obstacleGrid[i][0] = -1;
            } else {
                obstacleGrid[i][0] = 1;
            }
        }
        for (int i = 1; i < cols; i++) {
            if (obstacleGrid[0][i] == 1 || obstacleGrid[0][i - 1] == -1) {
                obstacleGrid[0][i] = -1;
            } else {
                obstacleGrid[0][i] = 1;
            }
        }
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (obstacleGrid[i][j] == 1) {
                    obstacleGrid[i][j] = -1;
                }
            }
        }
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (obstacleGrid[i][j] == -1) {
                    continue;
                }
                if (obstacleGrid[i-1][j] == -1) {
                    obstacleGrid[i][j] = obstacleGrid[i][j-1];
                } else if (obstacleGrid[i][j-1] == -1) {
                    obstacleGrid[i][j] = obstacleGrid[i-1][j];
                } else {
                    obstacleGrid[i][j] = obstacleGrid[i-1][j] + obstacleGrid[i][j-1];
                }
            }
        }
        return obstacleGrid[rows-1][cols-1] == -1 ? 0 : obstacleGrid[rows-1][cols-1];
    }

    public static int uniquePathsWithObstacles1(int[][] obstacleGrid) {
        ArrayList<ArrayList<Integer>> A = new ArrayList<>();
        int rows = obstacleGrid.length;
        int cols = obstacleGrid[0].length;
        if (obstacleGrid[0][0] == 1 || obstacleGrid[rows - 1][cols - 1] == 1) {
            return 0;
        }
        int blockedCol = 0, blockedRow = 0;
        for (int i = 0; i < rows; i++) {
            ArrayList<Integer> innerList = new ArrayList<>();
            int blockerCount = 0;
            for (int j = 0; j < cols; j++) {
                if (obstacleGrid[i][j] == 1) {
                    if (i == rows - 1) {
                        blockedRow = 1;
                    }
                    if (j == cols - 1) {
                        blockedCol = 1;
                    }
                    blockerCount++;
                    innerList.add(-1);
                } else if (i == rows - 1) {
                    innerList.add(1);
                } else if (j == cols - 1) {
                    innerList.add(1);
                } else {
                    innerList.add(obstacleGrid[i][j]);
                }
            }
            if (blockerCount == cols) {
                return 0;
            }
            A.add(innerList);
        }
        if (blockedRow == 1 && blockedCol == 1) {
            return 0;
        }
        for (int i = rows - 2; i >= 0; i--) {
            for (int j = cols - 2; j >= 0; j--) {
                if (A.get(i).get(j) == -1) {
                    continue;
                }
                int down = A.get(i + 1).get(j);
                int right = A.get(i).get(j + 1);
                if (down == -1 && right == -1) {
                    A.get(i).set(j, 0);
                } else if (down == -1) {
                    A.get(i).set(j, right);
                } else if (right == -1) {
                    A.get(i).set(j, down);
                } else {
                    A.get(i).set(j, down + right);
                }
            }
        }
        // for (int i = 0; i < rows; i++) {
        // System.out.println(A.get(i));
        // }

        return A.get(0).get(0);
    }
}
