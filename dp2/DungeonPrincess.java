public class DungeonPrincess {
    public static void main(String args[]) {
        // int[][] grid = { { 1, 3, 1 }, { 1, 5, 1 }, { 4, 2, 1 } };
        // int[][] grid = { { -2,-3,3},{-5,-10,1},{10,30,-5 } };
        // int[][] grid = {{-3,5}};
        // int[][]grid={{1},{-2},{1}};
        int[][] grid={{1,-4,5,-99},{2,-2,-2,-1}};
        // int[][] grid={{1,-2,3},{2,-2,-2}};
        // int[][] grid = { { 3, 0, -3 }, { -3, -2, -2 }, { 3, 1, -3 } };
        // int[][] grid = {{ 1, -3, 2 },{ 0, -1, 2 },{ 0, 0, -2 } };
        // int[][] grid={{101}};
        // int[][] grid={{2},{1}};
        System.out.println(calculateMinimumHP(grid));
    }

    public static int calculateMinimumHP(int[][] dungeon) {
        int rows = dungeon.length;
        int cols = dungeon[0].length;
        int originalStart = dungeon[0][0];

        dungeon[rows-1][cols-1] = dungeon[rows-1][cols-1] >= 0 ? 0 : dungeon[rows-1][cols-1];
        for (int i = rows - 2; i >= 0; i--) {
            dungeon[i][cols-1] = Math.min(0, dungeon[i+1][cols-1] + dungeon[i][cols-1]);
        }
        for (int i = cols - 2; i >= 0; i--) {
            dungeon[rows - 1][i] = Math.min(0, dungeon[rows-1][i]+dungeon[rows-1][i+1]);
        }

        for (int i = rows - 2; i >= 0; i--) {
            for (int j = cols - 2; j >= 0; j--) {
                dungeon[i][j] = Math.min(0, dungeon[i][j] + Math.max(dungeon[i][j+1], dungeon[i+1][j]));
            }
        }
        int ans = 0;
        if (dungeon[0][0] < 0) {
            ans = Math.abs(dungeon[0][0]) + 1;
        }
        // else if (dungeon[0][0] == 0) {
        //     ans = 1;
        // }
        else {
            ans = originalStart < 0 ? Math.abs(originalStart) + 1 : 1;
        }
        return ans;
    }
}
