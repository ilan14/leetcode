package tree;

import base.TreeNode;
import base.Trees;

/**
 * 111. Minimum Depth of Binary Tree
 */
public class MinimumDepthofBinaryTree {
    public static int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }

        if (root.left == null) {
            return minDepth(root.right) + 1;
        }

        if (root.right == null) {
            return minDepth(root.left) + 1;
        }

        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }

    public static void main(String[] args) {
        TreeNode root = Trees.buildCompleteTree(new int[]{1, 2, 3, 4, 5});

        System.out.println(minDepth(root));
    }
}
