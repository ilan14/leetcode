package tree;

import base.Lists;
import base.TreeNode;
import base.Trees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * 144. Binary Tree Preorder Traversal
 */
public class BinaryTreePreorderTraversal {
    public static List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }

        TreeNode node = root;
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> resultList = new ArrayList<>();
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                resultList.add(node.val);
                stack.push(node);
                node = node.left;
            }

            node = stack.pop();
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
    public static List<Integer> preorderTraversal1(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }

        List<Integer> resultList = new ArrayList<>();
        resultList.add(root.val);
        resultList.addAll(preorderTraversal1(root.left));
        resultList.addAll(preorderTraversal1(root.right));
        return resultList;
    }

    public static void main(String[] args) {
        TreeNode root = Trees.buildCompleteTree(new int[]{1, 2, 3, 4, 5, 6});

        List<Integer> resultList = preorderTraversal(root);

        Lists.printList(resultList);

        List<Integer> resultList1 = preorderTraversal1(root);

        Lists.printList(resultList1);
    }
}
