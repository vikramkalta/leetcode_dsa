import java.util.ArrayList;
import java.util.List;

public class SerializeDeserialize {
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
        // [1,2,3,null,null,4,5,6,7]
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
        // root.left.left = new TreeNode(4);
        // root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        root.right.left.left = new TreeNode(6);
        root.right.left.right = new TreeNode(7);
        // TreeNode root = null;
        String str = serialize(root);
        System.out.println(str);
        System.out.println(deserialize(str));
    }

    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        StringBuilder str = new StringBuilder();
        if (root == null) {
            return new String();
        }
        Queue q = new Queue(10001);
        q.enqueue(root);
        while (!q.isEmpty()) {
            TreeNode front = q.dequeue();
            str.append(front == null ? "|" : front.val);
            str.append("_");
            if (front != null) {
                q.enqueue(front.left);
                q.enqueue(front.right);
            }
        }
        return new String(str);
    }

    public static TreeNode root;

    public static TreeNode deserialize(String data) {
        if (data.equals("")) {
            return null;
        }
        List<Integer> list = new ArrayList<>();
        int i = 0, len = data.length();
        while (i < len) {
            int j = i;
            StringBuilder currIntegerStr = new StringBuilder();
            while (data.charAt(j) != '_') {
                currIntegerStr.append(data.charAt(j) == '|' ? Integer.MIN_VALUE : data.substring(j,j+1));
                j++;
            }
            list.add(Integer.valueOf(new String(currIntegerStr)));
            i = j;
            i++;
        }
        root = createTree(list, root);
        return root;
    }

    public static TreeNode createTree(List<Integer> data, TreeNode root) {
        int i = 0, len = data.size();
        Queue q = new Queue(10001);
        root = new TreeNode(data.get(i));
        q.enqueue(root);
        i++;
        while (i < len) {
            TreeNode front = q.dequeue();
            if (data.get(i) != Integer.MIN_VALUE) {
                front.left = new TreeNode(data.get(i));
                q.enqueue(front.left);
            }
            if (i + 1 < len) {
                if (data.get(i + 1) != Integer.MIN_VALUE) {
                    front.right = new TreeNode(data.get(i + 1));
                    q.enqueue(front.right);
                }
            }
            i += 2;
        }
        return root;
    }

    static class Queue {
        int len = 0, size = 0, rear = -1, front = 0;
        TreeNode[] q;

        Queue(int n) {
            q = new TreeNode[n];
            len = n;
        }

        public void enqueue(TreeNode n) {
            if (isFull()) {
                System.exit(1);
                System.out.println("Ill op[e]");
            }
            rear = (rear + 1) % len;
            q[rear] = n;
            size++;
        }

        public TreeNode dequeue() {
            if (isEmpty()) {
                System.exit(1);
                System.out.println("Ill op[d]");
            }
            TreeNode temp = q[front];
            front = (front + 1) % len;
            size--;
            return temp;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean isFull() {
            return len == size;
        }
    }
}
