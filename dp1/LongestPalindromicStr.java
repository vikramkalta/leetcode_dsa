public class LongestPalindromicStr {
    public static void main(String[] args) {
        // String s = "cbbd";
        String s = "ac";
        // String s = "abcba";
        // String s = "babad";
        System.out.println(longestPalindrome(s));
    }

    public static String longestPalindrome(String s) {
        int len = s.length();
        int[][] dp = new int[len][len];
        int max = 0;
        int start = -1, end = -1;
        for (int diff = 0; diff < len; diff++) {
            for (int i = 0, j = i + diff; j < len; i++, j++) {
                if (i == j) {
                    dp[i][j] = 1;
                } else if (diff == 1) {
                    int x = s.charAt(i) == s.charAt(j) ? 1 : 0;
                    dp[i][j] = x;
                    if (x == 1 && j - i + 1 > max) {
                        max = j - i + 1;
                        start = i;
                        end = j;
                    }
                } else {
                    int x = s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1] == 1 ? 1 : 0;
                    if (x == 1 && j - i + 1 > max) {
                        max = j - i + 1;
                        start = i;
                        end = j;
                    }
                    dp[i][j] = x;
                }
            }
        }
        if (start == -1 || end == -1){
            return s.substring(0, 1);
        }
        return s.substring(start, end + 1);
    }

    public static String longestPalindrome1(String s) {
        checkPalindrome(s, 0, s.length());
        return x;
    }

    static int max = Integer.MIN_VALUE;
    static String x = "";

    public static void checkPalindrome(String s, int startIndex, int endIndex) {
        if (startIndex >= endIndex) {
            return;
        }
        String str = isPalindrome(s, startIndex, endIndex);
        if (str.length() > max) {
            max = str.length();
            x = str;
        }
        checkPalindrome(s, startIndex + 1, endIndex);
        checkPalindrome(s, startIndex, endIndex - 1);
    }

    public static String isPalindrome(String s, int i, int j) {
        String sub = "";
        sub = s.substring(i, j);
        int len = sub.length();
        for (int k = 0; k < len / 2; k++) {
            if (sub.charAt(k) != sub.charAt(len - k - 1)) {
                return "";
            }
        }

        return sub;
    }
}
