import java.util.Stack;

public class MaxRectangle {
    public static void main(String[] args) {
        // int[] heights = {0,9};
        // int[] heights = {1,2,2};
        int[] heights = {2,1,5,6,2,3};
        // {1,-1,4,4,-1,-1}
        // {-1,-1,1,2,1,4}
        System.out.println(largestRectangleArea(heights));
    }

    public static int largestRectangleArea(int[] heights) {
        int len = heights.length;
        int[] nextSmallerArr = nextSmallerElement(heights);
        int[] previousSmallerArr = previousSmallerElement(heights);
        int max = 0;
        for (int i = 0; i < len; i++) {
            int x = nextSmallerArr[i];
            int y = previousSmallerArr[i];
            int area = heights[i] * ((Math.abs(x-y)) - 1);
            max = Math.max(max, area);
        }
        return max;
    }
    public static int[] nextSmallerElement(int[] heights) {
        int len = heights.length;
        int[] ans = new int[len];
        for (int i = 0; i < len; i++) ans[i]=-1;
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        while (i<len) {
            int curr = heights[i];
            while (!stack.empty() && heights[stack.peek()] > curr) {
                ans[stack.peek()] = i;
                stack.pop();
            }
            stack.push(i);
            i++;
        }
        for (int k = 0; k < len; k++) if (ans[k]==-1)ans[k]=len;

        return ans;
    }
    public static int[] previousSmallerElement(int[] heights) {
        int len = heights.length;
        int[] ans = new int[len];
        for (int i = 0; i < len; i++) ans[i]=-1;
        Stack<Integer> stack = new Stack<>();
        int i = len - 1;
        while (i>=0) {
            int curr = heights[i];
            while (!stack.empty() && heights[stack.peek()] > curr) {
                ans[stack.peek()] = i;
                stack.pop();
            }
            stack.push(i);
            i--;
        }
        return ans;
    }

    public static int largestRectangleArea1(int[] heights) {
        int len = heights.length;
        if (len==1){
            return heights[0];
        }
        int ans = 0;
        for (int i = 0; i < len; i++) {
            int min = heights[i];
            for (int j = i; j < len; j++) {
                if (min > heights[j]) {
                    min = heights[j];
                }
                int dist = j - i + 1;
                int x = dist * min;
                ans = Math.max(ans, x);
            }
        }
        return ans;
    }
    
}