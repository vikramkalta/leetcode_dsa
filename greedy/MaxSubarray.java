public class MaxSubarray {
    public static void main(String[] args) {
        int[] nums = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        System.out.println(maxSubArray(nums));
    }

    public static int maxSubArray(int[] nums) {
        int len = nums.length;
        int left = 0, right = 0;
        int max = Integer.MIN_VALUE;
        int currSum = 0;
        while (right < len) {
            int curr = nums[right];
            currSum += curr;
            if (currSum > max) {
                max = currSum;
            } else {
                currSum -= nums[left];
                left++;
            }
            // if (currSum<max){
            // max=currSum;
            // }
            right++;
        }
        return max;
    }
}
