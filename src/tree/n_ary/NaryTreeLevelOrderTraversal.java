package tree.n_ary;

import java.util.*;

/**
 * 429. N-ary Tree Level Order Traversal
 */
public class NaryTreeLevelOrderTraversal {
	public List<List<Integer>> levelOrder(Node root) {
		if (root == null) {
			return Collections.emptyList();
		}

		List<List<Integer>> resultList = new ArrayList<>();
		Node node;
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			List<Integer> tmpList = new ArrayList<>();
			for (int i = 0; i < size; i++) {
				node = queue.poll();
				tmpList.add(node.val);

				if (node.children != null && node.children.size() != 0) {
					queue.addAll(node.children);
				}
			}

			resultList.add(tmpList);
		}

		return resultList;
	}
}
