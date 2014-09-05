package LinkedList;

public class SortList {

	// http://blog.csdn.net/linhuanmars/article/details/21133949
    public ListNode sortList(ListNode head) {
        return mergeSort(head);
    }
    
    private ListNode mergeSort(ListNode head)   {
        if(head == null || head.next == null)
            return head;
        ListNode walker = head;
        ListNode runner = head;
        
        // break the whole list into 2 halves: head1 & head2
        while(runner.next != null && runner.next.next != null) {
            walker = walker.next;
            runner = runner.next.next;
        }
        ListNode head2 = walker.next;   // the right half: (right.length <= left.length)
        walker.next = null;             // disconnect the 2 halves !!!
        
        ListNode head1 = head;          // this is the first half
        head1 = mergeSort(head1);       
        head2 = mergeSort(head2);
        return merge(head1, head2);
    }
    
    // merge 2 lists (head1 & head2)
    // merge 2 sorted lists (the same )
    private ListNode merge(ListNode p1, ListNode p2)  {

        ListNode fakeHead = new ListNode(0);
        ListNode p = fakeHead;
        
        // remember this condition !!!
        while(p1 != null && p2 != null) {
            if(p1.val < p2.val) {
                p.next = p1;
                p1 = p1.next;
            } else {  // p2.val <= p1.val
                p.next = p2;
                p2 = p2.next;
            }
            p = p.next;
        }
        
        if(p1 == null)  {
            p.next = p2;
        } else {    // p1 != null
            p.next = p1;
        }
        
        return fakeHead.next;
    }

    public static void main(String[] args) {
		
	}
}
