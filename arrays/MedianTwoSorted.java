import java.util.ArrayList;

public class MedianTwoSorted {
    public static void main(String[] args) {
        // int[] A = {1,2};
        int[] A = { 1, 3 };
        // int[] B = {3,4};
        int[] B = { 2 };
        System.out.println(findMedianSortedArrays(A, B));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double median = 0;
        int i = 0;
        int j = 0;
        ArrayList<Integer> mergedList = new ArrayList<>();
        int len1 = nums1.length;
        int len2 = nums2.length;

        while (i < len1 && j < len2) {
            if (nums1[i] < nums2[j]) {
                mergedList.add(nums1[i]);
                i++;
            } else {
                mergedList.add(nums2[j]);
                j++;
            }
        }
        while (i < len1) {
            mergedList.add(nums1[i]);
            i++;
        }
        while (j < len2) {
            mergedList.add(nums2[j]);
            j++;
        }
        int mergedLen = len1 + len2;
        if (mergedLen % 2 == 0) {
            median = mergedList.get(mergedLen / 2) + mergedList.get(mergedLen / 2 - 1);
            median = median / 2;
        } else {
            median = mergedList.get(mergedLen / 2);
        }
        return median;
    }
}
