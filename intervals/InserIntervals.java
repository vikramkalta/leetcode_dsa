import java.util.ArrayList;
import java.util.List;

public class InserIntervals {
    public static void main(String[] args) {
        // int[][] intervals = { { 1, 2 }, { 3, 5 }, { 6, 7 }, { 8, 10 }, { 12, 16 } };
        // int[] newInterval = { 4, 8 };
        // int[][] intervals = { { 1, 5 } };
        // int[] newInterval = { 5, 7 };
        int[][] intervals = { { 1, 5 } };
        int[] newInterval = { 6, 8 };
        System.out.println(insert(intervals, newInterval));
    }

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> ansList = new ArrayList<>();

        for (int i = 0; i < intervals.length; i++) {
            int[] curr = intervals[i];

            if (newInterval[1] < curr[0]) {
                ansList.add(newInterval);
                for (; i < intervals.length; i++) {
                    ansList.add(intervals[i]);
                }
                int[][] ans = new int[ansList.size()][2];
                for (int k = 0; k < ansList.size(); k++) {
                    ans[k][0] = ansList.get(k)[0];
                    ans[k][1] = ansList.get(k)[1];
                }
                return ans;
            } else if (curr[1] < newInterval[0]) {
                ansList.add(curr);
            } else {
                newInterval[0] = Math.min(curr[0], newInterval[0]);
                newInterval[1] = Math.max(curr[1], newInterval[1]);
            }
        }
        ansList.add(newInterval);
        int[][] ans = new int[ansList.size()][2];
        ans[0] = newInterval;
        for (int k = 0; k < ansList.size(); k++) {
            ans[k][0] = ansList.get(k)[0];
            ans[k][1] = ansList.get(k)[1];
        }
        return ans;
    }
}
