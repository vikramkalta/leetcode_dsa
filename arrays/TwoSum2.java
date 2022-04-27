public class TwoSum2 {
    public static void main(String args[]) {
        int[] arr = { 2, 7, 11, 15 };
        System.out.println(twoSum(arr, 9));
    }

    public static int[] twoSum(int[] numbers, int target) {
        int len = numbers.length;
        int low = 0, high = len - 1;
        int currLow = 0;
        int currHigh = 0;
        while (low < high) {
            currLow = numbers[low];
            currHigh = numbers[high];
            int sum = currLow + currHigh;
            if (sum == target) {
                return new int[] { low, high };
            } else if (sum > target) {
                high--;
            } else {
                low++;
            }
        }
        return new int[] { low, high };
    }
}
