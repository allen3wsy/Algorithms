package iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RotationIterator<T> implements Iterator<T> {

	private List<Iterator<T>> lists;
	private int listIdx = 0;

	public RotationIterator(List<Iterator<T>> lists) {
		this.lists = lists;
	}

	@Override
	public boolean hasNext() {
		for (Iterator<T> iter : lists) {
			if (iter.hasNext()) {
				return true;
			}
		}
		return false;
	}

	@Override
	public T next() {
		if (hasNext()) { // which ensures there are elements to get
			while (true) {
				listIdx = listIdx % lists.size();
				Iterator<T> curIter = lists.get(listIdx);
				listIdx++;
				if (curIter.hasNext()) {
					return curIter.next();
				}
			}
		} else {
			return null;
		}
	}

	public static void main(String[] args) {

		ArrayList<Integer> a = new ArrayList<Integer>();
		ArrayList<Integer> b = new ArrayList<Integer>();
		ArrayList<Integer> c = new ArrayList<Integer>();

		a.add(1);
		a.add(2);
		a.add(3);
		b.add(4);
		b.add(5);
		b.add(6);
		c.add(7);
		c.add(8);

		ArrayList<Iterator<Integer>> list = new ArrayList<>();
		list.add(a.iterator());
		list.add(b.iterator());
		list.add(c.iterator());

		RotationIterator<Integer> rotationIterator = new RotationIterator<Integer>(
				list);
		while (rotationIterator.hasNext()) {
			System.out.println(rotationIterator.next());
		}
	}

}