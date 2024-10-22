import java.util.List;

public class LongestIncCommonSubseq {
    public static void main(String[] args) {
        String s1 = "adebc";
        String s2 = "dcadbmn";
        // String s1 = "adb";
        // String s2 = "dcb";
        System.out.println(longestCommonSubsequence(s1, s2));
    }

    public static int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length()][text2.length()];
        for (int i = 0; i < text1.length(); i++) {
            for (int j = 0; j < text2.length(); j++) {
                dp[i][j] = -1;
            }
        }
        return getCommonSubseq(text1, text2, text1.length() - 1, text2.length() - 1, dp);
    }

    public static int getCommonSubseq(String text1, String text2, int i, int j, int[][] dp) {
        if (i < 0 || j < 0) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        if (text1.charAt(i) == text2.charAt(j)) {
            int x = 1 + getCommonSubseq(text1, text2, i - 1, j - 1, dp);
            dp[i][j]=x;
            return x;
        } else {
            int x = getCommonSubseq(text1, text2, i - 1, j, dp);
            int y = getCommonSubseq(text1, text2, i, j - 1, dp);
            dp[i][j]=Math.max(x, y);
            return Math.max(x, y);
        }
    }

    // public static int getCommonSubseq1(String text1, String text2, int i, int j) {
    //     if (i >= text1.length()) {
    //         return 0;
    //     }
    //     if (j >= text2.length()) {
    //         return 0;
    //     }
    //     int x = 0, y = 0;
    //     if (text1.charAt(i) == text2.charAt(j)) {
    //         return 1 + getCommonSubseq(text1, text2, i + 1, j + 1);
    //     } else {
    //         x = getCommonSubseq(text1, text2, i + 1, j);
    //         y = getCommonSubseq(text1, text2, i, j + 1);
    //         return Math.max(x, y);
    //     }
    // }
}
