package leetcode;

public class RemoveDuplicatesFromSortedList2 {

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public ListNode deleteDuplicates(ListNode head) {
		ListNode prev = new ListNode(0);
		prev.next = head;
		head = prev;

		ListNode n1 = head; // FAKE HEAD n1.val == 0 !!!

		// for example: 1.1.1.2.2.3
		// FAKE: 0.1.1.1.2.2.3
		while (n1.next != null) { // n1 always points to the valid element
			ListNode n2 = n1.next;
			// to find the rightmost 1, assign it to n2
			while (n2.next != null && n2.next.val == n2.val) {
				n2 = n2.next;
			}
			if (n2 != n1.next) { // important !!!!!!!
				n1.next = n2.next;
			} else {
				n1 = n2; // (n2 == n1.next)
			}
		}
		return head.next;
	}
}
