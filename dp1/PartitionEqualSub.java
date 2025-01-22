public class PartitionEqualSub {
    public static void main(String[] args) {
        // int[] nums = { 1, 5, 11, 5 };
        // int[] nums = {1,2,3,5};
        int[] nums={14,9,8,4,3,2};
        System.out.println(canPartition(nums));
    }

    public static boolean canPartition(int[] nums) {
        int sum = 0;
        int len = nums.length;
        
        for (int i = 0; i < len; i++) {
            sum += nums[i];
        }

        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;
        int[][] dp = new int[len][target + 1];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < target + 1; j++) {
                dp[i][j] = -1;
            }
        }
        return findTarget(nums, 0, target, dp);
    }

    public static boolean findTarget(int[] nums, int i, int target, int[][] dp) {
        if (i == nums.length) {
            return false;
        }
        if (target < 0) {
            return false;
        }
        if (target == 0) {
            return true;
        }
        if (dp[i][target] != -1) {
            return dp[i][target] == 1;
        }
        boolean take = findTarget(nums, i + 1, target - nums[i], dp);
        boolean notTake = findTarget(nums, i + 1, target, dp);
        dp[i][target] = (take || notTake) ? 1 : 0;
        return take || notTake;
        // return dp[target] == 1;
    }
}
