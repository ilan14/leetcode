package tree;

import base.TreeNode;
import base.Trees;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 230. Kth Smallest Element in a BST
 */
public class KthSmallestElementinaBST {
    /**
     * recursive
     *
     * @param root
     * @param k
     * @return
     */
    public static int kthSmallest(TreeNode root, int k) {
        TreeNode[] node = new TreeNode[1];
        kthSmallest(root, k, new int[1], node);
        return node[0].val;
    }

    private static void kthSmallest(TreeNode root, int k, int[] count, TreeNode[] node) {
        if (root == null) {
            return;
        }

        kthSmallest(root.left, k, count, node);
        count[0]++;
        if (count[0] == k) {
            node[0] = root;
            return;
        }

        kthSmallest(root.right, k, count, node);
    }

    public static int kthSmallest1(TreeNode root, int k) {
        if (root == null) {
            throw new IllegalArgumentException();
        }

        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode node = root;
        int i = 0;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }

            node = stack.pop();
            if (++i == k) {
                return node.val;
            }
            node = node.right;
        }
        throw new IllegalArgumentException();
    }

    public static void main(String[] args) {
        TreeNode root = Trees.buildCompleteTree(new int[]{4, 2, 7, 1, 3, 5, 6});

        System.out.println(kthSmallest(root, 3));

        System.out.println(kthSmallest1(root, 3));
    }
}
