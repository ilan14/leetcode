package tree;

import base.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 872. Leaf-Similar Trees
 */
public class LeafSimilarTrees {
    public static boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();

        buildLeafList(root1, list1);

        List<Integer> list2 = new ArrayList<>();
        buildLeafList(root2, list2);

        if (list1.size() != list2.size()) {
            return false;
        }

        for (int i = 0; i < list1.size(); i++) {
            if (!list1.get(i).equals(list2.get(i))) {
                return false;
            }
        }

        return true;
    }

    private static void buildLeafList(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            list.add(root.val);
            return;
        }

        buildLeafList(root.left, list);
        buildLeafList(root.right, list);
    }
}
