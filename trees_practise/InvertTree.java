public class InvertTree {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
            right = null;
            left = null;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        invertTree(root);
    }
    public static TreeNode invertTree(TreeNode root) {
        if (root==null){
            return null;
        }
        TreeNode t = new TreeNode(root.val);
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        t.left = right;
        t.right = left;
        return t;
    }
}
