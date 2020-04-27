package slidingwindow;

import java.util.HashMap;

/**
 * 3. Longest Substring Without Repeating Characters
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        HashMap<Character, Integer> map = new HashMap<>();
        int mark = 0;
        int result = 0;
        int i;
        for (i = 0; i < s.length(); i++) {
            Character ch = s.charAt(i);
            if (map.containsKey(ch) && map.get(ch) >= mark) {
                int temp = i - mark;
                result = Math.max(result, temp);
                mark = map.get(ch) + 1;
            }
            map.put(ch, i);
        }

        int temp = i - mark;
        result = Math.max(result, temp);

        return result;
    }

    public static int lengthOfLongestSubstring1(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int[] array = new int[128];
        int mark = 0;
        int result = 0;
        int i;
        for (i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (((i != 0 && ch == s.charAt(0)) || array[ch] != 0) && array[ch] >= mark) {
                int temp = i - mark;
                result = Math.max(result, temp);
                mark = array[ch] + 1;
            }
            array[ch] = i;
        }

        int temp = i - mark;
        result = Math.max(result, temp);

        return result;
    }

    public static void main(String[] args) {
//        System.out.println(lengthOfLongestSubstring("wobgrovw"));

        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }
}
