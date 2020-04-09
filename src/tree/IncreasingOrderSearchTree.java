package tree;

import base.TreeNode;
import base.Trees;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 897. Increasing Order Search Tree
 *
 * similar to 114. Flatten Binary Tree to Linked List
 */
public class IncreasingOrderSearchTree {
    public static TreeNode increasingBST(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode newRoot = new TreeNode(0);

        TreeNode node = newRoot;
        TreeNode cur = root;

        Deque<TreeNode> stack = new LinkedList<>();

        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                TreeNode temp = cur.left;
                cur.left = null;
                stack.push(cur);
                cur = temp;
            }

            if (!stack.isEmpty()) {
                cur = stack.pop();
                node.right = cur;
                node = node.right;
                cur = cur.right;
            }
        }

        return newRoot;
    }

    public static void main(String[] args) {
        TreeNode root = Trees.buildCompleteTree(new int[]{4, 2, 6, 1, 3, 5, 7});

        root = increasingBST(root);

        Trees.printLevelOrder(root);
    }
}
