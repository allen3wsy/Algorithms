package bstGraph;

public class BinaryTreeDelete {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		public TreeNode(int value) {
			this.val = value;
		}
	}
	
	public int findMin(TreeNode node) {
		while (node.left != null) {
			node = node.left;
		}
		return node.val;
	}

	// remove the TreeNode with value t (target)
	public TreeNode remove(int t, TreeNode node) {
		if (node == null)
			return node; // not found!!! doNothing
		if (t > node.val)
			node.right = remove(t, node.right);
		else if (t < node.val)
			node.left = remove(t, node.left);
		else if (node.left != null && node.right != null) { // node.val == t
			// First step!!! copy the minValue from right and replace the value
			// Or we can also find the maxValue from the left, replace it
			node.val = findMin(node.right); // first step
			node.right = remove(node.val, node.right); // second step
		} else
			// node.val == t, but one of node's child is null
			node = (node.left != null) ? node.left : node.right;
		return node;
	}

}
