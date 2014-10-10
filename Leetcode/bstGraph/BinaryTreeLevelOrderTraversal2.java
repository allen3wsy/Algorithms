package bstGraph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal2 {

	public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (root == null)
			return result;

		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		while (!queue.isEmpty()) {
			ArrayList<Integer> valueList = new ArrayList<Integer>();

			int size = queue.size(); // size of current queue
			for (int i = 0; i < size; i++) {
				TreeNode node = queue.poll();
				valueList.add(node.val); // add the node to current level
				if (node.left != null) {
					queue.add(node.left);
				}
				if (node.right != null) {
					queue.add(node.right);
				}
			}
			result.add(valueList); // add this new level
		}

		Collections.reverse(result); // reverse
		return result;
	}
}
