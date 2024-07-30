public class BinaryTreeToLinkedList {
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
        flatten(root);
        // 1,2,4,5,3,6,7
    }

    static TreeNode prev = null;
    public static void flatten(TreeNode root) {
        if (root==null) {
            return;
        }
        flatten(root.right);
        flatten(root.left);
        // Set root.right to prev
        root.right = prev;
        // Set root.left to null 
        root.left = null;
        prev = root;
    }

    // public static void preOrder(TreeNode root, TreeNode linkedList) {
    //     if (root == null) {
    //         return;
    //     }
    //     linkedList.right = root.left;
    //     preOrder(root.left, linkedList.right);
    //     preOrder(root.right, linkedList.right);
    // }
}
