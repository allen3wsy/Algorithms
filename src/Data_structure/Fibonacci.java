package Data_structure;
import java.util.Scanner;


// given a number, find the nearest fibonacci num ???
public class Fibonacci {
	public static int fib_dp(int  n)	{
	
		int[] fib = new int[10000];  
		int i;
	  
		fib[0] = 0;
		fib[1] = 1;
	  
		for (i = 2;i <= n; i++)
			fib[i] = fib[i-1] + fib[i-2];

		return fib[n];
	}

	// find the nearest Fibonacci number
	public static int findNearFib(int n)	{
		if(n <= 0)
			return 0;
		
		int[] fib = new int[1000];
		fib[0] = 0;
		fib[1] = 1;
		for(int i = 2; i < 1000; i++)	{
			fib[i] = fib[i - 1] + fib[i - 2]
;		}
		
		// difference array
		int[] dif = new int[1000];
		
		dif[0] = n - fib[0];
		for(int i = 1; i < 1000; i++)	{
			dif[i] = n - fib[i];
			if(dif[i] * dif[i - 1] <= 0)	{
				if(Math.abs(dif[i]) < Math.abs(dif[i - 1]))	
					return fib[i];
				else
					return fib[i - 1];
			}		
		}
		return fib[999];
		
	}
	
	public static void main(String args[])	{	  
		System.out.println(fib_dp(3));	
		System.out.println(findNearFib(1));
	}
	
	
}
