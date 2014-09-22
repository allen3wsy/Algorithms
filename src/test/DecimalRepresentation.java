package test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class DecimalRepresentation {

	// http://www.careercup.com/question?id=5764083194265600
	public static String decimalRepresentation(int denominator, int numerator) {

		StringBuilder sb = new StringBuilder();
		sb.append(denominator);
		sb.append(numerator);

		String result = sb.toString();
		return result;
	}

	public static void main(String[] args) {
		// System.out.println(decimalRepresentation(10, 3));

		LinkedHashMap<Integer, Integer> linkedHashMap = new LinkedHashMap<Integer, Integer>();
		linkedHashMap.put(100, 3);
		linkedHashMap.put(1000, 4);
		linkedHashMap.put(20, 1);

		boolean printFlag = false;

		for (Map.Entry<Integer, Integer> entry : linkedHashMap.entrySet()) {
			if (entry.getKey() == 1000)
				printFlag = true;
			if (printFlag)
				System.out.println(entry);
		}
		System.out.println(linkedHashMap);
	}
}
