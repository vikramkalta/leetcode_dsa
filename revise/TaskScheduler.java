import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class TaskScheduler {
    public static void main(String[] args) {
        System.out.println(leastInterval(new char[] { 'A', 'B', 'C', 'A' }, 1));
    }

    public static int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> countMap = new HashMap<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for (char c : tasks) {
            countMap.put(c, countMap.getOrDefault(c, 0) + 1);
        }
        maxHeap.addAll(countMap.values());
        Deque<int[]> que = new LinkedList<>();
        int time = 0;

        while (!maxHeap.isEmpty() || !que.isEmpty()) {
            time++;
            if (!maxHeap.isEmpty()) {

                int x = maxHeap.poll();
                if (x - 1 > 0) {
                    que.add(new int[] { x - 1, time + n });
                }
            }
            if (!que.isEmpty() && que.peek()[1] == time) {
                maxHeap.add(que.poll()[0]);
            }
        }
        return time;
    }
}
