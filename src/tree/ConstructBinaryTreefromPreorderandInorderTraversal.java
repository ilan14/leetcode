package tree;

import base.TreeNode;
import base.Trees;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 105. Construct Binary Tree from Preorder and Inorder Traversal
 * <p>
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 * <p>
 * Note:
 * You may assume that duplicates do not exist in the tree.
 */
public class ConstructBinaryTreefromPreorderandInorderTraversal {
    /**
     * recursive
     *
     * @param preorder
     * @param inorder
     * @return
     */
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length == 0 || preorder.length != inorder.length) {
            return null;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        int[] preIndex = new int[1];
        return buildTree(preorder, preIndex, inorder, 0, inorder.length - 1, map);
    }

    /**
     * 每次从preorder中确定一个root，在inorder中查找root.val位置为index，index左右两边形成两个子树，继续递归
     *
     * @param preorder
     * @param preIndex 当前步骤中root在preorder中的位置
     * @param inorder
     * @param start
     * @param end
     * @return
     */
    private static TreeNode buildTree(int[] preorder, int[] preIndex, int[] inorder, int start, int end, Map<Integer,
            Integer> map) {
        if (start > end) {
            return null;
        }

        if (start == end) {
            preIndex[0]++;
            return new TreeNode(inorder[start]);
        }

        TreeNode root = new TreeNode(preorder[preIndex[0]++]);
        int i = map.get(root.val);
        root.left = buildTree(preorder, preIndex, inorder, start, i - 1, map);
        root.right = buildTree(preorder, preIndex, inorder, i + 1, end, map);

        return root;
    }

    /**
     * leetcode 看的分享
     *
     * @param preorder
     * @param inorder
     * @return
     */
    public static TreeNode buildTree1(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length == 0 || preorder.length != inorder.length) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[0]);
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);

        int j = 0;
        for (int i = 1; i < preorder.length; i++) {
            TreeNode node = new TreeNode(preorder[i]);
            TreeNode parent = stack.peek();
            if (inorder[j] != parent.val) {
                parent.left = node;
            } else {
                while (!stack.isEmpty() && stack.peek().val == inorder[j]) {
                    parent = stack.pop();
                    j++;
                }
                parent.right = node;
            }
            stack.push(node);
        }

        return root;
    }

    public static TreeNode buildTree2(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length == 0 || preorder.length != inorder.length) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[0]);

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        Deque<TreeNode> stack = new LinkedList<>();
        Deque<Integer> indexStack = new LinkedList<>();

        TreeNode last = root;
        int start = 0;
        int end = map.get(root.val);
        indexStack.push(inorder.length);

        int i = 1;
        while (i < preorder.length) {
            TreeNode node = new TreeNode(preorder[i]);
            int index = map.get(node.val);
            if (index >= start && index < end) {
                last.left = node;
                stack.push(last);
                indexStack.push(end);

                end = index;
            } else {
                do {
                    start = end + 1;
                    end = indexStack.pop();
                    index = map.get(node.val);
                    if (index >= start && index < end) {
                        last.right = node;
                        indexStack.push(end);

                        end = index;
                        break;
                    }
                    last = stack.pop();
                } while (!indexStack.isEmpty());
            }
            last = node;

            i++;
        }

        return root;
    }

    public static void main(String[] args) {
        int[] preorder = {5, 2, 1, 3, 4, 7, 6, 8};
        int[] inorder = {1, 2, 3, 4, 5, 6, 7, 8};

        TreeNode root = buildTree(preorder, inorder);

        Trees.printLevelOrder(root);

//        TreeNode root1 = buildTree1(preorder, inorder);
//
//        Trees.printLevelOrder(root1);

        TreeNode root2 = buildTree2(preorder, inorder);

        Trees.printLevelOrder(root2);

    }
}
