public class MoveZeroes {
    public static void main(String args[]) {
        // int[] digits = {9,9,9,9};
        int[] nums = {0,1,0,3,12};
        // int[] nums = {1,0,1};
        // int[] digits = {2,4,1};
        moveZeroes(nums);
        System.out.println();
    }

    public static void moveZeroes(int[] nums) {
        int len = nums.length;
        int leftPtr = 0, rightPtr = 1;
        while(rightPtr < len) {
            int left = nums[leftPtr];
            int right = nums[rightPtr];
            if (leftPtr == rightPtr) {
                rightPtr++;
            } else if (left != 0) {
                leftPtr++;
            } else if (left == 0 && right != 0) {
                nums[leftPtr] = right;
                nums[rightPtr] = left;
                leftPtr++;
                rightPtr++;
            } else {
                // leftPtr++;
                rightPtr++;
            }
        }
    }

    public static void moveZeroes1(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int currI = nums[i];
            for (int j = i + 1; j < len; j++) {
                int currJ = nums[j];
                if (currI == 0 && currJ != 0) {
                    nums[i] = currJ;
                    nums[j] = currI;
                    break;
                }
            }
        }
    }
}
