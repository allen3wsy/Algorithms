package test;

import java.util.HashMap;

// http://www.programcreek.com/2013/09/java-hashcode-equals-contract-set-contains/
// there is a contract between equals() and hashCode()
// if we a self-defined class like Apple is Newed, then both methods should be overridden
public class Apple {
	private String color;

	public Apple(String color) {
		this.color = color;
	}

	public boolean equals(Object obj) {
		if (!(obj instanceof Apple))
			return false;
		if (obj == this)
			return true;
		return this.color.equals(((Apple) obj).color);
	}

	// public int hashCode() {
	// return this.color.length();
	// }

	public static void main(String[] args) {
		Apple a1 = new Apple("green");
		Apple a2 = new Apple("green");

		// hashMap stores apple type and its quantity
		HashMap<Apple, Integer> m = new HashMap<Apple, Integer>();
		m.put(a1, 10);
		m.put(a2, 20);

		// true
		System.out.println("a1 and a2 are equal?: " + a1.equals(a2));
		// this will still be false because we didn't override hashCode() method
		System.out.println(m.get(new Apple("green")));
		
	}
}