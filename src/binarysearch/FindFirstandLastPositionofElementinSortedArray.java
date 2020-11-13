package binarysearch;

/**
 * 34. Find First and Last Position of Element in Sorted Array
 */
public class FindFirstandLastPositionofElementinSortedArray {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = search(nums, target, 0, true);

        if (result[0] == -1) {
            result[1] = -1;
        } else {
            result[1] = search(nums, target, result[0], false);
        }

        return result;
    }

    private int search(int[] nums, int target, int low, boolean first) {
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] > target) {
                high = mid - 1;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                if (first) {
                    if (mid == 0 || nums[mid - 1] != target) {
                        return mid;
                    } else {
                        high = mid - 1;
                    }
                } else {
                    if (mid == nums.length - 1 || nums[mid + 1] != target) {
                        return mid;
                    } else {
                        low = mid + 1;
                    }
                }
            }
        }

        return -1;
    }
}
