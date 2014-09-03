package leetcode;

import java.util.LinkedList;

public class MinimumDepthOfBinaryTree {

	public int minDepth(TreeNode root) {
		if (root == null)
			return 0;

		LinkedList<TreeNode> nodes = new LinkedList<TreeNode>();
		LinkedList<Integer> counts = new LinkedList<Integer>();

		nodes.add(root); // maintains two queue with the exact length
		counts.add(1); // maintains two queue with the exact length

		// another idea: create a class that wraps: TreeNode and Integer: every
		// TreeNode has a field which is the level of the Node
		while (!nodes.isEmpty()) {
			TreeNode curr = nodes.poll();
			int count = counts.poll();

			if (curr.left == null && curr.right == null) {
				return count;
			}

			if (curr.left != null) {
				nodes.add(curr.left);
				counts.add(count + 1);
			}

			if (curr.right != null) {
				nodes.add(curr.right);
				counts.add(count + 1);
			}
		}
		return 0; // actually the program never goes to here.... but you have to
					// add the return statement
	}
}
