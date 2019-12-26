package tree;

import base.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 236. Lowest Common Ancestor of a Binary Tree
 */
public class LowestCommonAncestorofaBinaryTree {
    /**
     * recursive
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        if (root == p || root == q) {
            return root;
        }

        TreeNode leftSearch = lowestCommonAncestor(root.left, p, q);
        TreeNode rightSearch = lowestCommonAncestor(root.right, p, q);

        if (leftSearch != null && rightSearch != null) {
            return root;
        }

        return leftSearch == null ? rightSearch : leftSearch;
    }

    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) {
            return null;
        }

        if (root == p || root == q) {
            return root;
        }

        Deque<TreeNode> stack1 = new LinkedList<>();
        TreeNode node = root;
        while (node != p && node != q) {
            while (node != null && node != p && node != q) {
                stack1.push(node);
                node = node.left;
            }

            if (node == null) {
                node = stack1.pop();
                node = node.right;
            }
        }

        TreeNode target = node == p ? q : p;
        Deque<TreeNode> stack2 = new LinkedList<>();
        TreeNode result = node;
        while (node != target) {
            while (node != target && (node != null || !stack2.isEmpty())) {
                while (node != null && node != target) {
                    stack2.push(node);
                    node = node.left;
                }

                if (node == null) {
                    node = stack2.pop();
                    node = node.right;
                }
            }

            if (node != target) {
                node = stack1.pop();
                result = node;
                node = node.right;
            }
        }

        return result;
    }
}
