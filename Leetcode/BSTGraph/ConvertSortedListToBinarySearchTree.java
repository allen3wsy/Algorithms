package BSTGraph;

import LinkedList.LinkedListCycle.ListNode;

public class ConvertSortedListToBinarySearchTree {

	public class ListNode {
		int val;
		ListNode next;
		public ListNode(int i) {
			val = i;
		}
	}
	
	static ListNode list;

	public static TreeNode sortedListToBST(ListNode head) {
		ListNode r = head;
		int length = 0;
		while (r != null) {
			length++;
			r = r.next;
		}

		ListNode[] lists = { head };
		return sortedBST(lists, 0, length - 1);
	}

	// EX: one is ListNode, one is TreeNode !
	// don't confuse them
	public static TreeNode sortedBST(ListNode[] list, int start, int end) {
		if (start > end)
			return null;

		int middle = (start + end) / 2;

		TreeNode left = sortedBST(list, start, middle - 1);
		TreeNode parent = new TreeNode(list[0].val);
		parent.left = left;

		list[0] = list[0].next; // this is very important !!! changing the
								// current node that should be inserted into the
								// tree

		parent.right = sortedBST(list, middle + 1, end);

		return parent;
	}
}
