package tree;

import base.TreeNode;

/**
 * 404. Sum of Left Leaves
 */
public class SumofLeftLeaves {
    public int sumOfLeftLeaves(TreeNode root) {
        return sumOfLeftLeaves(root, false);
    }

    private static int sumOfLeftLeaves(TreeNode root, boolean left) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return left ? root.val : 0;
        }

        return sumOfLeftLeaves(root.left, true) + sumOfLeftLeaves(root.right, false);
    }
}
