package linkedList;

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

		// consider the situation that n larger than given list's length
		int k = len - n % len;
		ListNode preHead = last; // preHead: should point to null (end)
		while (k > 0) { // find the point which are previous for our target head
			preHead = preHead.next;
			k--;
		}
		head = preHead.next; // DON'T FORGET TO MODIFY THE NEW HEAD !!!!!
		preHead.next = null; // break the circle !!!

		return head; // the new head
	}
}
