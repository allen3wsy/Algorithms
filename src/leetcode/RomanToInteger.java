package leetcode;
import java.util.HashMap;

// assume the input is valid
public class RomanToInteger {

    public static int romanToInt(String s) {
        
        HashMap<Character, Integer> m = new HashMap<Character, Integer>();
        m.put('M', 1000);
        m.put('D', 500);
        m.put('C', 100);
        m.put('L', 50);
        m.put('X', 10);
        m.put('V', 5);
        m.put('I', 1);
               
        char[] c = s.toCharArray();
        int res = m.get(c[s.length() - 1]);
        
        for(int i = 0; i< s.length() -1; i++)	{
        	int sign;
        	if(m.get(c[i]) < m.get(c[i+1]))	
        		sign = -1;
        	else
        		sign = 1;
        	res += m.get(c[i]) * sign;
        }
        return res;
   
    }
    
    public static void main(String [] args)	{
    	String s = "CCXIV";
    	System.out.println(romanToInt(s));
    	
    }
    
}