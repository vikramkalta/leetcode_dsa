public class CapacityToShipPackage {
    public static void main(String[] args) {
        // int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int[] arr = {1,2,3,1,1};
        // prefix sum
        // 1,3,6,10,15,21,28,36,45,55
        // System.out.println(shipWithinDays(arr, 5));
        System.out.println(shipWithinDays(arr, 4));
    }

    public static int shipWithinDays(int[] weights, int days) {
        int max = 0;
        int sum = 0;
        for (int i = 0; i < weights.length; i++) {
            int curr = weights[i];
            sum += curr;
            if (max < curr) {
                max = curr;
            }
        }
        return binarySearch(weights, days, max, sum);
    }
    static int minLoad = Integer.MAX_VALUE;
    static int minDays = Integer.MAX_VALUE;
    public static int binarySearch(int[] weights, int days, int l, int r) {
        if (l>r){
            return l;
            // return -1;
        }
        int mid = (l+r)/2;
        int load = 0;
        int _days = 1;
        for (int i = 0; i < weights.length; i++) {
            int curr = weights[i];
            load += curr;
            if (load > mid) {
                load = curr;
                _days++;
            }
        }
        if (_days > days) {
            return binarySearch(weights, days, mid+1, r);
        } else if (_days < days) {
            if (minLoad > load) {
                minLoad = load;
                minDays = _days;
            }
            return binarySearch(weights, days, l, mid-1);
        } else {
            // return mid;
            return l;
        }
    }
        // for (int i = max; i <= sum; i++) {
        //     int _days = 1;
        //     int load = 0;
        //     for (int j = 0; j < weights.length; j++) {
        //         int curr = weights[j];
        //         load += curr;
        //         if (load>i){
        //             _days++;
        //             load=curr;
        //         }
        //         if (_days>days){
        //             break;
        //         }
        //     }
        //     if (_days<=days){
        //         return i;
        //     }
        // }
    public static int shipWithinDays1(int[] weights, int days) {
        int max = 0;
        int sum = 0;
        int len = weights.length;
        for (int i = 0; i < len; i++) {
            int curr = weights[i];
            if (max < curr) {
                max = curr;
            }
            sum += curr;
        }

        for (int i = max; i <= sum; i++) {
            int load = 0;
            int _days = 1;
            for (int j = 0; j < len; j++) {
                int curr = weights[j];
                if (load + curr > i) {
                    _days++;
                    load = curr;
                } else {
                    load = load + curr;
                }
            }
            if (_days <= days) {
                return i;
            }
        }
        return -1;
    }
}
