package leetcode;

public class CountAndSay {
	
    public String countAndSay(int n) {
        if (n == 1) 
        	return "1";
        String prevStr = countAndSay(n - 1);			// recursively
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < prevStr.length(); i++){
            int count = getCount(prevStr, i);
            sb.append(count);
            sb.append(prevStr.charAt(i));
            i += count - 1;		// skip to the rightmost one with the same number
        }
        return sb.toString();
    }
    // helper function
    public int getCount(String s, int i){
        char c = s.charAt(i);
        int count = 1;								// at least one!!!
        i++;
        while (i < s.length() && s.charAt(i) == c){	 	// until the first different char
            count++;
            i++;
        }
        return count;
    }

    public static void main(String[] args){
        System.out.println(new CountAndSay().countAndSay(5));
    }
}