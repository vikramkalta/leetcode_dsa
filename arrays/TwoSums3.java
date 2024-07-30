import java.util.HashMap;

public class TwoSums3 {
    public static void main(String[] args) {
        // int[] a = {2,7,11,15};
        int[] a = {3,2,4};
        // System.out.println(twoSum(a, 9));
        System.out.println(twoSum(a, 6));
    }

    static public int[] twoSum(int[] nums, int target) {
        int first = -1; int second = -1;
        HashMap<Integer, Integer> intMap = new HashMap<>();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            intMap.put(nums[i], i);
        }
        for (int i = 0; i < len; i++) {
            int curr = nums[i];
            int remainder = target - curr;
            if (intMap.containsKey(remainder) && i != intMap.get(remainder)) {
                first = i;
                second = intMap.get(remainder);
                break;
            } 
        }
        return new int[]{first, second};
    }
}