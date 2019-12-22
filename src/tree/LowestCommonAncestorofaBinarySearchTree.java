package tree;

import base.TreeNode;

/**
 * 235. Lowest Common Ancestor of a Binary Search Tree
 *
 * Note:
 * All of the nodes' values will be unique.
 * p and q are different and both values will exist in the BST.
 */
public class LowestCommonAncestorofaBinarySearchTree {
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val <= root.val && q.val >= root.val) {
            return root;
        }

        if (p.val >= root.val && q.val <= root.val) {
            return root;
        }

        if (p.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        }

        return lowestCommonAncestor(root.right, p, q);
    }
}
