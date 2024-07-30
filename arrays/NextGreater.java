import java.util.Stack;

public class NextGreater {
    public static void main(String[] args) {
        int[] nums = {1,2,1};
        System.out.println(nextGreaterElements(nums));
    }
    public static int[] nextGreaterElements(int[] nums) {
        int len = nums.length;
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[len];
        for (int i =0;i<len;i++)ans[i]=-1;
        int doubleLen = 2 * len;
        int i = 0;
        int j = 0;

        while (j<doubleLen) {
            int curr = nums[i];
            while (!stack.empty() && nums[stack.peek()] < curr) {
                ans[stack.peek()] = curr;
                stack.pop();
            }
            stack.push(i);
            i = (i + 1) % len;
            j++;
        }
        return ans;
    }
}
