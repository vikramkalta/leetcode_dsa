public class PlusOne {
    public static void main(String args[]) {
        // int[] nums = {2,7,11,15};
        // int[] digits = {7,1,4,3,6,4};
        // int[] digits = {9,9,9,9};
        int[] digits = {7,8,9};
        // int[] digits = {2,4,1};
        System.out.println(plusOne(digits));
    }
    // 7,8,9
    // 9,9
    public static int[] plusOne(int[] digits) {
        int len = digits.length;
        int[] ans = new int[len + 1];
        int remainder = 1;
        int j = 0;
        for (int i = len - 1; i >= 0; i--) {
            int curr = digits[i];
            int currDigit = (curr + remainder) % 10;
            remainder = (curr + remainder) / 10;
            ans[j] = currDigit;
            j++;
        }
        if (remainder == 1) {
            ans[j] = remainder;
        }
        // reverse the array
        int finalLen = len + remainder;
        int[] finalAns = new int[finalLen];
        for (int i = 0; i <= finalLen / 2; i++) {
            int left = ans[i];
            int right = ans[finalLen - (i + 1)];
            finalAns[i] = right;
            finalAns[finalLen - (i+1)] = left;
        }

        return finalAns;
    }
}