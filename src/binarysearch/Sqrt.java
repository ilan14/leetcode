package binarysearch;

/**
 * 69. Sqrt(x)
 */
public class Sqrt {
    public static int mySqrt(int x) {
        if (x < 0) {
            throw new IllegalArgumentException();
        }

        if (x <= 1) {
            return x;
        }

        int low = 0;
        int high = x;
        int last = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            int target = x / mid;
            if (target == mid) {
                return mid;
            } else if (target > mid) {
                low = mid + 1;
                last = mid;
            } else {
                high = mid - 1;
            }
        }

        return last;
    }

    public static void main(String[] args) {
        System.out.println(mySqrt(30));
    }
}
