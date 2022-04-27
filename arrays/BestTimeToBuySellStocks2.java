public class BestTimeToBuySellStocks2 {
    public static void main(String args[]) {
        // int[] nums = {2,7,11,15};
        int[] prices = { 7, 1, 5, 3, 6, 4 };
        // int[] prices = { 1,2,3,4,5 };
        // int[] prices = {2,4,1};
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        int len = prices.length;
        int diff = 0;
        for (int i = 1; i < len; i++) {
            if (prices[i] > prices[i-1]) {
                diff += prices[i] - prices[i-1];
            }
        }
        return diff;
    }

    public static int maxProfit1(int[] prices) {
        int len = prices.length;
        int leftPtr = 0;
        int rightPtr = 1;
        int profit = 0;
        int lastProfit = 0;
        while (rightPtr < len) {
            int currLeft = prices[leftPtr];
            int currRight = prices[rightPtr];
            // 1,2,3,4,5
            // 7,1,5,3,6,4
            if (currLeft < currRight) {
                int x = currRight - currLeft;
                if (x > lastProfit) {
                    lastProfit = x;
                } else {
                    leftPtr++;
                }
                rightPtr++;
            } else if (currLeft > currRight) {
                leftPtr++;
            } else {
                rightPtr++;
            }
            // profit += lastProfit;
        }
        return profit;
    }
}
