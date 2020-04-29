package string;

/**
 * 8. String to Integer (atoi)
 */
public class StringtoInteger {
    public static int myAtoi(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }

        boolean positive = true;
        int i = 0;
        while (i < str.length() && str.charAt(i) == ' ') {
            i++;
        }

        if (i >= str.length()) {
            return 0;
        }

        char ch = str.charAt(i);
        int result = 0;

        if (ch == '+') {

        } else if (ch == '-') {
            positive = false;
        } else if (ch >= '0' && ch <= '9') {
            result = ch - '0';
        } else {
            return 0;
        }

        i++;
        for (; i < str.length(); i++) {
            ch = str.charAt(i);
            if (ch < '0' || ch > '9') {
                break;
            }

            int num = ch - '0';
            if (result > 214748364) {
                if (positive) {
                    return Integer.MAX_VALUE;
                } else {
                    return Integer.MIN_VALUE;
                }
            }

            if (result == 214748364) {
                if (positive) {
                    if (num <= 7) {
                        result = result * 10 + num;
                        return result;
                    } else {
                        return Integer.MAX_VALUE;
                    }
                } else {
                    if (num <= 8) {
                        result = result * 10 + num;
                        return -1 * result;
                    } else {
                        return Integer.MIN_VALUE;
                    }
                }
            }
            result = result * 10 + num;
        }

        if (!positive) {
            result = -1 * result;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(myAtoi("-91283472332"));
    }
}
