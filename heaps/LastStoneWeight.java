import java.util.Collections;
import java.util.PriorityQueue;

public class LastStoneWeight {
    public static void main(String[] args) {
        int[] arr= {2,7,4,1,8,1};
        System.out.println(lastStoneWeight(arr));
    }

    public static int lastStoneWeight(int[] stones) {
        // Create a max heap
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < stones.length; i++) {
            maxHeap.offer(stones[i]);
        }
        while (maxHeap.size() > 1) {
            int firstBigStone = maxHeap.poll();
            int secondBigStone = maxHeap.poll();
            if (firstBigStone != secondBigStone) {
                int x = firstBigStone - secondBigStone;
                maxHeap.offer(x);
            }
        }
        return maxHeap.peek();
    }
}
