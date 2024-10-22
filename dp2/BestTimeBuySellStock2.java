public class BestTimeBuySellStock2 {
    public static void main(String[] args) {
        int[] prices = { 7, 1, 5, 3, 6, 4 };
        // int[] prices = { 1, 2, 3, 4, 5 };
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
            y = +prices[ind] + buySellStock(prices, ind + 1, 1, dp);
            x = buySellStock(prices, ind + 1, 0, dp);
        }
        dp[ind][buy] = Math.max(x, y);
        return dp[ind][buy];
    }
}
