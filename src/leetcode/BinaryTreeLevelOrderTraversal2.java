package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal2 {

	public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		if (root == null)
			return result;

		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);

		while (!queue.isEmpty()) {
			// hard copy !!! Using this queue to make integer list !
			Queue<TreeNode> tempQueue = new LinkedList<TreeNode>(queue);
			ArrayList<Integer> valueList = new ArrayList<Integer>();

			// getting the integer value out of the queue (Mostly copying
			// integer values !!!)
			while (!tempQueue.isEmpty()) {
				TreeNode node = tempQueue.poll();
				valueList.add(node.val);
			}
			list.add(valueList);

			int size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeNode node = queue.poll();
				if (node.left != null) {
					queue.add(node.left);
				}
				if (node.right != null) {
					queue.add(node.right);
				}
			}
		}

		// reverse the result list !!!
		for (int i = list.size() - 1; i >= 0; i--) {
			result.add(list.get(i));
		}
		return result;
	}
}
