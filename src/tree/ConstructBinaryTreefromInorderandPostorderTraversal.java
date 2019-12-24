package tree;

import base.TreeNode;
import base.Trees;

import java.util.HashMap;
import java.util.Map;

/**
 * 106. Construct Binary Tree from Inorder and Postorder Traversal
 */
public class ConstructBinaryTreefromInorderandPostorderTraversal {
    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length == 0 || inorder.length != postorder.length) {
            return null;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        int[] postIndex = {postorder.length - 1};
        return buildTree(postorder, postIndex, inorder, 0, inorder.length - 1, map);
    }

    private static TreeNode buildTree(int[] postorder, int[] postIndex, int[] inorder, int start, int end, Map<Integer
            , Integer> map) {
        if (start > end) {
            return null;
        }

        if (start == end) {
            postIndex[0]--;
            return new TreeNode(inorder[start]);
        }

        TreeNode root = new TreeNode(postorder[postIndex[0]--]);
        int i = map.get(root.val);

        root.right = buildTree(postorder, postIndex, inorder, i + 1, end, map);
        root.left = buildTree(postorder, postIndex, inorder, start, i - 1, map);

        return root;
    }

    public static void main(String[] args) {
        int[] inorder = {1, 2, 3};
        int[] postorder = {3, 2, 1};

        TreeNode root = buildTree(inorder, postorder);

        Trees.printLevelOrder(root);
    }
}
