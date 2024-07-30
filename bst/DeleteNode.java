public class DeleteNode {
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
        // 5,3,6,2,4,null,7
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(7);
        // System.out.println(deleteNode(root, 3));
        System.out.println(deleteNode(root, 7));
    }

    public static TreeNode deleteNode(TreeNode root, int key) {
        if (root == null)
            return null;
        if (root.val == key)
            return helper(root);

        TreeNode temp = root;
        while (root != null) {
            if (key > root.val) {
                if (root.left != null && root.left.val == key) {
                    root.left = helper(root.left);
                    break;
                } else if (root.right != null && root.right.val == key) {
                    root.right = helper(root.right);
                    break;
                }

                root = root.right;
            } else if (key < root.val) {
                if (root.left != null && root.left.val == key) {
                    root.left = helper(root.left);
                    break;
                } else if (root.right != null && root.right.val == key) {
                    root.right = helper(root.right);
                    break;
                }
                root = root.left;
            }
        }

        return temp;
    }

    public static TreeNode helper(TreeNode root) {
        if (root.left == null) {
            return root.right;
        }
        if (root.right == null) {
            return root.left;
        }
        TreeNode rightChild = root.right;
        TreeNode lastRightChild = getRight(root.left);
        lastRightChild.right = rightChild;
        return root.left;
    }

    public static TreeNode getRight(TreeNode root) {
        if (root.right == null) {
            return root;
        }
        return getRight(root.right);
    }
}
