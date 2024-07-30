public class RegexMatchDP {
    public static void main(String[] args) {
        // String s = "aab";
        // String p = "a*b";
        // String s = "aabb";
        // String p = "a*b";
        String s = "ab";
        String p = ".*";
        //      a a b b
        //   {t,f,f,f,f}
        // a {f,t,f,f,f}
        // * {t,t,t,f,f}
        // b {f,f,f,f,f}
        System.out.println(isMatch(s, p));
    }

    public static boolean isMatch(String s, String p) {
        int sLen = s.length();
        int pLen = p.length();
        boolean[][] dp = new boolean[pLen + 1][sLen + 1];
        dp[0][0] = true;
        
        for (int i = 1; i <= pLen; i++) {
            if (p.charAt(i - 1) == '*')
                dp[i][0] = dp[i-2][0];
        }
        for (int i = 1; i <= pLen; i++) {
            for (int j = 1; j <= sLen; j++) {
                if (p.charAt(i - 1) == s.charAt(j - 1) || p.charAt(i-1) == '.') {
                    dp[i][j] = dp[i-1][j-1];
                } else if (p.charAt(i-1) == '*') {
                    if (dp[i-2][j] || ((p.charAt(i-2) == s.charAt(j-1) || p.charAt(i-2) == '.') && dp[i][j-1])) {
                        dp[i][j] = true;
                    }
                }
            }
        }
        return dp[pLen][sLen];
    }
}
