import java.util.Arrays;
import java.util.Collections;

public class CoinChange {
    public static void main(String[] args) {
        // int[] coins = { 1, 2, 5 };
        // int[] coins = { 2, 5, 10, 1 };
        int[] coins = { 1,2 };
        // int[] coins = {186,419,83,408};
        // System.out.println(coinChange(coins, 11));
        // System.out.println(coinChange(coins, 27));
        // System.out.println(coinChange(coins, 6249));
        System.out.println(coinChange(coins, 2));
    }

    public static int coinChange(int[] coins, int amount) {
        int len = coins.length;
        int[][] dp = new int[amount + 1][len];
        for (int i = 0; i < amount + 1; i++) {
            for (int j = 0; j < len; j++) {
                dp[i][j] = -1;
            }
        }
        return f(len - 1, coins, amount, dp);
    }

    static int max = 1000000;

    public static int f(int ind, int[] coins, int amount, int[][] dp) {
        if (ind == 0) {
            if (amount % coins[ind] == 0) {
                return amount / coins[ind];
            }
            return max; // Integer.MAX_VALUE;
        }
        // if (amount == 0) {
        //     return 1;
        // }
        if (dp[amount][ind] != -1) {
            return dp[amount][ind];
        }
        int notTake = f(ind - 1, coins, amount, dp);
        int take = max; // Integer.MAX_VALUE;
        if (coins[ind] <= amount) {
            take = 1 + f(ind, coins, amount - coins[ind], dp);
        }
        dp[amount][ind] = Math.min(notTake, take);
        return Math.min(notTake, take);
    }

    public static int coinChange1(int[] coins, int amount) {
        int len = coins.length;
        Arrays.sort(coins);
        for (int i = 0; i < len / 2; i++) {
            int curr = coins[i];
            int currLast = coins[len - i - 1];
            coins[i] = currLast;
            coins[len - i - 1] = curr;
        }
        for (int i = 0; i < len; i++) {
            int[] debug = new int[len];
            count = 0;
            getCount(coins, amount, i, 0, debug);
        }
        return minCount == Integer.MAX_VALUE ? -1 : minCount;
    }

    static int count = 0;
    static int minCount = Integer.MAX_VALUE;

    public static void getCount(int[] coins, int amount, int ind, int total, int[] debug) {
        if (ind >= coins.length || total > amount) {
            return;
        }
        if (total == amount) {
            if (minCount > count) {
                minCount = count;
            }
            return;
        }
        debug[ind] = debug[ind] + 1;
        count++;
        getCount(coins, amount, ind, total + coins[ind], debug);
        debug[ind] = debug[ind] - 1;
        count--;
        getCount(coins, amount, ind + 1, total - coins[ind], debug);
    }
}
