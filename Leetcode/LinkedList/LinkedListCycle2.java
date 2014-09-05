package LinkedList;

public class LinkedListCycle2 {

	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null)   
            return null;
        ListNode fast = head;
        ListNode slow = head;
        
        // here we used &&
        while(fast.next != null && fast.next.next != null)    {
            fast = fast.next.next;
            slow = slow.next;
            if(slow == fast)
                break;
        }
        
        // here we used ||
        if(fast.next == null || fast.next.next == null)
            return null;
            
        slow = head;
        while(slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        
        return slow;
    }
	
}
