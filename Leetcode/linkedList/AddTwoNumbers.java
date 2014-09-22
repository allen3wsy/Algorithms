package linkedList;

// this is quite similar to AddBinary
// Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
// Output: 7 -> 0 -> 8
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
		ListNode result = null;
		ListNode runner = null;

		// if any of the condition meets, we go on
		while (n1 != null || n2 != null || carry > 0) {
			int num1 = 0;
			if (n1 != null) {
				num1 = n1.val;
				n1 = n1.next;
			}
			int num2 = 0;
			if (n2 != null) {
				num2 = n2.val;
				n2 = n2.next;
			}
			// EX: first digit then carry, otherwise will cause mistake...
			int digit = (num1 + num2 + carry) % 10; // 1: set the digit
			carry = (num1 + num2 + carry) / 10; // 2: then reset the carry

			if (runner == null) { // 1: only for the 1st time!!!
				runner = new ListNode(digit);
				result = runner; // only for the 1st time
			} else { // 2-n: from 2nd to nth time
				runner.next = new ListNode(digit);
				runner = runner.next; // I forgot this one!!! *****
			}
		}
		return result;
	}
}
