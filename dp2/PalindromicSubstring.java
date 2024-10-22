public class PalindromicSubstring {
    public static void main(String[] args) {
        // String s = "abcba";
        // String s = "aaa";
        String s = "abba";
        System.out.println(countSubstrings(s));
    }

    // for (int i = 2; i < len; i++){
    // for (int j = 0; j < len; j++) {
    // System.out.println("j: " + j);
    // System.out.println(j + " : " + (j + i));
    // if (s.charAt(i) == s.charAt(j)) {
    // int count = dp[i+1][j-1];
    // if (count > 0) {
    // dp[j][j+i] = count + 1;
    // }
    // }
    // }
    // }

    public static int countSubstrings(String s) {
        int len = s.length();
        int[][] dp = new int[len][len];
        int ans = 0;

        for (int i = 0; i < len; i++) {
            dp[i][i] = 1;
            if (i + 1 < len && s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = 2;
                ans++;
            }
        }
        int max = 0;
        for (int g = 0; g < len; g++) {
            for (int i = 0, j = g; j < len; i++, j++) {
                if (j - 1 < 0 || i + 1 >= len) {
                    continue;
                }
                if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1] > 0) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                    ans++;
                    if (max < dp[i][j]) {
                        max = dp[i][j];
                    }
                }
            }
        }
        return ans + len;
    }

    public static int countSubstrings1(String s) {
        int len = s.length();
        int[] dp = new int[len];
        int ans = 0;

        for (int i = 0; i < len; i++) {
            dp[i] = 1;
        }
        for (int i = 0; i < len; i++) {
            char curr = s.charAt(i);
            if (i - 1 >= 0 && curr == s.charAt(i - 1)) {
                ans++;
                dp[i] = dp[i - 1] + 1;
            }
            if (i - 1 > 0 && curr == s.charAt(i - dp[i - 1] - 1)) {
                ans++;
                dp[i] = i - dp[i - 1] - 1;
            }
        }
        return ans + s.length();
    }
}
