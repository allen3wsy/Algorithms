package bstGraph;

import java.util.HashMap;

public class CopyListWithRandomPointer {

	public class RandomListNode {
		int label;
		RandomListNode next, random;

		RandomListNode(int x) {
			this.label = x;
		}
	};

	// http://blog.csdn.net/fightforyourdream/article/details/16879561
	public RandomListNode copyRandomList(RandomListNode head) {
		if (head == null)
			return head;
		return copy(head);
	}

	// Important !!! Using HashMap: should compare CloneGraph !!! Pretty similar
    // Using HashMap: O(N) space & O(N) time: 2 while loop
    public RandomListNode copy(RandomListNode head) {
       
        HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
        RandomListNode p = head;     // the original head
       
        // copy every node of given list and store it in hashmap
        while(p != null) {
            map.put(p, new RandomListNode(p.label));
            p = p.next;
        }
       
        p = head;                    // back to the the original head AGAIN !!! (start another loop)
        RandomListNode newHead = map.get(p);   // head pointer for the new list
        RandomListNode newP = newHead;      // current pointer for the new list
       
        // connect every node with next and random references
        while (p != null) {
            newP = map.get(p);
            // we don't have to check (newP.next == null) || (newp.random == null)
            // because map.get(null) will return null, it still works !!!
            newP.next = map.get(p.next); // for the last one: p.next may be null, BUT STILL OK !
            newP.random = map.get(p.random); // assign random reference
            p = p.next;
        }
        return newHead;
    }
    
    public static void main(String[] args) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		System.out.println(map.get(null));
	}
}
