public class SquaresSortedArray {
    public static void main(String args[]) {
        // int[] nums = {-4,-1,0,3,10};
        int[] nums = {-10000,-9999,-7,-5,0,0,10000};
        // int[] prices = {2,4,1};
        // System.out.println();
        System.out.println(sortedSquares(nums));
    }
    public static int[] sortedSquares(int[] nums) {
        // get negative numbers ending index;
        int negativeIndex = -1;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i] < 0) {
                negativeIndex = i;
            } else {
                break;
            }
        }
        if (negativeIndex > -1) {
            for (int i = 0; i <= negativeIndex / 2; i++) {
                int curr = Math.abs(nums[i]);
                int rev = Math.abs(nums[negativeIndex - i]);
                nums[i] = rev;
                nums[negativeIndex - i] = curr;
            }
            int leftIndex = 0;
            int leftArrLen = negativeIndex;
            int[] leftArr = new int[negativeIndex + 1];
            for (int i = 0; i <= leftArrLen; i++) {
                leftArr[i] = nums[i];
            }

            int rightIndex = negativeIndex + 1;
            int rightArrLen = len - 1 - rightIndex;
            int[] rightArr = new int[rightArrLen + 1];
            rightIndex = 0;
            for (int i = 0; i <= rightArrLen; i++) {
                rightArr[i] = nums[i + negativeIndex + 1];
            }
            int k = 0;
            while(leftIndex < negativeIndex + 1 && rightIndex < rightArrLen + 1) {
                int currLeft = leftArr[leftIndex];
                int currRight = rightArr[rightIndex];
                if (currLeft > currRight) {
                    nums[k] = currRight;
                    rightIndex++;
                } else {
                    nums[k] = currLeft;
                    leftIndex++;
                }
                k++;
            }
            while(leftIndex < negativeIndex + 1) {
                nums[k] = leftArr[leftIndex];
                k++;
                leftIndex++;
            }
            while(rightIndex < rightArrLen + 1) {
                nums[k] = rightArr[rightIndex];
                k++;
                rightIndex++;
            }
        }
        for (int i = 0; i < len; i++) {
            nums[i] = nums[i] * nums[i];
        }
        return nums;
    }
}
