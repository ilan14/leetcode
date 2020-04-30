/**
 * 面试题 17.14. Smallest K LCCI
 */
public class SmallestKLCCI {
    public int[] smallestK(int[] arr, int k) {
        if (k <= 0) {
            return new int[0];
        }

        if (arr == null || arr.length <= k) {
            return arr;
        }

        int[] result = new int[k];
        System.arraycopy(arr, 0, result, 0, k);

        for (int i = k / 2 - 1; i >= 0; i--) {
            heapify(result, i, k - 1);
        }

        for (int i = k; i < arr.length; i++) {
            if (arr[i] < result[0]) {
                result[0] = arr[i];
                heapify(result, 0, k - 1);
            }
        }

        return result;
    }

    private static void heapify(int[] arr, int cur, int maxPos) {
        int left = 2 * cur + 1;
        int right = left + 1;

        if (left > maxPos) {
            return;
        }

        int target = cur;
        if (arr[left] > arr[target]) {
            target = left;
        }

        if (right <= maxPos && arr[right] > arr[target]) {
            target = right;
        }

        if (target != cur) {
            int temp = arr[target];
            arr[target] = arr[cur];
            arr[cur] = temp;
            heapify(arr, target, maxPos);
        }
    }
}
