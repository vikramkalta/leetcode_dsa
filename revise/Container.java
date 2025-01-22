public class Container {
    public static void main(String[] args) {
        // int[] height = {1,8,6,2,5,4,8,3,7};
        // int[]height={2,3,4,5,18,17,6};
        int[] height = {1,2,1};
        System.out.println(maxArea(height));
    }

    public static int maxArea(int[] height) {
        int len = height.length;
        int max = Integer.MIN_VALUE;
        int left = 0;
        int right = len-1;
        while (left<right) {
            int currLeft = height[left];
            int currRight = height[right];
            int x = Math.min(currLeft, currRight);
            int y = right-left;
            max = Math.max(max, x*y);
            if (currLeft<currRight){
                left++;
            }else{
                right--;
            }
        }
        return max;
    }

    public static int maxArea1(int[] height) {
        int len = height.length;
        int ans = 0;
        int maxLeft = Integer.MIN_VALUE;
        int[] left = new int[len];
        int maxLeftInd = 0;
        for (int i = 0; i < len; i++) {
            int curr = height[i];
            left[i] = maxLeftInd;
            if (curr > maxLeft) {
                maxLeft = curr;
                maxLeftInd = i;
            }
            // left[i] = maxLeftInd;
        }
        int maxRight = Integer.MIN_VALUE;
        int[] right = new int[len];
        int maxRightInd = len-1;
        for (int i = len - 1; i >= 0; i--) {
            int curr = height[i];
            right[i] = maxRightInd;
            if (curr > maxRight) {
                maxRight = curr;
                maxRightInd = i;
            }
            // right[i] = maxRightInd;
        }
        for (int i = 0; i < len; i++) {
            int leftInd = left[i];
            int rightInd = right[i];
            System.out.println(height[leftInd] + ", " + height[rightInd] + ", " + (rightInd-leftInd));
            int x = Math.min(height[leftInd], height[rightInd]);
            // System.out.println("x: " + x + " , " + (rightInd-leftInd));
            ans = Math.max(x * (rightInd - leftInd), ans);
        }

        return ans;
    }
}