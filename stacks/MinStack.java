import java.util.ArrayList;
import java.util.List;

public class MinStack {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        int x = minStack.getMin(); // return -3
        minStack.pop();
        minStack.top();    // return 0
        int y = minStack.getMin(); // return -2
        System.out.println();
    }

    int[] stack;
    int top = -1;
    int len = 10000;
    int min = Integer.MAX_VALUE;

    public MinStack() {
        stack = new int[len];
    }

    public void push(int val) {
        if (top + 1 == len)
            return;

        top++;
        if (val < min) {
            min = val;
        }
        stack[top] = val;
    }

    public void pop() {
        if (top == -1)
            return;
        if (stack[top]==min) {
            min = Integer.MAX_VALUE;
            for (int i = 0; i < top; i++) {
                if (stack[i]<min){
                    min=stack[i];
                }
            }
        }
        top--;
    }

    public int top() {
        return stack[top];
    }

    public int getMin() {
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
