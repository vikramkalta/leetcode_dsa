import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
    public static void main(String args[]) {
        System.out.println(generate(5));
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        int i = 0;
        while(i < numRows) {
            List<Integer> innerList = new ArrayList<>();
            for (int index = 0; index < i + 1; index++) {
                if (index == 0 || index == i) {
                    innerList.add(1);
                } else {
                    List<Integer> prevList = result.get(i - 1);
                    int left = prevList.get(index - 1);
                    int right = prevList.get(index);
                    innerList.add(left + right);
                }
            }
            result.add(innerList);
            i++;
        }
        return result;
    }
}
