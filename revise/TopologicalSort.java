import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayList;
import java.util.Arrays;

public class TopologicalSort {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        adj.add(new ArrayList<>(Arrays.asList(1, 2))); // Node 0 has edges to 1 and 2
        adj.add(new ArrayList<>(Arrays.asList(3, 4))); // Node 1 has edges to 3 and 4
        adj.add(new ArrayList<>(Arrays.asList(4))); // Node 2 has an edge to 4
        adj.add(new ArrayList<>(Arrays.asList(5))); // Node 3 has an edge to 5
        adj.add(new ArrayList<>(Arrays.asList(5))); // Node 4 has an edge to 5
        adj.add(new ArrayList<>());
    }

    public static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
        int indegree[] = new int[V];
        for (int i = 0; i < V; i++) {
            for (int it : adj.get(i)) {
                indegree[it]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }
        int[] topo = new int[V];
        int i = 0;

        while (!q.isEmpty()) {
            int node = q.peek();
            q.remove();
            topo[i++] = node;
            for (int it : adj.get(node)) {
                indegree[it]--;
                if (indegree[it] == 0) {
                    q.add(it);
                }
            }
        }
        return topo;
    }
}
