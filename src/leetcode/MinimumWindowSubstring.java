package leetcode;
import java.util.HashMap;

public class MinimumWindowSubstring {
	// http://rleetcode.blogspot.com/2014/01/minimum-window-substring-java.html
	// http://huntfor.iteye.com/blog/2083485
	// S is the string that contains T !!!
	// S = "e b a d b a c c b", T = "abc" for example !!!
	// S = "cakbkkkkabc", T = "abc" for example !!!

    public static String minWindow(String S, String T) {
         if (S == null || T == null)
             return null;
         if (S.length() < T.length() || S.length() == 0)
             return "";
         
         HashMap<Character, Integer> needFind = new HashMap<Character, Integer>();
         HashMap<Character, Integer> alreadyFind = new HashMap<Character, Integer>();
         
         // initializing 2 hashMaps !!!
         for(int i = 0; i < T.length(); i++) {
             alreadyFind.put(T.charAt(i), 0);
             
             // needFind hashMap will never change once initialized !!!
             if (needFind.containsKey(T.charAt(i)))
                 needFind.put(T.charAt(i), needFind.get(T.charAt(i)) + 1);
             else
                 needFind.put(T.charAt(i), 1);
         }
         
         int minStart = -1;
         int minEnd = S.length();
         
         int start = 0;
         int len = 0;
         for (int i = 0; i < S.length(); i++) {
             if (alreadyFind.containsKey(S.charAt(i))) {
                 alreadyFind.put(S.charAt(i), alreadyFind.get(S.charAt(i)) + 1);
                 
                 if (alreadyFind.get(S.charAt(i)) <= needFind.get(S.charAt(i)))
                     len++;
                 
                 // when it reaches "c", then (len == 3), then SQUEEZE THE WINDOW from left hand side, but len never goes less anymore
                 if (len == T.length())   {
                     
                     // this WHILE CONDITION MUST BE REMEMBERED !!!  (S.charAt(start) !!!)
                     while (!needFind.containsKey(S.charAt(start)) || alreadyFind.get(S.charAt(start)) > needFind.get(S.charAt(start)))   {
                         
                         if (needFind.containsKey(S.charAt(start)))  // the latter condition meets !!!
                             alreadyFind.put(S.charAt(start), alreadyFind.get(S.charAt(start)) - 1);
                         start++;
                     }
                     // if the new window size is smalle than the older one, then update it
                     if (i - start < minEnd - minStart) {
                         minStart = start;
                         minEnd = i;
                     }
                 }
             }
             
         }
                     
         if (minStart == -1)   // which means "len never reaches T.length" (not found) !!!
             return "";
         return S.substring(minStart, minEnd + 1);  // [minStart, minEnd + 1)
            
    }
    
	public static void main(String[] args) {

		String S1 = "ebadbaccb";
		String T1 = "abc";

		System.out.println(minWindow(S1, T1));

		String S2 = "cakbkkkkabc";
		String T2 = "cba";
		System.out.println(minWindow(S2, T2));

	}
}
