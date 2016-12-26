package bstGraph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;

public class BinaryTreeVerticalOrderTraversal {

	/**
	 * http://www.programcreek.com/2014/04/leetcode-binary-tree-vertical-order-traversal-java/
	 * used 2 queues: queue for Node and queue for Degree
	 */
	public List<List<Integer>> verticalOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (root == null)
			return result;

		// level and list
		HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

		LinkedList<TreeNode> queue = new LinkedList<>();
		LinkedList<Integer> degreeQueue = new LinkedList<>();

		queue.offer(root);
		degreeQueue.offer(0);

		int minLevel = 0;
		int maxLevel = 0;

		while (!queue.isEmpty()) {
			TreeNode p = queue.poll();
			int degree = degreeQueue.poll();

			// track min and max levels
			minLevel = Math.min(minLevel, degree);
			maxLevel = Math.max(maxLevel, degree);

			// construct the Result !!!
			if (map.containsKey(degree)) {
				map.get(degree).add(p.val);
			} else {
				ArrayList<Integer> list = new ArrayList<>();
				list.add(p.val);
				map.put(degree, list);
			}

			if (p.left != null) {
				queue.offer(p.left);
				degreeQueue.offer(degree - 1);
			}

			if (p.right != null) {
				queue.offer(p.right);
				degreeQueue.offer(degree + 1);
			}
		}

		for (int i = minLevel; i <= maxLevel; i++) {
			if (map.containsKey(i)) {
				result.add(map.get(i));
			}
		}
		return result;
	}
}
