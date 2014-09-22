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
		ListNode p1 = head; // 2 pointers: (p1 & prev) (smaller than x)
		ListNode prev = fakeHead1; // 2 pointers: (p1 & prev) (smaller than x)

		ListNode p2 = fakeHead2; // p2 is the running pointer for second list

		while (p1 != null) {
			if (p1.val < x) {
				p1 = p1.next;
				prev = prev.next;
			} else { // p.val >= x
				p2.next = p1;
				prev.next = p1.next;

				p1 = p1.next; // move p1 forward
				p2 = p2.next; // move p2 forward
			}
		}
		p2.next = null; // don't forget! (if not null, will a circular list )

		// now p is null and prev is the rightmost node of the first part
		prev.next = fakeHead2.next;
		return fakeHead1.next;
	}

	public static void main(String[] args) {

	}
}
