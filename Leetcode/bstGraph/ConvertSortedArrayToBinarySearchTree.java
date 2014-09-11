package bstGraph;


public class ConvertSortedArrayToBinarySearchTree {

	public TreeNode sortedArrayToBST(int[] num) {
		return BuildTree(num, 0, num.length - 1);
	}

	TreeNode BuildTree(int[] num, int start, int end) {
		if (start > end)
			return null;
		if (start == end)
			return new TreeNode(num[start]);
		int mid = (start + end) / 2;

		TreeNode node = new TreeNode(num[mid]);
		node.left = BuildTree(num, start, mid - 1);
		node.right = BuildTree(num, mid + 1, end);

		return node;
	}
}
