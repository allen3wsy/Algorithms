/**
 * In case of ListNode Recursion !!!
 * 
 * @author AllenNg
 */
public class LinkedListRecursion {

	public static class ListNode {
		ListNode next;
		int val;

		public ListNode(int n) {
			val = n;
		}
	}

	public class IntWrapper {
		public int value = 0;
	}

	public static ListNode nthToLast(ListNode head, int k, IntWrapper intWrapper) {
		if (head == null)
			return null;

		// main recursion node (2 possibilities:)
		ListNode node = nthToLast(head.next, k, intWrapper);
		intWrapper.value = intWrapper.value + 1; // 1: always null
		if (intWrapper.value == k) // 2: once found, always return it up
			return head;

		return node;
	}

	public static class Result {
		public ListNode node;
		public boolean result;

		public Result(ListNode n, boolean res) {
			node = n;
			result = res;
		}
	}

	public static LinkedListRecursion.Result isPalindromeRecurse(ListNode head,
			int length) {
		if (head == null || length == 0) {
			return new LinkedListRecursion.Result(null, true);
		} else if (length == 1) {
			return new LinkedListRecursion.Result(head.next, true);
		} else if (length == 2) {
			return new LinkedListRecursion.Result(head.next.next,
					head.val == head.next.val);
		}

		LinkedListRecursion.Result res = isPalindromeRecurse(head.next,
				length - 2); // recursion here !!!

		if (!res.result || res.node == null) {
			return res; // Only "result" member is actually used in the call
						// stack.
		} else {
			res.result = head.val == res.node.val;
			res.node = res.node.next;
			return res;
		}
	}

	public static boolean isPalindrome(ListNode head) {
		int size = 0;
		ListNode n = head;
		while (n != null) { // getting the size of the Linked List and pass the
							// size as the "param"
			size++; // into PalindromeRecurse(head, size) function
			n = n.next;
		}
		Result p = isPalindromeRecurse(head, size);
		return p.result;
	}

	/**
	 * 2.5
	 * 
	 * @author AllenNg
	 */
	public class PartialSum {
		public ListNode sum = null;
		public int carry = 0;
	}
	
	public static void main(String[] args) {
		int length = 10;
		ListNode[] nodes = new ListNode[length];
		for (int i = 0; i < length; i++) {
			if (i >= length / 2) {
				nodes[i] = new ListNode(length - i - 1);
			} else { // i < length / 2
				nodes[i] = new ListNode(i);
			}
		}

		// for (int i = 0; i < length; i++) {
		// if (i < length - 1) {
		// nodes[i].setNext(nodes[i + 1]);
		// }
		// if (i > 0) {
		// nodes[i].setPrevious(nodes[i - 1]);
		// }
		// }
		// nodes[length - 2].data = 9; // Uncomment to ruin palindrome

		ListNode head = nodes[0];
		System.out.println(isPalindrome(head));
	}
}
