import java.util.HashMap;
import java.util.HashSet;

public class LongestConsecutiveSeq {
    public static void main(String[] args) {
        int[] nums = { 100, 4, 200, 1, 3, 2 };
        System.out.println(longestConsecutive(nums));
    }

    public static int longestConsecutive(int[] nums) {
        HashSet<Integer> map = new HashSet<>();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            map.add(nums[i]);
        }
        int ans = 1;
        for (int i = 0; i < len; i++) {
            int maxLen = 1;
            int curr = nums[i];
            if (!map.contains(curr - 1)) {
                while (map.contains(curr + 1)) {
                    curr++;
                    maxLen++;
                }
                if (maxLen > ans) {
                    ans = maxLen;
                }
            }
        }
        return ans;
    }
}
