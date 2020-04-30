package math;

/**
 * 13. Roman to Integer
 */
public class RomantoInteger {
    public static int romanToInt(String s) {
        if (s == null) {
            return 0;
        }

        int result = 0;
        char ch;
        for (int i = 0; i < s.length(); i++) {
            ch = s.charAt(i);
            switch (ch) {
                case 'I':
                    if (i < s.length() - 1) {
                        ch = s.charAt(i + 1);
                        if (ch == 'V') {
                            result += 4;
                            i++;
                        } else if (ch == 'X') {
                            result += 9;
                            i++;
                        } else {
                            result += 1;
                        }
                        continue;
                    } else {
                        result += 1;
                    }
                    break;
                case 'V':
                    result += 5;
                    break;
                case 'X':
                    if (i < s.length() - 1) {
                        ch = s.charAt(i + 1);
                        if (ch == 'L') {
                            result += 40;
                            i++;
                        } else if (ch == 'C') {
                            result += 90;
                            i++;
                        } else {
                            result += 10;
                        }
                    } else {
                        result += 10;
                    }
                    break;
                case 'L':
                    result += 50;
                    break;
                case 'C':
                    if (i < s.length() - 1) {
                        ch = s.charAt(i + 1);
                        if (ch == 'D') {
                            result += 400;
                            i++;
                        } else if (ch == 'M') {
                            result += 900;
                            i++;
                        } else {
                            result += 100;
                        }
                    } else {
                        result += 100;
                    }
                    break;
                case 'D':
                    result += 500;
                    break;
                case 'M':
                    result += 1000;
                    break;
                default:
                    break;
            }
        }

        return result;
    }

    public static int romanToInt1(String s) {
        if (s == null) {
            return 0;
        }

        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            int cur = romanToInt(s.charAt(i));
            int next = 0;
            if (i < s.length() - 1) {
                next = romanToInt(s.charAt(i + 1));
            }

            if (cur < next) {
                result += next - cur;
                i++;
            } else {
                result += cur;
            }
        }

        return result;
    }

    private static int romanToInt(char ch) {
        switch (ch) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }

    public static void main(String[] args) {
        System.out.println(romanToInt1("MCMXCIV"));
    }
}
