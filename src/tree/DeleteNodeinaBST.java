package tree;

import base.TreeNode;

/**
 * 450. Delete Node in a BST
 */
public class DeleteNodeinaBST {
	/**
	 * 1. 找到值为key的待删除的节点deleted，如果不存在，返回
	 * 2. 找到替代deleted位置的节点replace
	 * a. deleted 为叶子节点，replace为null
	 * b. deleted 有一个child，replace为child
	 * c. deleted 有两个child，取中序的后继（右子树的最左节点）或前驱节点（左子树的最右节点）
	 * 3. 修改待删除节点parent的指针（考虑删除root的情况）
	 *
	 * @param root
	 * @param key
	 * @return
	 */
	public static TreeNode deleteNode(TreeNode root, int key) {
		if (root == null) {
			return null;
		}

		TreeNode node = root;
		TreeNode parent = null;

		TreeNode mark;
		while (node.val != key) {
			mark = node;
			while (node.val > key && node.left != null) {
				parent = node;
				node = node.left;
			}

			while (node.val < key && node.right != null) {
				parent = node;
				node = node.right;
			}

			if (node == mark) {
				return root;
			}
		}

		TreeNode deleted = node;
		TreeNode replace = null;
		if (node.left == null || node.right == null) {
			replace = node.left == null ? node.right : node.left;
		} else {
			node = node.right;
			if (node.left != null) {
				TreeNode parent1 = node;
				while (node.left != null) {
					parent1 = node;
					node = node.left;
				}
				parent1.left = node.right;
				node.right = deleted.right;
			}

			node.left = deleted.left;
			replace = node;
		}

		if (parent != null) {
			if (parent.left == deleted) {
				parent.left = replace;
			} else {
				parent.right = replace;
			}
		} else {
			root = replace;
		}

		return root;
	}

	public static void main(String[] args) {
		TreeNode root = SerializeandDeserializeBinaryTree.deserialize("4,2,6,1,3,5,7");

		root = deleteNode(root, 2);

		String data = SerializeandDeserializeBinaryTree.serialize(root);

		System.out.println(data);
	}
}
