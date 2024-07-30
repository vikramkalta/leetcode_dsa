import java.util.Arrays;

public class ThreeSumClosest {
    public static void main(String[] args) {
        // int[] arr = { -1, 2, 1, -4 };
        int[] arr = { 0, 1, 2 };
        // -4,-1,1,2
        System.out.println(threeSumClosest(arr, 0));
    }

    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int len = nums.length;
        int l = 0, r = len - 1;
        int min = Integer.MAX_VALUE;
        int sum = 0;
        for (int i = 0; i < len; i++) {
            int curr = nums[i];
            if (l == i) {
                l++;
            } else if (r == i) {
                r--;
            }
            while (l < r && l != i && r != i) {
                int left = nums[l];
                int right = nums[r];
                int sum3 = curr + left + right;
                int x = Math.abs(sum3 - target);
                if (sum3 > target) {
                    r--;
                } else if (sum3 < target) {
                    l++;
                } else {
                    return sum3;
                }
                if (x < min) {
                    min = x;
                    sum = sum3;
                }
            }
            l = 0;
            r = len - 1;
        }
        return sum;
    }
}
