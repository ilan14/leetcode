package base;

import java.util.LinkedList;
import java.util.Queue;

public class Trees {
    public static TreeNode buildCompleteTree(int[] array) {
        if (array == null || array.length == 0) {
            return null;
        }

        TreeNode root = new TreeNode(array[0]);
        int i = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (i < array.length) {
            TreeNode node = queue.poll();
            node.left = new TreeNode(array[i]);
            queue.add(node.left);
            if (++i < array.length) {
                node.right = new TreeNode(array[i]);
                queue.add(node.right);
                i++;
            }
        }

        return root;
    }
}
