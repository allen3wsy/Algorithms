package interviewFLGT;

public class removeString {

	// DONE:
	public static String removeString(String str, String remove)	{
		StringBuilder s = new StringBuilder();
		
		boolean[] flags = new boolean[128]; // should be 256 ?!
		
		for(int i = 0; i < remove.length(); i++)	{
			flags[remove.charAt(i)] = true;
		}
		
		for(int i = 0; i < str.length(); i++)	{
			if(!flags[str.charAt(i)])	{
				s.append(str.charAt(i));
			}
		}
		
		return s.toString();
	}
	
	public static void main(String[] args)	{
		String str = "ascdfcccg";
		String remove = "c";
		
		System.out.println(removeString(str, remove));
		
		int num = 3;
		System.out.println( (num >> 1) ^ num) ;
	}
}
