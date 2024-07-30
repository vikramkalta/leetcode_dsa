package dp_on_trees;

import java.util.ArrayList;
import java.util.List;

public class MaxDepth {
    static class Node {
        public int val;
        public List<Node> children;
        public Node(int _val) {
            val = _val;
        }
        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
    public static void main(String args[]) {
        Node root = new Node(1);
        root.children = new ArrayList<>();
        Node root1 = new Node(3);
        root1.children = new ArrayList<>();
        Node root2 = new Node(2);
        Node root3 = new Node(4);
        Node root11 = new Node(5);
        Node root12 = new Node(6);
        root.children.add(root1);
        root.children.add(root2);
        root.children.add(root3);
        root1.children.add(root11);
        root1.children.add(root12);
        System.out.println(getHeight(root));
    }
    public static int getHeight(Node root) {
        if (root == null || root.children == null) {
            return 0;
        }
        int maxHeight = 0;
        for (int i = 0; i < root.children.size(); i++) {
            Node node = root.children.get(i);
            int height = getHeight(node);
            maxHeight = Math.max(maxHeight, height);
        }
        return maxHeight + 1;
    }
}
