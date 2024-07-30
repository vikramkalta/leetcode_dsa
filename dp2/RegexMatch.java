public class RegexMatch {
    public static void main(String[] args) {
        // String s = "aa";
        // String p = "a";
        // String s = "aa";
        // String p = "a.";
        // String s = "aaa";
        // String p = "a*";
        // String s = "ab";
        // String p = ".*";
        String s = "ab";
        String p = ".*c";
        System.out.println(isMatch(s, p));
    }

    public static boolean isMatch(String s, String p) {
        return checkMatch(s, p, 0, 0);
    }

    public static boolean checkMatch(String s, String p, int i, int j) {
        if (p.length() == j) {
            return s.length() == i;
        }
        boolean firstMatch = i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');

        if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
            return (checkMatch(s, p, i, j + 2))
                    || (firstMatch && checkMatch(s, p, i + 1, j));
        } else {
            return firstMatch && checkMatch(s, p, i + 1, j + 1);
        }
    }
}
