package binarysearch;

/**
 * 74. Search a 2D Matrix
 */
public class Searcha2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }

        int low = 0;

        int columns = matrix[0].length;
        int high = matrix.length * columns - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            int row = mid / columns;
            int column = mid % columns;

            if (matrix[row][column] == target) {
                return true;
            } else if (matrix[row][column] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return false;
    }
}
