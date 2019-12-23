package tree;

import base.TreeNode;
import base.Trees;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 101. Symmetric Tree
 *
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 * For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 *
 * But the following [1,2,2,null,3,null,3] is not:
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 *
 */
public class SymmetricTree {
    public static boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        return isSymmetric(root.left, root.right);
    }

    private static boolean isSymmetric(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        }

        if (node1 == null || node2 == null) {
            return false;
        }

        if (node1.val != node2.val) {
            return false;
        }

        return isSymmetric(node1.left, node2.right) && isSymmetric(node1.right, node2.left);
    }

    /**
     * recursive
     *
     * @param root
     * @return
     */
    public static boolean isSymmetric1(TreeNode root) {
        if (root == null) {
            return true;
        }

        TreeNode node1, node2;
        Deque<TreeNode> stack1 = new LinkedList<>();
        stack1.push(root);
        Deque<TreeNode> stack2 = new LinkedList<>();
        stack2.push(root);
        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            node1 = stack1.pop();
            node1 = node1.right;
            node2 = stack2.pop();
            node2 = node2.left;

            while (node1 != null && node2 != null) {
                if (node1.val != node2.val) {
                    return false;
                }

                stack1.push(node1);
                stack2.push(node2);
                node1 = node1.left;
                node2 = node2.right;
            }

            if (node1 == null && node2 == null) {
                continue;
            }

            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode root = Trees.buildCompleteTree(new int[]{1, 2, 2, 3, 4, 4, 3});

        System.out.println(isSymmetric(root));

        System.out.println(isSymmetric1(root));
    }
}
