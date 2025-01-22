public class DecodeWays {
    public static void main(String[] args) {
        String s = "11106";
        // System.out.println(numDecodings(s));
        System.out.println(numDecodingsIter(s));
    }

    public static int numDecodingsIter(String s) {
        if (s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }
        int len = s.length() + 1;
        int[] dp = new int[len];
        // for (int i = 0; i < len; i++) {
        // dp[i] = -1;
        // }
        dp[len - 1] = 1;
        for (int i = len - 2; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                dp[i] = 0;
                continue;
            }
            dp[i] = dp[i] + dp[i + 1];
            if (i + 1 < len - 1) {
                int x = Integer.parseInt(s.substring(i, i + 2));
                if (x >= 10 && x <= 26) {
                    dp[i] += dp[i + 2];
                }
            }
        }
        return dp[0];
    }

    public static int numDecodings(String s) {
        if (s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }
        int len = s.length() + 1;
        int[] dp = new int[len];
        for (int i = 0; i < len; i++) {
            dp[i] = -1;
        }
        int count = dfs(s, 0, dp);
        return count;
    }

    public static int dfs(String s, int ind, int[] dp) {
        if (ind == s.length()) {
            return 1;
        }
        if (s.charAt(ind) == '0') {
            return 0;
        }
        if (dp[ind] != -1) {
            return dp[ind];
        }
        int count = 0;
        count = dfs(s, ind + 1, dp);

        if (ind + 1 < s.length()) {
            int x = Integer.parseInt(s.substring(ind, ind + 2));
            if (x >= 10 && x <= 26) {
                count += dfs(s, ind + 2, dp);
            }
        }
        dp[ind] = count;
        return count;
    }
}