package test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
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
//		System.out.println(decimalRepresentation(10, 3));
		
        LinkedHashSet<String> hs = new LinkedHashSet();
        hs.add("A");
        hs.add("D");
        hs.add("F");
        
        boolean printFlag = false;
        for (String str : hs) {
        	if(str.equals("D"))
        		printFlag = true;
        	if(printFlag) 
        		System.out.println(str);
		}
		System.out.println(hs);
	}
}
