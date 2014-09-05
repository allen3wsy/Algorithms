package BSTGraph;

import java.util.LinkedList;

//Definition for binary tree
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}

	public int Queue(MinimumDepthOfBinaryTree minimumDepthOfBinaryTree) {
		if (this == null)
			return 0;
	
		LinkedList<TreeNode> nodes = new LinkedList<TreeNode>();
		LinkedList<Integer> counts = new LinkedList<Integer>();
	
		nodes.add(this); // maintains two queue with the exact length
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

public class MaximumPathSum {
	// http://leetcodenotes.wordpress.com/2013/11/04/leetcode-binary-tree-maximum-path-sum-%E6%A0%91%E4%B8%AD%E4%BB%BB%E6%84%8F%E4%B8%A4%E7%82%B9%E9%97%B4%E6%9C%80%E5%A4%A7path-sum/
	// most clear solution !!!

	public int maxPathSum(TreeNode root) {
		int[] result = new int[1];
		result[0] = Integer.MIN_VALUE;

		maxPath(root, result); // return the oneSide value: don't assign it !
		return result[0]; // return the final result

	}

	public int maxPath(TreeNode root, int[] result) {
		if (root == null)
			return 0;

		int left = maxPath(root.left, result); // leftSide: itself not included
		int right = maxPath(root.right, result); // rightSide: itself not
													// included

		int arc = root.val + left + right;
		int oneSide = Math.max(root.val, root.val + Math.max(left, right)); // oneSide
																			// value(including
																			// itself)
		result[0] = Math.max(result[0], Math.max(oneSide, arc));

		return oneSide; // pass the oneSide value up recursively (don't pass the final result)
	}
}