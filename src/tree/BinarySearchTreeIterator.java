package tree;

import base.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 173. Binary Search Tree Iterator
 *
 * Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.
 * Calling next() will return the next smallest number in the BST.
 *
 * Note:
 * 1. next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
 * 2. You may assume that next() call will always be valid, that is, there will be at least a next smallest number in
 * the BST when next() is called.
 */
public class BinarySearchTreeIterator {
    private Deque<TreeNode> stack;
    private TreeNode cur;

    public BinarySearchTreeIterator(TreeNode root) {
        stack = new LinkedList<>();
        cur = root;

        if (cur != null) {
            while (cur.left != null) {
                stack.push(cur);
                cur = cur.left;
            }
        }
    }

    public int next() {
        int result = cur.val;
        if (cur.right != null) {
            cur = cur.right;
            while (cur.left != null) {
                stack.push(cur);
                cur = cur.left;
            }
        } else if (!stack.isEmpty()) {
            cur = stack.pop();
        } else {
            cur = null;
        }
        return result;
    }

    public boolean hasNext() {
        return cur != null || !stack.isEmpty();
    }

    public static void main(String[] args) {
        String str = "7,3,15,null,null,9,20";

        TreeNode root = SerializeandDeserializeBinaryTree.deserialize(str);

        BinarySearchTreeIterator it = new BinarySearchTreeIterator(root);
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
