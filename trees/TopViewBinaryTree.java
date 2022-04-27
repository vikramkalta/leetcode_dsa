import java.util.ArrayList;

public class TopViewBinaryTree {
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
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        // TreeNode root = new TreeNode(3);
        // root.left = new TreeNode(1);
        // root.left.right = new TreeNode(2);
        // TreeNode root = new TreeNode(2);
        // root.left = new TreeNode(3);
        // root.left.left = new TreeNode(2);
        System.out.println(solve(root));
    }
    public static ArrayList<Integer> solve(TreeNode A) {
        ArrayList<Integer> result = new ArrayList<>();
        result.add(A.val);
        // ArrayList<Integer> left = left(A.left, new ArrayList<>());
        // ArrayList<Integer> right = right(A.right, new ArrayList<>());
        left(A.left, result);
        right(A.right, result);
        return result;
    }
    public static ArrayList<Integer> left(TreeNode root, ArrayList<Integer> left) {
        if (root == null) {
            return left;
        }
        left.add(root.val);
        left(root.left, left);
        return left;
    }
    public static ArrayList<Integer> right(TreeNode root, ArrayList<Integer> right) {
        if (root == null) {
            return right;
        }
        right.add(root.val);
        right(root.right, right);
        return right;
    }
}
