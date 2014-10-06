package bstGraph;

public class SerializeConstructBinaryTree {
	// http://leetcode.com/2010/09/serializationdeserialization-of-binary.html

	// this class demonstrates the method of serializing a binary tree (not BST)
	// and constructs it back

	// We use "pre-order" traversal, the reason why in-order and post-order
	// don't work is that for the later two
	// children nodes come before parent node, therefore we'll have hard time
	// reconstruct the tree. Pre-order is
	// the only one that the parent comes before the children

	public String serializeBT(TreeNode root) {
		StringBuilder builder = new StringBuilder();
		serializeHelper(root, builder);
		return builder.toString();
	}

	public void serializeHelper(TreeNode current, StringBuilder builder) {
		// base case
		if (current == null) {
			// use # to represent a null node
			builder.append("# ");
			return;
		}

		// recursion
		builder.append(current.val).append(" ");
		serializeHelper(current.left, builder);
		serializeHelper(current.right, builder);
	}

	// Deserialize a tree
	// concept is simple : pre-orderly construct the tree

	public TreeNode deserializeBT(String compressedBT) {
		TreeNode root = null;
		Helper helper = new Helper(compressedBT.trim().split(" "), 0);
		root = deserializationHelper(root, helper);
		return root;
	}

	public TreeNode deserializationHelper(TreeNode currentNode, Helper helper) {

		if (!helper.hasNext())
			return null;

		String current = helper.next();

		// construct the current node
		currentNode = current.equals("#") ? null : new TreeNode(
				Integer.valueOf(current));

		// base case
		if (currentNode == null)
			return null;

		// recursion
		currentNode.left = deserializationHelper(currentNode.left, helper);
		currentNode.right = deserializationHelper(currentNode.right, helper);

		return currentNode;
	}

	class Helper {
		String[] nodes;
		int index = 0;

		public Helper(String[] nodes, int index) {
			this.nodes = nodes;
			this.index = index;
		}

		boolean hasNext() {
			return index < nodes.length;
		}

		String next() {
			return nodes[index++];
		}

	}

}
