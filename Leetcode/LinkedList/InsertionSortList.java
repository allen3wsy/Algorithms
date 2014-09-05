package LinkedList;

public class InsertionSortList {
    
	// using fakeHead again !!!
	public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        
        ListNode fakeHead = new ListNode(head.val);  
        ListNode pre = fakeHead;  			// disconnected !!! (fakeHead.next == null)
        ListNode cur = head;
        
        // loop through each element in the list
        while(cur != null)  {
            ListNode next = cur.next;
            pre = fakeHead;
            
            // move "pre" forward until pre.next >= cur
            while(pre.next != null && pre.next.val < cur.val)   {
                pre = pre.next;
            }
            
            cur.next = pre.next;
            pre.next = cur;
            cur = next;
            
        }
        return fakeHead.next;
    }
}
