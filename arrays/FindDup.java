public class FindDup {
    public static void main(String[] args) {
        // int[]x={4,3,1,4,2};
        int[]x={8,7,1,10,17,15,18,11,16,9,19,12,5,14,3,4,2,13,18,18};
        System.out.println(findDuplicate(x));
    }

    public static int findDuplicate(int[] nums) {
        int len = nums.length;
        int i = 0;
        while (true) {
            i = i % len;
            int curr = nums[i];
            if (curr != i + 1) {
                int x = swap(nums, curr, i);
                if (x==1){
                    return curr;
                }
            }
            i++;
        }
    }
    public static int swap(int[] nums, int loc, int oldLoc) {
        int temp = nums[loc-1];
        nums[loc-1] = loc;
        nums[oldLoc] = temp;
        if (loc == temp) {
            return 1;
        } else {
            return 0;
        }
    }
}
