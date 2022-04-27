import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VerticalOrderTraversal {
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
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(6);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);
        System.out.println(verticalTraversal(root));
    }

    public static int min = Integer.MAX_VALUE;
    public static int max = Integer.MIN_VALUE;

    public static List<List<Integer>> verticalTraversal(TreeNode root) {
        HashMap<Integer, HashMap<Integer, List<Integer>>> verticalOrderMap = new HashMap<>();
        List<List<Integer>> result = new ArrayList<>();

        vertical(root, verticalOrderMap, 0, 0);

        for (int i = min; i <= max; i++) {
            List<Integer> innerList = new ArrayList<>();
            Map<Integer, List<Integer>> vMap = verticalOrderMap.get(i);
            List<Integer> depths = new ArrayList<>();
            for (Map.Entry<Integer, List<Integer>> entry : vMap.entrySet()){
                depths.add(entry.getKey());
            }
            Collections.sort(depths);
            for (int j = 0, len = depths.size(); j < len; j++) {
                int currKey = depths.get(j);
                List<Integer> currList = vMap.get(currKey);
                innerList.addAll(currList);
            }
            result.add(innerList);
        }
        return result;
    }

    public static void vertical(TreeNode root, HashMap<Integer, HashMap<Integer, List<Integer>>> verticalOrderMap,
            int mapKey, int depth) {
        if (root == null) {
            return;
        }
        if (mapKey < min) {
            min = mapKey;
        }
        if (mapKey > max) {
            max = mapKey;
        }
        if (verticalOrderMap.containsKey(mapKey)) {
            if (verticalOrderMap.get(mapKey).containsKey(depth)) {
                List<Integer> arr = verticalOrderMap.get(mapKey).get(depth);
                arr.add(root.val);
                Collections.sort(arr);
                verticalOrderMap.get(mapKey).put(depth, arr);
            } else {
                List<Integer> arr = new ArrayList<>();
                arr.add(root.val);
                verticalOrderMap.get(mapKey).put(depth, arr);
            }
        } else {
            HashMap<Integer, List<Integer>> innerMap = new HashMap<>();
            List<Integer> arr = new ArrayList<>();
            arr.add(root.val);
            innerMap.put(depth, arr);
            verticalOrderMap.put(mapKey, innerMap);
        }
        vertical(root.left, verticalOrderMap, mapKey - 1, depth + 1);
        vertical(root.right, verticalOrderMap, mapKey + 1, depth + 1);
    }
}