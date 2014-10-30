package bstGraph;

import java.util.Stack;

public class FlattenBinaryTreeToLinkedList {

	public void flatten(TreeNode root) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode p = root;

		while (p != null || !stack.empty()) {
			if (p.right != null) {
				stack.push(p.right);
			}

			if (p.left != null) {
				p.right = p.left;
				p.left = null;
			} else if (!stack.empty()) { // p.left == null
				TreeNode temp = stack.pop();
				p.right = temp;
			}

			p = p.right;
		}
	}
}
