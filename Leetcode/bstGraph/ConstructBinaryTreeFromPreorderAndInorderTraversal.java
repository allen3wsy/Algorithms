package bstGraph;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

	// http://www.geeksforgeeks.org/construct-tree-from-given-inorder-and-preorder-traversal/
	// Inorder sequence: D B E A F C
	// Preorder sequence: A B D E C F

	public TreeNode buildTree(int[] preorder, int[] inorder) {
		int preStart = 0;
		int preEnd = preorder.length - 1;
		int inStart = 0;
		int inEnd = inorder.length - 1;

		return build(preorder, preStart, preEnd, inorder, inStart, inEnd);
	}

	public TreeNode build(int[] preorder, int preStart, int preEnd,
			int[] inorder, int inStart, int inEnd) {
		if (preStart > preEnd || inStart > inEnd) // exit condition
			return null;

		// preorder[preStart] must be the root of this subtree
		TreeNode root = new TreeNode(preorder[preStart]);

		int k = 0; // (preStart == preEnd && inStart == inEnd): only one node
		for (int i = inStart; i <= inEnd; i++) { // traverse inOrder[] array
			if (inorder[i] == root.val) { // "k" is the divide for inOrder[]
				k = i; // left side of k (inOrder array) is of left subtree
				break; // this command can also be removed
			}
		}
		int len = k - inStart; // len is the number of nodes of the left subtree

		root.left = build(preorder, preStart + 1, preStart + len, inorder,
				inStart, k - 1);
		root.right = build(preorder, preStart + len + 1, preEnd, inorder,
				k + 1, inEnd);
		return root;
	}
}
