package bstGraph;

public class PopulatingNextRightPointersInEachNode2 {

	public class TreeLinkNode {
		int val;
		TreeLinkNode left, right, next;

		TreeLinkNode(int x) {
			val = x;
		}
	}

	// TEST CASE: [0, 2, 4, 1, #, 3, -1, 5, 1, #, 6, #, 8] FINDING the next
	// point is the most important !!
	public void connect(TreeLinkNode root) {
		if (root == null)
			return;

		// keep going right til p is null p is null or p's children is valid
		TreeLinkNode p = root.next;
		while (p != null) {
			if (p.left != null) {
				p = p.left;
				break; // after breaking, p is a valid node
			}
			if (p.right != null) {
				p = p.right;
				break; // after breaking, p is a valid node
			}
			p = p.next;
		} // p can be null!!! NOTICE !!!

		if (root.right != null) // FIRST RIGHT !!!
			root.right.next = p;

		if (root.left != null) { // THEN LEFT !!!
			if (root.right == null)
				root.left.next = p;
			else
				root.left.next = root.right;
		}
		connect(root.right); // key point: FIRST RIGHT, THEN LEFT !!!
		connect(root.left);
	}
}
