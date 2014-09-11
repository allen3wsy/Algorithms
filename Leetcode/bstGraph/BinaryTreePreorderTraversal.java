package bstGraph;

import java.util.ArrayList;
import java.util.Stack;

public class BinaryTreePreorderTraversal {

	public ArrayList<Integer> preorderTraversal(TreeNode root) {

		ArrayList<Integer> arr = new ArrayList<Integer>();
		Stack<TreeNode> s = new Stack<TreeNode>();
		if (root != null)
			s.push(root);

		while (!s.isEmpty()) {
			TreeNode temp = s.pop();
			arr.add(temp.val);

			if (temp.right != null)
				s.push(temp.right);
			if (temp.left != null)
				s.push(temp.left);
		}

		return arr;
	}
}
