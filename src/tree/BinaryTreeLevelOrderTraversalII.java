package tree;

import base.Lists;
import base.TreeNode;
import base.Trees;

import java.util.*;

/**
 * 107. Binary Tree Level Order Traversal II
 *
 */
public class BinaryTreeLevelOrderTraversalII {
    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }

        LinkedList<List<Integer>> resultList = new LinkedList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode node;
        while (!queue.isEmpty()) {
            int count = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < count; i++) {
                node = queue.poll();
                list.add(node.val);

                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }
            }

            resultList.addFirst(list);
        }

        return resultList;
    }

    public static void main(String[] args) {
        TreeNode root = Trees.buildCompleteTree(new int[]{1, 2, 3, 4, 5, 6, 7});

        List<List<Integer>> resultList = levelOrderBottom(root);

        resultList.forEach(Lists::printList);
    }
}
