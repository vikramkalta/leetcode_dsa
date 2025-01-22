import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class NetworkDelays {
    public static void main(String[] args) {
        int[][] times = { { 2, 1, 1 }, { 2, 3, 1 }, { 3, 4, 1 } };
        System.out.println(networkDelayTime(times, 4, 2));
    }

    public static int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> graph = new ArrayList<>();
        int[] visited = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }
        int len = times.length;
        for (int i = 0; i < len; i++) {
            graph.get(times[i][0]).add(new int[] { times[i][1], times[i][2] });
        }

        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(k);
        int minTime = 0;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            visited[node] = 1;

            int min = Integer.MAX_VALUE;
            List<int[]> neighbors = graph.get(node);
            for (int i = 0; i < neighbors.size(); i++) {
                int[] currNode = neighbors.get(i);
                if (visited[currNode[0]] == 0) {
                    queue.add(currNode[0]);
                    min = Math.min(min, currNode[1]);
                }
            }
            minTime += (Integer.MAX_VALUE == min ? 0 : min);
        }
        int totalVisited = 0;
        for (int i: visited) {
            if (i==1) totalVisited++;
        }
        return  totalVisited == n ? minTime : -1;
    }
}
