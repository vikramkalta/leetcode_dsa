public class MinAvgDiff {
    public static void main(String[] args) {
        int[] arr = { 2, 5, 3, 9, 5, 3 };
        System.out.println(minimumAverageDifference(arr));
    }

    public static int minimumAverageDifference(int[] nums) {
        int len = nums.length;
        long[] prefixSum = new long[len];
        long sum = nums[0] * 1l;
        prefixSum[0] = (sum * 1l);
        for (int i = 1; i < len; i++) {
            sum += (nums[i] * 1l);
            prefixSum[i] = sum;
        }
        long min = Long.MAX_VALUE;
        int smallestIndex = -1;
        for (int i = 0; i < len; i++) {
            long x = (prefixSum[i] / (i + 1));
            long lastElementCount = (len - i - 1) * 1l;
            lastElementCount = lastElementCount == 0l ? 1l : lastElementCount;
            long y = (prefixSum[len - 1] - prefixSum[i]) / lastElementCount;
            long z = Math.abs(x - y);
            if (min > z) {
                min = z;
                smallestIndex = i;
            }
        }
        return smallestIndex;
    }
}
