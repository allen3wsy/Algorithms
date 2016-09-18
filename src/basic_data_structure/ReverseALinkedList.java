package basic_data_structure;

/**
 * This is a basic question being asked a lot !!!
 * 
 * @author AllenNg
 */

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
}
public class ReverseALinkedList {

	/**
	 * Recursive
	 * @param node
	 * @return
	 */
	public static ListNode recursiveReverse(ListNode node) {
		// check for empty list
		if (node == null)
			return node;
		/*
		 * if we are at the TAIL node: recursive base case:
		 */
		if (node.next == null) {
			// set HEAD to current TAIL since we are reversing list
			ListNode newHead = node;
			return newHead; // since this is the base case
		}

		ListNode newHead = recursiveReverse(node.next);	// Recurse !!!
		node.next.next = node;			// REMEMBER THIS !!!!!!!
		node.next = null; 				// set "old" next pointer to NULL
		return newHead;
	}

	/**
	 * Iterative
	 * @param head
	 * @return
	 */
	public static ListNode revereseOrder(ListNode head) {
		if (head == null || head.next == null)
			return head;

		// length >= 2
		ListNode pre = head;
		ListNode curr = head.next;

		while (curr != null) {
			ListNode temp = curr.next;
			curr.next = pre;
			pre = curr;
			curr = temp;
		}

		head.next = null; // don't forget this last essential step !!!
		return pre; // pre is the new head!!!
	}
	
	public static void printList(ListNode listNode) {
		while(listNode != null) {
			System.out.print(listNode.val + " ");
			listNode = listNode.next;
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode head = l1;
		
		l1.next = l2;
		l2.next = l3;
		printList(head);
		
		ListNode newHead = recursiveReverse(head);
		printList(newHead);
	}
}
