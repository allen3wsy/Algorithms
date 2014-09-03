package leetcode;

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
		if (head == null) {
			return head;
		}
		return copy(head);
	}

	// Important !!! Using HashMap: should compare CloneGraph !!! Pretty similar
	// Using HashMap: O(N) space & O(N) time: 2 while loop
	public RandomListNode copy(RandomListNode node) {

		HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
		RandomListNode p = node; // the original head

		// copy every node of give list and store it in hashmap
		while (p != null) {
			map.put(p, new RandomListNode(p.label));
			p = p.next;
		}

		p = node; // back to the the original head AGAIN !!! (start another
					// loop)
		RandomListNode head = null; // head pointer for the new list
		RandomListNode current = null; // current pointer for the new list

		// connect every node with next and random references
		while (p != null) {
			if (head == null) { // only for the first time!
				head = map.get(p);
			}
			current = map.get(p);

			// FOR THE following sentences: BETTER to be surrounded with
			// if(p.next != null) { current.next = map.get(p.next); }
			// if(p.randome != null) { current.random = map.get(p.random) }
			current.next = map.get(p.next); // for the last one: p.next may be
											// null, BUT STILL OK !
			current.random = map.get(p.random); // assign random reference

			p = p.next;
		}

		return head;
	}
}
