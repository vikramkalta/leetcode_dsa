import java.util.ArrayList;

public class LongestIncreasingSubsequences {
    public static void main(String args[]) {
        // int[] arr = { 10, 9, 2, 5, 3, 7, 101, 18 };
        // int[] arr = {0,1,0,3,2,3};
        // int[] arr = {4,10,4,3,8,9};
        int[]arr={1,3,6,7,9,4,10,5,6};
        System.out.println(lengthOfLIS(arr));
    }

    public static int lengthOfLIS(int[] nums) {
        ArrayList<Integer> dp = new ArrayList<>();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            dp.add(1);
        }
        for (int i = 0; i < len; i++) {
            int currI = nums[i];
            for (int j = i - 1; j >= 0; j--) {
                int currJ = nums[j];
                if (currJ < currI) {
                    dp.set(i, Math.max(dp.get(j) + 1, dp.get(i)));
                }
            }
        }
        // System.out.println(dp);

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < dp.size(); i++) {
            if (max < dp.get(i)) {
                max = dp.get(i);
            }
        }
        return max;
    }
}
