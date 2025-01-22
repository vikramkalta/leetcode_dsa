public class HouseRobber2 {
    public static void main(String[] args) {
        // int[] nums = {200,3,140,20,10};
        int[] nums = {1,2,3};
        System.out.println(rob(nums));
    }

    public static int rob(int[] nums) {
        int len = nums.length;
        if (len==1) {
            return nums[0];
        }
        if (len==2) {
            return Math.max(nums[0],nums[1]);
        }

        int[] skipLast = new int[len-1];
        int[] skipFirst = new int[len-1];

        for (int i = 0; i < len; i++) {
            if (i<len-1)
                skipLast[i] = nums[i];
            if (i>0)
                skipFirst[i-1] = nums[i];
        }
        for (int i = 2; i < len - 1; i++) {
            skipLast[i] = skipLast[i] + Math.max(skipLast[i-2], i-3<0 ? 0 : skipLast[i-3]);
            skipFirst[i] = skipFirst[i] + Math.max(skipFirst[i-2], i-3<0 ? 0 : skipFirst[i-3]);
        }
        int x = Math.max(skipLast[len-2], skipLast[len-3]);
        int y = Math.max(skipFirst[len-2], skipFirst[len-3]);
        return Math.max(x, y);
    }
}
