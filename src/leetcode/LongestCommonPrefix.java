package leetcode;

public class LongestCommonPrefix {
	// http://gongxuns.blogspot.com/2012/12/leetcodelongest-common-prefix.html
    public static String longestCommonPrefix(String[] strs) {

        int n = strs.length;
        if(n == 0) 
            return "";
        
        for(int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            
            for(int j = 1; j < strs.length; j++) {
                if(i >= strs[j].length() || strs[j].charAt(i) != c) 
                    return strs[0].substring(0, i);
            }
        }
        
        return strs[0];
    }
    
    public static void main(String[] args) {
    	String[] strs = {"abccc", "abk", "abc", "ab"};
    	System.out.println(longestCommonPrefix(strs));
    }
}
