public class TreeFromInAndPre {
    public static void main(String args[]) {
        int[] inorder = { 4, 2, 5, 1, 6, 3, 7 };
        int[] preorder = { 1, 2, 4, 5, 3, 6, 7 };
        System.out.println(buildTree(inorder, preorder));
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
    public static TreeNode buildTree(int[] inorder, int[] preorder) {
        int len = inorder.length;
        TreeNode root = _buildTree(inorder, preorder, 0, len - 1, 0, len - 1);
        return root;
    }
    public static TreeNode _buildTree(int[] inorder, int[] preorder, int inStart, int inEnd, int preStart, int preEnd) {
        if (inStart > inEnd || preStart > preEnd) {
            return null;
        }
        int rootEl = preorder[preStart];
        int index = inStart;
        while(index <= inEnd) {
            if (inorder[index] == rootEl) {
                break;
            }
            index++;
        }
        TreeNode root = new TreeNode(rootEl);
        TreeNode left = _buildTree(inorder, preorder, inStart, index - 1, preStart + 1, (preStart + 1) + (index - 1 - inStart));
        TreeNode right = _buildTree(inorder, preorder, index + 1, inEnd, preEnd - (inEnd - (index + 1)), preEnd);
        root.left = left;
        root.right = right;
        return root;
    }
}
