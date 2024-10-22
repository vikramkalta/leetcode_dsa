public class SlidingWindowMax {
    public static void main(String[] args) {
        // int[] nums = { 1, 3, -1, -3, 5, 3, 6, 7 };
        // int[] nums = { 1, -1 };
        int[] nums = { 9, 10, 9, -7, -4, -8, 2, -6 };
        // System.out.println(maxSlidingWindow(nums, 3));
        // System.out.println(maxSlidingWindow(nums, 1));
        System.out.println(maxSlidingWindow(nums, 5));
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        int[] result = new int[len - k + 1];
        int left = 0, right = 0;
        int max = Integer.MIN_VALUE;
        while (right < len) {

            if (right >= k - 1) {
                int curr = nums[right];
                if (right - left >= k && curr > max) {
                    max = curr;
                    left = right;
                } else if (right - left >= k) {
                    max = Integer.MIN_VALUE;
                    int newLeft = left;
                    while (newLeft < right) {
                        newLeft++;
                        int newCurr = nums[newLeft];
                        if (newCurr > max) {
                            max = newCurr;
                            left = newLeft;
                        }
                    }
                } else {
                    if (curr > max) {
                        max = curr;
                        left = right;
                    }
                }
                result[right - k + 1] = max;
            } else {
                int curr = nums[right];
                if (curr > max) {
                    max = curr;
                    left = right;
                }
            }
            right++;
        }
        return result;
    }

    public static int[] maxSlidingWindow1(int[] nums, int k) {
        int len = nums.length;
        int[] result = new int[len - k + 1];
        for (int i = 0; i < len; i++) {
            if (i >= k - 1) {
                int max = Integer.MIN_VALUE;
                for (int j = i; j >= i - k + 1; j--) {
                    int currWindow = nums[j];

                    if (max < currWindow) {
                        max = currWindow;
                    }
                }
                result[i + 1 - k] = max;
            }
        }
        return result;
    }
}
