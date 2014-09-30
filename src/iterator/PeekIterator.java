package iterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

// peek() and next() is very alike
/**
 * @author AllenNg
 *
 */
public class PeekIterator<E> implements Iterator<E> {
	private Iterator<E> iter;
	private E nextElement = null; // init: null

	public PeekIterator(Iterator<E> iter) {
		this.iter = iter;
		advance();
	}

	@Override
	public boolean hasNext() {
		return nextElement != null;
	}

	@Override
	public E next() {
		if (nextElement != null) {
			E result = nextElement;
			advance();
			return result;
		} else { // if curElement == null
			throw new NoSuchElementException();
		}
	}

	// peek() and next() is very alike
	public E peek() {
		if (nextElement != null)
			return nextElement;
		else { // if curElement == null
			throw new NoSuchElementException();
		}
	}

	// @Override
	// public void remove() {
	// throw new UnsupportedOperationException();
	// }

	private void advance() {
		if (iter.hasNext()) {
			nextElement = iter.next();
		} else {
			nextElement = null;
		}
	}

	public static void main(String[] args) {
		ArrayList<Integer> arrayList = new ArrayList<>(
				Arrays.asList(1, 2, 3, 4));
		PeekIterator<Integer> peekIterator = new PeekIterator<>(
				arrayList.iterator());

		System.out.println(peekIterator.peek());
		System.out.println(peekIterator.next());// 1

		System.out.println(peekIterator.next());// 2
		System.out.println(peekIterator.next());// 3
		System.out.println(peekIterator.peek());// 4

		// System.out.println(peekIterator.next());
		// System.out.println(peekIterator.peek());
	}
}
