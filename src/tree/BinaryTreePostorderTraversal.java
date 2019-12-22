package tree;

import base.Lists;
import base.TreeNode;
import base.Trees;

import java.util.*;

/**
 * 145. Binary Tree Postorder Traversal
 *
 * leetcode上，前序（Preorder），中序（Inorder），层次（Level Order）遍历都是Medium难度，
 * 而后序（Postorder）是Hard难度，
 * 个人理解，因为按照一般正向思路，左子树，右子树，根节点这样，需要判断节点是否访问过，更复杂些，
 * 而反向思路程序更快，但难于理解
 */
public class BinaryTreePostorderTraversal {
    /**
     * 反向思路
     *
     * note：
     * 写个例子，从后向前容易理解
     * stack是个同步容器，所以尽量减少重复操作，比如同一个节点先push，再pop出来
     *
     * @param root
     * @return
     */
    public static List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }

        LinkedList<Integer> resultList = new LinkedList<>();

        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            resultList.addFirst(node.val);
            if (node.left != null) {
                stack.push(node.left);
            }

            node = node.right;
            if (node == null && !stack.isEmpty()) {
                node = stack.pop();
            }
        }

        return resultList;
    }

    /**
     * 正向思路
     * 使用set判断一个节点是否被访问过，第二次访问时才加入结果中
     *
     * @param root
     * @return
     */
    public static List<Integer> postorderTraversal1(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }

        List<Integer> resultList = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();
        HashSet<TreeNode> set = new HashSet<>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }

            node = stack.pop();
            if (!set.contains(node)) {
                stack.push(node);
                set.add(node);
                node = node.right;
            } else {
                resultList.add(node.val);
                node = null;
            }
        }
        return resultList;
    }

    /**
     * recursive
     *
     * @param root
     * @return
     */
    public static List<Integer> postorderTraversal2(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }

        List<Integer> resultList = new ArrayList<>();
        resultList.addAll(postorderTraversal1(root.left));
        resultList.addAll(postorderTraversal1(root.right));
        resultList.add(root.val);

        return resultList;
    }

    public static void main(String[] args) {
        TreeNode root = Trees.buildCompleteTree(new int[]{1, 2, 3, 4, 5, 6});

        List<Integer> resultList = postorderTraversal(root);

        Lists.printList(resultList);

        List<Integer> resultList1 = postorderTraversal1(root);

        Lists.printList(resultList1);
    }
}
