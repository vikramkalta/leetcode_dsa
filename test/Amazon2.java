import java.util.ArrayList;
import java.util.List;

public class Amazon2 {
    public static void main(String args[]) {
        int[] a = {4,5,6,7};
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            numbers.add(a[i]);
        }
        System.out.println(getEncryptedNumber(numbers));
    }

    public static String getEncryptedNumber(List<Integer> numbers) {
        // Write your code here
            int len = numbers.size();
            List<Integer> list1 = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                list1.add(numbers.get(i));
            }
            List<Integer> list2 = new ArrayList<>();
            for (int i = 0; i < len - 1; i++) {
                for (int j = 0; j < len - 1; j++) {
                    int curr, next;
                    if (list1.size() > 1) {
                        curr = list1.get(j) % 10;
                        next = list1.get(j+1) % 10;
                        list2.add(curr + next);
                        if (j == len - 2) {
                            list1 = new ArrayList<>();
                        }
                    } else {
                        curr = list2.get(j) % 10;
                        next = list2.get(j+1) % 10;
                        list1.add(curr+ next);
                        if (j == len - 2) {
                            list2 = new ArrayList<>();
                        }
                    }
                }
                if (list2.size() > 0) {
                    len = list2.size();
                    // list1 = new ArrayList<>();
                } else {
                    len = list1.size();
                    // list2 = new ArrayList<>();
                }
            }
            System.out.print("list1 " + list1);
            System.out.println("list2 " + list2);
            StringBuilder str = new StringBuilder();
            if (list1.size()>0) {
                str.append(list1.get(0) % 10);
                str.append(list1.get(1) % 10);
            } else {
                str.append(list2.get(0) % 10);
                str.append(list2.get(1) % 10);
            }
            return new String(str);
        }
}