public class Diameter {
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
        // TreeNode root = new TreeNode(3);
        // root.left = new TreeNode(1);
        // root.left.right = new TreeNode(2);
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(2);
        System.out.println(diameterOfBinaryTree(root));
    }

    public static int max = Integer.MIN_VALUE;
    public static int diameterOfBinaryTree(TreeNode root) {
        int ans = getDiameter(root);
        return max;
    }
    public static int getDiameter(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = Math.max(getDiameter(root.left), getHeight(root.left));
        int rightHeight = Math.max(getDiameter(root.right), getHeight(root.right));
        int diameter = leftHeight + rightHeight;
        if (max < diameter) {
            max = diameter;
        }
        return Math.max(leftHeight, rightHeight);
    }
    // public static int getDiameter1(TreeNode root) {
    //     if (root == null) {
    //         return 0;
    //     }
    //     int leftH = getDiameter(root.left);
    //     int rightH = getDiameter(root.right);
    //     int leftHeight = getLeftHeight(root);
    //     int rightHeight = getRightHeight(root);
    //     int diameter = Math.max(leftH, rightH) +  Math.max(leftHeight, rightHeight);
    //     if (max < diameter) {
    //         max = diameter;
    //     }
    //     return diameter;
    // }
    public static int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = getHeight(root.left) + 1;
        int right = getHeight(root.right) + 1;
        return Math.max(left, right);
    }
}
