import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class TopKFreqElem {
    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        System.out.println(topKFrequent(nums, 2));
    }

    public static int[] topKFrequent(int[] nums, int k) {
        int len = nums.length;

        List<List<Integer>> bucket = new ArrayList();
        for (int i = 0; i < len + 1; i++) {
            bucket.add(new ArrayList<>());
        }
        HashMap<Integer, Integer> countMap = new HashMap<>();
        for (int curr: nums) {
            countMap.put(curr, countMap.getOrDefault(curr, 0) + 1);
        }
        for (int key: countMap.keySet()) {
            int count = countMap.get(key);
            bucket.get(count).add(key);
        }
        int[] ans = new int[k];
        List<Integer> someList= new ArrayList<>();

        for (int i = len; i>=1; i--) {
            List<Integer> innerList=  bucket.get(i);
            if (!innerList.isEmpty()) {
                for (int curr: innerList) {
                    someList.add(curr);
                    if (someList.size()>=k){
                        break;
                    }
                }
            }
            if (someList.size()>=k){
                break;
            }
        }
        int i =0;
        for (int x:someList){
            ans[i]=x;
            i++;
        }
        return ans;
    }
}
