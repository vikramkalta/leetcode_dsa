public class MergeIntervals {
    public static void main(String args[]) {
        // int[][] arr = {{1,3},{2,6},{8,10},{15,18}};
        // int[][] arr = {{1,3},{2,6},{15,18},{8,10},};
        // int[][]arr = {{1,4},{4,5}};
        int[][]arr = {{1,4},{1,5}};
        // {1,2,8,15}
        // {3,6,10,18}
        System.out.println(merge(arr));
    }
    public static int[][] merge(int[][] intervals) {
        int len = intervals.length;
        if (len == 1) {
            return intervals;
        }
        int[][] mergedIntervals = new int[len][2];
        mergeSort(intervals, 0, len - 1);

        int currStart = intervals[0][0];
        int currEnd = intervals[0][1];
        int nextStart = intervals[1][0];
        int mergedIndex = 0;
        for (int i = 1; i < len; i++) {
            if (nextStart <= currEnd) {
                currEnd = intervals[i][1];
                if (i+1 < len) {
                    nextStart = intervals[i+1][0];
                } else {
                    mergedIntervals[mergedIndex][0] = currStart;
                    mergedIntervals[mergedIndex][1] = currEnd;
                    mergedIndex++;
                }
            } else {
                mergedIntervals[mergedIndex][0] = currStart;
                mergedIntervals[mergedIndex][1] = currEnd;
                currStart = intervals[i][0];
                currEnd = intervals[i][1];
                if (i+1 < len) {
                    nextStart = intervals[i+1][0];
                } else {
                    mergedIndex++;
                    mergedIntervals[mergedIndex][0] = currStart;
                    mergedIntervals[mergedIndex][1] = currEnd;
                }
                mergedIndex++;
            }
        }
        int[][] newMergedIntervals = new int[mergedIndex][2];
        for (int i = 0; i < mergedIndex; i++) {
            newMergedIntervals[i] = mergedIntervals[i];
        }
        return newMergedIntervals;
    }
    public static void mergeSort(int[][] intervals, int l, int r) {
        if (l >= r) {
            return;
        }
        int m = (l + r) / 2;
        mergeSort(intervals, l, m);
        mergeSort(intervals, m+1, r);
        mergeOp(intervals, l, m+1, r);
    }
    public static void mergeOp(int[][] intervals, int l, int m, int r) {
        int leftLen = m - l;
        int rightLen = r - m + 1;
        int[][] left = new int[leftLen][2];
        int[][] right = new int[rightLen][2];
        int _i = 0;
        for (int i = l; i < m; i++) {
            left[_i] = intervals[i];
            _i++;
        }
        int _j = 0;
        for (int i = m; i <= r; i++) {
            right[_j] = intervals[i];
            _j++;
        }
        int k = l;
        int i = 0, j = 0;
        while( i < leftLen && j < rightLen ) {
            int _left = left[i][0];
            int _right = right[j][0];
            if (_left < _right) {
                intervals[k] = left[i];
                i++;
            } else {
                intervals[k] = right[j];
                j++;
            }
            k++;
        }
        while(i <leftLen) {
            intervals[k] = left[i];
            k++;
            i++;
        }
        while(j < rightLen) {
            intervals[k] = right[j];
            k++;
            j++;
        }
    }
}
