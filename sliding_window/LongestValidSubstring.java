import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

public class LongestValidSubstring {
    public static void main(String[] args) {
        List<String> forbidden = new ArrayList();
        forbidden.add("aaa");
        forbidden.add("cb");
        System.out.println(longestValidSubstring("cbaaaabc", forbidden));
    }

    public static int longestValidSubstring(String word, List<String> forbidden) {
        HashMap<String, Boolean> forbiddenMap = new HashMap<>();
        int forbiddenWordsLen = forbidden.size();
        for (int i = 0; i < forbiddenWordsLen; i++) {
            forbiddenMap.put(forbidden.get(i), true);
        }
        int l = 0, r = 0;
        int max = Integer.MIN_VALUE;
        int wordsLen = word.length();
        while (r < wordsLen) {
            for (int k = r; k > Math.max(r - 10, l - 1); k--) {
                if (forbiddenMap.containsKey(word.substring(k, r+1))) {
                    l = k+1;
                }
            }
            max = Math.max(max, r-l+1);
            r++;
        }
        return max;
    }
}
