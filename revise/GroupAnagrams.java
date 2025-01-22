import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class GroupAnagrams {
    public static void main(String[] args) {
        String[] strs = { "eat", "tea", "tan", "ate", "nat", "bat" };
        System.out.println(groupAnagrams(strs));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        int len = strs.length;
        HashMap<String,List<String>>hMap = new HashMap<>();
        for (int i = 0; i < len; i++) {
            String curr = strs[i];
            int[]count = new int[26];
            for (char c: curr.toCharArray()) {
                count[c-'a']++;
            }
            String x = Arrays.toString(count);
            hMap.putIfAbsent(x, new ArrayList<>());
            hMap.get(x).add(curr);
        }
        for (String l: hMap.keySet()) {
            result.add(hMap.get(l));
        }
        return result;
    }
}
