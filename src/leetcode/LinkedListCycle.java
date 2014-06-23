package leetcode;

// careful:
public class LinkedListCycle 	{

	class ListNode {	
		int val;	    
		ListNode next;	    
		ListNode(int x) {	    
			val = x;	        
			next = null;
	      }
	}

    public boolean hasCycle(ListNode head) {
        
    	/* error check: don't forget */
    	if(head == null || head.next == null)   
            return false;
    	
    	/* initialization is also important */
        ListNode fast = head;
        ListNode slow = head;
        
        while(fast != null && fast.next != null)	{
            fast = fast.next.next;
            slow = slow.next;
        	if(slow == fast)   
                return true;
        }
        return false;
    }	
}
