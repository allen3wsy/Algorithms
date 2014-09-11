package bstGraph;


public class ValidateBinarySearchTree {

	public boolean isValidBST(TreeNode root) {
		return validate(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	public boolean validate(TreeNode root, int min, int max) {
		if (root == null)
			return true;

		if (root.val >= max || root.val <= min)
			return false;
		else
			return validate(root.left, min, root.val) && validate(root.right, root.val, max);
	}
}
