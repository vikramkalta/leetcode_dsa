public class Trap {
    public static void main(String args[]) {
        // int[] nums = {1,7,3,6,5,6};
        // int[] nums = {2,1,-1};
        // int[] nums = {-1,-1,-1,-1,-1,0};
        // int[] nums = {-1,-1,1,1,0,0};
        // int[] nums ={0,1,0,2,1,0,1,3,2,1,2,1};
        int[] nums = {4,2,0,3,2,5};
        System.out.println(trap(nums));
    }

    public static int trap(int[] height) {
        int len = height.length;
        int[] leftMaxArr = new int[len];
        int[] rightMaxArr = new int[len];
        int leftMax = Integer.MIN_VALUE;
        int rightMax = Integer.MIN_VALUE;
        
        for (int i = 0; i < len; i++) {
            int curr = height[i];
            if (leftMax < curr) {
                leftMax = curr;
            }
            leftMaxArr[i] = leftMax;
        }
        for (int i = len - 1; i>=0; i--) {
            int curr = height[i];
            if (rightMax < curr) {
                rightMax = curr;
            }
            rightMaxArr[i] = rightMax;
        }

        int sum = 0;
        for (int i = 0; i < len; i++) {
            int curr = height[i];
            int currLeftMax = leftMaxArr[i];
            int currRightMax = rightMaxArr[i];
            if (curr < currLeftMax && curr < currRightMax) {
                sum = sum + (Math.min(currLeftMax, currRightMax) - curr);
            }
        }

        return sum;
    }
}
