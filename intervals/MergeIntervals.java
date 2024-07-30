import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class MergeIntervals {
    public static void main(String[] args) {
        // int[][] intervals = { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };
        // int[][] intervals ={{1,4},{0,4}};
        int[][] intervals ={{1,4},{2,3}};
        System.out.println(merge(intervals));
    }

    public static int[][] merge(int[][] intervals) {
        // Sorting using lambda expressions
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0]) {
                return Integer.compare(a[1], b[1]);
            } else {
                return Integer.compare(a[0], b[0]);
            }
        });
        List<int[]> ansList = new ArrayList<>();

        int[] prev = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            int[] curr = intervals[i];
            if (curr[0] <= prev[1]) {
                prev[1] = Math.max(curr[1], prev[1]);
            } else {
                ansList.add(prev);
                prev = curr;
            }
        }
        if (prev.length > 0) {
            ansList.add(prev);
        }

        int[][] ans = new int[ansList.size()][2];
        for (int i = 0; i < ansList.size(); i++) {
            ans[i] = ansList.get(i);
        }
        return ans;
    }
}
