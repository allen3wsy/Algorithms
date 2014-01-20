package Amazon;

import java.util.HashSet;
import java.util.Set;

public class Factorial {

	public static Set<Integer> findAllFactorial(int num)	{
		Set<Integer> s = new HashSet<Integer>();
		//error check
		if(num <= 0)
			return s;

		for(int i = 1; i <= num; i++)	{
			
			/* num is dividable by i*/
			if(num % i == 0)	{
			
				if(s.contains(i))	{
					return s;
				} else	{
					s.add(i);
					s.add(num / i);
				}
			}		
		}
		return s;
		
	}
	
	public static void main(String[] args)	{
		int num = 48;
		System.out.println(findAllFactorial(48));
	}
}
