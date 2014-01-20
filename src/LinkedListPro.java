import java.util.HashMap;

import java.util.Stack;


// sb.delete(0, sb.length());

public class LinkedListPro {
	public static void main(String[] args){
//		int[] arr ={1,1,2,3,5,4,63,7,7,8,8,3,8,8};
//		LinkedNode head = newLinkedList(arr);
//		printList(head);
//		printList(orderList(head, 6));
		//System.out.println(findLastK(head, 8));
//		LinkedNode a1 = new LinkedNode(7);
//		LinkedNode a2 = new LinkedNode(1);
//		LinkedNode a3 = new LinkedNode(6);
//		LinkedNode a4 = new LinkedNode(1);
//		LinkedNode a5 = new LinkedNode(7);
//
//		a1.next = a2;
//		a2.next = a3;
//		a3.next = a4;
//		a4.next = a5;
//
//
//		printList(a1);
//		System.out.println(ifPalindrome(a1));
		//printList(a1);
		
		Node n = new Node(4);
		System.out.println(n.next);
		
	
	}
	
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
	public static void removeDup1(Node head){
		if(head ==null || head.next == null)
			return ;
		
		HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();
		Node prev = null;
		while(head != null){
			if(map.containsKey(head.data)){
				prev.next = head.next;
			}else{
				map.put(head.data, true);
				prev = head;
			}
			head = head.next;
		}
	}
	
	public static void removeDup2(Node head){
		if(head ==null || head.next == null)
			return ;
		
		Node current = head;
		while(current != null){
			Node runner = current;
			while(runner.next != null){
				if(runner.next.data == current.data){
					runner.next = runner.next.next;
				}else
					runner = runner.next;
			}
			current = current.next;
		}
	}
	
	/**
	 * 2.2
	 */
	public static Integer findLastK(Node head, int k){
		if(k < 0)
			return null;
		boolean isLongEnough = true;
		Node p1 = head;
		Node p2 = head;
		while(k-- > 0){
			if(p2 != null)
				p2 = p2.next;
			else{
				isLongEnough = false;
				break;
			}
		}
		if(!isLongEnough || p2 == null) return null;
		
		while(p2.next != null){
			p2 = p2.next;
			p1 = p1.next;
		}
		return p1.data;
		
	}
	
	/**
	 * 2.3
	 */
	public static void deleteMiddle(Node n){
		if(n == null || n.next ==null) return;
		
		n.data = n.next.data;
		n.next = n.next.next;
	}
	
	/**
	 * 2.4
	 */
	public static Node orderList(Node head, int val){
		Node smaller = null, ps = smaller;
		Node larger = null, pl = larger;
		
		while(head != null){
			if(head.data < val){
				if(smaller == null){
					smaller = new Node(head.data);
					ps = smaller;
				}
				else{
					ps.next = new Node(head.data);
					ps = ps.next;
				}
			}else{
				if(larger == null){
					larger = new Node(head.data);
					pl = larger;
				}
				else{
					pl.next = new Node(head.data);
					pl = pl.next;
				}
			}
			head = head.next;
		}
		if(smaller == null)
			return larger;
		ps.next = larger;
		return smaller;
	}
	
	/**
	 * 2.5
	 */
	public static Node addListInReverse(Node n1, Node n2){
		if(n1 == null || n2 == null)
			return null;
		int carry = 0;
		int i1 = 0 , i2 = 0;
		Node result = null;
		Node runner = null;
		while(n1 != null || n2 != null){
			i1 = i2 = 0;
			if(n1 != null){
				i1 = n1.data;
				n1 = n1.next;
			}
			if(n2 != null){
				i2 = n2.data;
				n2 = n2.next;
			}
			
			int i3 = i1 + i2 + carry;
			carry = 0;
			if(result == null){
				result = new Node(i3 % 10);
				runner = result;
			}else{
				runner.next = new Node(i3 % 10);
				runner = runner.next;
			}
			if(i3 >= 10)
				carry = 1;
		}
		if(carry != 0)
			runner.next = new Node(1);
		return result;
			
	}
	
	public static Node addListInOrder(Node n1, Node n2){
		if(n1 == null || n2 == null)
			return null;
		
		int i1 = 0, i2 = 0;
		StringBuilder sb = new StringBuilder();

		while(n1 != null){
			sb.append(n1.data);
			n1 = n1.next;
		}
		i1 = Integer.parseInt(sb.toString());
		
		sb.delete(0, sb.length());
		while(n2 != null){
			sb.append(n2.data);
			n2 = n2.next;
		}
		i2 = Integer.parseInt(sb.toString());
		
		int i3 = i1 + i2;
		System.out.println("i3 = "+ i3);
		int base = 1;
		int tmp = i3;
		while( tmp >= 10){
			base *= 10;
			tmp/=10;
		}
		Node head = null, runner = null;
		while(base >= 1){
			if(head == null){
				head = new Node(i3/base);
				runner = head;
			}else{
				runner.next = new Node(i3/base);
				runner = runner.next;
			}
			i3 %= base;
			base /= 10;
		}
		return head;
	}
	
	/**
	 * 2.6
	 */
	public static int findHeadInCirList(Node head){
		Node runner1 = head;
		Node runner2 = head;
		
		while(runner2 != null && runner2.next!=null){
			runner1 = runner1.next;
			runner2 = runner2.next.next;
			if(runner1 == runner2){
				break;
			}
		}
		
		if(runner2 == null || runner2.next==null)
			return -1; //no loops
		
		runner2 = head;
		while(runner1  != runner2){
			runner1 = runner1.next;
			runner2 = runner2.next;
		}
		return runner1.data;
	}
	
	/**
	 * 2.7
	 */
	public static boolean ifPalindrome(Node head){
		if(head == null)
			return false;
		if(head.next == null)
			return true;
		int num = 0;
		Node tmp = head;
		while(tmp != null)	{
			num++;
			tmp = tmp.next;
		}
		//System.out.println(num);
		Stack<Integer> stack = new Stack<Integer>();
		for(int i=0; i< num/2; i++){
			stack.push(head.data);
			head = head.next;
		}
		//System.out.println(stack.size());
		if(num%2 != 0)
			head = head.next;
		
		while(head != null){
			if(stack.pop() != head.data)
				return false;
			head = head.next;
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
	
}


class LinkedNode{
	int data;
	Node next;
	
	public LinkedNode(int d){
		this.data = d;
		//this.next = null;
	}
}
