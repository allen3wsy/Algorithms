import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;


public class cracking_11 implements Comparator<String> {


	public static void main(String[] args)	{
		String[] array = {"zdb", "agb", "fca"};
		String s = "dd";
		String l = "mm";
		
		// String s has the compareTo function already !!!!
		if(s.compareTo(l) > 0)	{
			System.out.println("Awesome");
		}
		Arrays.sort(array, new cracking_11());
		for(String str : array)	
		System.out.print(str + ", ");
		
	}
	
	

	/**
	 * 11.1
	 */
	public static void sortAB(int[] aArr, int[] bArr)	{
		int a = aArr.length - 1;	// 0,1,2	2
		int b = bArr.length - 1;	//0,1,2,3	3
		int merge = a + b + 1;		//			6
		
		while(b >= 0){
			if(a>=0 && aArr[a] > bArr[b]){
				aArr[merge] = aArr[a];
				a--;
				merge--;
			}else{
				aArr[merge] = bArr[b];
				b--;
				merge--;
			}
		}
	}
	
	
	/**
	 * 11.2
	 */
	
	/*
	 * solution 1: create a new class using comparator
	 */
	/*
	 * ALREADY defined !!
	 */
	
//	public String sortChars(String s) {
//		char[] content = s.toCharArray();
//		Arrays.sort(content);
//		return new String(content);
//	}

	@Override
	public int compare(String s1, String s2) {
		// TODO Auto-generated method stub
		return sortChars(s1).compareTo(sortChars(s2));
	}

	
	/*
	 * solution 2*/
	public static String sortChars(String s)	{
		char[] cArr = s.toCharArray();
		Arrays.sort(cArr);
		return new String(cArr);
		
	}
		
	public static void groupAnagram(String[] sArr)	{
		Map<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
		for(String s : sArr)	{
			String key = sortChars(s);
			if(!map.containsKey(key))	{
				ArrayList<String> list = new ArrayList<String>();
				list.add(s);
				map.put(key, list);			
			}	else	{
				ArrayList<String> list = map.get(key);
				list.add(s);
			}
		}
		
		int index = 0;
		for(Entry<String, ArrayList<String>> entry : map.entrySet())	{
			ArrayList<String> a = entry.getValue();
			for(String s : a)	{
				sArr[index] = s;
				index++;
			}	
		}	
//		int index = 0;
//		for(String key : map.keySet()){
//			for(String s : map.get(key)){
//				sarr[index++] = s;
//			}
//		}
		
	}
	
	/**
	 * 11.5
	 * @return 
	 * @return
	 */

	/*
	 * Interative version 
	 * */
	public int searchI(String[] strings, String str)	{
		int left = 0;
		int right = strings.length - 1;
		int mid;
		
		while(left <= right)	{
			mid = (left + right) / 2;
			
			/* If mid is empty, find closest non-empty string */
			if (strings[mid].isEmpty()) { 
				int l = mid - 1;
				int r = mid + 1;
				
				/* Or I can use WHILE TRUE */
				while(left <= l || r <= right)	{
					if(left <= l && !strings[l].isEmpty())	{
						mid = l;
						break;
					}
					else if(r <= right && !strings[r].isEmpty())	{
						mid = r;
						break;
					} else {
						l--;
						r++;
					}
					
				}
				// one side out-of-bound is OK
				if(left > l && r > right)	
					return -1;
			}
			// perform the Binary Search			
			if(strings[mid].equals(str))	{
				return mid;			// found it!!!
			} else if(strings[mid].compareTo(str) < 0){
				left = mid + 1;		 // search right		
			} else {
				right = mid - 1;
			}
	
		}
		
		return -1;
	}
	
	/*
	 * recursive version
	 * */
	public int searchR(String[] strings, String str, int left, int right)	{
		if(left > right)
			return -1;
		int mid = (left + right) / 2;
		
		
		/* If mid is empty, find closest non-empty string. */
		if (strings[mid].isEmpty()) { 
			int l = mid - 1;
			int r = mid + 1;
			
			while(true)	{
				if(l < left && r > right)	
					return -1;
				else	{
					if(!strings[l].isEmpty() && left <= l)	{
						mid = l;
						break; // dont' forget this
					}	else if(!strings[r].isEmpty() && r <= right) {
						mid = r;
						break; // dont' forget this
					} else	{
						l--;
						r++;
					}
					
				}			
			}
		}
		if(strings[mid].compareTo(str) < 0)	{
			return searchR(strings, str, mid + 1, right); // search right
		} else if(strings[mid].compareTo(str) > 0)	{
			return searchR(strings, str, left, mid - 1);
		} else {		// FOUND !!!
			return mid;
		}		
	}
	
	public int search(String[] strings, String str)	{
		if(str == null || strings == null || str == "")
			return -1;
		else
			return searchR(strings, str, 0, strings.length - 1);
	}

}
