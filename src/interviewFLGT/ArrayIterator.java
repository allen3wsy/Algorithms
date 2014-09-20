package interviewFLGT;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayIterator<T> implements Iterator<T> {
	T[] array;
	int cursor = 0;

	public ArrayIterator(T[] a) {
		this.array = a;
	}

	@Override
	public boolean hasNext() {
		return cursor < array.length;
	}

	@Override
	public T next() {
		if (!hasNext()) {
			throw new NoSuchElementException();
		}
		T t = array[cursor];
		cursor++;
		return t;
	}

	public static void main(String[] a) {
	}
}
