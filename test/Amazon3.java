import java.util.ArrayList;
import java.util.List;

public class Amazon3 {
    public static void main(String args[]) {
        int[] a = { 2, 3, 6, 10, 11 };
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            numbers.add(a[i]);
        }
        System.out.println(getMinimumCost(numbers, 9));
    }

    public static long getMinimumCost(List<Integer> parcels, int k) {
        // Write your code here
        int len = parcels.size();
        merge(parcels, 0, len - 1);
        long sum = 0;
        int curr = parcels.get(0);
        k = k - len;

        int starter = 1;
        while (starter < curr && k > 0) {
            starter++;
            k--;
            sum = sum + (curr * 1l);
        }

        for (int i = 1; i < len; i++) {
            int next = parcels.get(i);
            if (next - curr > 1) {
                while (curr < next && k > 0) {
                    curr++;
                    k--;
                    sum = sum + (curr * 1l);
                }
            }
            curr = next;
        }
        return sum;
    }

    public static void merge(List<Integer> A, int l, int r) {
        if (l >= r) {
            return;
        }
        int m = (l + r) / 2;
        merge(A, l, m);
        merge(A, m + 1, r);
        mergeSort(A, l, m, r);
    }

    public static void mergeSort(List<Integer> A, int l, int m, int r) {
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        for (int i = l; i <= m; i++) {
            left.add(A.get(i));
        }
        for (int i = m + 1; i <= r; i++) {
            right.add(A.get(i));
        }
        int leftLen = left.size();
        int rightLen = right.size();
        int i = 0, j = 0, k = l;
        while (i < leftLen && j < rightLen) {
            int currLeft = left.get(i);
            int currRight = right.get(j);
            if (currLeft < currRight) {
                A.set(k, currLeft);
                i++;
            } else {
                A.set(k, currRight);
                j++;
            }
            k++;
        }
        while (i < leftLen) {
            A.set(k, left.get(i));
            i++;
            k++;
        }
        while (j < rightLen) {
            A.set(k, right.get(j));
            j++;
            k++;
        }
    }
}
