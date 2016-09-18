package iterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenIterator implements Iterator<Integer> {
	private Iterator<Integer> iter;
	private Integer nextEven = null;
	
	public EvenIterator(Iterator<Integer> iter) {
		this.iter = iter;
		advance();
	}

	@Override
	public boolean hasNext() {
		return nextEven != null;
	}

	@Override
	public Integer next() {
		if (nextEven != null) {
			Integer res = nextEven;
			advance();
			return res;
		} else { // if curElement == null
			throw new NoSuchElementException();
		}
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException();
	}

	private void advance() {

		while (iter.hasNext()) {
			Integer cur = iter.next();
			if (cur % 2 == 0) {
				nextEven = cur;
				return; // found even number
			}
		}
		nextEven = null; // if no further even number
	}

	public static void main(String[] args) {
		// even number: 2 6
		ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 5, 6));
		EvenIterator evenIterator = new EvenIterator(list.iterator());

		if (evenIterator.hasNext()) {
			System.out.println(evenIterator.next());
		}
		if (evenIterator.hasNext()) {
			System.out.println(evenIterator.next());
		}
		if (evenIterator.hasNext()) {
			System.out.println(evenIterator.next());
		}

	}
}
