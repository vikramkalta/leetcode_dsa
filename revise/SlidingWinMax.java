import java.util.Deque;
import java.util.LinkedList;

public class SlidingWinMax {
    public static void main(String[] args) {
        // int[] nums ={1,3,-1,-3,5,3,6,7};
        // int[] nums = {1,1,1,5,4,7,3};
        // int[] nums = {1,1,1,5,4,3,2};
        // int[] nums = {7,2,4};
        int[] nums = {1,3,1,2,0,5};
        // System.out.println(maxSlidingWindow(nums, 3));
        // System.out.println(maxSlidingWindow(nums, 2));
        System.out.println(maxSlidingWindow(nums, 3));
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        Deque<Integer> deq = new LinkedList<>();
        int[] ans = new int[len-k+1];
        int l = 0;int r = 0;
        while (r<len) {
            int curr = nums[r];
            
            while (!deq.isEmpty() && nums[deq.peekFirst()] < curr) {
                deq.pop();
            }
            // Remove elements from the back that are smaller than the current element
            while (!deq.isEmpty() && nums[deq.peekLast()] < nums[r]) {
                deq.removeLast();
            }
            deq.add(r);
            if (l > deq.peekFirst()) {
                deq.removeFirst();
            }
            if (r>=k-1) {
                ans[r-k+1] = nums[deq.peekFirst()];
                l++;
            }
            r++;
        }
        return ans;
    }
}
