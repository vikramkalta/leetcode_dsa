import java.util.Arrays;
import java.util.HashMap;

public class KthDiff {
    public static void main(String[] args) {
        // int[] a = {3,8,8,6,1,2,1,1,4,8};
        // int[] a = {1,3,3,4,5};
        // int[] a = {2,9,0,8,9,6,5,9,8,1,9,6,9,2,8,8,7,5,7,8,8,3,7,4,1,1,6,2,9,9,3,9,2,4,6,5,6,5,1,5,9,9,8,1,4,3,2,
        //     8,5,3,5,4,5,7,0,0,7,6,4,7,2,4,9,3,6,6,5,0,0,0,8,9,9,6,5,4,6,2,1,3,2,5,0,1,4,2,6,9,5,4,9,6,0,8,3,8,0,0,2,1};
        int[] a = {1,1,1,1,1};
        System.out.println(findPairs(a, 0));
    }

    public static int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        int len = nums.length;
        int count = 0;
        int i = 0, j = 1;
        HashMap<Integer, Pair> processedMap = new HashMap<>();
        while (j < len) {
            int currI = nums[i];
            int currJ = nums[j];
            if (processedMap.containsKey(currI)) {
                Pair x = processedMap.get(currI);
                if (x.checkDuplicate(currI, currJ)) {
                    i++;j++;
                    continue;
                }
            }
            if (processedMap.containsKey(currJ)) {
                Pair x = processedMap.get(currJ);
                if (x.checkDuplicate(currI, currJ)) {
                    i++;j++;
                    continue;
                }
            }
            int diff = Math.abs(currI - currJ);
            if (diff > k) {
                i++;
            } else if (diff < k) {
                j++;
            } else {
                i++;
                j++;
                count++;
                processedMap.put(currI, new Pair(currI, currJ));
                processedMap.put(currJ, new Pair(currI, currJ));
            }
            if (i==j) j++;
        }
        return count;
    }


    public static int findPairsBF(int[] nums, int k) {
        Arrays.sort(nums);
        HashMap<Integer, Pair> processedMap = new HashMap<>();
        int len = nums.length;
        int count = 0;
        for (int i = 0; i < len; i++) {
            int currI = nums[i];
            for (int j = i + 1; j < len; j++) {
                int currJ = nums[j];
                if (processedMap.containsKey(currI)) {
                    Pair x = processedMap.get(currI);
                    if (x.checkDuplicate(currI, currJ)) {
                        System.out.println("pairs1: " + currI + " : " + currJ);
                        continue;
                    }
                }
                if (processedMap.containsKey(currJ)) {
                    Pair x = processedMap.get(currJ);
                    if (x.checkDuplicate(currI, currJ)) {
                        System.out.println("pairs2: " + currI + " : " + currJ);
                        continue;
                    }
                }
                if (i != j) {
                    int diff = Math.abs(currI - currJ);
                    if (k == diff) {
                        count++;
                        // System.out.println("pairs: " + currI + " : " + currJ);
                        processedMap.put(currI, new Pair(currI, currJ));
                        processedMap.put(currJ, new Pair(currI, currJ));
                    }
                }
            }
        }
        return count;
    }
    private static class Pair {
        int x;
        int y;
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
        public boolean checkDuplicate(int a, int b){
            return (this.x == a && this.y == b) || (this.x == b && this.y == a);
        }
    }
}
