package leetcode;

public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        
        ListNode helper = new ListNode(head.val);  
        ListNode pre = helper;  
        ListNode cur = head;
        
        // loop through each element in the list
        while(cur != null)  {
            ListNode next = cur.next;
            pre = helper;
            
            while(pre.next != null && pre.next.val < cur.val)   {
                pre = pre.next;
            }
            
            cur.next = pre.next;
            pre.next = cur;
            cur = next;
            
        }
        return helper.next;
    }
}
