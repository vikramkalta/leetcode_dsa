import java.util.ArrayList;

public class LongestCommonSubsequence {
    public static void main(String args[]) {
        // String text1 = "abcde";
        // String text2 = "ace";
        String text1 = "cba";
        String text2 = "ca";
        System.out.println(longestCommonSubsequence(text1, text2));
    }

    public static int longestCommonSubsequence(String text1, String text2) {
        int text1Len = text1.length();
        int text2Len = text2.length();
        ArrayList<ArrayList<Integer>> dp = new ArrayList<>();
        for (int i = 0; i < text1Len; i++) {
            ArrayList<Integer> innerList = new ArrayList<>();
            for (int j = 0; j < text2Len; j++) {
                innerList.add(-1);
            }
            dp.add(innerList);
        }
        return lcs(text1, text2, text1Len - 1, text2Len - 1, dp);
    }

    public static int lcs(String s1, String s2, int i, int j, ArrayList<ArrayList<Integer>> dp) {
        if (i < 0 || j < 0) {
            return 0;
        }
        if (dp.get(i).get(j) !=-1){
            return dp.get(i).get(j);
        }
        int ans = 0;
        if (s1.charAt(i) == s2.charAt(j)) {
            ans = 1 + lcs(s1, s2, i - 1, j - 1, dp);
        } else {
            int x = lcs(s1, s2, i - 1, j, dp);
            int y = lcs(s1, s2, i, j - 1, dp);
            ans = Math.max(x, y);
        }
        dp.get(i).set(j, ans);
        return ans;
    }
}