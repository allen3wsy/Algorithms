import java.util.HashMap;
import java.util.Stack;

public class cracking_2 {

	public static void main(String[] args) {
		int[] arr = { 1, 1, 2, 3, 5, 4, 63, 7, 7, 8, 8, 3, 8, 8 };
		Node head = newLinkedList(arr);

		printList(head);

		// 2.1
		removeDup2(head);
		printList(head);

		// 2.2
		printList(nthToLast(head, 8));

		int[] a1 = { 7, 1, 7 };
		int[] a2 = { 5, 9, 2 };
		Node n1 = newLinkedList(a1);
		Node n2 = newLinkedList(a2);
		printList(addTwoNumbers(n1, n2)); // 717 + 295 = 1012 (reverse Order)

		// 2.7
		int[] palin = { 1, 1, 2, 3, 5, 5, 3, 2, 1, 1, 100 };
		head = newLinkedList(palin);
		System.out.println(isPalindrome(head));

	}

	// create a new LinkedList from an array
	public static Node newLinkedList(int[] arr) {
		Node head = new Node(arr[0]);
		Node p = head;
		for (int i = 1; i < arr.length; i++) {
			p.next = new Node(arr[i]);
			p = p.next;
		}
		return head;
	}

	public static void printList(Node head) {
		while (head != null) {
			System.out.print(head.val + "->");
			head = head.next;
		}
		System.out.println();
	}

	/**
	 * 2.1
	 */
	// with a hashMap O(N):
	// We used a prev and a head: In this way, I would be less easier to
	// make mistake
	public static void removeDup1(Node head) {
		if (head == null || head.next == null)
			return;
		HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();
		Node prev = null; //
		while (head != null) {
			if (map.containsKey(head.val)) {
				prev.next = head.next;
			} else {
				map.put(head.val, true);
				prev = head;
			}
			head = head.next;
		}
	}

	// no buffer: then O(N squared)
	public static void removeDup2(Node head) {
		if (head == null || head.next == null)
			return;

		Node current = head;
		while (current != null) {
			Node runner = current;
			while (runner.next != null) {
				if (runner.next.val == current.val) {
					runner.next = runner.next.next;
				} else {
					runner = runner.next;
				}
			}
			current = current.next;
		}
	}

	/**
	 * 2.2 case: when k is bigger than the size of the list (3 > 2) return
	 */
	public static Node nthToLast(Node head, int k) {
		if (k <= 0)
			return null;
		Node p1 = head;
		Node p2 = head;

		for (int i = 0; i < k - 1; i++) {
			p2 = p2.next;
			// we must have error check here (assume k = 100 >> 2)
			if (p2 == null)
				return null;
		}

		while (p2.next != null) {
			p1 = p1.next;
			p2 = p2.next;
		}
		return p1;

	}

	/**
	 * 2.3
	 */
	// note: when n == null || n.next == null
	// this algorithm fails
	public static boolean deleteNode(Node n) {
		if (n == null || n.next == null)
			return false;
		n.val = n.next.val;
		n.next = n.next.next;
		return true;
	}

	/**
	 * 2.4
	 */
	// note that Leetcode is better on this because the Leetcode problem
	// preserves the order of the original list
	public static Node partition(Node head, int x) {
		Node before = null;
		Node after = null;

		while (head != null) {
			Node temp = head.next;
			if (head.val < x) {
				head.next = before;
				before = head;
			} else {
				head.next = after;
				after = head;
			}
			head = temp;
		}
		// merge them back
		if (before == null)
			return after;

		Node runner = before;
		while (runner.next != null) {
			runner = runner.next;
		}
		runner.next = after;
		return before;
	}

	/**
	 * 2.5
	 */
	public static Node addTwoNumbers(Node n1, Node n2) {
		if (n1 == null && n2 == null)
			return null;
		int carry = 0;
		Node result = null;
		Node runner = null;

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
				runner = new Node(digit);
				result = runner; // only for the 1st time
			} else { // 2-n: from 2nd to nth time
				runner.next = new Node(digit);
				runner = runner.next; // I forgot this one!!! *****
			}
		}
		return result;
	}

	/**
	 * 2.6
	 */
	public static Node FindBeginning(Node head) {
		Node slow = head;
		Node fast = head;

		// here we used &&
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			if (fast == slow)
				break;
		}

		/* Error check: no meeting point, therefore no loop */
		// EX: here we used ||
		if (fast == null || fast.next == null)
			return null;
		slow = head;
		while (fast != slow) {
			fast = fast.next;
			slow = slow.next;
		}
		return slow;
	}

	/**
	 * 2.7
	 */
	public static boolean isPalindrome(Node head) {
		if (head == null)
			return false;
		if (head.next == null)
			return true;

		int listSize = 0;
		Node runner = head;
		while (runner != null) {
			listSize++;
			runner = runner.next;
		}

		runner = head; // reset the runner
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < listSize / 2; i++) {
			stack.push(runner.val);
			runner = runner.next;
		}

		if (listSize % 2 != 0) // in case of the size is an odd number
			runner = runner.next; // then the middle node doesn't count

		while (runner != null) {
			if (stack.pop() != runner.val)
				return false;
			runner = runner.next; // stack.pop() == head.data
		}
		return true; // now the runner is null
	}

	/**
	 * reverse a doubly linked list without extra space
	 */
	public static Node reverseDoule(Node head) {
		// error check
		if (head == null || head.next == null)
			return head;
		Node n = head, next;
		Node prev = null;

		// n is the runner
		while (n != null) {
			next = n.next;
			n.next = n.prev;
			n.prev = next;
			prev = n; // this is for return!!!
			n = next;
		}
		return prev; // prev is the new head.
	}
}

class Node {
	int val;
	Node next;
	Node prev;

	public Node(int d) {
		this.val = d;
	}
}
