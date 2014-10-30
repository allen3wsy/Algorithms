package iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

public class DeepIterator implements Iterator {
	private Stack<Iterator> stack;

	public DeepIterator(ArrayList finalLists) {
		stack = new Stack<Iterator>();
		stack.push(finalLists.iterator());
	}

	public boolean hasNext() {
		if (stack.isEmpty()) {
			return false;
		} else {
			Iterator iterator = stack.peek();
			if (!iterator.hasNext()) {
				stack.pop();
				return hasNext(); // recursion
			} else {
				return true;
			}
		}
	}

	/**
	 * this is right !
	 */
	public Object next() {
		if (hasNext()) {
			Iterator iterator = stack.peek();
			Object object = iterator.next(); // because hasNext() is true

			if (object instanceof ArrayList) {
				stack.push(((ArrayList) object).iterator());
				return next(); // recursion
			} else { // if it is an integer
				return object;
			}
		}
		return null; // if it doesn't have next ?
	}

	public void remove() {
	}
}

// 下面是输出的例子
class Question {
	public Iterator getIterator(ArrayList lists) {
		return new DeepIterator(lists);
	}

	public static void main(String[] args) {
		ArrayList finalLists = new ArrayList();

		finalLists.add(0);

		ArrayList firstLevelList = new ArrayList();
		firstLevelList.add(1);
		firstLevelList.add(2);
		finalLists.add(firstLevelList);

		finalLists.add(3);

		firstLevelList = new ArrayList();
		firstLevelList.add(4);
		ArrayList secondLevelList = new ArrayList();
		secondLevelList.add(5);
		secondLevelList.add(6);
		firstLevelList.add(secondLevelList);
		finalLists.add(firstLevelList);

		System.out.print("The original Lists is --- > " + finalLists);
		Question sol = new Question();
		Iterator iterator = sol.getIterator(finalLists);
		System.out.println();
		System.out.print("The flatten Lists is --- > ");
		while (iterator.hasNext()) {
			System.out.print(iterator.next() + " --> ");
		}
	}
}
