public class RedundantConn {
    public static void main(String[] args) {
        // int[][] edges = { { 1, 2 }, { 1, 3 }, { 2, 3 } };
        // int[][] edges = {{1,2},{2,3},{3,4},{1,4},{1,5}};
        // int[][] edges = { { 1, 5 }, { 3, 4 }, { 3, 5 }, { 4, 5 }, { 2, 4 } };
        int[][]edges={{3,4},{1,2},{2,4},{3,5},{2,5}};
        System.out.println(findRedundantConnection(edges));
    }

    public static int[] findRedundantConnection(int[][] edges) {
        int size = 10;
        int[] parent = new int[size];
        int[] rank = new int[size];
        int len = edges.length;
        int[] ans = new int[2];

        for (int i = 0; i < size; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < len; i++) {
            int x = edges[i][0];
            int y = edges[i][1];
            boolean res = union(y, x, parent, rank);
            if (!res) {
                ans = edges[i];
                break;
            }
        }
        return ans;
    }

    public static int find(int node, int[] parent) {
        if (parent[node] != node) {
            return find(parent[node], parent);
        }
        return parent[node];
    }

    public static boolean union(int v1, int v2, int[] parent, int[] rank) {
        int parentV1 = find(v1, parent);
        int parentV2 = find(v2, parent);
        if (parentV1 == parentV2) {
            // already joined, do something
            return false;
        } else {
            if (rank[parentV1] > rank[parentV2]) {
                parent[v2] = parentV1;
                rank[parentV1]++;
            } else {
                parent[parentV1] = parentV2;
                rank[parentV2]++;
            }
            return true;
        }
    }
}
