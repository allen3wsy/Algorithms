package test;

class ListNode<T> {
	ListNode<T> next;
	T val;

	public ListNode(T val) {
		this.val = val;
	}
}

public class SequenceList<T> implements Sequence<T> {

	// basically it's a queue
	private ListNode<T> head;
	private ListNode<T> tail;
	private int size;

	// O(1)
	public void add(T o) {
		if (head == null) {
			head = new ListNode<T>(o);
			tail = head;
			size++;
			return;
		}
		tail.next = new ListNode<T>(o);
		tail = tail.next;
		size++;
	}

	public int size() {
		return size;
	}

	// O(n)
	public T get(int index) {
		if (index > size || index < 0) // check for index out of bound
			return null;
		ListNode<T> current = head;
		for (int i = 0; i < index; i++) {
			current = current.next;
		}
		return current.val;
	}

	// O(n)
	public boolean remove(T o) {
		// special case : remove head
		if (head.val == o) {
			head = head.next;
			return true;
		}

		// normal case:
		ListNode<T> current = head.next;
		ListNode<T> prev = head;
		for (int i = 1; i < size; i++) {
			if (current.val == o) {
				// remove the node
				prev.next = current.next;
				size--;
				return true;
			}
			// 下一輪的東西
			prev = current;
			current = current.next;
		}
		return false;
	}
}
