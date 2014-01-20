import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;


public class cracking_11 {

	/**
	 * 11.1
	 */
	public static void sortAB(int[] aArr, int[] bArr){
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
//	public static String sortChars(String s){
//		char[] carr = s.toCharArray();
//		Arrays.sort(carr);
//		return new String(carr);
//	}
	public static String sortChars(String s)	{
		char[] cArr = s.toCharArray();
		Arrays.sort(cArr);
		return new String(cArr);
		
	}
//	
//	public static void groupAnagram(String[] sarr){
//		Map<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
//		for(String s : sarr){
//			String key = sortChars(s);
//			if(map.containsKey(key)){
//				List<String> list = map.get(key);
//				list.add(s);
//			}else{
//				ArrayList<String> list = new ArrayList<String>();
//				list.add(s);
//				map.put(key, list);
//			}
//		}
//		
//		int index = 0;
//		for(String key : map.keySet()){
//			for(String s : map.get(key)){
//				sarr[index++] = s;
//			}
//		}
//	} 
	
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
	}

	
	
}
