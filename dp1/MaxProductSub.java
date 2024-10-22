public class MaxProductSub {
    public static void main(String[] args) {
        // int[] nums ={2,3,-2,4};
        // int[] nums = {0,10,10,10,10,10,10,10,10,10,-10,10,10,10,10,10,10,10,10,10,0};
        // int[] nums = {-2,0,-1};
        int[] nums = { -2, 0 };
        System.out.println(maxProduct(nums));
    }

    public static int maxProduct(int[] nums) {
        int len = nums.length;
        long max = Long.MIN_VALUE;
        long prefix = 1l;
        long suffix = 1l;
        for (int i = 0; i < len; i++) {
            max = Math.max(nums[i], max);
        }
        for (int i = 0; i < len; i++) {
            int curr = nums[i];
            int currLast = nums[len - i - 1];
            if (curr == 0 && currLast == 0) {
                prefix = 1l;
                suffix = 1l;
                continue;
            } else if (curr == 0) {
                prefix = 1l;
                suffix *= (currLast * 1l);
                long x = Math.max(max, Math.max(0, suffix));
                if (x > max && x < Integer.MAX_VALUE) {
                    max = x;
                }
            } else if (currLast == 0) {
                suffix = 1l;
                prefix *= (curr * 1l);
                long x = Math.max(max, Math.max(prefix, 0));
                if (x > max && x < Integer.MAX_VALUE) {
                    max = x;
                }
            } else {
                prefix *= (curr * 1l);
                suffix *= (currLast * 1l);
                long x = Math.max(max, Math.max(prefix, suffix));
                if (x > max && x < Integer.MAX_VALUE) {
                    max = x;
                }
            }
        }
        return (int) max;
    }

    public static int maxProduct1(int[] nums) {
        int len = nums.length;
        long max = Long.MIN_VALUE;

        for (int i = 0; i < len; i++) {
            long product = nums[i] * 1l;
            for (int j = i + 1; j < len; j++) {
                product = product * (nums[j] * 1l);
                if (product <= Integer.MAX_VALUE)
                    max = Math.max(max, product);
                else
                    break;
            }
        }
        return (int) max;
    }
}
