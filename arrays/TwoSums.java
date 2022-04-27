import java.util.ArrayList;
import java.util.HashMap;

public class TwoSums {
    public static void main(String args[]) {
        // int[] nums = {2,7,11,15};
        // System.out.println(twoSum(nums, 9));
        int[] nums = {3,2,4};
        System.out.println(twoSum(nums, 6));
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        HashMap<Integer, Integer> hm = new HashMap<>();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            hm.put(nums[i], i);
        }
        for (int i = 0; i < len; i++) {
            int curr = nums[i];
            int remaining = target - curr;
            if (hm.containsKey(remaining) && i != hm.get(remaining)) {
                ans[0] = i;
                ans[1] = hm.get(remaining);
                break;
            }
        }
        return ans;
    }
}