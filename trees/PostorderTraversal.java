import java.util.ArrayList;
import java.util.List;

public class PostorderTraversal {
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
        // root.right = new TreeNode(2);
        // root.right.left = new TreeNode(3);
        TreeNode root = new TreeNode(1);
        root.left =  new TreeNode(2);
        root.right =  new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        System.out.println(postorderTraversal(root));
    }

    public static List<Integer> postorderTraversal(TreeNode root) {
        TreeNode curr = root;
        ArrayList<Integer> result = new ArrayList<>();
        Stack s = new Stack(1000);
        while(!s.isEmpty() || curr != null) {
            if (curr != null) {
                s.push(curr);
                result.add(curr.val);
                curr = curr.right;
            } else {
                curr = s.pop();
                curr = curr.left;
            }
        }
        int len = result.size();
        for (int i = 0; i < len / 2; i++) {
            int left = result.get(i);
            int right = result.get(len - 1 - i);
            result.set(i, right);
            result.set(len - 1 - i, left);
        }
        return result;
    }

    static class Stack {
        int len = 0, size = 0, top = -1;
        TreeNode[] stack;
        Stack(int n) {
            stack = new TreeNode[n];
            len = n;
        }
        public void push(TreeNode n) {
            if (isFull()) {
                System.out.println("Ill op[pu]");
                System.exit(1);
            }
            top++;
            stack[top] = n;
            size++;
        }
        public TreeNode pop() {
            if (isEmpty()) {
                System.out.println("ill op[po]");
                System.exit(1);
            }
            TreeNode temp = stack[top];
            top--;
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
