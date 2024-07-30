public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("findnitianhere"));
        // System.out.println(longestPalindrome("cbbd"));
    }

    static public String longestPalindrome(String s) {
        int len = s.length();
        int[][] dp = new int[len][len];
        int start = 0;
        int maxPalLen = 1;
        for (int i = 0; i < len; i++) {
            dp[i][i] = 1;
            if (i < len - 1 && dp[i][i + 1] == dp[i][i]) {
                dp[i][i+1]=1;
            }
        }
        for (int i = 3; i <= len; i++) {
            for (int j = 0; j < len - i + 1; j++) {
                int k = j + i - 1;
                if (dp[j+1][k-1] == 1 && s.charAt(j)==s.charAt(k)) {
                    dp[j][k] = 1;
                    if (i>maxPalLen) {
                        start=j;
                        maxPalLen = i;
                    }
                }
            }
        }
        return s.substring(start, start + maxPalLen);
    }
}