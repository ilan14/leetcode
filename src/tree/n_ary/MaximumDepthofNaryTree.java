package tree.n_ary;

/**
 * 559. Maximum Depth of N-ary Tree
 */
public class MaximumDepthofNaryTree {
	public int maxDepth(Node root) {
		if (root == null) {
			return 0;
		}

		int maxChildenDepth = 0;
		if (root.children != null && root.children.size() != 0) {
			for (int i = 0; i < root.children.size(); i++) {
				int tmp = maxDepth(root.children.get(i));
				maxChildenDepth = Math.max(maxChildenDepth, tmp);
			}
		}

		return maxChildenDepth + 1;
	}
}
