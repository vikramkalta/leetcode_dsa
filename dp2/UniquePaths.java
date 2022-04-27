import java.util.ArrayList;

public class UniquePaths {
    public static void main(String args[]) {
        int m = 3; int n = 7;
        System.out.println(uniquePaths(m, n));
    }

    public static int uniquePaths(int m, int n) {
        ArrayList<ArrayList<Integer>> dp = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            ArrayList<Integer>innerList = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if (i == m-1) {
                    innerList.add(1);
                } else if (j == n - 1) {
                    innerList.add(1);
                } else {
                    innerList.add(0);
                }
            }
            dp.add(innerList);
        }
        for (int i = m-2; i>=0; i--) {
            for (int j = n-2; j>=0; j--) {
                int ways = dp.get(i+1).get(j) + dp.get(i).get(j+1);
                dp.get(i).set(j, ways);
            }
        }
        return dp.get(0).get(0);
    }
}