import java.util.ArrayList;
import java.util.HashMap;

public class LongestSubstringWithoutRepeat {
    public static void main(String[] args) {
        // String s = "abcabcbb";
        // String s = "pwwkew";
        // String s = " ";
        // String s = "au";
        // String s = "aab";
        // String s = " ";
        String s = "abba";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {
        int len = s.length();

        HashMap<Character, Integer> charMap = new HashMap<>();
        // char[]arr={'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z',
        // ' '};
        // for (int i = 0; i < arr.length; i++) {
        // charMap.put(arr[i], -1);
        // }
        int startIndex = 0;
        int maxLen = 0;
        for (int i = 0; i < len; i++) {
            char curr = s.charAt(i);
            int currPos = charMap.containsKey(curr) ? charMap.get(curr) : -1;
            if (currPos != -1 && startIndex <= currPos) {
                startIndex = currPos + 1;
            }
            int x = i - startIndex + 1;
            charMap.put(curr, i);
            maxLen = Math.max(maxLen, x);
        }
        return maxLen == 0 ? len : maxLen;
    }
}