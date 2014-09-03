package leetcode;

public class AddTwoNumbers {

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public ListNode addTwoNumbers(ListNode n1, ListNode n2) {
		if (n1 == null && n2 == null)
			return null;
		int carry = 0;
		int i1 = 0, i2 = 0;
		ListNode result = null;
		ListNode runner = null;

		while (n1 != null || n2 != null) {
			i1 = i2 = 0; // reset i1 and i2
			if (n1 != null) {
				i1 = n1.val;
				n1 = n1.next;
			}
			if (n2 != null) {
				i2 = n2.val;
				n2 = n2.next;
			}
			int sum = i1 + i2 + carry; // set the sum
			carry = 0; // reset the carry
			if (sum >= 10)
				carry = 1;

			if (runner == null) {
				// first
				runner = new ListNode(sum % 10);
				result = runner;
			} else {
				// second
				runner.next = new ListNode(sum % 10);
				runner = runner.next; // I forgot this one!!! *****
			}
		}

		if (carry > 0) {
			runner.next = new ListNode(carry);
		}
		return result;
	}
}
