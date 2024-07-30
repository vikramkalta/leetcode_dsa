import java.util.Stack;

public class EvalRPN {
    public static void main(String[] args) {
        // String[] tokens = { "2", "1", "+", "3", "*" };
        String[] tokens = {"4","13","5","/","+"};
        System.out.println(evalRPN(tokens));
    }

    public static int evalRPN(String[] tokens) {
        int len = tokens.length;
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < len; i++) {
            String curr = tokens[i];
            if (curr.equals("*")
                    || curr.equals("+")
                    || curr.equals("-")
                    || curr.equals("/")) {
                int x = Integer.parseInt(stack.pop());
                int y = Integer.parseInt(stack.pop());

                int z = 0;
                switch (curr) {
                    case "+":
                        z = x + y;
                        break;
                    case "/":
                        z = y / x;
                        break;
                    case "-":
                        z = y - x;
                        break;
                    case "*":
                        z = x * y;
                        break;
                    default:
                        break;
                }
                stack.push(String.valueOf(z));
            } else {
                int x = Integer.parseInt(curr);
                stack.push(String.valueOf(x));
            }
        }
        return Integer.parseInt(stack.pop());
    }
}
