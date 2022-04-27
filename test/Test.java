public class Test {
    public static void main(String args[]) {
        int[] arr = {0,1,1,1,1,1,1};
        System.out.println(solve(arr));
    }
    public static int solve(int[] arr) {
        int l = 0, r = arr.length - 1;
        int m = (l + r) / 2;
        while(l < r) {
            int mid = arr[m];
            if (mid == 0 && arr[m + 1] == 1) {
                return m + 1;
            }
            if (mid == 1 && arr[m - 1] == 0) {
                return m;
            }
            if (mid == 0) {
                l = m + 1;
            } else if (mid == 1) {
                r = m - 1;
            }
            m = (l + r) / 2;
        }
        return m;
    }
}

