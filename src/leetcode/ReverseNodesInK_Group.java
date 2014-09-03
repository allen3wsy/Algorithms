package leetcode;

public class ReverseNodesInK_Group {

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	// http://www.cnblogs.com/lichen782/p/leetcode_Reverse_Nodes_in_kGroup.html
	public ListNode reverseKGroup(ListNode head, int k) {
		if (head == null || k == 1)
			return head;

		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode pre = dummy; // the pre pointer

		int i = 0;
		// move "head" forward, make it "changed"
		while (head != null) {
			i++;
			if (i % k == 0) { // only under this condition that we should
								// reverse
				pre = reverse(pre, head.next); // head.next can be null
												// (rightmost.next)
				// return "last" to "pre" to make sure that it is not part of
				// changing again
				head = pre.next; // EX: Don't forget this, which makes head the
									// next of "pre"
									// (starting position) !!!
			} else {
				head = head.next;
			}
		}
		return dummy.next; // which is the head of the whole list
	}

	/**
	 * Reverse a link list between pre and next EXCLUSIVELY an example: a linked
	 * list: 0->1->2->3->4->5->6 | | pre next after call pre = reverse(pre,
	 * next)
	 * 
	 * 0->3->2->1->4->5->6 | | pre next
	 * 
	 * @param pre
	 * @param next
	 * @return the reversed list's last node, which is the precedence of
	 *         parameter next
	 */
	public ListNode reverse(ListNode pre, ListNode next) {
		ListNode last = pre.next;
		ListNode cur = last.next;

		// 4 steps here !!!
		while (cur != next) {
			last.next = cur.next; // update 3 pointers !!!
			cur.next = pre.next;
			pre.next = cur;

			cur = last.next; // move the cur pointer forward
		}
		return last; // EX: return "last" pointer to "pre"
	}
}
