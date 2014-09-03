import com.sun.xml.internal.messaging.saaj.packaging.mime.Header;

public class LinkedListRecursion {
	
	public class IntWrapper {
		public int value = 0;
	}
	
	public static LinkedListNode nthToLast(LinkedListNode head, int k, IntWrapper i)	{
		if(head == null)
			return null;
		
		LinkedListNode node = nthToLast(head.next, k, i);	// main recursion
															// node (2 possibilities:)
		i.value = i.value + 1;								// 1: always null
		if(i.value == k)	{								// 2: once found, will always return that up...
			return head;
		}
		
		return node;
	}
	
		
	public class Result {
		public LinkedListNode node;
		public boolean result;
		public Result(LinkedListNode n, boolean res) {
			node = n;
			result = res;
		}
	}

	public LinkedListRecursion.Result isPalindromeRecurse(LinkedListNode head, int length) {
		if (head == null || length == 0) {
			return new LinkedListRecursion.Result(null, true);
		} else if (length == 1) {
			return new LinkedListRecursion.Result(head.next, true);
		} else if (length == 2) {
			return new LinkedListRecursion.Result(head.next.next, head.data == head.next.data);
		}
		
		LinkedListRecursion.Result res = isPalindromeRecurse(head.next, length - 2);	// recursion here !!!
		
		if (!res.result || res.node == null) {
			return res; // Only "result" member is actually used in the call stack.
		} else {
			res.result = head.data == res.node.data;
			res.node = res.node.next;
			return res;
		}
	}
	
	public boolean isPalindrome(LinkedListNode head) {
		int size = 0;
		LinkedListNode n = head;
		while (n != null) {			// getting the size of the Linked List and pass the size as the "param" 
			size++;					// into PalindromeRecurse(head, size) function
			n = n.next;
		}
		Result p = isPalindromeRecurse(head, size);			
		return p.result;
	}
	
	public static void main(String[] args) {
		int length = 10;
		LinkedListNode[] nodes = new LinkedListNode[length];
		for (int i = 0; i < length; i++) {
			nodes[i] = new LinkedListNode(i >= length / 2 ? length - i - 1 : i);
		}
		
//		for (int i = 0; i < length; i++) {
//			if (i < length - 1) {
//				nodes[i].setNext(nodes[i + 1]);
//			}
//			if (i > 0) {
//				nodes[i].setPrevious(nodes[i - 1]);
//			}
//		}
		// nodes[length - 2].data = 9; // Uncomment to ruin palindrome
		
		LinkedListNode head = nodes[0];
//		System.out.println(head.printForward());
		LinkedListRecursion q = new LinkedListRecursion();
		System.out.println(q.isPalindrome(head));
	}

}


class LinkedListNode{
	LinkedListNode next;
	int data;
	public LinkedListNode(int n) {
		data = n;
	}
}
