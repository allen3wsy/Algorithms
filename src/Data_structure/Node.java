package Data_structure;

// This node is for a singly linked list 
public class Node {

	// public is easier for interview!!!
	public Node next;
	public int data;
	public Node()	{}
	public Node(int d)	{
		this.data = d;
	}
	
	
	// traverse all the way to the end
	void appendToTail(int d)	{
		Node end = new Node(d);
		Node n = this;
		while(n.next != null)	{
			n = n.next;
		}
		n.next = end;
	}
	
	Node deleteNode(Node head, int d) {
		Node n = head;
		if (n.data == d) {
			return n.next;  /* moved head */
		}
		
		while(n.next != null)	{
			if(n.next.data == d)	{
				n.next = n.next.next;
				// if we don't allow delete duplicates, we should return head here
			}
			n = n.next;		
		}
		return head;
	}
		
	public static void main(String args[])	{
		Node node1 = new Node(1);
		Node newNode;
		
		node1.appendToTail(2);
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
					
		newNode = node1.deleteNode(node1, 2);
		System.out.println("\nAfter deletion:");


		System.out.println(node1.data);
		
		for(n  = node1; n.next != null; n = n.next)	{
			System.out.println(n.next.data);	
		}
		
	}
}

