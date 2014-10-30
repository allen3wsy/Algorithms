package iterator;

import java.util.ArrayList;
import java.util.Iterator;

//下面是输出的例子
public class DeepIteratorImp {
	public static Iterator getIterator(ArrayList lists) {
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
		
		Iterator iterator = getIterator(finalLists);
		System.out.println();
		System.out.print("The flatten Lists is --- > ");
		while (iterator.hasNext()) {
			System.out.print(iterator.next() + " --> ");
		}
	}
}