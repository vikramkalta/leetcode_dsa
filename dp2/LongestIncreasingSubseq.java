import java.util.ArrayList;
import java.util.List;

public class LongestIncreasingSubseq {
    public static void main(String[] args) {
        int[] nums = {10,9,2,5,3,7,101,18};
        // int[] nums = { 4, 10, 4, 3, 8, 9 };
        // int[] nums = { 4, 2, 6 };
        // int[]nums={-2,-1};
        // int[]nums={2,1};
        System.out.println(lengthOfLIS(nums));
    }

    static List<List<Integer>> list = new ArrayList<>();

    public static int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++)
            dp[i] = -1;

        int max = 0;
        for (int i = 0; i < nums.length; i++) {
           max = Math.max(getAllSubseq(nums, i, dp), max);
        }
        return max;
    }

    public static int getAllSubseq(int[] nums, int curr, int[] dp) {
        if (curr == 0)
            return 1;

        if (dp[curr] != -1)
            return dp[curr];

        int ans = 1;
        for (int i = curr - 1; i >= 0; i--) {
            if (nums[i] < nums[curr])
                ans = Math.max(ans, 1 + getAllSubseq(nums, i, dp));
        }

        dp[curr] = ans;
        return ans;
    }

    // public static int getAllSubseq(int[] nums, int i, int prevIndex, int[] dp) {
    //     if (i == nums.length) {
    //         return 0;
    //     }
    //     if (dp[i] != -1) {
    //         return dp[i];
    //     }
    //     int x = 0 + getAllSubseq(nums, i + 1, prevIndex, dp);
    //     int y = 0;
    //     // if (i + 1 < nums.length && nums[i + 1] > nums[i]) {
    //     if (prevIndex>-1 && nums[i] > nums[prevIndex]) {
    //         y = 1 + getAllSubseq(nums, i + 1, i, dp);
    //     }
    //     dp[i] = Math.max(x, y);
    //     return Math.max(x, y);
    // }

    public static void getAllSubseq1(int[] nums, int i, int[] dummy) {
        if (i >= nums.length) {
            List<Integer> innerList = new ArrayList<>();
            for (int index = 0; index < dummy.length; index++) {
                if (dummy[index] == 1) {
                    innerList.add(nums[index]);
                }
            }
            list.add(innerList);
            return;
        }
        dummy[i] = 1;
        getAllSubseq1(nums, i + 1, dummy);
        dummy[i] = 0;
        getAllSubseq1(nums, i + 1, dummy);
    }
}
