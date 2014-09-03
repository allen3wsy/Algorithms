package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class WordBreak {

    // leetCode: Word Break I & Word Break II
    // http://blog.csdn.net/ljphhj/article/details/21643391
    // based on problem 1: easy to understand
    
    // result here is a shared member variable
    // private static ArrayList<String> result = new ArrayList<String>();  
    
    /**
     * Word Break II !!!
     * 
     * @param s
     * @param dict
     * @return
     */
    public static ArrayList<String> wordBreak2(String s, Set<String> dict) {  
    	
    	ArrayList<String> result = new ArrayList<String>();
        // check whether it has result, if no: then don't waste time
        if (hasResult(s, dict))  {  
            dfs(s, dict, "", result);  
        }  
        return result;  
    }  
	
	/**
	 * Word Break I!!!! check whether it is separable first..... 
	 * 
	 * @param s
	 * @param dict
	 * @return
	 */
	public static boolean hasResult(String s, Set<String> dict) {
		int len = s.length();
		boolean[] arrays = new boolean[len + 1];
		arrays[0] = true;
		for (int i = 1; i <= len; i++)	{
			for (int j = 0; j < i; j++)	{
				if (arrays[j] && dict.contains(s.substring(j, i))){			// consider:  s = "leetcode" & dict = {"leetcode"}
					// f(n) = f(0,i) + f(i,j) + f(j,n)
					arrays[i] = true;
					break;
				}
			}
		}
		return arrays[len];
	}

	/**
	 * Used Recursion to find the result
	 * 
	 * @param subStr
	 * @param dict
	 * @param currentStr
	 * @param result
	 */
    public static void dfs(String subStr, Set<String> dict, String currentStr, ArrayList<String> result) {  
        /* the condition for the recursion to end */  
        if (subStr.length() == 0)   {  
            result.add(currentStr);  
        }  
          
        for (int i = 0; i <= subStr.length(); ++i)  {  
            String sub = subStr.substring(0,i);  
            
            // if the dict has this substring 
            if (dict.contains(sub)){  
                  
                // this value is used for restore currentStr after recursion  
                int subLen = currentStr.length();  
                  
                // if it is not the first word in the solution, then add a " " after that...
                if (!currentStr.equals("")) {  
                    currentStr += " ";  
                }  
                 
                currentStr += sub;  
                // Recursion 
                dfs(subStr.substring(i), dict, currentStr, result);  
                
                // restore currentStr, go on to the next solution  
                currentStr = currentStr.substring(0, subLen);  
            }  
        }  
    }  
	
	public static void main(String[] args) {
		
		String s = "leetcode";
		Set<String> dict = new HashSet<String>();
//		HashSet<String> dict = new HashSet<String>();
		dict.add("leet");
		dict.add("code");
		
		dict.add("lee");
		dict.add("tcode");
	
		// Word Break: I
		System.out.println(hasResult(s, dict));

		// Word Break: II
		ArrayList<String> result = wordBreak2(s, dict);
		for(String str : result)	{
			System.out.println(str);
		}
		
	}
}