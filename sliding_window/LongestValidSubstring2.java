import java.util.List;
import java.util.ArrayList;
// import java.util.HashMap;
import java.util.HashSet;

public class LongestValidSubstring2 {
    public static void main(String[] args) {
        String word = "cbaaaabc";
        List<String> forbidden = new ArrayList();
        forbidden.add("cb");
        forbidden.add("aaa");
        System.out.println(longestValidSubstring(word, forbidden));
    }

    public static int longestValidSubstring(String word, List<String> forbidden) {
        HashSet<String> forbiddenSet = new HashSet();
        int len = word.length();
        for (int i = 0; i < forbidden.size(); i ++) {
            forbiddenSet.add(forbidden.get(i));
        }
        int l = 0;
        int r = 0;
        int max = Integer.MIN_VALUE;
        while (r < len) {
            for (int k = r; k >= Math.max(r-10, l); k--) {
                if (forbiddenSet.contains(word.substring(k, r+1))) {
                    l = k + 1;
                    break;
                }
            }
            max = Math.max(max, r-l+1);
            r++;
        }
        return max;
    }
}
