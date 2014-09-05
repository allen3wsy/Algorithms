package BSTGraph;


public class SymmetricTree {

	public boolean isSymmetric(TreeNode root) {
		if (root == null)
			return true;
		return mirror(root.left, root.right);
	}

	public static boolean mirror(TreeNode t1, TreeNode t2) {
		/* we should always check null first */
		if (t1 == null && t2 == null)
			return true;

		if ((t1 != null && t2 == null) || (t2 != null && t1 == null))
			return false;

		/* first check the data, then recurse down */
		return ((t1.val == t2.val) && mirror(t1.left, t2.right) && mirror(
				t1.right, t2.left));

	}
}
