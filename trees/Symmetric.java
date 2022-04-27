public class Symmetric {
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
        // root.left =  new TreeNode(2);
        // root.right =  new TreeNode(3);
        // root.left.left = new TreeNode(4);
        // root.left.right = new TreeNode(5);
        // root.right.left = new TreeNode(6);
        // root.right.right = new TreeNode(7);
        // root.left =  new TreeNode(2);
        // root.right =  new TreeNode(2);
        // root.left.left = new TreeNode(3);
        // root.left.right = new TreeNode(4);
        // root.right.left = new TreeNode(4);
        // root.right.right = new TreeNode(3);
        root.left =  new TreeNode(2);
        root.right =  new TreeNode(2);
        // root.left.left = new TreeNode(null);
        root.left.right = new TreeNode(3);
        // root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);
        System.out.println(isSymmetric(root));
    }
    public static boolean isSymmetric(TreeNode root) {
        boolean _isSymmetric = _isSymmetric(root.left, root.right);
        return _isSymmetric;
    }
    public static boolean _isSymmetric(TreeNode leftNode, TreeNode rightNode) {
        if (leftNode == null && rightNode == null) {
            return true;
        }
        if ((leftNode == null && rightNode != null) || (rightNode == null && leftNode !=null)) {
            return false;
        }
        if (leftNode.val != rightNode.val) {
            return false;
        }
        boolean left=_isSymmetric(leftNode.left, rightNode.right);
        boolean right=_isSymmetric(leftNode.right, rightNode.left);
        return left && right;
    }
}
