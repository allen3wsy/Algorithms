package bstGraph;

import java.util.ArrayList;
import java.util.List;

public class UniqueBinarySearchTree2 {

	// http://www.lifeincode.net/programming/leetcode-unique-binary-search-trees-i-and-ii-java/
	// http://blog.csdn.net/fightforyourdream/article/details/17345795
	// output all combinations: DFS
	// output number: DP

	public List<TreeNode> generateTrees(int n) {
		return generateTrees(1, n);
	}

	public ArrayList<TreeNode> generateTrees(int start, int end) {
		ArrayList<TreeNode> list = new ArrayList<TreeNode>();
		if (start > end) { // if start == end, then go to the for loop
			list.add(null); // which is like a place holder !!! (can't be null)
			return list; // then this list only has one TreeNode(which is null)
		}

		// [1, 3]
		for (int i = start; i <= end; i++) {
			// there are at least one for left or right
			ArrayList<TreeNode> lefts = generateTrees(start, i - 1);
			ArrayList<TreeNode> rights = generateTrees(i + 1, end);

			for (TreeNode left : lefts) { // every left node is a subtree
				for (TreeNode right : rights) { // every right node is a subtree
					TreeNode node = new TreeNode(i); // current node !!!
					node.left = left;
					node.right = right;
					list.add(node);
				}
			}
		}
		return list;
	}
}
