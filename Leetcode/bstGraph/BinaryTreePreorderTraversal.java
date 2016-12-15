package bstGraph;

import java.util.ArrayList;
import java.util.Stack;

//  2
// 1 3
// preOrder's output: 2, 1, 3
public class BinaryTreePreorderTraversal {

	public ArrayList<Integer> preorderTraversal(TreeNode root) {

		ArrayList<Integer> list = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		if (root != null)
			stack.push(root);

		while (!stack.isEmpty()) {
			TreeNode temp = stack.pop();
			list.add(temp.val);

			if (temp.right != null)
				stack.push(temp.right);
			if (temp.left != null)
				stack.push(temp.left);
		}

		return list;
	}
}
