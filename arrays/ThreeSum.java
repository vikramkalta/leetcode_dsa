import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static void main(String args[]) {
        int[] arr = { -1, 0, 1, 2, -1, -4 };
        System.out.println(threeSum(arr));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        // {-4,-1,-1,0,1,2};
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            int curr = nums[i];
            if (i == 0 || (i > 0 && curr != nums[i - 1])) {

                int low = i + 1;
                int high = len - 1;
                int target = 0 - curr;
                List<Integer> innerList = new ArrayList<>();
                while (low < high) {
                    int currLow = nums[low];
                    int currHigh = nums[high];
                    int sum = currLow + currHigh;
                    if (sum == target) {
                        innerList = Arrays.asList(curr, currLow, currHigh);
                        result.add(innerList);
                        while (low < high && nums[low] == nums[low + 1]) {
                            low++;
                        }
                        while (low < high && nums[high] == nums[high - 1]) {
                            high--;
                        }
                        low++;
                        high--;
                    } else if (sum > target) {
                        high--;
                    } else {
                        low++;
                    }
                }
            }
        }
        return result;
    }
}
