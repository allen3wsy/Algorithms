package LinkedList;

public class RemoveNthNodeFromEndOfList {

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public ListNode removeNthFromEnd(ListNode head, int n) {
		if (head == null) {
			return head;
		}

		// special case: when we have only 1 node and we delete the 1st node
		// from the end of the list
		// that's why we need preHead !!!
		ListNode preHead = new ListNode(-1);
		preHead.next = head;
		ListNode pre = preHead;
		ListNode last = preHead;

		while (n >= 1) { // move the right pointer to the right
			last = last.next;
			n--;
		}

		while (last.next != null) { // move 2 pointers together
			last = last.next;
			pre = pre.next;
		}
		pre.next = pre.next.next; // delete the node

		return preHead.next;
	}
}
