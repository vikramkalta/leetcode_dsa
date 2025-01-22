public class LongestPalinSubstr {
    public static void main(String[] args) {
        // String s = "abbc";
        String s = "abba";
        // String s = "ababc";
        System.out.println(longestPalindrome(s));
    }

    public static String longestPalindrome(String s) {
        int len = s.length();
        int[][] dp = new int[len][len];
        int min = 0;
        int maxLen = 0;
        for (int i = 0; i < len; i++) {
            dp[i][i] = 1;
            if (i+1<len && s.charAt(i) == s.charAt(i+1)) {
                dp[i][i+1]= 2;
                min = i;
                maxLen = 2;
            }
        }
        for (int n = 1; n < len; n++) {
            for (int i = 0,  j = n; j < len; i++,j++) {
                char x = s.charAt(i);
                char y = s.charAt(j);
                if (x==y && dp[i+1][j-1] > 0) {
                    dp[i][j] = dp[i+1][j-1] + 2;
                    if (dp[i][j] > maxLen) {
                        maxLen = dp[i][j];
                        min = i;
                    }
                }
            }
        }
        
        return s.substring(min, min + maxLen);
    }
}
