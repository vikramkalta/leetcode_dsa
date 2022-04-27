public class TreeFromInAndPost {
    public static void main(String args[]) {
        int[] inorder = { 4, 2, 5, 1, 6, 3, 7 };
        int[] postorder = { 4, 5, 2, 6, 7, 3, 1 };
        System.out.println(buildTree(inorder, postorder));
    }
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
    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        int len = inorder.length;
        TreeNode root = _buildTree(inorder, postorder, 0, len - 1, 0, len - 1);
        return root;
    }
    public static TreeNode _buildTree(int[] inorder, int[] postorder, int inStart, int inEnd, int postStart, int postEnd) {
        if (inEnd < inStart || postEnd < postStart) {
            return null;
        }
        int rootEl = postorder[postEnd];
        TreeNode root = new TreeNode(rootEl);
        int inIndex = inStart;
        int foundIndex = -1;
        while (inIndex <= inEnd) {
            if (inorder[inIndex] == rootEl) {
                foundIndex = inIndex;
                break;
            }
            inIndex++;
        }
        TreeNode left = _buildTree(inorder, postorder, inStart, foundIndex - 1, postStart, postStart + foundIndex - 1 - inStart);
        TreeNode right = _buildTree(inorder, postorder, foundIndex + 1, inEnd, postEnd - (inEnd - foundIndex), postEnd - 1);
        root.left = left;
        root.right = right;
        return root;
    }
}
