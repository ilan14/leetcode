/**
 * 7. Reverse Integer
 */
public class ReverseInteger {
    public static int reverse(int x) {
        boolean positive = true;
        int target = x;
        if (x == -2147483648) {
            return 0;
        }

        if (x < 0) {
            target = -1 * target;
            positive = false;
        }

        int result = 0;
        int num = target % 10;
        target = target / 10;
        while (num != 0 || target != 0) {
            if (result > 214748364) {
                return 0;
            } else if (result == 214748364) {
                if (positive) {
                    if (num <= 7) {
                        result = result * 10 + num;
                        return result;
                    } else {
                        return 0;
                    }
                } else {
                    if (num <= 8) {
                        result = result * 10 + num;
                        return -1 * result;
                    } else {
                        return 0;
                    }
                }
            }

            result = result * 10 + num;

            num = target % 10;
            target = target / 10;
        }

        if (!positive) {
            result = -1 * result;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(reverse(-2147483647));
    }
}
