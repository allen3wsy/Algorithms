package LinkedList;

public class ReverseLinkedList2 {

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public ListNode reverseBetween(ListNode head, int m, int n) {
		if (head == null || head.next == null)
			return head;

		ListNode prev = new ListNode(0);
		prev.next = head;
		head = prev; // fake HEAD : in case the real head is within the reverse
						// range !!!
		ListNode n1 = head;

		int k = m - 1;
		while (k > 0) {
			n1 = n1.next;
			k--;
		} // right now n1 is the prev pointer of pointer M

		prev = n1; // then, assign n1 to prev, prev is the prev pointer of
					// pointer M
		n1 = n1.next; // n1 is the pointer of pointer M right now (n1 is now M)

		// this is so perfect !!!
		k = n - m;
		while (n1.next != null && k > 0) { // the reverse stage !!! KEY stage
											// !!!
			ListNode temp = n1.next;
			n1.next = temp.next;
			temp.next = prev.next;
			prev.next = temp;
			k--;
		}

		return head.next; // fake head's next the real head
	}
}
