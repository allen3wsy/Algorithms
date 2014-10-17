package linkedList;

public class SwapNodesInPairs {

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	// http://blog.csdn.net/linhuanmars/article/details/19957455
    // Allen's modified version based on the 2 solutions above !!!
	public ListNode swapPairs(ListNode head) {
		if (head == null) // move on when k >= 2
			return head;
		ListNode dummy = new ListNode(0);
		dummy.next = head;

		ListNode pre = dummy;
		ListNode cur = head;
		int count = 0;
		while (cur != null) {
			cur = cur.next;
			count++;
			if (count % 2 == 0) {
				pre = reverse(pre, cur);
			}
		}
		return dummy.next;
	}

	// leftBound and rightBound are both not included in k-Nodes
	private static ListNode reverse(ListNode leftBound, ListNode rightBound) {

		ListNode prev = leftBound.next;
		ListNode cur = leftBound.next.next;
		cur.next = prev;
		prev.next = rightBound;
		leftBound.next = cur;

		return prev;
	}
}
