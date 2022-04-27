import java.util.ArrayList;

public class Fibonacci {
    public static void main(String args[]) {
        System.out.println(solve(5));
    }
    public static int solve(int A) {
        ArrayList<Integer> dp = new ArrayList<>();
        dp.add(1);
        dp.add(1);
        for (int i = 1; i < A; i++) {
            dp.add(-1);
        }
        fib(A, dp);
        return dp.get(A-1);
    }
    public static int fib(int A, ArrayList<Integer> B) {
        if (A <= 2) {
            return 1;
        }
        if (B.get(A-1) != -1) {
            return B.get(A-1);
        }
        int x = fib(A - 1, B);
        int y = fib(A - 2, B);

        B.set(A-1, x+y);
        return x + y;
    }
}