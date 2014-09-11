package bstGraph;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumDepthOfBinaryTree {

	// BFS solution
	public int minDepth(TreeNode root) {
		if (root == null)
			return 0;

		Queue<TreeNode> nodes = new LinkedList<TreeNode>();
		Queue<Integer> counts = new LinkedList<Integer>();

		nodes.add(root); // maintains two queue with the exact length
		counts.add(1); // maintains two queue with the exact length

		// another idea: create a class that wraps: TreeNode and Integer: every
		// TreeNode has a field which is the level of the Node
		while (!nodes.isEmpty()) {
			TreeNode curr = nodes.poll();
			int count = counts.poll();

			if (curr.left == null && curr.right == null) {
				return count;
			}

			if (curr.left != null) {
				nodes.add(curr.left);
				counts.add(count + 1);
			}

			if (curr.right != null) {
				nodes.add(curr.right);
				counts.add(count + 1);
			}
		}
		return 0; // actually the program never goes to here.... but you have to
					// add the return statement
	}
	
	// DFS (recursion) solution
	// Allen && Leon
    public int minDepth2(TreeNode root) {
        if(root == null)
            return 0;

        int left = minDepth(root.left);
        int right = minDepth(root.right);
        
        if(root.left == null) {
            return right + 1;
        } else if(root.right == null) {     // root.left != null;  root.right == null
            return left + 1;
        } else {        // left != null && right != null
            return Math.min(left, right) + 1;
        }
        
    }
}
