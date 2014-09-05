package others;

public class StringToInteger_atoi_ {

	public int atoi(String str) {
        if (str == null || str.length() < 1)
		    return 0;
 
    	// trim white spaces
    	str = str.trim();
     
    	char flag = '+';
     
    	// check negative or positive
    	int i = 0;
    	if (str.charAt(i) == '-') {
    		flag = '-';
    		i++;
    	} else if (str.charAt(i) == '+') {
    		i++;
    	}   // else: we think it is a positive number       
    	
        // use double to store result: Long is also ok (remember sqrt(x) ?)
    	long result = 0;        // DEFAULT RESULT SHOULD BE 0
        
    	// calculate value: if str.charAt(i) is 'a' '@' or other stuff..... Ignore them and stop
    	while (i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
    		result = result * 10 + (str.charAt(i) - '0');
    		i++;
    	}
     
    	if (flag == '-')
    		result = -result;
     
    	// handle max and min
    	if (result > Integer.MAX_VALUE)
    		return Integer.MAX_VALUE;
     
    	if (result < Integer.MIN_VALUE)
    		return Integer.MIN_VALUE;
     
    	return (int) result;            // Don't forget to cast back !!!
    }
}
