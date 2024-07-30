import java.util.List;
import java.util.ArrayList;

public class Subsequences {
    public static void main(String[] args) {
        System.out.println(getSubseq("abc"));
    }

    static List<String> ans = new ArrayList<>();

    public static List<String> getSubseq(String str) {
        int[] arr = new int[str.length()];
        subseq(str, 0, arr);
        return ans;
    }

    public static void subseq(String str, int i, int[] arr) {
        if (i == str.length()) {
            StringBuilder builtStr = new StringBuilder();
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] == 1) {
                    builtStr.append(str.charAt(j));
                }
            }
            ans.add(new String(builtStr));
            return;
        }
        arr[i] = 0;
        subseq(str, i + 1, arr);
        arr[i] = 1;
        subseq(str, i + 1, arr);
    }
}
