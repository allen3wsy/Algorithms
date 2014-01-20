package Data_structure;

import java.util.Iterator;
import java.util.LinkedList;

// print the nthToLast
public class nthToLast {

	public int findNthToLast(LinkedList<Integer> list, int n)	{
		Iterator<Integer> it1 = list.iterator();
		Iterator<Integer> it2 = list.iterator();
		
		for(int i = 0; i < n; i++)	{
			it1.next();
		}
		
		while(it1.hasNext())	{
			it1.next();
			it2.next();			
		}	
		return it2.next();
	}
	
	public static void main(String[] args)	{
		LinkedList<Integer> list = new LinkedList<Integer>();
				
		nthToLast N = new nthToLast();
		list.add(new Integer(1));
		list.add(new Integer(2));
		list.add(new Integer(3));
		list.add(new Integer(4));
		list.add(new Integer(5));
		// print the 2th to last
		System.out.println(N.findNthToLast(list, 2));
		
	}
}
