import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeInterval {
    public static void main(String[] args) {
        // int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        // int[][] intervals = { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 7, 18 } };
        int[][] intervals = {{1,4},{4,5}};
        System.out.println(merge(intervals));
    }

    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            return a[0] - b[0];
        });
        List<int[]> ansList = new ArrayList<>();
        int len = intervals.length;
        int[] previous = intervals[0];
        ansList.add(previous);
        for (int i = 1; i < len; i++) {
            int[] currInterval = intervals[i];

            if (previous[1] < currInterval[0]) {
                ansList.add(currInterval);
                previous = currInterval;
            }else if (previous[1] >= currInterval[0]) {
                previous[0] = Math.min(previous[0], currInterval[0]);
                previous[1] = Math.max(previous[1], currInterval[1]);
            }
        }
        int[][] ans = new int[ansList.size()][2];
        for (int i = 0; i < ansList.size(); i++) ans[i]=ansList.get(i);
        return ans;
    }
}
