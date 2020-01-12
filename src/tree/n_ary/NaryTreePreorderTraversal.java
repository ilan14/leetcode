package tree.n_ary;

import java.util.*;

/**
 * 589. N-ary Tree Preorder Traversal
 */
public class NaryTreePreorderTraversal {
	public List<Integer> preorder(Node root) {
		if (root == null) {
			return Collections.emptyList();
		}

		List<Integer> resultList = new ArrayList<>();
		Deque<Node> stack = new LinkedList<>();
		Node node = root;
		while (node != null || !stack.isEmpty()) {
			while (node != null) {
				resultList.add(node.val);

				if (node.children != null && node.children.size() != 0) {
					for (int i = node.children.size() - 1; i > 0; i--) {
						stack.push(node.children.get(i));
					}
					node = node.children.get(0);
				} else {
					node = null;
				}
			}

			if (!stack.isEmpty()) {
				node = stack.pop();
			}
		}

		return resultList;
	}
}

