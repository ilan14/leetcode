package string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 22. Generate Parentheses
 *
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 *
 * For example, given n = 3, a solution set is:
 *
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 *
 */
public class GenerateParentheses {
    public static List<String> generateParenthesis(int n) {
        if (n <= 0) {
            return Collections.emptyList();
        }

        List<String> resultList = new ArrayList<>();
        generateParenthesis(resultList, "(", 1, n - 1);
        return resultList;
    }

    private static void generateParenthesis(List<String> resultList, String str, int left, int right) {
        if (left == 0 && right == 0) {
            resultList.add(str);
            return;
        }

        if (right > 0) {
            generateParenthesis(resultList, str + "(", left + 1, right - 1);
        }

        if (left > 0) {
            generateParenthesis(resultList, str + ")", left - 1, right);
        }
    }

    public static void main(String[] args) {
        List<String> resultList = generateParenthesis(3);
        resultList.forEach(s -> System.out.println(s));
    }

}
