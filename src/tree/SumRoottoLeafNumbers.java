package tree;

import base.TreeNode;
import base.Trees;

/**
 * 129. Sum Root to Leaf Numbers
 *
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
 * An example is the root-to-leaf path 1->2->3 which represents the number 123.
 * Find the total sum of all root-to-leaf numbers.
 * Note: A leaf is a node with no children.
 *
 * Example:
 * Input: [1,2,3]
 *     1
 *    / \
 *   2   3
 * Output: 25
 * Explanation:
 * The root-to-leaf path 1->2 represents the number 12.
 * The root-to-leaf path 1->3 represents the number 13.
 * Therefore, sum = 12 + 13 = 25.
 *
 * Example 2:
 * Input: [4,9,0,5,1]
 *     4
 *    / \
 *   9   0
 *  / \
 * 5   1
 * Output: 1026
 * Explanation:
 * The root-to-leaf path 4->9->5 represents the number 495.
 * The root-to-leaf path 4->9->1 represents the number 491.
 * The root-to-leaf path 4->0 represents the number 40.
 * Therefore, sum = 495 + 491 + 40 = 1026.
 */
public class SumRoottoLeafNumbers {
    public static int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return sumNumbers(root, 0);
    }

    private static int sumNumbers(TreeNode root, int parentValue) {
        int value = 10 * parentValue + root.val;
        if (root.left == null && root.right == null) {
            return value;
        }

        int left = 0;
        if (root.left != null) {
            left = sumNumbers(root.left, value);
        }

        int right = 0;
        if (root.right != null) {
            right = sumNumbers(root.right, value);
        }

        return left + right;
    }

    public static void main(String[] args) {
        TreeNode root = Trees.buildCompleteTree(new int[]{4, 9, 0, 5, 1});

        System.out.println(sumNumbers(root));
    }
}
