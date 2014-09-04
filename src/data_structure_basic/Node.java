package data_structure_basic;

// This node is for a singly linked list 
public class Node {

	// public is easier for interview!!!
	public Node next;
	public int data;
	
	public Node()	{}
	
	public Node(int d)	{
		this.data = d;
	}
		
	/**
	 * Reverse every k nodes
	 * @param head
	 * @param n
	 * @return
	 */
	
	public Node groupReverse(Node head, int n)	{
		if(head == null || head.next == null)
			return head;
		
		Node first = head;
		Node last = head;
		int count = 1;
		while(last.next != null)	{
			last = last.next;
			if(++count == n)
				break;
		}

		while(first != last){
			Node p = first;
			first = first.next;
			p.next = last.next;
			last.next = p;
		}
		
		count = 1;
		while(last.next != null && count++ < n){
			last = last.next;
		}
		
		last.next = groupReverse(last.next, n);
		return first;
	}
	
	// traverse all the way to the end
	void appendToTail(int d)	{
		
		Node endNode = new Node(d);
		Node n = this;
		while(n.next != null)	{
			n = n.next;
		}
		n.next = endNode;
	}
	
	/**
	 * delete all the nodes with the intended value
	 * @param head
	 * @param d
	 * @return
	 */
	
	Node deleteNode(Node head, int d) {
		  
		if(head == null)	
			return head;
		while(head != null)	{
			if(head.data != d)	
				break;
			head = head.next;
		}
		
		// deleting all the nodes with element d
		if(head == null)
			return head;
		
		Node prev = head;  
		Node current = head.next;
		
		// cannot delete the first node:
		while(current != null)	{
			if(current.data == d)	{
				prev.next = current.next;
				current = prev.next;
			} else {
				prev = current;
				current = current.next;
			}
		}
		return head;
	}
	
		
	public static void main(String args[])	{
		Node node1 = new Node(1);
		Node newNode;
		
		node1.appendToTail(1);
		node1.appendToTail(3);
		node1.appendToTail(2);
		node1.appendToTail(3);
		
		System.out.println("print all numbers:");
		
		Node n = new Node();
		
		// print num
		System.out.print(node1.data);
		for(n  = node1; n.next != null; n = n.next)	{
			System.out.print("->" + n.next.data);	
		}
					
		// newNode is the the first node after deletion
		newNode = node1.deleteNode(node1, 1);
		System.out.println("\nAfter deletion:");
		
		System.out.println(newNode.data);
		for(n  = newNode; n.next != null; n = n.next)	{
			System.out.println(n.next.data);	
		}
		
		String s = "  a";
        String[] arr = s.split(" ");
        System.out.println();
        System.out.println(arr.length);
        
        if(arr[1].equals(""))	
        	System.out.println("haha");
        if(arr[2].equals("a"))	
        	System.out.println("hey");
        
        
	}
}

