package tree;

import base.Lists;
import base.TreeNode;
import base.Trees;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 257. Binary Tree Paths
 *
 * Given a binary tree, return all root-to-leaf paths.
 * Note: A leaf is a node with no children.
 *
 * Example:
 * Input:
 *    1
 *  /   \
 * 2     3
 *  \
 *   5
 *
 * Output: ["1->2->5", "1->3"]
 */
public class BinaryTreePaths {
    public static List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }

        List<String> resultList = new LinkedList<>();

        binaryTreePaths(root, new StringBuilder(), resultList);

        return resultList;
    }

    private static void binaryTreePaths(TreeNode root, StringBuilder s, List<String> resultList) {
        String str = String.valueOf(root.val);
        int length = str.length();
        s.append(str);
        if (root.left == null && root.right == null) {
            resultList.add(s.toString());
            s.delete(s.length() - length, s.length());
            return;
        }

        s.append("->");
        if (root.left != null) {
            binaryTreePaths(root.left, s, resultList);
        }

        if (root.right != null) {
            binaryTreePaths(root.right, s, resultList);
        }
        s.delete(s.length() - length - 2, s.length());
    }

    public static void main(String[] args) {
        TreeNode root = Trees.buildCompleteTree(new int[]{1, 2, 3, 4, 5});

        Lists.printList(binaryTreePaths(root));
    }
}
