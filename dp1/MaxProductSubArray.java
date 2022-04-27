import java.util.ArrayList;

public class MaxProductSubArray {
    public static void main(String args[]) {
        // int[] nums = {1,2,3,4,5};
        // int[]nums = {2,3,-2,4};
        // int[] nums = { -2, 3, -4 };
        // int[] nums = {-3,0,1,-2};
        // int[] nums = {2,3,-2,4};
        int[] nums = { -1, -2, -3, 0 };
        System.out.println(maxProduct(nums));
    }

    public static int maxProduct(int[] nums) {
        int len = nums.length;
        int leftProduct = 1;
        int leftMax = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            int curr = nums[i];
            leftProduct *= curr;
            if (leftMax < leftProduct) {
                leftMax = leftProduct;
            }
            if (leftProduct == 0) {
                leftProduct = 1;
            }
        }

        int rightProduct = 1;
        int rightMax = Integer.MIN_VALUE;
        for (int i = len - 1; i >= 0; i--) {
            int curr = nums[i];
            rightProduct *= curr;
            if (rightMax < rightProduct) {
                rightMax = rightProduct;
            }
            if (rightProduct == 0) {
                rightProduct = 1;
            }
        }
        return Math.max(leftMax, rightMax);
    }

    public static ArrayList<ArrayList<Integer>> subArrays = new ArrayList<>();

    public static int maxProduct1(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            getSubArray(nums, i, i + 1);
        }
        int subArraysLen = subArrays.size();
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < subArraysLen; i++) {
            ArrayList<Integer> innerList = subArrays.get(i);
            int product = 1;
            for (int j = 0; j < innerList.size(); j++) {
                int curr = innerList.get(j);
                product *= curr;
            }
            if (max < product) {
                max = product;
            }
        }
        return max;
    }

    public static void getSubArray(int[] nums, int start, int end) {
        if (end > nums.length) {
            return;
        }
        ArrayList<Integer> innerList = new ArrayList<>();
        for (int i = start; i < end; i++) {
            innerList.add(nums[i]);
        }
        subArrays.add(innerList);
        getSubArray(nums, start, end + 1);
    }
}
