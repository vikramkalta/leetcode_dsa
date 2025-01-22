public class PalindromicSubstringRe {
    public static void main(String[] args) {
        String s = "abccba";
        System.out.println(countSubstrings(s));
    }

    public static int countSubstrings(String s) {
        int len = s.length();
        int[][] dp = new int[len][len];
        int count = 0;
        for (int i = 0;i < len; i++){
            dp[i][i] = 1;
            count++;
            if (i+1<len&& s.charAt(i+1)==s.charAt(i)) {
                dp[i][i+1] = 1;
                count++;
            }
        }
        for (int n = 2; n < len; n++) {
            for (int i = 0, j = n; j<len; i++,j++) {
                if (s.charAt(i) ==s.charAt(j) && dp[i+1][j-1] == 1) {
                    dp[i][j] = 1;
                    count++;
                }
            }
        }
        
        return count;
    }
}
