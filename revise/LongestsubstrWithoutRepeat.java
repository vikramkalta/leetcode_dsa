import java.util.HashMap;

public class LongestsubstrWithoutRepeat {
    public static void main(String[] args) {
        // String s = "pwwkew";
        // String s = "aab";
        String s = "abba";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {
        int len = s.length();

        HashMap<Character, Integer> charMap = new HashMap<>();
        int max = 0;
        int left = 0;
        for (int i = 0; i < len; i++) {
            char curr = s.charAt(i);
            if (charMap.containsKey(curr) && left <= charMap.get(curr)) {
                left = charMap.get(curr) + 1;
            }
            charMap.put(curr, i);
            max = Math.max(max, i - left + 1);
        }
        return max;
    }
}
