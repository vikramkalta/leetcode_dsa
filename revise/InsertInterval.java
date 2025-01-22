import java.util.List;
import java.util.ArrayList;

public class InsertInterval {
    public static void main(String[] args) {
        // int[][] intervals = { { 1, 3 }, { 6, 9 } };
        // int[] newInterval = { 2, 5 };
        int[][] intervals = { { 1, 2 }, { 3, 5 }, { 6, 7 }, { 8, 10 }, { 12, 16 } };
        int[] newInterval = { 4, 8 };
        System.out.println(insert(intervals, newInterval));
    }

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> ansList = new ArrayList<>();
        int len = intervals.length;
        for (int i = 0; i < len; i++) {
            int[] currInterval = intervals[i];
            if (newInterval[1]  < currInterval[0]) {
                ansList.add(newInterval);
                for (int j = i; j < len; j++) ansList.add(intervals[j]);
                int[][] ans=new int[ansList.size()][2];
                int k=0;
                for (int[] curr: ansList) ans[k++]=curr;
                return ans;
            } else if (currInterval[1] < newInterval[0]) {
                ansList.add(currInterval);
            }else{
                newInterval[0]=Math.min(newInterval[0], currInterval[0]);
                newInterval[1]=Math.max(newInterval[1], currInterval[1]);
            }
            
        }
        ansList.add(newInterval);

        int[][] ans = new int[ansList.size()][2];
        for (int i = 0; i < ansList.size(); i++) {
            ans[i] = ansList.get(i);
        }
        return ans;
    }
}
