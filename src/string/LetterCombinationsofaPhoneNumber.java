package string;

import java.util.*;

/**
 * 17. Letter Combinations of a Phone Number
 */
public class LetterCombinationsofaPhoneNumber {
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return Collections.emptyList();
        }

        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        LinkedList<String> list = new LinkedList<>();
        String s = map.get(digits.charAt(0));
        for (int i = 0; i < s.length(); i++) {
            list.add(String.valueOf(s.charAt(i)));
        }

        for (int i = 1; i < digits.length(); i++) {
            s = map.get(digits.charAt(i));
            int size = list.size();
            for (int j = 0; j < size; j++) {
                String str = list.removeFirst();
                for (int k = 0; k < s.length(); k++) {
                    list.add(str + s.charAt(k));
                }
            }
        }

        return list;
    }
}
