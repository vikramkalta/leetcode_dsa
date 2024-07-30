public class MaxConsecutive3 {
    public static void main(String[] args) {
        int[] nums = { 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0 };
        int k = 2;
        System.out.println(longestOnes(nums, k));
    }

    public static int longestOnes(int[] nums, int k) {
        int len = nums.length;
        int maxLen = 0;
        int start = 0;
        int count0 = 0;
        for (int i = 0; i < len; i++) {
            int curr = nums[i];
            if (curr == 0) {
                if (count0 <= k) {
                    count0++;
                }
                while (count0 > k) {
                    if (nums[start] == 0) {
                        count0--;
                    }
                    start++;
                }
            }
            maxLen = Math.max(maxLen, i - start + 1);
        }
        return maxLen;
    }
}
