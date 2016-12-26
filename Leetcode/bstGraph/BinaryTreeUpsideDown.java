package bstGraph;

public class BinaryTreeUpsideDown {

	/**
	 * There are 3 solutions: 1) Recursion, 2) Iterative and 3) LevelOrder
	 * http://blog.csdn.net/whuwangyi/article/details/43186045
	 */

	/**
	 * Method 1
	 */
	public TreeNode upsideDownBinaryTree(TreeNode root) {
		if (root == null)
			return null;
		TreeNode parent = root, left = root.left, right = root.right;
		if (left != null) {
			TreeNode ret = upsideDownBinaryTree(left);
			left.left = right;
			left.right = parent;
			return ret;
		}
		return root;
	}

	/**
	 * Method 2
	 */
	public TreeNode upsideDownBinaryTree_2(TreeNode root) {
		// init
		TreeNode node = root;
		TreeNode parent = null;
		TreeNode right = null;
		
		// look at all 6 sentences they are very elegant.
		while (node != null) {
			TreeNode left = node.left;
			node.left = right;
			right = node.right;
			node.right = parent;
			parent = node;
			node = left;
		}
		return parent;
	}

	/**
	 * Method 3: look at the website: not the best
	 */
}
