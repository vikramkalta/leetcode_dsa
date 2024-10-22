import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.ArrayList;

public class TaskScheduler {
    public static void main(String[] args) {
        // char[] tasks = { 'A', 'A', 'A', 'B', 'B', 'B' };
        char[] tasks = { 'A', 'A', 'A', 'B', 'B', 'C','D' };
        // A,B,C,A,B,C,A,D
        System.out.println(leastInterval(tasks, 2));
    }

    public static int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> countMap = new HashMap<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b-a);
        for (char c:tasks){
            countMap.put(c, countMap.getOrDefault(c, 0) + 1);
        }
        maxHeap.addAll(countMap.values());
        int cycles = 0;
        while (!maxHeap.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < n+1; i++) {
                if (!maxHeap.isEmpty()) {
                    temp.add(maxHeap.remove());
                }
            }
            for (int t: temp) {
                if (t-1>0){
                    maxHeap.add(t-1);
                }
            }
            cycles += maxHeap.isEmpty() ? temp.size() : n+1;
        }

        return cycles;
    }

        HashMap<Character, Integer> countMap = new HashMap<>();

    public static int leastInterval2(char[] tasks, int n) {

        HashMap<Character, Integer> countMap = new HashMap<>();
        for (int i = 0; i < tasks.length; i++) {
            char curr = tasks[i];
            countMap.put(curr, countMap.getOrDefault(curr, 0) + 1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>(
                (a, b) -> b.getValue() - a.getValue());
        maxHeap.addAll(countMap.entrySet());

        int ans = 0;
        while (!maxHeap.isEmpty()) {
            int coolingPeriod = n + 1;
            int taskCount = 0;
            while (coolingPeriod >= 0 && !maxHeap.isEmpty()) {
                Map.Entry<Character, Integer> entry = maxHeap.poll();
                char curr = entry.getKey();
                int x = countMap.get(curr);
                if (x == 1) {
                    countMap.remove(curr);
                    maxHeap.remove(entry);
                } else {
                    countMap.put(curr, x - 1);
                }
                coolingPeriod--;
                taskCount++;
            }
            maxHeap.addAll(countMap.entrySet());
            ans += maxHeap.isEmpty() ? taskCount : n + 1;
        }

        return ans;
    }

    public static int leastInterval1(char[] tasks, int n) {
        // Create countMap to get count of each char and decrement it, each time it is
        // used.
        HashMap<Character, Integer> countMap = new HashMap<>();
        // Create locationMap which tracks last position.
        HashMap<Character, Integer> locationMap = new HashMap<>();
        int len = tasks.length;
        for (int i = 0; i < len; i++) {
            char curr = tasks[i];
            if (countMap.containsKey(curr)) {
                countMap.put(curr, countMap.get(curr) + 1);
            } else {
                countMap.put(curr, 1);
            }
        }
        List<Character> list = new ArrayList<>();
        int i = 0;
        int count = 0;
        char c = 'A';

        while (c <= 'Z') {

            if (countMap.containsKey(c)) {
                if (!locationMap.containsKey(c)) {
                    if (countMap.get(c) == 1) {
                        countMap.remove(c);
                    } else {
                        countMap.put(c, countMap.get(c) - 1);
                        locationMap.put(c, count);
                    }
                    count++;
                } else if (count - locationMap.getOrDefault(c, 0) > n) {
                    if (countMap.get(c) == 1) {
                        countMap.remove(c);
                        locationMap.remove(c);
                    } else {
                        countMap.put(c, countMap.get(c) - 1);
                    }
                    locationMap.put(c, count);
                    count++;
                } else {
                    count++;
                }
            }
            // Loop cycling
            if (c == 'Z') {
                c = 'A';
            } else {
                c++;
            }
        }
        // Time complexity is n*26
        return count;
    }
}
