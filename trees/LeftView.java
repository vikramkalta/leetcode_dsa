public class LeftView {
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
        // System.out.println(leftView(root));
    }
}
