package bstGraph;

import java.util.ArrayList;

public class BinaryTreeZigzagLevelOrderTraversal {

	public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {

		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (root == null)
			return result;

		boolean reverseOrder = true; // second line : right to left

		ArrayList<TreeNode> currentLevel = new ArrayList<TreeNode>();
		currentLevel.add(root);

		while (!currentLevel.isEmpty()) {
			ArrayList<TreeNode> nextLevel = new ArrayList<TreeNode>();

			// everytime the temp ArrayList<> should be newed
			ArrayList<Integer> temp = new ArrayList<Integer>();
			for (TreeNode node : currentLevel)
				temp.add(node.val);
			result.add(temp); // finished one line

			// always traverse the ArrayList: from right to left
			for (int i = currentLevel.size() - 1; i >= 0; i--) {
				TreeNode node = currentLevel.get(i);
				if (reverseOrder) { // second line: right to left
					if (node.right != null)
						nextLevel.add(node.right);
					if (node.left != null)
						nextLevel.add(node.left);
				} else {
					if (node.left != null)
						nextLevel.add(node.left);
					if (node.right != null)
						nextLevel.add(node.right);
				}
			}
			reverseOrder = !reverseOrder; // changing the order
			currentLevel = nextLevel; // copying one ArrayList to another
		}

		return result;
	}
}
