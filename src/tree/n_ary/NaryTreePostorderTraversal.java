package tree.n_ary;

import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 590. N-ary Tree Postorder Traversal
 */
public class NaryTreePostorderTraversal {
	public List<Integer> postorder(Node root) {
		if (root == null) {
			return Collections.emptyList();
		}

		LinkedList<Integer> resultList = new LinkedList<>();
		Deque<Node> stack = new LinkedList<>();
		Node node = root;
		while (node != null || !stack.isEmpty()) {
			while (node != null) {
				resultList.addFirst(node.val);
				if (node.children != null && node.children.size() != 0) {
					for (int i = 0; i < node.children.size() - 1; i++) {
						stack.push(node.children.get(i));
					}

					node = node.children.get(node.children.size() - 1);
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
