package tree;

import base.TreeNode;
import base.Trees;

/**
 * 104. Maximum Depth of Binary Tree
 */
public class MaximumDepthofBinaryTree {
    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    public static void main(String[] args) {
        TreeNode root = Trees.buildCompleteTree(new int[]{1, 2, 3, 4, 5});

        System.out.println(maxDepth(root));
    }
}
