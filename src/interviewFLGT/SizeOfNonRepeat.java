package interviewFLGT;

import java.util.HashMap;


// time complexity is O(2N) every character is traversed less than 2 times
public class SizeOfNonRepeat {
	
	/*
	 * Given s string, Find max size of a sub-string,
	 *  in which no duplicate chars present.*/
	public static int maxSize(String str){
		int maxLen = 0;
		int len = str.length();
		int tempMax = 0;
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for(int i=0;i<len;i++){
			if(map.containsKey(str.charAt(i))){
				i = map.get(str.charAt(i));
				map.clear();
				tempMax = 0;
			}
			else{
				map.put(str.charAt(i), i);
				tempMax++;
				if (tempMax > maxLen)
					maxLen = tempMax;
			}
		}
		return maxLen;
	}

	
	public static void main(String[] args)	{
		System.out.println(maxSize("aaaaa"));
	}
}
