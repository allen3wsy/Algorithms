import java.util.HashMap;
import java.util.Stack;


public class cracking_2 {


	public static void main(String[] args)	{
		int[] arr ={1,1,2,3,5,4,63,7,7,8,8,3,8,8};
		Node head = newLinkedList(arr);
		printList(head);

		
		// 2.1
		removeDup2(head);
		printList(head);
		
		// 2.2
		printList(nthToLast(head, 8));
		
		int[] a1 = {7,1,7}; 
		int[] a2 = {5,9,2};
		Node n1 = newLinkedList(a1);
		Node n2 = newLinkedList(a2);
		printList(addLists(n1, n2));  // 717 + 295 = 1012 (reverse Order)

		
		// 2.7
		int[] palin ={1,1,2,3,5,5,3,2,1,1,100};
		head = newLinkedList(palin);
		System.out.println(isPalindrome(head));
		
		// reverse a list using 3 pointers 
		printList(reverseList(head));
		
		
	}
	
	// create a new LinkedList from an array
	public static Node newLinkedList(int[] arr){
		Node head = new Node(arr[0]);
		Node p = head;
		for(int i=1; i<arr.length; i++){
			p.next = new Node(arr[i]);
			p = p.next;
		}
		return head;
	}
	
	public static void printList(Node head){
		while(head != null){
			System.out.print(head.data + "->");
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
	
	public static void removeDup1(Node head)	{
		if(head == null || head.next == null)	
			return;
		HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();
		Node prev = null; 	//
		while(head != null)	{
			if(map.containsKey(head.data))	{
				prev.next = head.next;
			} else {
				map.put(head.data, true);
				prev = head;
			}
			head = head.next;
		}
	}
		
	// no buffer: then O(N squared)
	public static void removeDup2(Node head)	{
		if(head == null || head.next == null)
			return;
		
		Node current = head;
		while(current != null)	{
			Node runner = current;
			while(runner.next != null)	{
				if(runner.next.data == current.data)	{
					runner.next = runner.next.next;
				} else {
					runner = runner.next;					
				}
			}
			current = current.next;
		}
	}
	
	/**
	 * 2.2
	 */
	// ************************
	// easy to make mistakes....
	// when k is bigger than the size of the list (3 > 2)
	public static Node nthToLast(Node head, int k)	{
		if(k <= 0)
			return null;
		Node p1 = head;
		Node p2 = head;
		
		for(int i = 0; i < k - 1; i++)	{
			p2 = p2.next;
			// we must have error check here (assume k = 100 >> 2)
			if(p2 == null)
				return null;
		}
		
		while(p2.next != null)	{
			p1 = p1.next;
			p2 = p2.next;
		}
		return p1;
		
	}
	
	
	
	
	/**
	 * 2.3
	 */
	
	// note:  when n == null || n.next == null
	// this algorithm fails
	public static boolean deleteNode(Node n)	{
		if(n == null || n.next == null)
			return false;
		n.data = n.next.data;
		n.next = n.next.next;
		return true;
	}
	
	
	
	/**
	 * 2.4
	 */
	public static Node partition(Node node, int x)	{
		Node before = null;
		Node after = null;
		
		while(node != null)	{
			Node temp = node.next;
			if(node.data < x)	{			
				node.next = before;
				before = node;		
			}	else	{
				node.next = after;
				after = node;
			}
			node = temp;
			
		}		
		// merge them back
		if(before == null)	
			return after;
		
		Node runner = before;
		while (runner.next != null)	{
			runner = runner.next;
		}
		runner.next = after;
		return before;	
	}
	
	
	/**
	 * 2.5
	 */
	public static Node addLists(Node n1, Node n2){
		if(n1 == null && n2 == null)
			return null;
		int carry = 0;
		int i1 = 0 , i2 = 0;
		Node result = null;
		Node runner = null;
		
		while(n1 != null || n2 != null)	{
			i1 = i2 = 0;		// reset i1 and i2
			if(n1 != null)	{
				i1 = n1.data;
				n1 = n1.next;
			}
			if(n2 != null)	{
				i2 = n2.data;
				n2 = n2.next;
			}
			int sum = i1 + i2 + carry;	// set the sum
			carry = 0;			// reset the carry
			if(sum >= 10)
				carry = 1;
			
			if(runner == null)	{
				// first
				runner = new Node(sum % 10);
				result = runner;
			}
			else	{
				// second
				runner.next = new Node(sum % 10);
				runner = runner.next;		// I forgot this one!!! *****
			}			
		}
		
		if(carry > 0)	{
			runner.next = new Node(carry);
		}
		return result;
	}
	
	
	/**
	 * 2.6
	 */
	
	public static Node FindBeginning(Node head)	{
		Node slow = head;
		Node fast = head;
		
		/* This is extremely important because if there is no loop
		 * Then the fast of fast.next will reach "null"
		 * */
		while(fast != null && fast.next != null)	{
			fast = fast.next.next;
			slow = slow.next;
			if(fast == slow)
				break;
		}
		/* Error check: no meeting point, therefore no loop */
		if(fast != null || fast.next != null)	
			return null;		
		slow = head;
		while(fast != slow)	{
			fast = fast.next;
			slow = slow.next;
		}		
		return slow;
		
	}
	
	
	/**
	 * 2.7
	 */
	
	public static boolean isPalindrome(Node head)	{
		if(head == null || head.next == null)
			return true;
		Stack<Integer> stack = new Stack<Integer>();
		Node runner = head;
		while(runner != null)	{
			stack.push(runner.data);
			runner = runner.next;
			
		}
		
		runner = head;
		while(runner != null)	{
			if(runner.data != stack.pop())
				return false;
			runner = runner.next;
		}
		return true;
		
	}
	
	/**
	 * reverse a linked list using 3 pointers
	 */
	public static Node reverseList(Node head)	{
		Node prev = null;
		Node forward = head.next;	// not necessary
		
		while(head != null)	{
			forward = head.next;	// we construct forward if and only if head != null
			head.next = prev;
			prev = head;
			head = forward;			
		}	
		return prev;
		
	}
	
	/**
	 * reverse a doubly linked list without extra space
	 */
	/*
	 * using a temp
	 * */
	public static Node reverse(Node head){
		// error check
		if(head == null || head.next == null)
			return head;		
		Node n = head, next;

		while(n != null){
			next = n.next;
			n.next = n.prev;
			n.prev = next;
			n = next;
		}
		// n is the new head.
		return n;
	}
	
}

class Node	{
	int data;
	Node next;
	Node prev;
	public Node(int d)	{
		this.data = d;
	}
}
