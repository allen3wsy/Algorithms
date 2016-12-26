package bstGraph;

import java.util.LinkedList;

/**
 * Similar to {@code SerializeBinaryTree}, which was what I originally wrote...
 * 
 * http://www.programcreek.com/2014/05/leetcode-serialize-and-deserialize-binary-tree-java/
 * there are 2 solutions here: LevelOrder (BFS) and Recursion(DFS)
 * only did the first solution here.
 */
public class SerializeAndDeserializeBinaryTree {

	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {
		if (root == null) {
			return "";
		}

		StringBuilder sb = new StringBuilder();

		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();

		queue.add(root);
		while (!queue.isEmpty()) {
			TreeNode t = queue.poll();
			if (t != null) {
				sb.append(String.valueOf(t.val) + ",");
				queue.add(t.left);
				queue.add(t.right);
			} else {
				sb.append("#,");
			}
		}

		sb.deleteCharAt(sb.length() - 1);
		System.out.println(sb.toString());
		return sb.toString();
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		if (data == null || data.length() == 0)
			return null;

		String[] arr = data.split(",");
		TreeNode root = new TreeNode(Integer.parseInt(arr[0]));

		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);

		int i = 1;
		while (!queue.isEmpty()) {
			TreeNode t = queue.poll();

			if (t == null)
				continue;

			if (!arr[i].equals("#")) {
				t.left = new TreeNode(Integer.parseInt(arr[i]));
				queue.offer(t.left);

			} else {
				t.left = null;
				queue.offer(null);
			}
			i++;

			if (!arr[i].equals("#")) {
				t.right = new TreeNode(Integer.parseInt(arr[i]));
				queue.offer(t.right);

			} else {
				t.right = null;
				queue.offer(null);
			}
			i++;
		}

		return root;
	}
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
