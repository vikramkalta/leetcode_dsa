import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class ZigzagLevelOrder {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
            left = null;
            right = null;
        }
    }

    public static void main(String args[]) {
        // TreeNode root = new TreeNode(1);
        // root.left = new TreeNode(2);
        // root.right = new TreeNode(3);
        // root.left.left = new TreeNode(4);
        // root.left.right = new TreeNode(5);
        // root.right.left = new TreeNode(6);
        // root.right.right = new TreeNode(7);
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        // root.left.left = new TreeNode(4);
        // root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(zigzagLevelOrder(root));
    }

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        Queue q = new Queue(2001);
        q.enqueue(new Pair(0, root));
        HashMap<Integer, List<Integer>> levelMap = new HashMap<>();

        List<Integer> innerList = new ArrayList<>();
        innerList.add(root.val);
        result.add(innerList);
        int maxHeight = Integer.MIN_VALUE;

        while (!q.isEmpty()) {
            Pair front = q.dequeue();
            if (maxHeight < front.level) {
                maxHeight = front.level;
            }
            if (front.node != null) {
                List<Integer> list;
                if (front.node.left != null) {
                    if (levelMap.containsKey(front.level + 1)) {
                        list = levelMap.get(front.level + 1);
                        list.add(front.node.left.val);
                    } else {
                        list = new ArrayList<>();
                        list.add(front.node.left.val);
                    }
                    levelMap.put(front.level + 1, list);
                    q.enqueue(new Pair(front.level + 1, front.node.left));
                }
                if (front.node.right != null) {
                    if (levelMap.containsKey(front.level + 1)) {
                        list = levelMap.get(front.level + 1);
                        list.add(front.node.right.val);
                    } else {
                        list = new ArrayList<>();
                        list.add(front.node.right.val);
                    }
                    levelMap.put(front.level + 1, list);
                    q.enqueue(new Pair(front.level + 1, front.node.right));
                }
            }
        }
        for (int i = 1; i <= maxHeight; i++) {
            List<Integer> list = levelMap.get(i);
            if (i % 2 != 0) {
                Collections.reverse(list);
            }
            result.add(list);
        }
        return result;
    }

    static class Pair {
        int level;
        TreeNode node;

        Pair(int _level, TreeNode _node) {
            this.level = _level;
            this.node = _node;
        }
    }

    static class Queue {
        int len = 0, size = 0, rear = -1, front = 0;
        Pair[] q;

        Queue(int n) {
            len = n;
            q = new Pair[n];
        }

        public void enqueue(Pair n) {
            if (isFull()) {
                System.out.println("ill op[e]");
                System.exit(1);
            }
            rear = (rear + 1) % len;
            q[rear] = n;
            size++;
        }

        public Pair dequeue() {
            if (isEmpty()) {
                System.out.println("ill op[d]");
                System.exit(1);
            }
            Pair temp = q[front];
            front = (front + 1) % len;
            size--;
            return temp;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean isFull() {
            return size == len;
        }
    }
}
