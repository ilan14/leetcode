package tree;

/**
 * 117. Populating Next Right Pointers in Each Node II
 * <p>
 * Follow up:
 * You may only use constant extra space.
 * Recursive approach is fine, you may assume implicit stack space does not count as extra space for this problem.
 */
public class PopulatingNextRightPointersinEachNodeII {
	/**
	 * 沿着当前层的next指针向后遍历，并修改下层next指针
	 *
	 * @param root
	 * @return
	 */
	public Node connect(Node root) {
		if (root == null) {
			return null;
		}

		Node nextLevelHead = null;

		Node cur = root;
		Node former = null;
		while (cur != null) {
			if (cur.left == null && cur.right == null) {
				cur = cur.next;
				continue;
			}

			if (cur.left != null && cur.right != null) {
				cur.left.next = cur.right;
				former = cur.right;
			}

			Node next = cur.next;
			if (former == null) {
				former = cur.left == null ? cur.right : cur.left;
			}

			if (nextLevelHead == null) {
				nextLevelHead = cur.left == null ? cur.right : cur.left;
			}

			Node latter = null;
			while (next != null && latter == null) {
				if (next.left != null) {
					latter = next.left;
				} else if (next.right != null) {
					latter = next.right;
				} else {
					next = next.next;
				}
			}
			former.next = latter;
			former = latter;
			cur = next;

			if (cur == null) {
				cur = nextLevelHead;
				nextLevelHead = null;
			}
		}

		return root;
	}
}
