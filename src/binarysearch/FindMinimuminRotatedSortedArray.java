package binarysearch;

/**
 * 153. Find Minimum in Rotated Sorted Array
 */
public class FindMinimuminRotatedSortedArray {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] < nums[high]) {
                if (mid == 0 || nums[mid - 1] > nums[mid]) {
                    return nums[mid];
                } else {
                    high = mid - 1;
                }
            } else if (nums[mid] > nums[high]) {
                low = mid + 1;
            } else {
                return nums[mid];
            }
        }

        return -1;
    }
}
