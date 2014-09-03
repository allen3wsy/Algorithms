package leetcode;

import java.util.ArrayList;

public class PathSum2 {

	public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

		ArrayList<Integer> list = new ArrayList<Integer>();

		dfs(root, sum, result, list);
		return result;
	}

	private static void dfs(TreeNode root, int sum,
			ArrayList<ArrayList<Integer>> result, ArrayList<Integer> l) {
		if (root == null)
			return;

		// find the last leaf node for the list
		if (root.val == sum && root.left == null && root.right == null) {
			l.add(root.val);

			// NOTE: we must deep copy first here, otherwise the list will
			// change
			ArrayList<Integer> clone = new ArrayList<Integer>(l);
			result.add(clone);

			l.remove(l.size() - 1); // recover the Global variable // BACKTRACK
									// !!!
			return;
		}

		l.add(root.val);
		dfs(root.left, sum - root.val, result, l);
		dfs(root.right, sum - root.val, result, l);
		l.remove(l.size() - 1); // recover the Global variable // BACKTRACK !!!
	}
}
