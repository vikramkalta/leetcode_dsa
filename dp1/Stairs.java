import java.util.ArrayList;

public class Stairs {
    public static void main(String args[]) {
        System.out.println(climbStairs(5));
    }
    public static int climbStairs(int n) {
        ArrayList<Integer> dp = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            dp.add(-1);
        }
        return stairs(n, dp);
    }

    public static int stairs(int n, ArrayList<Integer> dp) {
        if (n <= 2) {
            return n;
        }
        if (dp.get(n-1)!=-1) {
            return dp.get(n-1);
        }
        int x = stairs(n-2, dp);
        int y = stairs(n-1, dp);
        int z = x+y;
        dp.set(n-1, z);
        return stairs(n - 2, dp) + stairs(n - 1, dp);
    }
}
