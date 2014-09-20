package iterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

class JumpIterator<T> implements Iterator<T> {

	private Iterator<T> iter;

	JumpIterator(Iterator<T> iter) {
		this.iter = iter;
	}

	@Override
	public boolean hasNext() {
		return iter.hasNext();
	}

	@Override
	public T next() {
		T curElem = iter.next();
		if (hasNext())
			iter.next();
		return curElem;
	}

	public static void main(String[] args) {
		JumpIterator<Integer> jumpIterator = new JumpIterator<Integer>(
				new ArrayList<Integer>(Arrays.asList(1,2))
						.iterator());

		while (jumpIterator.hasNext()) {
			System.out.println(jumpIterator.next());
		}
	}
}