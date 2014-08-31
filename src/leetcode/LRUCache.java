package leetcode;

import java.util.HashMap;

public class LRUCache {
	private int capacity;
	private HashMap<Integer, DoubleLinkedListNode> map = new HashMap<Integer, DoubleLinkedListNode>();

	private DoubleLinkedListNode head;
	private DoubleLinkedListNode end;

	private int len;

	public LRUCache(int capacity) {
		this.capacity = capacity;
		len = 0;
	}

	public int get(int key) {
		if (map.containsKey(key)) {
			DoubleLinkedListNode node = map.get(key);
			removeNode(node); // don't forget (diff from normal hashmap)
			setHead(node); // don't forget (diff from normal hashmap)
			return node.val;
		} else {
			return -1;
		}
	}

	public void set(int key, int value) {

		if (map.containsKey(key)) {
			DoubleLinkedListNode oldNode = map.get(key);
			oldNode.val = value;
			removeNode(oldNode);
			setHead(oldNode);
		} else {
			DoubleLinkedListNode newNode = new DoubleLinkedListNode(key, value);
			if (len < capacity) {
				setHead(newNode);
				map.put(key, newNode);
				len++;
			} else {
				map.remove(end.key);
				DoubleLinkedListNode toDelete = end; // Allen's
				end = end.pre;
				removeNode(toDelete); // Allen's

				// if(end != null) {
				// end.next = null; // Can I remove end ??? You can't removeNode
				// the last Node because you cannot locate it in O(1)
				// }

				setHead(newNode);
				map.put(key, newNode);
			}
		}
	}

	// helper
	public void removeNode(DoubleLinkedListNode node) {
		DoubleLinkedListNode cur = node;
		DoubleLinkedListNode pre = cur.pre;
		DoubleLinkedListNode next = cur.next;

		if (pre != null) {
			pre.next = next;
		} else { // pre == null, which means cur is now the head
			head = next;
		}

		if (next != null) {
			next.pre = pre;
		} else { // next == null, which means cur is now the end
			end = pre;
		}
	}

	// helper
	public void setHead(DoubleLinkedListNode node) {
		node.next = head; // even if head may be null
		node.pre = null;

		if (head != null) {
			head.pre = node;
		}
		head = node;

		if (end == null) { // this is for the first node inserted (ONLY the
							// first time !!!)
			end = node;
		}
	}

	// helper class
	public class DoubleLinkedListNode {
		public int val;
		public int key;
		public DoubleLinkedListNode pre;
		public DoubleLinkedListNode next;

		DoubleLinkedListNode(int key, int value) {
			val = value;
			this.key = key;
		}

	}
}