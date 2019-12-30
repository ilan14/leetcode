package array;

/**
 * 4. Median of Two Sorted Arrays
 */
public class MedianofTwoSortedArrays {
	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		if (nums1 == null || nums1.length == 0) {
			return median(nums2);
		}

		if (nums2 == null || nums2.length == 0) {
			return median(nums1);
		}

		int length = nums1.length + nums2.length;
		int middle = length / 2;
		if (nums1[nums1.length - 1] <= nums2[0] || nums2[nums2.length - 1] <= nums1[0]) {
			int[] smaller, bigger;
			if (nums1[nums1.length - 1] <= nums2[0]) {
				smaller = nums1;
				bigger = nums2;
			} else {
				smaller = nums2;
				bigger = nums1;
			}

			if (length % 2 == 0) {
				int a = middle <= smaller.length ? smaller[middle - 1] : bigger[middle - 1 - smaller.length];
				int b = middle <= smaller.length - 1 ? smaller[middle] : bigger[middle - smaller.length];

				return (double) (a + b) / 2;
			} else {
				return middle <= smaller.length - 1 ? smaller[middle] : bigger[middle - smaller.length];
			}
		}

		int i = 0, j = 0;
		for (int k = 0; k < middle - 1; k++) {
			if (j >= nums2.length || (i < nums1.length && nums1[i] < nums2[j])) {
				i++;
			} else {
				j++;
			}
		}

		int a = j >= nums2.length || (i < nums1.length && nums1[i] < nums2[j]) ? nums1[i++] : nums2[j++];
		int b = j >= nums2.length || (i < nums1.length && nums1[i] < nums2[j]) ? nums1[i] : nums2[j];

		if (length % 2 == 0) {
			return (double) (a + b) / 2;
		} else {
			return b;
		}
	}

	private static double median(int[] array) {
		int mid = array.length / 2;
		if (array.length % 2 == 0) {
			return (double) (array[mid - 1] + array[mid]) / 2;
		} else {
			return array[mid];
		}
	}
}
