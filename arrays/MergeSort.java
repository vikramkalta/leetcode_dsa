public class MergeSort {
    public static void main(String args[]) {
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        // int[] prices = {2,4,1};
        // System.out.println();
        merge(nums1, 3, nums2, 3);
        System.out.println();
    }
    
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0, j = 0, k = 0;
        int[] nums3 = new int[m];
        for (int index = 0; index < m; index++) {
            nums3[index] = nums1[index];
        }
        while(i < m && j < n) {
            int currI = nums3[i];
            int currJ = nums2[j];
            if (currI < currJ) {
                nums1[k] = currI;
                i++;
            } else {
                nums1[k] = currJ;
                j++;
            }
            k++;
        }
        while(i < m) {
            nums1[k] = nums3[i];
            i++;
            k++;
        }
        while(j < n) {
            nums1[k] = nums2[j];
            j++;
            k++;
        }
    }
}
