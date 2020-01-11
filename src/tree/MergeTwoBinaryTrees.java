package tree;

import base.TreeNode;

/**
 * 617. Merge Two Binary Trees
 */
public class MergeTwoBinaryTrees {
	public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
		if (t1 == null && t2 == null) {
			return null;
		}

		int value = t1 == null ? 0 : t1.val;
		if (t2 != null) {
			value += t2.val;
		}

		TreeNode root = new TreeNode(value);

		TreeNode node1 = t1 == null ? null : t1.left;
		TreeNode node2 = t2 == null ? null : t2.left;
		root.left = mergeTrees(node1, node2);

		node1 = t1 == null ? null : t1.right;
		node2 = t2 == null ? null : t2.right;
		root.right = mergeTrees(node1, node2);

		return root;
	}

	/**
	 * 不申请新空间，直接修改t1
	 *
	 * @param t1
	 * @param t2
	 * @return
	 */
	public TreeNode mergeTrees1(TreeNode t1, TreeNode t2) {
		if (t1 == null) {
			return t2;
		}

		if (t2 == null) {
			return t1;
		}

		t1.val += t2.val;

		if (t1.left == null) {
			t1.left = t2.left;
		} else {
			t1.left = mergeTrees(t1.left, t2.left);
		}

		if (t1.right == null) {
			t1.right = t2.right;
		} else {
			t1.right = mergeTrees(t1.right, t2.right);
		}

		return t1;
	}
}
