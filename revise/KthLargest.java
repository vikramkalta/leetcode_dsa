import java.util.PriorityQueue;

public class KthLargest {
    public static void main(String[] args) {
       KthLargest kthLargest =new KthLargest(3, new int[]{4,5,8,2});
       System.out.println(kthLargest.add(3));
       System.out.println(kthLargest.add(5));
       System.out.println(kthLargest.add(10));
    }
    static PriorityQueue<Integer> maxHeap = new PriorityQueue<>();
    static int k1 = 0;
    public KthLargest(int k, int[] nums) { 
        k1=k;
        for (int i = 0; i < nums.length; i++) {
            maxHeap.add(nums[i]);
            if (i>=k) {
                maxHeap.poll();
            }
        }
        // while (maxHeap.size()>k) {
        //     maxHeap.poll();
        // }
    }

    public  static int add(int val) {
        maxHeap.add(val);
        while (maxHeap.size() > k1) {
            maxHeap.poll();
        }
        return maxHeap.peek();
    }
}
