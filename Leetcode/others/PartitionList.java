package others;

public class PartitionList {

	/**
	 * @author Allen
	 */
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public ListNode partition(ListNode head, int x) {
		if (head == null)
			return null;

		ListNode fakeHead1 = new ListNode(0); // fakeHead1 is for first part
		ListNode fakeHead2 = new ListNode(0); // this fakeHead2 is for the part
												// bigger than or equal to x

		fakeHead1.next = head;
		ListNode p = head; // need 2 pointer for the list (smaller than x)
		ListNode prev = fakeHead1; //

		ListNode p2 = fakeHead2; // p2 is the running pointer for the second
									// list part

		while (p != null) {
			if (p.val < x) {
				p = p.next;
				prev = prev.next;
			} else { // p.val >= x
				p2.next = p;
				prev.next = p.next;

				p = p.next; // move p forward
				p2 = p2.next; // move p2 forward
				p2.next = null; // don't forget this (if not set to null, will a
								// circular list )
			}
		}

		prev.next = fakeHead2.next; // now p is null and prev is the rightmost
									// node of the first part

		return fakeHead1.next;
	}
}
