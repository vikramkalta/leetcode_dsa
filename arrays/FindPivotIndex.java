public class FindPivotIndex {
    public static void main(String args[]) {
        // int[] nums = {1,7,3,6,5,6};
        // int[] nums = {2,1,-1};
        // int[] nums = {-1,-1,-1,-1,-1,0};
        // int[] nums = {-1,-1,1,1,0,0};
        // int[] nums ={-1,-1,0,1,1,-1};
        int[] nums = {-1,-1,0,1,1,0};
        System.out.println(pivotIndex(nums));
    }

    public static int pivotIndex(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return 0;
        }
        int[] prefix = new int[len];
        int[] postfix = new int[len];

        int prefixSum = 0;
        for (int i = 0; i < len; i++) {
            prefixSum += nums[i];
            prefix[i] = prefixSum;
        }
        int postfixSum = 0;
        for (int i = len - 1; i>=0; i--){
            postfixSum += nums[i];
            postfix[i] = postfixSum;
        }

        if (postfix[1] == 0) {
            return 0;
        }

        for (int i = 0; i < len - 2; i++) {
            int left = prefix[i];
            int right = postfix[i+2];
            if (left == right) {
                return i + 1;
            }
        }

        if (prefix[len - 2] == 0){
            return len - 1;
        }
        return -1;
    }

    public static int pivotIndex1(int[] nums) {
        int len = nums.length;
        int leftPtr = 0, rightPtr = len - 1;
        int leftSum = nums[leftPtr], rightSum = nums[rightPtr];
        while(leftPtr + 1 < rightPtr) {
            if (leftSum == rightSum && rightPtr - leftPtr == 2) {
                return leftPtr+ 1;
            }
            if (leftSum == rightSum) {
                leftPtr++;
                rightPtr--;
            } else if (leftSum < rightSum) {
                leftPtr++;
                int left = nums[leftPtr];
                leftSum += left;
            } else {
                rightPtr--;
                int right = nums[rightPtr];
                rightSum += right;
            }
        }
        if (leftPtr == 0 && rightSum == 0) {
            return 0;
        }
        if (rightPtr == len - 1 && leftSum == 0) {
            return len - 1;
        }
        return -1;
    }
}