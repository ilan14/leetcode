package string;

/**
 * 6. ZigZag Conversion
 */
public class ZigZagConversion {
    public static String convert(String s, int numRows) {
        if (numRows <= 1) {
            return s;
        }

        StringBuilder[] array = new StringBuilder[numRows];

        boolean flag = true;
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            StringBuilder sb = array[j];
            if (sb == null) {
                sb = new StringBuilder();
                array[j] = sb;
            }
            sb.append(ch);

            if (flag) {
                j++;
                if (j >= numRows) {
                    flag = false;
                    j = numRows - 2;
                }
            } else {
                j--;
                if (j < 0) {
                    flag = true;
                    j = 1;
                }
            }
        }

        StringBuilder sb1 = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            StringBuilder sb = array[i];
            if (sb == null) {
                break;
            }

            sb1.append(sb);
        }

        return sb1.toString();
    }

    public static void main(String[] args) {
        String str = "PAYPALISHIRING";
        int numrows = 3;

        String result = convert(str, numrows);

        System.out.println(result);
    }
}
