package binarysearch;

/**
 * 1095. Find in Mountain Array
 */
public class FindinMountainArray {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int start = 0;
        int end = mountainArr.length() - 1;
        int low = start;
        int high = end;
        int mid = 0;
        while (low <= high) {
            mid = low + (high - low) / 2;

            int num = mountainArr.get(mid);
            if ((mid == 0 || num > mountainArr.get(mid - 1)) && (mid == end || num > mountainArr.get(mid + 1))) {
                break;
            } else if ((mid == 0 || num < mountainArr.get(mid - 1)) && (mid == end || num > mountainArr.get(mid + 1))) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        int result = binarySearch(target, mountainArr, start, mid, false);
        if (result == -1) {
            result = binarySearch(target, mountainArr, mid, end, true);
        }
        return result;
    }

    private int binarySearch(int target, MountainArray arr, int start, int end, boolean direction) {
        int low = start;
        int high = end;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            int num = arr.get(mid);
            if (num == target) {
                return mid;
            } else if (num < target) {
                if (direction) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (direction) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }

            }
        }

        return -1;
    }

    private static class MountainArray {
        private int[] array;


        public int get(int index) {
            if (index < 0 || index >= array.length) {
                throw new IllegalArgumentException();
            }

            return array[index];
        }

        public int length() {
            return array.length;
        }
    }

    public static void main(String[] args) {
        MountainArray array = new MountainArray();
        array.array = new int[]{1, 5, 2};

        System.out.println(new FindinMountainArray().findInMountainArray(2, array));
    }
}
