package bstGraph;

// C++ solution:
// shttps://github.com/larryhujob/LeetCode/blob/master/Serialization%20and%20Deserialization%20of%20a%20Binary%20Tree.cpp
public class SerializeBinaryTree {
	public static void printInPreorder(TreeNode root) {
		if (root == null)
			return;
		System.out.println(root.val + "");
		printInPreorder(root.left);
		printInPreorder(root.right);
	}

	public static TreeNode deserialize(int[] index, char[] input) {
		if (index[0] >= input.length) // EX: have to check whether out of bound
			return null;
		char ch = input[index[0]];
		index[0]++;
		if (ch == '#') // base case
			return null;

		TreeNode current = new TreeNode(ch - '0');
		current.left = deserialize(index, input);
		current.right = deserialize(index, input);
		return current;
	}

	public static void main(String[] args) {
		char[] input = { '1', '2', '#', '#', '3', '#', '5' };
		int[] index = { 0 };
		TreeNode root = deserialize(index, input);
		printInPreorder(root);
	}

}