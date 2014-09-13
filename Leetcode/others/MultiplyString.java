package others;

public class MultiplyString {
   
	// http://blog.csdn.net/fightforyourdream/article/details/17370495
    public static String multiply(String num1, String num2) {
        String n1 = new StringBuilder(num1).reverse().toString();
        String n2 = new StringBuilder(num2).reverse().toString();
          
        // d[] array is the array for   
        int[] d = new int[n1.length() + n2.length()];       
        for(int i = 0; i < n1.length(); i++) {  
            for(int j = 0; j < n2.length(); j++) {  
                d[i + j] += (n1.charAt(i) - '0') * (n2.charAt(j) - '0');
            }  
        }
        
        StringBuffer sb = new StringBuffer();
        
        int carry = 0;
        for(int i = 0; i < d.length; i++) {
            int digit = (d[i] + carry) % 10;
            carry = (d[i] + carry) / 10;
            sb.insert(0, digit);
        }

        // Don't forget !!!
        // remove 0's that are leading the string
        while(sb.charAt(0) == '0' && sb.length() >= 2) {    // if "0", then ok !!!
            sb.deleteCharAt(0);  
        }  
        
        return sb.toString();
    }
    
    public static void main(String[] args) {
    	System.out.println(multiply("12", "12"));
    }
}
