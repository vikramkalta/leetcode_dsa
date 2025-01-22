import java.util.Stack;

public class MaxArea {
    public static void main(String[] args) {
        int[] nums= {2,1,5,6,2,3};
        System.out.println(largestRectangleArea(nums));
    }

    public static int largestRectangleArea(int[] heights) {
        int len = heights.length;
        int[]rb = new int[len];
        Stack<Integer> st = new Stack<>();
        st.push(len - 1);
        rb[len-1] = len;
        for (int i = len-2; i>=0; i--) {
            while (st.size()>0 && heights[i] < heights[st.peek()]) {
                st.pop();
            }
            if (st.size() == 0) {
                rb[i] = len;
            } else {
                rb[i] = st.peek();
            }
            st.push(i);
        }

        int[]lb = new int[len];
        st.push(0);
        lb[0] = -1;
        for (int i = 1; i < len; i++) {
            while (st.size() > 0 && heights[i] < heights[st.peek()]) {
                st.pop();
            }
            if (st.empty()) {
                lb[i] = -1;
            }else{
                lb[i] = st.peek();
            }
            st.push(i);
        }

        int max = 0;
        for (int i = 0; i < len; i++) {
            int width = rb[i] - lb[i] - 1;
            int area = heights[i] * width;
            max = Math.max(max, area);
        }
        return max;
    }
}
