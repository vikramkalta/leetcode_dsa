public class LIS {
    public static void main(String[] args) {
        // int[] nums = {10,9,2,5,3,7,101,18};
        int[] nums = {1,2,4,3};
        System.out.println(lengthOfLIS(nums));
    }

    public static int lengthOfLIS(int[] nums) {
        int max = 0;
        int len = nums.length;
        int[] dp = new int[len];

        for (int i = len-1; i >=0; i--) {
            max = Math.max(max, subseq(nums, i));
        }
        return max;
    }
    // 1,2,4,3
    public static int subseq(int[] nums, int ind) {
        if (ind == 0) {
            return 1;
        }
        int max = 0;
        for (int i = ind - 1; i >= 0; i--) {
            if (nums[i] < nums[ind]) {
                max = Math.max(max, subseq(nums, i) + 1);
                // max = subseq(nums, i) + 1;
            }
        }
        return max;
    }

}
