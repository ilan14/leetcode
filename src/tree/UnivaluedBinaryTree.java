package tree;

import base.TreeNode;

/**
 * 965. Univalued Binary Tree
 */
public class UnivaluedBinaryTree {
	public boolean isUnivalTree(TreeNode root) {
		if (root == null) {
			return true;
		}

		if (root.left != null && root.left.val != root.val) {
			return false;
		}

		if (root.right != null && root.right.val != root.val) {
			return false;
		}

		return isUnivalTree(root.left) && isUnivalTree(root.right);
	}
}
