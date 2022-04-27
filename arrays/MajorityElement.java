import java.util.HashMap;

public class MajorityElement {
    public static void main(String args[]) {
        int[] nums = {3,2,3};
        System.out.println(majorityElement(nums));
    }
    public static int majorityElement(int[] nums) {
        int len = nums.length;
        int candidate = nums[0];
        int occurrence = 0;
        int count = 1;
        for (int i = 1; i < len; i++) {
            if (candidate == nums[i]) {
                count++;
            } else {
                count--;
            }
            if (count == 0) {
                candidate = nums[i];
                count = 1;
            }
        }
        for (int i = 0; i < len; i++) {
            if (nums[i] == candidate) {
                occurrence++;
            }
        }
        return occurrence;
    }
    public static int majorityElement1(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return nums[0];
        }
        HashMap<Integer, Integer> hm = new HashMap<>();
        
        for (int i = 0; i < len; i++) {
            int curr = nums[i];
            if (hm.containsKey(curr)) {
                int occurrence = hm.get(curr) + 1;
                if (occurrence > len / 2) {
                    return curr;
                }
                hm.put(curr, hm.get(curr) + 1);
            } else {
                hm.put(curr, 1);
            }
        }
        return -1;
    }
}
