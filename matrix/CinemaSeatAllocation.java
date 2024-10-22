import java.util.HashMap;
import java.util.Map;

public class CinemaSeatAllocation {
    public static void main(String[] args) {
        int n = 3;
        int[][] reservedSeats = { { 1, 2 }, { 1, 3 }, { 1, 8 }, { 2, 6 }, { 3, 1 }, { 3, 10 } };
        int x = 0b0100000100 & 0b0111100000;
        int y = 0b0 & 0b0;
        System.out.println(x);
        System.out.println(maxNumberOfFamilies(n, reservedSeats));
    }

    public static int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        int len = reservedSeats.length;
        Map<Integer, Integer> reservedMap = new HashMap<>();
        for (int[] seat : reservedSeats) {
            int row = seat[0], seatNum = seat[1];
            reservedMap.merge(row, 1 << (10 - seatNum), (oldValue, value) -> oldValue | value);
        }
        int ans = 0;
        return ans;
    }

    public static int maxNumberOfFamilies1(int n, int[][] reservedSeats) {
        int[][] seats = new int[n][10];
        int len = reservedSeats.length;
        HashMap<String, Integer> allocatedSeatMap = new HashMap<>();
        for (int i = 0; i < len; i++) {
            int x = reservedSeats[i][0];
            int y = reservedSeats[i][1];
            String x1 = Integer.toString(x - 1);
            String y1 = Integer.toString(y - 1);
            allocatedSeatMap.put(x1 + "-" + y1, 1);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 10; j++) {
                String x = Integer.toString(i) + "-" + Integer.toString(j);
                if (allocatedSeatMap.containsKey(x)) {
                    seats[i][j] = 1;
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int count = 0;
            int prev = 0;
            for (int j = 0; j < 10; j++) {
                if (seats[i][j] == 0 && prev == 1 && (j == 1 || j == 3 || j == 5)) {
                    count++;
                    prev = 0;
                } else if (seats[i][j] == 0 && prev == 0) {
                    if (count == 0 && (j != 1 && j != 3 && j != 5)) {
                        continue;
                    }
                    count++;
                    prev = 0;
                    if (count == 4) {
                        ans++;
                        count = 0;
                    }
                } else {
                    prev = 1;
                    count = 0;
                }
            }
        }
        return ans;
    }

    static class Pair {
        int x;
        int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
