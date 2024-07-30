import java.util.ArrayList;

public class LongestPalindromicSubsequence {
    public static void main(String args[]) {
        // String s = "bbabb";
        String s = "bbbab";
        // String s = "cbbd";
        // String s = "aaa";
        System.out.println(longestPalindromeSubseq(s));
    }

    public static int longestPalindromeSubseq(String s) {
        int len = s.length();
        if (len == 1){
            return 1;
        }
        ArrayList<ArrayList<Integer>> dp = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            ArrayList<Integer> innerList = new ArrayList<>();
            for (int j = 0; j < len; j++) {
                innerList.add(-1);
            }
            dp.add(innerList);
        }
        int ans = longestPalindrome(s, 0, len - 1, dp);
        return ans;
    }

    public static int longestPalindrome(String s, int l, int r, ArrayList<ArrayList<Integer>> dp) {
        if (l >= r) {
            if (l==r) {
                return 1;
            }
            return 0;
        }
        if (dp.get(l).get(r) != -1) {
            return dp.get(l).get(r);
        }
        int ans = 0;
        if (s.charAt(l) == s.charAt(r)) {
            ans = 2 + longestPalindrome(s, l + 1, r - 1, dp);
        } else {
            int x = ans + longestPalindrome(s, l + 1, r, dp);
            int y = ans + longestPalindrome(s, l, r - 1, dp);
            ans = Math.max(x, y);
        }
        dp.get(l).set(r, ans);
        return ans;
    }
}
