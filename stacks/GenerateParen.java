import java.util.ArrayList;
import java.util.List;

public class GenerateParen {
    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }

    public static List<String> ans = new ArrayList<>();

    public static List<String> generateParenthesis(int n) {
        genParen(n, 0, 0);
        return ans;
    }

    static StringBuilder str = new StringBuilder();

    public static void genParen(int n, int openCount, int closeCount) {
        if (openCount == n && closeCount == n) {
            ans.add(new String(str));
            return;
        }
        if (openCount < n) {
            str.append('(');
            genParen(n, openCount + 1, closeCount);
            str.deleteCharAt(str.length() - 1);
        }
        if (closeCount < openCount) {
            str.append(')');
            genParen(n, openCount, closeCount + 1);
            str.deleteCharAt(str.length() - 1);
        }
    }
}
