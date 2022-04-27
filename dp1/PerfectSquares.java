import java.util.ArrayList;

public class PerfectSquares {
    public static void main(String args[]) {
        System.out.println(numSquares(13));
    }
    public static int numSquares(int n) {
        if (n<=3){
            return n;
        }
        ArrayList<Integer> dp = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            if (i < 4) {
                dp.add(i);
            } else {
                dp.add(Integer.MAX_VALUE);
            }
        }
        for (int i = 4; i <=n;i++) {
            int sqrt = (int)Math.sqrt(i);
            for (int j = 1; j <= sqrt; j++) {
                int sqr = j*j;
                int x = dp.get(i - sqr);
                dp.set(i, Math.min(dp.get(i), x + 1));
            }
        }
        return dp.get(n);
    }
}
