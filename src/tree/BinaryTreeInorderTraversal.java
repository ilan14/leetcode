package tree;

import base.Lists;
import base.TreeNode;
import base.Trees;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 94. Binary Tree Inorder Traversal
 */
public class BinaryTreeInorderTraversal {
    public static List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }

        List<Integer> resultList = new LinkedList<>();
        TreeNode node = root;
        Stack<TreeNode> stack = new Stack<>();
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }

            node = stack.pop();
            resultList.add(node.val);
            node = node.right;
        }

        return resultList;
    }

    /**
     * recursive
     *
     * @param root
     * @return
     */
    public static List<Integer> inorderTraversal1(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }

        List<Integer> resultList = new LinkedList<>();
        resultList.addAll(inorderTraversal1(root.left));
        resultList.add(root.val);
        resultList.addAll(inorderTraversal1(root.right));

        return resultList;
    }

    public static void main(String[] args) {
        TreeNode root = Trees.buildCompleteTree(new int[]{1, 2, 3, 4, 5, 6});

        List<Integer> resultList = inorderTraversal(root);

        Lists.printList(resultList);

        List<Integer> resultList1 = inorderTraversal1(root);

        Lists.printList(resultList1);
    }
}
