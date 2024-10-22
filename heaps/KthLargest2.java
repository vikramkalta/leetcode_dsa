import java.util.PriorityQueue;

public class KthLargest2 {
    public static void main(String[] args) {
        int[] nums ={3,2,1,5,6,4};
        System.out.println(findKthLargest(nums, 2));
    }

    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            int curr = nums[i];
            minHeap.offer(curr);
            while (minHeap.size() > k) {
                minHeap.remove();
            }
        }
        return minHeap.poll();
    }
}
