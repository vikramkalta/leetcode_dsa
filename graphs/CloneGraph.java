import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

public class CloneGraph {
    static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    public static void main(String[] args) {
        int[][] adjList = { { 2, 4 }, { 1, 3 }, { 2, 4 }, { 1, 3 } };
        HashMap<Integer, Node> nodeMap = new HashMap<>();
        for (int i = 0; i < adjList.length; i++) {
            int[] curr = adjList[i];
            int n1 = curr[0];
            int n2 = curr[1];
            Node mainNode;
            if (nodeMap.containsKey(i + 1)) {
                mainNode = nodeMap.get(i + 1);
            } else {
                mainNode = new Node(i + 1);
                nodeMap.put(i + 1, mainNode);
            }
            Node n1Node;
            if (nodeMap.containsKey(n1)) {
                n1Node = nodeMap.get(n1);
            } else {
                n1Node = new Node(n1);
                nodeMap.put(n1, n1Node);
            }
            Node n2Node;
            if (nodeMap.containsKey(n2)) {
                n2Node = nodeMap.get(n2);
            } else {
                n2Node = new Node(n2);
                nodeMap.put(n2, n2Node);
            }
            mainNode.neighbors.add(n1Node);
            mainNode.neighbors.add(n2Node);
            // n2Node.neighbors.add(mainNode);
            // n1Node.neighbors.add(mainNode);
        }
        System.out.println(cloneGraph(nodeMap.get(1)));
    }

    public static Node cloneGraph(Node node) {
        HashMap<Integer, Node> nodeMap = new HashMap<>();
        Node newNode = new Node(node.val);
        nodeMap.put(node.val, newNode);
        int[] visited = new int[100];
        dfs(node, nodeMap, visited);
        return newNode;
    }

    public static void dfs(Node node, HashMap<Integer, Node> nodeMap, int[] visited) {
        visited[node.val] = 1;
        List<Node> neighbours = node.neighbors;
        for (int i = 0; i < neighbours.size(); i++) {
            Node neighbour = neighbours.get(i);
            Node newNeighbour;
            if (nodeMap.containsKey(neighbour.val)) {
                newNeighbour = nodeMap.get(neighbour.val);
            } else {
                newNeighbour = new Node(neighbour.val);
                nodeMap.put(neighbour.val, newNeighbour);
            }
            Node parent = nodeMap.get(node.val);
            parent.neighbors.add(newNeighbour);
            if (visited[neighbour.val] == 0) {
                dfs(neighbour, nodeMap, visited);
            }
        }
    }

}
