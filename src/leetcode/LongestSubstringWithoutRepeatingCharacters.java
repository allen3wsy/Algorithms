package leetcode;

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters {

	// Analysis:  REMEMBER THE PICTURE !!!
    // http://blog.csdn.net/likecool21/article/details/10858799
    // http://www.programcreek.com/2013/02/leetcode-longest-substring-without-repeating-characters-java/
    // using HashMap
    public static int lengthOfLongestSubstring(String s) {
 
    	char[] array = s.toCharArray();
    	int preSize = 0;
     
    	HashMap<Character, Integer> map = new HashMap<Character, Integer>();
             
    	for (int i = 0; i < array.length; i++) {
    		if (!map.containsKey(array[i])) {
    			map.put(array[i], i);
    		} else {
    		    if(map.size() > preSize)
    		        preSize = map.size();
    			i = map.get(array[i]);
    			map.clear();            // Don't forget to clean it !!! and scan again from this position + 1
    		}
    	}
     
    	return Math.max(preSize, map.size());       // maybe we reach the end and still don't have 1 repeated
    }
    
    public static void main(String[] args) {
    	int len = lengthOfLongestSubstring("abcqwer");
    	int len2 = lengthOfLongestSubstring("abcc");
    	System.out.println(len);
    	System.out.println(len2);
    }
}
