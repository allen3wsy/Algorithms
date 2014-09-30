package bstGraph;

public class MaxDiameter {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		public TreeNode(int value) {
			this.val = value;
		}
	}
	public static class Result {
		int depth;
		int maxDiameter;

		public Result(int depth, int maxDiameter) {
			this.depth = depth;
			this.maxDiameter = maxDiameter;
		}
	}

	/* Write your custom functions here */
	static Result findDiameter(TreeNode root) {
		// base case
		if (root == null) {
			return new Result(0, 0);
		}
		// recurse
		Result left = findDiameter(root.left);
		Result right = findDiameter(root.right);
		int depth = Math.max(left.depth, right.depth) + 1;

		int currentArc = left.depth + right.depth + 1;
		int maxDiameter = Math.max(
				Math.max(left.maxDiameter, right.maxDiameter), currentArc);

		return new Result(depth, maxDiameter);
	}

	static int diameterOfTree(TreeNode root) {
		/*
		 * For your reference class Node { Node left, right; int data; Node(int
		 * newData) { left = right = null; data = newData; } }
		 */
		Result result = findDiameter(root);
		return result.maxDiameter;

	}
	
}
