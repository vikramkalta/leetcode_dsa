public class BestTimeBuySellStock {
    public static void main(String[] args) {
        int[] prices = { 1, 2, 3, 0, 2 };
        System.out.println(maxProfit(prices));
    }
    public static int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        for (int i = 0; i < prices.length; i++) {
            dp[i][0] = -1;
            dp[i][1] = -1;
        }
        return buySellStock(prices, 0, 1, dp);
    }

    public static int buySellStock(int[] prices, int ind, int buy, int[][] dp) {
        if (ind >= prices.length) {
            return 0;
        }
        if (dp[ind][buy] != -1) {
            return dp[ind][buy];
        }
        int x = 0, y = 0;
        if (buy == 1) {
            x = -prices[ind] + buySellStock(prices, ind + 1, 0, dp);
            y = buySellStock(prices, ind + 1, 1, dp);
        } else {
            y = +prices[ind] + buySellStock(prices, ind + 2, 1, dp);
            x = buySellStock(prices, ind + 1, 0, dp);
        }
        dp[ind][buy] = Math.max(x, y);
        return dp[ind][buy];
    }

    public static int max = Integer.MIN_VALUE;

    public static int maxProfit1(int[] prices) {
        int[] x = new int[prices.length];
        dfs(prices, 0, x);
        return max;
    }

    public static void dfs(int[] prices, int ind, int[] x) {
        if (ind >= prices.length) {
            int lastSold = 0;
            int totalProfit = 0;
            for (int i = 0; i < x.length; i++) {
                if (lastSold == 1) {
                    lastSold = 0;
                    continue;
                }
                if (x[i] == 1) {
                    totalProfit -= prices[i];
                } else {
                    totalProfit += prices[i];
                    lastSold = 1;
                }
            }
            if (totalProfit==6){
                for (int j = 0; j < x.length; j++) {
                    System.out.println("j: " + j);
                    System.out.println(x[j]);
                }
            }
            max = Math.max(max, totalProfit);
            return;
        }
        x[ind] = 1;
        dfs(prices, ind + 1, x);
        x[ind] = 0;
        dfs(prices, ind + 1, x);
    }
}
