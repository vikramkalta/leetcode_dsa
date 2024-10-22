import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {
    public static void main(String[] args) {
        String[] strs= {"eat","tea","tan","ate","nat","bat"};
        System.out.println(groupAnagrams(strs));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        HashMap<String, List<String>> anagramMap = new HashMap<>();
        int len = strs.length;
        for (int i = 0; i < len; i++) {
            String x = strs[i];
            char[] strArr = x.toCharArray();
            Arrays.sort(strArr);
            String y = new String(strArr);
            
            if (anagramMap.containsKey(y)) {
                anagramMap.get(y).add(x);
            } else {
                List<String> list = new ArrayList<>();
                list.add(x);
                anagramMap.put(y, list);
            }
        }
        for (String x: anagramMap.keySet()) {
            result.add(anagramMap.get(x));
        }
        return result;
    }
}
