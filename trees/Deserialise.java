import java.util.ArrayList;
import java.util.List;

public class Deserialise {
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
        // int[] arr = {1,2,3,4,5,-1,-1,-1,-1,-1,-1};
        int[] arr = {1, 2, 3, 4, 5, -1, 6, -1, -1, -1, -1, -1, -1};
        ArrayList<Integer> A = new ArrayList<>();
        for (int i =0; i < arr.length; i++)A.add(arr[i]);
        System.out.println(solve(A));
    }
    public static TreeNode solve(ArrayList<Integer> A) {
        int len = A.size();
        Queue q = new Queue(len);
        TreeNode root = new TreeNode(A.get(0));
        q.enqueue(root);
        if (len == 1) {
            return root;
        }
        int i = 1;
        while(!q.isEmpty()) {
            TreeNode front = q.dequeue();
            if (A.get(i) != -1) { 
                front.left = new TreeNode(A.get(i));
                q.enqueue(front.left);
            }
            if (i + 1 < len && A.get(i + 1) != -1) {
                front.right = new TreeNode(A.get(i + 1));
                q.enqueue(front.right);
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
                System.out.println("ill op[e]");
                System.exit(1);
            }
            rear = (rear + 1) % len;
            q[rear] = n;
            size++;
        }
        public TreeNode dequeue() {
            if (isEmpty()) {
                System.out.println("ill op[d]");
                System.exit(1);
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
            return size == len;
        }
    }
}
