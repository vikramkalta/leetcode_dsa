import javax.swing.tree.TreeNode;

public class SubtreeOfAnotherTree {
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
        // TreeNode root = new TreeNode(3);
        // root.left = new TreeNode(4);
        // root.right = new TreeNode(5);
        // root.left.left = new TreeNode(1);
        // root.left.right = new TreeNode(2);

        // TreeNode subRoot = new TreeNode(4);
        // subRoot.left = new TreeNode(1);
        // subRoot.right = new TreeNode(2);
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(1);

        TreeNode subRoot = new TreeNode(1);
        System.out.println(isSubtree(root, subRoot));
    }

    public static boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (subRoot == null) {
            return true;
        }
        if (root == null) {
            return false;
        }
        if (isDup(root, subRoot)) {
            return true;
        } else {
            return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
        }
    }

    public static boolean isDup(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) {
            return true;
        }
        if (root != null && subRoot != null && root.val == subRoot.val) {
            return isDup(root.left, subRoot.left) && isDup(root.right, subRoot.right);
        }
        return false;
    }

    public static boolean isSame(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) {
            return true;
        }
        if (root != null && subRoot == null) {
            return true;
        }
        if (root == null && subRoot != null) {
            return true;
        }
        if (root.val == subRoot.val) {
            boolean x = isSame(root.left, subRoot.left);
            boolean y = isSame(root.right, subRoot.right);
            return x && y;
        } else {
            boolean x = isSame(root.left, subRoot);
            boolean y = isSame(root.right, subRoot);
            return x || y;
        }
    }
}
