public class IdenticalTree {
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
        int[] tree1 = { 4, 2, 5, 1, 6, 3, 7 };

        int[] tree2 = { 1, 2, 4, 5, 3, 6, 7 };
        // System.out.println(buildTree(inorder, preorder));
    }
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        // boolean isSame = _isSameTree(p, q);
        // return isSame;
        if (p == null && q == null) {
            return true;
        }
        if ((p == null && q != null) || (p != null && q == null)) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        boolean left = isSameTree(p.left, q.left);
        boolean right = isSameTree(p.right, q.right);
        return left && right;
    }
    public static boolean _isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if ((p == null && q != null) || (p != null && q == null)) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        boolean left = _isSameTree(p.left, q.left);
        boolean right = _isSameTree(p.right, q.right);
        return left && right;
    }
}
