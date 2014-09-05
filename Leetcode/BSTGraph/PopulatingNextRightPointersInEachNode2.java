package BSTGraph;

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
		// Note: The Solution object is instantiated only once and is reused by
		// each test case.
		if (root == null)
			return;

		// this part is find the effective "NEXT" node FOR root's children
		TreeLinkNode p = root.next;
		while (p != null) {
			if (p.left != null) {
				p = p.left;
				break;
			}
			if (p.right != null) {
				p = p.right;
				break;
			}
			p = p.next;
		} // p can be null!!! NOTICE !!!

		// FIRST RIGHT, THEN LEFT !!!
		if (root.right != null) {
			root.right.next = p;
		}

		if (root.left != null) {
			if (root.right == null) {
				root.left.next = p;
			} else {
				root.left.next = root.right;
			}
		}

		connect(root.right); // key point: FIRST RIGHT, THEN LEFT !!!
		connect(root.left);
	}
}
