package LinkedList;

public class SwapNodesInPairs {

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null)
			return head;

		// INIT: there are at least 2 nodes right now
		ListNode i = head;
		ListNode j = head.next;
		head = j;

		while (i != null && j != null) {
			ListNode nextI = j.next;
			j.next = i; // must be done

			if (nextI == null) {
				i.next = null; // first case
				break;
			} else {
				ListNode nextJ = nextI.next;
				if (nextJ == null) {
					i.next = nextI; // second case
					break;
				} else {
					i.next = nextJ; // third case
					i = nextI;
					j = nextJ;
				}
			}
		}

		return head;
	}
}
