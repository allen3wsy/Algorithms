package basic_data_structure;

/**
 * This is a basic question being asked a lot !!!
 * 
 * @author AllenNg
 */
public class ReverseALinkedList {

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public ListNode head = null; // this is for recursivevReverse !!!

	public void recursiveReverse(ListNode node) {
		// check for empty list
		if (node == null)
			return;
		/*
		 * if we are at the TAIL node: recursive base case:
		 */
		if (node.next == null) {
			// set HEAD to current TAIL since we are reversing list
			head = node;
			return; // since this is the base case
		}

		recursiveReverse(node.next); // Recurse !!!
		node.next.next = node; // REMEMBER THIS !!!!!!!
		node.next = null; // set "old" next pointer to NULL
	}

	public static ListNode revereseOrder(ListNode head) {
		if (head == null || head.next == null)
			return head;

		// length >= 2
		ListNode pre = head;
		ListNode curr = head.next;

		while (curr != null) {
			ListNode temp = curr.next;
			curr.next = pre;
			pre = curr;
			curr = temp;
		}

		head.next = null; // don't forget this last essential step !!!
		return head;
	}
}
