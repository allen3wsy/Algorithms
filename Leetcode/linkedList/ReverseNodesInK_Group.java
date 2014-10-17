package linkedList;

public class ReverseNodesInK_Group {

	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	// http://www.cnblogs.com/lichen782/p/leetcode_Reverse_Nodes_in_kGroup.html
	// http://blog.csdn.net/linhuanmars/article/details/19957455
	// Allen's modified version based on the 2 solutions above !!!
	public static ListNode reverseKGroup(ListNode head, int k) {
		if (head == null || k == 1) // move on when k >= 2
			return head;
		ListNode dummy = new ListNode(0);
		dummy.next = head;

		ListNode pre = dummy;
		ListNode cur = head;
		int count = 0;
		while (cur != null) {
			cur = cur.next;
			count++;
			if (count % k == 0) {
				pre = reverse(pre, cur);
			}
		}
		return dummy.next;
	}

	// leftBound and rightBound are both not included in k-Nodes
	private static ListNode reverse(ListNode leftBound, ListNode rightBound) {

		ListNode prev = leftBound.next;
		ListNode cur = leftBound.next.next;
		while (cur != rightBound) {
			ListNode next = cur.next;
			cur.next = prev;
			prev = cur;
			cur = next;
		}
		ListNode toReturn = leftBound.next; // toReturn is the left node next rounds
		leftBound.next.next = rightBound;
		leftBound.next = prev;
		return toReturn;
	}

}
