public class MaxPointsCards {
    public static void main(String[] args) {
        // int[] arr = {1,2,3,4,5,6,1};
        // int[] arr = {2,2,2};
        int[] arr = {2,2,4,9,3,5,2,2};
        System.out.println(maxScore(arr, 4));
    }

    public static int maxScore(int[] cardPoints, int k) {
        int len = cardPoints.length;

        int max = 0;
        int lSum = 0;
        for (int i = 0; i < k; i++) {
            lSum += cardPoints[i];
        }
        max = lSum;
        int rSum = 0;
        int r = len - 1;
        for (int i = k-1; i>=0; i--) {
            lSum -= cardPoints[i];
            rSum += cardPoints[r];
            r--;
            max = Math.max(max, lSum+rSum);
        }
        return max;
    }

    public static int maxScore1(int[] cardPoints, int k) {
        int len = cardPoints.length;
        int l = 0;
        int r = len - 1;
        int ans = 0;
        int cardsTaken = 0;
        // l < r && 
        while (l < r && cardsTaken < k) {
            int left = cardPoints[l];
            int right = cardPoints[r];
            if (left > right) {
                ans += left;
                l++;
                cardsTaken++;
            } else if (right > left) {
                ans += right;
                r--;
                cardsTaken++;
            } else {
                if (cardPoints[l + 1] > cardPoints[r - 1]) {
                    ans += left;
                    l++;
                    cardsTaken++;
                } else if (cardPoints[r - 1] > cardPoints[l + 1]) {
                    ans += right;
                    r--;
                    cardsTaken++;
                } else {
                    // This can be wrong.
                    // ans = right + left;
                    l++;
                    r--;
                    // cardsTaken+=2;
                }
            }
        }
        return ans;
    }
}
