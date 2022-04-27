public class DailyTemperatures {
    public static void main(String args[]) {
        int[] arr = {73,74,75,71,69,72,76,73};
        System.out.println(dailyTemperatures(arr));
    }

    public static int[] dailyTemperatures(int[] temperatures) {
        int len = temperatures.length;
        Stack stack = new Stack(len);
        int[] ans = new int[len];
        stack.push(new Pair(0, temperatures[0]));

        int i = 1;
        while(i < len) {
            int curr = temperatures[i];
            while(!stack.isEmpty() && curr > stack.top().temperature) {
                ans[stack.top().index] = i - stack.top().index;
                stack.pop();
            }
            stack.push(new Pair(i, curr));
            i++;
        }
        return ans;
    }

    static class Pair {
        int index;
        int temperature;
        Pair(int _index, int _temperature) {
            index = _index;
            temperature = _temperature;
        } 
    }
    static class Stack {
        int len = 0, size = 0;
        Pair[] stack;
        Stack(int n) {
            stack = new Pair[n];
            len = n;
        }
        public void push(Pair n) {
            if (isFull()) {
                System.out.println("ill op[push]");
                System.exit(1);
            }
            stack[size] = n;
            size++;
        }
        public Pair pop() {
            if (isEmpty()) {
                System.out.println("ill op[pop]");
                System.exit(1);
            }
            size--;
            Pair temp = stack[size];
            return temp;
        }
        public Pair top() {
            return stack[size-1];
        }
        public boolean isEmpty() {
            return size == 0;
        }
        public boolean isFull() {
            return size == len;
        }
    }
}