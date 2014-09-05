package LinkedList;

public class RotateList {

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	// http://rleetcode.blogspot.com/2014/01/rotate-list-java.html
	public ListNode rotateRight(ListNode head, int n) {
		if (head == null || n == 0)
			return head;

		int len = 1;
		ListNode last = head;

		// calculate the lenght of given list
		while (last.next != null) {
			last = last.next;
			len++;
		}

		last.next = head; // make it a circle !!!

		// Should considered the situtation that n larger than given list's
		// length
		int k = len - n % len;
		ListNode preHead = last; // preHead is the node which should point to
									// null (end)

		// find the point which are previuse for our target head
		while (k > 0) {
			preHead = preHead.next;
			k--;
		}
		head = preHead.next; // DON'T FORGET TO MODIFY THE NEW HEAD !!!!!
		preHead.next = null; // break the circle !!!

		return head; // the new head
	}
}
