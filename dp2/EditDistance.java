import java.util.ArrayList;

public class EditDistance {
    public static void main(String args[]) {
        String word1 = "intention";
        String word2 = "execution";
        // String word1 = "horse";
        // String word2 = "ros";
        // String word1= "";
        // String word2 = "";
        // String word1= "b";
        // String word2 = "";
        // String word1 = "a";
        // String word2 = "a";
        // String word1 = "a";
        // String word2 = "ab";
        // String word1 = "prosperity";
        // String word2 = "properties";
        System.out.println(minDistance(word1, word2));
    }

    public static int min = Integer.MAX_VALUE;

    public static int minDistance(String word1, String word2) {
        ArrayList<ArrayList<Integer>> dp = new ArrayList<>();
        int word1Len = word1.length();
        int word2Len = word2.length();
        for (int i = 0; i < word1Len; i++) {
            ArrayList<Integer> innerList = new ArrayList<>();
            for (int j = 0; j < word2Len; j++) {
                innerList.add(-1);
            }
            dp.add(innerList);
        }
        int ans = getMinDistance(word1, word2, word1Len - 1, word2Len - 1, dp);
        return ans;
    }

    public static int getMinDistance(String s1, String s2, int i, int j, ArrayList<ArrayList<Integer>> dp) {
        if (i < 0) {
            return j + 1;
        }
        if (j < 0) {
            return i + 1;
        }
        int curr = dp.get(i).get(j);
        if (curr > -1) {
            return curr;
        }
        int result = 0;
        if (s1.charAt(i) == s2.charAt(j)) {
            result = getMinDistance(s1, s2, i - 1, j - 1,  dp);
        } else {
            int x = 1 + getMinDistance(s1, s2, i, j - 1, dp);
            int y = 1 + getMinDistance(s1, s2, i - 1, j, dp);
            int z = 1 + getMinDistance(s1, s2, i - 1, j - 1, dp);
            result = Math.min(x, Math.min(y, z));
        }
        dp.get(i).set(j, result);
        return result;
    }

    public static int getMinDistance1(String s1, String s2, int i, int j, int ans, ArrayList<ArrayList<Integer>> dp) {
        if (i < 0) {
            int x = ans + j + 1;
            if (min > x) {
                min = x;
            }
            return min;
        }
        if (j < 0) {
            int x = ans + i + 1;
            if (min > x) {
                min = x;
            }
            return min;
        }
        if (s1.charAt(i) == s2.charAt(j)) {
            return getMinDistance1(s1, s2, i - 1, j - 1, ans, dp);
        } else {
            int x = delete(s1, s2, i, j, ans + 1, dp);
            int y = replace(s1, s2, i, j, ans + 1, dp);
            int z = add(s1, s2, i, j, ans + 1, dp);
            int result = ans + x + y + z;
            return result;
        }
    }

    public static int delete(String s1, String s2, int i, int j, int ans, ArrayList<ArrayList<Integer>> dp) {
        int x = getMinDistance1(s1, s2, i - 1, j, ans, dp);
        int y = getMinDistance1(s1, s2, i, j - 1, ans, dp);
        return ans + x + y;
    }

    public static int replace(String s1, String s2, int i, int j, int ans, ArrayList<ArrayList<Integer>> dp) {
        int x = getMinDistance1(s1, s2, i - 1, j - 1, ans, dp);
        return ans + x;
    }

    public static int add(String s1, String s2, int i, int j, int ans, ArrayList<ArrayList<Integer>> dp) {
        int x = getMinDistance1(s1, s2, i, j - 1, ans, dp);
        int y = getMinDistance1(s1, s2, i - 1, j, ans, dp);
        return ans + x + y;
    }
}
