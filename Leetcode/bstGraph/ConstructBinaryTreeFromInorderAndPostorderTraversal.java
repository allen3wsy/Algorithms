package bstGraph;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {

	// http://www.programcreek.com/2013/01/construct-binary-tree-from-inorder-and-postorder-traversal/
	// in-order: 4 2 5 (1) 6 7 3 8
	// post-order: 4 5 2 6 7 8 3 (1)

	public TreeNode buildTree(int[] inorder, int[] postorder) {
		int inStart = 0;
		int inEnd = inorder.length - 1;
		int postStart = 0;
		int postEnd = postorder.length - 1;

		return build(inorder, inStart, inEnd, postorder, postStart, postEnd);
	}

	public TreeNode build(int[] inorder, int inStart, int inEnd,
			int[] postorder, int postStart, int postEnd) {
		if (inStart > inEnd || postStart > postEnd)
			return null;

		TreeNode root = new TreeNode(postorder[postEnd]);
		int k = 0; // k is whatever, cuz because k will finally have a value
		for (int i = inStart; i <= inEnd; i++) {
			if (inorder[i] == root.val) {
				k = i; // k is the target index that separates the inorder array
			}
		}

		int len = k - inStart; // the len of the left subtree
		root.left = build(inorder, inStart, k - 1, postorder, postStart,
				postStart + len - 1);
		root.right = build(inorder, k + 1, inEnd, postorder, postStart + len,
				postEnd - 1);
		return root;
	}
}
