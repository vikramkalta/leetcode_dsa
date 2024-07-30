public class MaxConsecutive1 {
    public static void main(String[] args) {
        int[] arr = { 1, 1, 0, 1, 1, 1 };
        System.out.println(findMaxConsecutiveOnes(arr));
    }

    public static int findMaxConsecutiveOnes(int[] nums) {
        int len = nums.length;
        int max = 0;
        // int l = 0;
        // int r = 0;
        int counter = 0;
        for (int i = 0; i < len; i++) {
            int curr = nums[i];
            if (curr == 1) {
                counter++;
            } else {
                counter = 0;
            }
            max = Math.max(max, counter);
        }
        return max;
    }
}
