import java.util.ArrayList;
import java.util.List;

public class KthSmallestElement {
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
    static TreeNode root = null;
    public static void main(String[] args) {
        // int[] arr = {3,6,12,15,11,7};
        int[] arr = {3,1,4,2};
        for (int i = 0; i < arr.length; i++) {
            root = insert(root, arr[i]);
        }
        System.out.println(kthSmallest(root, 0));
    }
    public static TreeNode insert(TreeNode root, int val) {
        if (root == null) {
            root = new TreeNode(val);
        } else {
            if (val > root.val) {
                root.right = insert(root.right, val);
            } else {
                root.left = insert(root.left, val);
            }
        }
        return root;
    }

    static int count = 0;
    static int ans = 0;
    public static int kthSmallest(TreeNode root, int k) {
        inorder(root, k);
        return ans;
    }
    public static void inorder(TreeNode root, int k) {
        if (root==null){
            return;
        }
        inorder(root.left, k);
        count++;
        if (count == k) {
            ans = root.val;
            return;
        }
        inorder(root.right, k);
    }

    // public static int kthSmallest1(TreeNode root, int k) {
    //     List<Integer> list = new ArrayList<>();
    //     inorder(list, root);
    //     int ans = 0;
    //     for (int i = 0; i < k; i++) {
    //         ans = list.get(i);
    //     }
    //     return ans;
    // }
    // public static void inorder1(List<Integer> list, TreeNode root) {
    //     if (root==null){
    //         return;
    //     }
    //     inorder(list, root.left);
    //     list.add(root.val);
    //     inorder(list, root.right);
    // }
}
