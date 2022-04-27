public class BestTimeToBuySellStocks {
    public static void main(String args[]) {
        // int[] nums = {2,7,11,15};
        int[] prices = {7,1,4,3,6,4};
        // int[] prices = {2,4,1};
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        int len = prices.length;
        int currI = 0;
        int currJ = 0;
        int maxProfit = Integer.MIN_VALUE;
        for (int i = 1; i < len; i++) {
            // int curr = prices[i];
            if (prices[currI] > prices[i]) {
                currI = i;
            }
            if (prices[currJ] > prices[currI]) {
                currJ = i;
            }
            if (prices[i] > prices[currJ]) {
                currJ = i;
            }
            int profit = prices[currJ] - prices[currI];
            if (profit > maxProfit) {
                maxProfit = profit;
            }
        }
        int ans = maxProfit < 0 ? 0 : maxProfit;
        return ans;
    }

    public static int maxProfit1(int[] prices) {
        int len = prices.length;
        int currMin = Integer.MAX_VALUE;
        int currMax = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            int curr = prices[i];
            if (currMin > curr) {
                currMin = curr;
                if (currMax > curr) {
                    currMax = curr;
                }
            }
            if (currMax < curr) {
                currMax = curr;
            }
        }
        int ans = currMax - currMin;
        return ans < 0 ? 0 : ans;
    }
}
