package tree;

import base.TreeNode;

/**
 * 938. Range Sum of BST
 */
public class RangeSumofBST {
	public int rangeSumBST(TreeNode root, int L, int R) {
		if (root == null) {
			return 0;
		}

		if (root.val < L) {
			return rangeSumBST(root.right, L, R);
		}

		if (root.val > R) {
			return rangeSumBST(root.left, L, R);
		}

		int value = root.val;
		value = value + rangeSumBST(root.left, L, R) + rangeSumBST(root.right, L, R);

		return value;
	}
}
