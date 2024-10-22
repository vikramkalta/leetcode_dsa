import java.util.Stack;

public class TrapWater {
    public static void main(String[] args) {
        int[] arr = { 4, 2, 0, 3, 2, 5 };
        // int[] arr = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        System.out.println(trap(arr));
    }

    public static int trap(int[] height) {
        int len = height.length;
        int[] rMax = new int[len];
        int[] lMax = new int[len];

        int maxL = Integer.MIN_VALUE;
        int maxR = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            int curr = height[i];
            if (maxL < curr) {
                maxL = curr;
            }
            lMax[i] = maxL;
        }
        for (int i = len - 1; i >= 0; i--) {
            int curr = height[i];
            if (maxR < curr) {
                maxR = curr;
            }
            rMax[i] = maxR;
        }
        int sum = 0;
        for (int i = 0; i < len; i++) {
            int curr = height[i];
            int x = Math.min(lMax[i], rMax[i]) - curr;
            sum += x;
        }
        return sum;
    }
}
