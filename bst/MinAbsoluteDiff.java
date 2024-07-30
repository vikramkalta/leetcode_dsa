public class MinAbsoluteDiff {
    static class TreeNode {
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
        // int[] arr = {4,2,6,1,3};
        int[] arr = { 1, 0, 48, 12, 49 };
        insert(arr);
        System.out.println(getMinimumDifference(root));
        System.out.println();
    }

    static TreeNode root = null;

    public static void insert(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            root = insert(root, arr[i]);
        }
        return;
    }

    public static TreeNode insert(TreeNode node, int val) {
        if (node == null) {
            node = new TreeNode(val);
        } else {
            if (node.val > val) {
                node.left = insert(node.left, val);
            } else if (node.val < val) {
                node.right = insert(node.right, val);
            }
        }
        return node;
    }

    public static int getMinimumDifference(TreeNode root) {
        prev = root.val;
        inorder(root);
        return minDiff;
    }

    static int prev = 0;
    static int minDiff = Integer.MAX_VALUE;

    public static void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        if (prev != root.val)
            minDiff = Math.min(minDiff, Math.abs(prev - root.val));
        prev = root.val;
        inorder(root.right);
    }
}
