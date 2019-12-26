package tree;

import base.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 297. Serialize and Deserialize Binary Tree
 */
public class SerializeandDeserializeBinaryTree {
    public static String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }

        List<TreeNode> list = new ArrayList<>();
        list.add(root);

        int i = 0;
        int end = 1;
        while (i < end) {
            TreeNode node = list.get(i);

            if (node != null) {
                list.add(node.left);
                list.add(node.right);
                end += 2;
            }
            i++;
        }

        i = list.size() - 1;
        while (i >= 0 && list.get(i) == null) {
            i--;
        }
        end = i;

        StringBuilder s = new StringBuilder();
        for (i = 0; i <= end; i++) {
            TreeNode node = list.get(i);
            String data = node == null ? "null" : String.valueOf(node.val);
            s.append(data).append(",");
        }
        s.delete(s.length() - 1, s.length());

        return s.toString();
    }

    public static TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) {
            return null;
        }

        String[] ss = data.split(",");
        if (ss.length == 0) {
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(ss[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int i = 1;
        while (i < ss.length) {
            TreeNode node = queue.poll();
            if (!"null".equals(ss[i])) {
                node.left = new TreeNode(Integer.parseInt(ss[i]));
                queue.add(node.left);
            }
            i++;
            if (i < ss.length && !"null".equals(ss[i])) {
                node.right = new TreeNode(Integer.parseInt(ss[i]));
                queue.add(node.right);
            }
            i++;
        }

        return root;
    }

    public static void main(String[] args) {
        String data = "1,2,3,null,4,5";
        TreeNode node = deserialize(data);

        System.out.println(serialize(node));
    }
}
