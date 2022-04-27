import java.util.ArrayList;

public class LongestBalancedString {
    public static void main(String args[]) {
        // String s = ")()()(";
        // String s = ")()())";
        // String s = ")(())(";
        // String s = "())";
        // String s = "()(())";
        // String s = "(()";
        // String s = "()()";
        // String s = ")()))(";
        String s =")()())";
        System.out.println(longestValidParentheses(s));
    }

    public static int longestValidParentheses(String s) {
        int len = s.length();
        ArrayList<Integer> dp = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            dp.add(0);
        }

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < len; i++) {
            char curr = s.charAt(i);
            if (i > 0) {
                char prev = s.charAt(i - 1);
                if (prev == '(' && curr == ')') {
                    int prevLen = 0;
                    if (i - 2 >= 0) {
                        prevLen = dp.get(i - 2);
                    }
                    int realLen = prevLen + 2;
                    if (max < realLen) {
                        max = realLen;
                    }
                    dp.set(i, realLen);
                } else {
                    if (curr == ')') {
                        int prevLen = dp.get(i - 1);
                        int index = i - prevLen - 1;
                        char charAtIndex = '.';
                        if (index>=0) {
                            charAtIndex = s.charAt(index);
                        }
                        int realLen = 0;
                        if (charAtIndex == '(') {
                            realLen = (index-1>=0 ? dp.get(index - 1) : 0) + 2 + dp.get(i-1);
                            dp.set(i, realLen);
                        }
                        if (max < realLen) {
                            max = realLen;
                        }
                    }
                }
            }
        }

        return max == Integer.MIN_VALUE ? 0 : max;
    }
}
