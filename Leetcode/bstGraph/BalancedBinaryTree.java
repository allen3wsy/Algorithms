package bstGraph;

//Definition for binary tree
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}
public class BalancedBinaryTree {

	public boolean isBalanced(TreeNode root) {
		if (checkHeight(root) == -1) {
			return false;
		} else { // if root is null: then return 0: also true
			return true;
		}
	}

	// - 1 means not balanced
	public int checkHeight(TreeNode root) {
		if (root == null) {
			return 0;
		}

		int leftHeight = checkHeight(root.left);
		if (leftHeight == -1) {
			return -1;
		}

		int rightHeight = checkHeight(root.right);
		if (rightHeight == -1) {
			return -1;
		}

		int heightDiff = Math.abs(leftHeight - rightHeight);
		if (heightDiff > 1) { // unbalanced...
			return -1;
		} else {
			return 1 + Math.max(leftHeight, rightHeight); // return the height
		}

	}
}
