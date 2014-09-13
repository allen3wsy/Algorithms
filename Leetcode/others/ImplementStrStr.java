package others;

public class ImplementStrStr {

	public String strStr(String haystack, String needle) {
		int needleLen = needle.length();
    	int haystackLen = haystack.length();
     
    	if (needleLen == haystackLen && needleLen == 0)     // if both lengths are 0.
    		return "";
     
    	if (needleLen == 0)
    		return haystack;  // the whole haystack string (because every string has "" in it)
    	
    	// if haystackLen == 0, the for loop will exit immediately !!!
    	for(int i = 0; i < haystackLen; i++) {
    	    if(haystackLen - i < needleLen)         // don't do unnecessary operations
    	        return null;
    	        
    	    int h = i;      // h is for: haystack
    	    int n = 0;      // n is for: needle
    	    
    	    while(n < needleLen && h < haystackLen && needle.charAt(n) == haystack.charAt(h)) {
    	        n++;
    	        h++;
    	        if(n == needleLen) {
    	            return haystack.substring(i);
    	        }
    	    }
    	}
    	
    	return null;
    }
}
