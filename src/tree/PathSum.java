package tree;

import base.TreeNode;
import base.Trees;

/**
 * 112. Path Sum
 *
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values
 * along the path equals the given sum.
 */
public class PathSum {
    public static boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }

        if (root.left == null && root.right == null) {
            return root.val == sum;
        }

        int value = sum - root.val;
        return hasPathSum(root.left, value) || hasPathSum(root.right, value);
    }

    public static void main(String[] args) {
        TreeNode root = Trees.buildCompleteTree(new int[]{5, 4, 8, 11, 13, 4, 7, 2});

        System.out.println(hasPathSum(root, 22));
    }
}
