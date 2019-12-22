package tree;

import base.Lists;
import base.TreeNode;
import base.Trees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 113. Path Sum II
 * <p>
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
 */
public class PathSumII {
    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) {
            return Collections.emptyList();
        }

        List<List<Integer>> list = new LinkedList<>();
        pathSum(root, sum, new ArrayList<>(), list);

        return list;
    }

    /**
     * resultList作为方法结果返回，需要进行大量额外的复制和空间申请，导致运行时间变长
     *
     * @param root
     * @param sum
     * @param path
     * @param resultList
     */
    private static void pathSum(TreeNode root, int sum, List<Integer> path, List<List<Integer>> resultList) {
        if (root.left == null && root.right == null) {
            if (root.val == sum) {
                List<Integer> list = new ArrayList<>(path);
                list.add(root.val);

                resultList.add(list);
            }
            return;
        }

        int value = sum - root.val;
        path.add(root.val);

        if (root.left != null) {
            pathSum(root.left, value, path, resultList);
        }

        if (root.right != null) {
            pathSum(root.right, value, path, resultList);
        }
        path.remove(path.size() - 1);
    }

    public static void main(String[] args) {
        TreeNode root = Trees.buildCompleteTree(new int[]{5, 4, 8, 11, 13, 4, 7, 2});

        List<List<Integer>> resultList = pathSum(root, 22);
        resultList.forEach(Lists::printList);
    }
}
