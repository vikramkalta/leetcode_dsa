import java.util.PriorityQueue;

public class KthLargest {
    public static void main(String[] args) {
        // int[][] list = { { 4, 5, 8, 2 }, { 3 }, { 5 }, { 10 }, { 9 }, { 4 } };
        int[][] list = { { }, { -3 }, { -2 }, { -4 }, { 0 }, { 4 } };
        // [1,[]],[-3],[-2],[-4],[0],[4]
        KthLargest kth = new KthLargest(3, list[0]);
        for (int i = 1; i < list.length; i++) {
            System.out.println(add(list[i][0]));
        }
    }

    static PriorityQueue<Integer> heap = new PriorityQueue<>();
    static int size = 0;

    public KthLargest(int k, int[] nums) {
        size = k;
        for (int i = 0; i < nums.length; i++) {
            heap.offer(nums[i]);
        }
        while (heap.size() > k) {
            heap.poll();
        }
    }

    public static int add(int val) {
        
        heap.add(val);
        if (heap.size() > size) {
            heap.poll();
        }
        return heap.peek();
    }
}
