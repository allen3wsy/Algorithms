
public class cracking_7 {

	public static void main(String[] args)	{
		System.out.println(checkPrime(89));
		sieve(100000);
		
	}
	
	// 2 is the smallest prime (excluding 0 & 1)
	public static boolean checkPrime(int n)	{
		if(n < 2)
			return false;
		for(int i = 2; i <= (int) Math.sqrt(n); i++)	{
			if(n % i == 0)	
				return false;
		}
		return true;
	}
	
	// find a list of prime numbers smaller than n
	// INTRODUCE: ARRAY a[i]. if i is a prime then 
	// a[i] = true, otherwise a[i] = false
	public static void sieve(int n)	{
        boolean[] a = new boolean[n + 1];
        
        for (int i = 2; i <= n; i++)  
        	a[i] = true; 
        
        // important !!!
        for (int i = 2; i <= Math.sqrt(n); i++)	{
            if (a[i])	{
            	// EX: j = 2 * i
                for (int j = 2 * i; j <= n; j += i) 
                	a[j] = false;
            }
        }
        for (int i = 0; i <= n; i++)	{
            if (a[i])
                System.out.print(i + " ");
        }
    } 
}
