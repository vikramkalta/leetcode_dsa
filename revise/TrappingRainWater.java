public class TrappingRainWater {
    public static void main(String[] args) {
        int[] height = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        System.out.println(trap(height));
    }

    public static int trap(int[] height) {
        int len = height.length;
        int[] lMax = new int[len];
        int[] rMax = new int[len];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            int curr = height[i];
            if (max < curr) {
                max = curr;
            }
            lMax[i] = max;
        }
        max = Integer.MIN_VALUE;
        for (int i = len - 1; i >= 0; i--) {
            int curr = height[i];
            if (max < curr) {
                max = curr;
            }
            rMax[i] = max;
        }
        int sum = 0;
        for (int i = 0; i < len; i++) {
            int leftMax = lMax[i];
            int rightMax = rMax[i];
            int min = Math.min(leftMax, rightMax);
            int x = min - height[i];
            sum += x;
        }

        return sum;
    }
}
