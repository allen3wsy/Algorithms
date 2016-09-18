package interviewFLGT;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.HashMap;

/**
 * Got asked by Google and EA All 4 methods are constant access
 * 
 * @author AllenNg
 */
public class MyRandomSet {

	private final ArrayList<String> list;
	private final HashMap<String, Integer> table;

	public MyRandomSet() {
		table = new HashMap<String, Integer>();
		list = new ArrayList<String>();
	}

	public void add(String s) {
		if(table.containsKey(s))
			return;
		list.add(s);
		table.put(s, list.size() - 1);
	}

	public void remove(String s) {
		if (!table.containsKey(s)) // if not in the set, do nothing
			return;

		String lastElement = list.get(list.size() - 1);
		int rmIndex = table.get(s);

		table.put(lastElement, rmIndex); // replace first
		table.remove(s); // then remove
		list.set(rmIndex, lastElement); // replace first
		list.remove(list.size() - 1); // then remove
	}

	public boolean contain(String s) {
		return table.containsKey(s);
	}

	public String getRandom() {

		if (table.size() == 0) // if null, we should throw exception
			throw new NoSuchElementException();

		Random rand = new Random(System.currentTimeMillis());
		int index = rand.nextInt(list.size());
		return list.get(index);
	}

	public static void main(String[] args) {
		MyRandomSet myRandomSet = new MyRandomSet();
		// System.out.println(myRandomSet.getRandom());

		myRandomSet.add("Apple");
		myRandomSet.add("Banana");
		myRandomSet.add("Cat");

		myRandomSet.remove("Cat");

		System.out.println(myRandomSet.table.size());
		System.out.println(myRandomSet.getRandom());
	}

}
