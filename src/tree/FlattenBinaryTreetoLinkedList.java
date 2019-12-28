package tree;

import base.TreeNode;

/**
 * 114. Flatten Binary Tree to Linked List
 *
 * Given a binary tree, flatten it to a linked list in-place.
 *
 * 把树每个节点的左子树节点放到右子树上，形成一个链表
 *
 * For example, given the following tree:
 *
 *     1
 *    / \
 *   2   5
 *  / \   \
 * 3   4   6
 * The flattened tree should look like:
 *
 * 1
 *  \
 *   2
 *    \
 *     3
 *      \
 *       4
 *        \
 *         5
 *          \
 *           6
 */
public class FlattenBinaryTreetoLinkedList {
	public static void flatten(TreeNode root) {
		if (root == null) {
			return;
		}

		TreeNode op;
		TreeNode cur = root;
		while (cur != null) {
			op = cur.left;
			if (op != null) {
				while (op.right != null) {
					op = op.right;
				}

				op.right = cur.right;
				cur.right = cur.left;
				cur.left = null;
			}
			cur = cur.right;
		}
	}

	public static void main(String[] args) {
		TreeNode root = SerializeandDeserializeBinaryTree.deserialize("1,2,3,4,5,6,7,null,8,null,9");

		flatten(root);

		String data = SerializeandDeserializeBinaryTree.serialize(root);

		System.out.println(data);
	}
}
