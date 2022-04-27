import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RightView {
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
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        // TreeNode root = new TreeNode(3);
        // root.left = new TreeNode(1);
        // root.left.right = new TreeNode(2);
        // TreeNode root = new TreeNode(2);
        // root.left = new TreeNode(3);
        // root.left.left = new TreeNode(2);
        System.out.println(rightSideView(root));
    }

    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        HashMap<Integer, List<Integer>> levelMap = new HashMap<>();
        Queue q = new Queue(101);
        q.enqueue(new Pair(0, root));
        int maxLevel = Integer.MIN_VALUE;
        while (!q.isEmpty()) {
            Pair front = q.dequeue();

            if (front.node == null) {
                continue;
            }

            if (levelMap.containsKey(front.level)) {
                List<Integer> list = levelMap.get(front.level);
                list.add(front.node.val);
                levelMap.put(front.level, list);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(front.node.val);
                levelMap.put(front.level, list);
            }
            if (maxLevel < front.level) {
                maxLevel = front.level;
            }

            if (front.node.right != null) {
                q.enqueue(new Pair(front.level + 1, front.node.right));
            }
            if (front.node.left != null) {
                q.enqueue(new Pair(front.level + 1, front.node.left));
            }
        }
        for (int i = 0; i <= maxLevel; i++) {
            result.add(levelMap.get(i).get(0));
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

        public void enqueue(Pair p) {
            if (isFull()) {
                System.exit(1);
                System.out.println("ill op[en]");
            }
            rear = (rear + 1) % len;
            q[rear] = p;
            size++;
        }

        public Pair dequeue() {
            if (isEmpty()) {
                System.exit(1);
                System.out.println("ill op[de]");
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
