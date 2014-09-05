package others;

public class ZigZagConversion {

	// pretty easy: just pattern matching!
    // FOR REFERENCE: 
    // http://tech-wonderland.net/blog/leetcode-zigzag-conversion.html
    public String convert(String s, int nRows) {  
        if(s == null || s.length() == 0 || nRows <= 0)  
            return ""; 
        if(nRows == 1)  
            return s;  
        StringBuilder result = new StringBuilder();  
        
        int diff = 2 * nRows - 2;                           // the diff for the first and the last row !!!
        for(int i = 0; i < nRows; i++)    {                 // for every line
            for(int j = i; j < s.length(); j += diff)   {   
                result.append(s.charAt(j));  
                if(i != 0 && i != nRows - 1 && j + diff - 2 * i < s.length())   // if it is not the last line or the first line :)
                    result.append(s.charAt(j + diff - 2 * i));  
            }                  
        }
        
        return result.toString();  
    }
}
