import javax.swing.tree.TreeNode;

public class ValidBST {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(6);
        //    5
        //   1  4
        //     3  6
        // TreeNode root = new TreeNode(2);
        // root.left = new TreeNode(2);
        // root.right = new TreeNode(2);
        // TreeNode root = new TreeNode(2);
        // root.left = new TreeNode(1);
        // root.right = new TreeNode(3);
        // TreeNode root = new TreeNode(2);
        // root.left = new TreeNode(2);
        // root.right = new TreeNode(2);
        // TreeNode root = new TreeNode(5);
        // root.left = new TreeNode(4);
        // root.right = new TreeNode(6);
        // root.right.left = new TreeNode(3);
        // root.right.right = new TreeNode(7);
        // TreeNode root = new TreeNode(3);
        // root.left = new TreeNode(1);
        // root.right = new TreeNode(5);
        // root.left.left = new TreeNode(0);
        // root.left.right = new TreeNode(2);
        // root.right.left = new TreeNode(4);
        // root.right.right = new TreeNode(6);
        System.out.println(isValidBST(root));
        //      3
        //    1   5
        //  0   2 4  6
    }

    public static boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left!=null && getMax(root.left) > root.val) {
            return false;
        }
        if (root.right !=null && getMin(root.right) < root.val) {
            return false;
        }
        boolean x = isValidBST(root.left);
        boolean y = isValidBST(root.right);
        return x && y;
    }
    public static int getMax(TreeNode root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }
        int z = root.val;
        int x = getMax(root.left);
        int y = getMax(root.right);
        return Math.max(x, Math.max(z, y));
    }
    public static int getMin(TreeNode root) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }
        int z = root.val;
        int x = getMin(root.left);
        int y = getMin(root.right);
        return Math.min(x, Math.min(z, y));
    }
}
