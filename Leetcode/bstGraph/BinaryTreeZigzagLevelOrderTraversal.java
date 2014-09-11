package bstGraph;

import java.util.ArrayList;

public class BinaryTreeZigzagLevelOrderTraversal {

	public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {

		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (root == null)
			return result;

		boolean order = true; // second line : right to left
		ArrayList<TreeNode> toVisit = new ArrayList<TreeNode>();
		toVisit.add(root);

		while (!toVisit.isEmpty()) {
			ArrayList<TreeNode> next = new ArrayList<TreeNode>();
			ArrayList<Integer> temp = new ArrayList<Integer>();
			// everytime the temp ArrayList<> should be newed

			for (TreeNode node : toVisit) {
				temp.add(node.val);
			}

			result.add(temp); // finished one line

			// always traverse the ArrayList: from right to left
			for (int i = toVisit.size() - 1; i >= 0; i--) {
				TreeNode node = toVisit.get(i);
				if (order) { // second line: right to left
					if (node.right != null)
						next.add(node.right);
					if (node.left != null)
						next.add(node.left);
				} else {
					if (node.left != null)
						next.add(node.left);
					if (node.right != null)
						next.add(node.right);
				}
			}
			order = !order; // changing the order from left to right
			toVisit = next; // the way of copying one ArrayList to another
							// ArrayList<>

			// toVisit = new ArrayList<TreeNode>(next);
			// don't have to do this really
		}

		return result;
	}
}
