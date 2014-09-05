package BSTGraph;

import java.util.ArrayList;
import java.util.Stack;

public class BinaryTreeInorderTraversal {

	public ArrayList<Integer> inorderTraversal(TreeNode root) {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		// t is for traversal
		Stack<TreeNode> s = new Stack<TreeNode>();

		TreeNode current = root;
		while (current != null || !s.isEmpty()) {
			/*
			 * keep going to the left and at the time push the node into the
			 * stack So at this time all the left nodes will be kept in the
			 * stack
			 */
			while (current != null) {
				s.push(current);
				current = current.left;
			}

			/*
			 * whenever we pop out a node we check that whether there is a right
			 * node But if right is null, then the current pointer can never go
			 * down left side thus, we will keep poping the stack
			 */
			if (!s.isEmpty()) {
				current = s.pop();
				arr.add(current.val);
				current = current.right;
			}

		}
		return arr;
	}
}
