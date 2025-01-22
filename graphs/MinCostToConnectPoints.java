import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class MinCostToConnectPoints {
    public static void main(String[] args) {
        int[][] points = { { 0, 0 }, { 2, 2 }, { 3, 10 }, { 5, 2 }, { 7, 0 } };
        System.out.println(minCostConnectPoints(points));
    }

    private static class Vertex {
        int start;
        int end;
        int dist;

        public Vertex(int start, int end, int dist) {
            this.start = start;
            this.end = end;
            this.dist = dist;
        }
    }

    public static int minCostConnectPoints(int[][] points) {
        int len = points.length;
        int[][] graph = new int[len][2];
        int[] parent = new int[len];
        int[] rank = new int[len];
        for (int i = 0; i < len; i++) {
            graph[i] = new int[2];
            parent[i] = i;
            rank[i] = 0;
        }

        PriorityQueue<Vertex> minHeap = new PriorityQueue<>((a, b) -> a.dist - b.dist);
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                int dist = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                minHeap.add(new Vertex(i, j, dist));
                minHeap.add(new Vertex(j, i, dist));
            }
        }
        int totalCost= 0;
        while (!minHeap.isEmpty()) {
            Vertex top = minHeap.poll();
            int start = top.start;
            int end = top.end;
            if (find(start, parent) != find(end, parent)) {
                union(start, end, parent, rank);
                totalCost += top.dist;
            }
        }
        return totalCost;
    }

    public static void union(int start, int end, int[] parent, int[] rank) {
        int parentStart = find(start, parent);
        int parentEnd = find(end, parent);
        if (rank[parentStart] > rank[parentEnd]) {
            parent[parentStart] = parentEnd;
            rank[parentEnd]++;
        } else {
            parent[parentEnd] = parentStart;
            rank[parentStart]++;
        }
    }
    public static int find(int start, int[] parent) {
        if (parent[start] != start) {
            return find(parent[start], parent);
        }
        return parent[start];
    }

}