public class Search2dMatrix {
    public static void main(String[] args) {
        // int[][] matrix = { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 60 } };
        // int[][] matrix = { { 1,1 } };
        int[][] matrix = { { 1, 3 } };
        System.out.println(searchMatrix(matrix, 3));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int low = 0;
        int high = rows * cols - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            // int i = mid / rows;
            int i = mid / cols;
            int j = mid % cols;
            if (i >= rows || j >= cols) {
                return false;
            }
            if (target > matrix[i][j]) {
                low = mid + 1;
            } else if (target < matrix[i][j]) {
                high = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }
}