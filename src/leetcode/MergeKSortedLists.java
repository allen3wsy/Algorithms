package leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MergeKSortedLists {

	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	// http://www.programcreek.com/2013/02/leetcode-merge-k-sorted-lists-java/
	public static ListNode mergeKLists(ArrayList<ListNode> lists) {
		if (lists.size() == 0)
			return null;

		Comparator<ListNode> comparator = new Comparator<ListNode>() {
			public int compare(ListNode a, ListNode b) {
				return a.val - b.val;
			}
		};
		
		// PriorityQueue is a sorted queue
		PriorityQueue<ListNode> q = new PriorityQueue<ListNode>(lists.size(), comparator);

		// add first node of each list to the queue
		for (ListNode list : lists) {
			if (list != null)
				q.add(list);
		}

		ListNode head = new ListNode(0);
		ListNode prev = head;

		// when the PriorityQueue has some nodes in it....
		while (q.size() > 0) {
			ListNode temp = q.poll();
			prev.next = temp;

			// keep adding next element of each list
			if (temp.next != null)
				q.add(temp.next);
			prev = prev.next;
		}

		return head.next;
	}
	
	public static void main(String[] args) {
		
	}
	
}
