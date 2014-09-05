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
    	        
    	    int k = i;      // k is for: haystack
    	    int j = 0;      // j is for: needle
    	    
    	    while(j < needleLen && k < haystackLen && needle.charAt(j) == haystack.charAt(k)) {
    	        j++;
    	        k++;
    	        if(j == needleLen) {
    	            return haystack.substring(i);
    	        }
    	    }
    	}
    	
    	return null;
    }
}
