import java.util.ArrayList;

import java.util.List;
import Algo_Midlevel.Permutation;

import com.sun.org.apache.xalan.internal.xsltc.util.IntegerArray;

public class cracking_9 {

	/**
	 * 9.1
	 * 
	 */

	// every time 1.....m steps
	// n is the highest
	public static int numOfStepDP(int n, int m) {
		
		int[] arr = new int[n + 1];			// EX: the array should be of length (n + 1)		
		return numOfStepDP(n, m, arr);
	}

	public static int numOfStepDP(int n, int m, int[] arr) {
		if (n < 0)
			return 0;
		if (n == 0)
			return 1;

		if (arr[n] != 0)		// DP here
			return arr[n];

		for (int i = 1; i <= m; i++) {
			arr[n] += numOfStepDP(n - i, m, arr);
		}
		return arr[n];
	}
	
	/**
	 * 9.4
	 */
	// another solution (better): using bit Manipulation
    public static ArrayList<ArrayList<Integer>> getSubSet(ArrayList<Integer> set)    {
        
        ArrayList<ArrayList<Integer>> allsubsets = new ArrayList<ArrayList<Integer>>();
        int max = 1 << set.size();     /* Compute 2 ^ n */
        for(int k = 0; k < max; k++) {
            ArrayList<Integer> subset = convertIntToSet(k, set);
            allsubsets.add(subset);
        }
        return allsubsets;
    }
    
    public static ArrayList<Integer> convertIntToSet(int x, ArrayList<Integer> set)   {
        ArrayList<Integer> subset = new ArrayList<Integer>();
        int index = 0;
        for(int k = x; k > 0; k >>= 1)   {
            if( (k & 1) == 1)  {
                subset.add(set.get(index));
            }
            index++;
        }
        return subset;
    }
    
    /**
     * 9.5
     * getPermutation
     */
    // DFS algo
    public static ArrayList<ArrayList<Integer>> permute(int[] num) {  
        
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();  
        ArrayList<Integer> tmp = new ArrayList<Integer>();      // temp is a null arrayList
        int n = num.length;  
        boolean[] visited = new boolean[n];  
          
        permuteImp(result, tmp, num, visited);  
        return result;  
    } 
    
    private static void permuteImp(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> tmp, int[] num, boolean[] visited) {  
        if(tmp.size() == num.length)    {               // otherwise the length is incorrect
            result.add(new ArrayList<Integer>(tmp));    // copy a new one and add it into the result set
            return;  
        }  
        
        // every time we recurse, we have to go through the loop,
        // For example: [1, 2, 3]:  look at the notes for the recursion tree and the for loop graph
        for(int i = 0; i < num.length; i++) {  
            if(!visited[i]) {                               // if num[i] has not been visited !
                tmp.add(num[i]);  
                visited[i] = true;  
                
                permuteImp(result, tmp, num, visited);      // recursive solve: DFS
                
                visited[i] = false;  
                tmp.remove(tmp.size() - 1);                 // remove the last one in the temp arrayList
            }  
        }  
    }
    

	/**
	 * 9.6
	 * 
	 * Recursion DP: generate Parenthesis
	 * @param args
	 */
    public static ArrayList<String> generateParenthesis(int n) {
        ArrayList<String> result = new ArrayList<String>();
        if(n > 0)   {
            generate(n, "", 0, 0, result);
        }
        return result;
    }
    
    public static void generate(int n, String s, int l, int r, ArrayList<String> result)   {
    	if(l == n)	{
        	StringBuilder sb = new StringBuilder(s);
        	for(int i = 1; i <= (l - r); i++ )	{
        		sb.append(')');
        	}
        	String str = sb.toString();
        	result.add(str);
        	return;
        }
        
        generate(n, s + "(", l + 1, r, result);
        if(l > r)
        	generate(n, s + ")", l, r + 1, result);
    }
	
	/**
	 * 9.7
	 */
	enum Color{
		white, black, green, blue, red
	}
	public static boolean paintFill(Color[][] screen, int x, int y, Color ocolor, Color ncolor){
		if(x < 0 || y < 0 || x >= screen[0].length || y >= screen.length)	{
			return false;
		}
		
		// only expand when it is the old color, otherwise do nothing
		if(screen[y][x] == ocolor)	{	
			screen[y][x] = ncolor;
			paintFill(screen, x - 1, y, ocolor, ncolor);
			paintFill(screen, x, y - 1, ocolor, ncolor);
			paintFill(screen, x + 1, y, ocolor, ncolor);
			paintFill(screen, x, y + 1, ocolor, ncolor);
		}
		return true;
	}
	
	
	/**
	 * 9.8
	 */
	// non-DP solution
	public static int makeChange(int amount, int[] denoms, int index){

		if(index >= denoms.length - 1)
			return 1;
		 
		int denomAmount = denoms[index];
		int ways = 0;
		for(int i = 0; i * denomAmount <= amount; i++)	{
			ways += makeChange(amount - i * denomAmount, denoms, index + 1);
		}
		return ways;
	}
	
	public static int makeChange(int amount)	{
		int[] denoms = {25, 10, 5, 1};
		return makeChange(amount, denoms, 0);
	}
	
	// DP solution !!!  REMEMBER THIS SOLUTION
	/**
	 * 
	 * @param amount
	 * @param coins
	 * @param index
	 * @param map
	 * @return
	 */
    public static int makeChangeDP(int amount, int[] coins, int index, int[][] map){

        if(index >= coins.length - 1)       // the rightmost column is always 1: because that column you can only use 1 cent!!!
            return 1;                       // one coin remaining...
        if(map[amount][index] > 0)          // DP: if it has value: don't recompute it
            return map[amount][index];      
        
        int coinValue = coins[index];       // current coin we are using
        int ways = 0;                       // don't forget to declare it to zero !!!!!!!!
        
        for(int i = 0; i * coinValue <= amount; i++)  {
            // go to next denom, assuming i coins of denomAmount
            int amountRemaining = amount - i * coinValue;
            ways += makeChangeDP(amountRemaining, coins, index + 1, map);          // index+1  here: RECURSE here
        }
        
        map[amount][index] = ways; 
        
        System.out.println(amount);
        System.out.println(index);
        System.out.println("map[amount][index] is: " + map[amount][index]);
        return ways;
    }


    public static int makeChangeDP(int amount){
        int[] denoms = {25, 10, 5, 1};
        int[][] map = new int[amount + 1][denoms.length];
        return makeChangeDP(amount, denoms, 0, map);
    }
	
	
	/**
	 * 9.9
	 */
	static int number_of_kind = 0; // the total number of kinds of n-Queen
									// placement
	static int GRID_SIZE = 8;
	public static void placeQueens(int row, Integer[] columns,
			ArrayList<Integer[]> list) {

		if (row == GRID_SIZE) {
			list.add(columns.clone()); // becaue list IS AN ARRAYLIST, the
										// content CAN BE CHANGED during
										// recursion!
			for (Integer i : columns) {
				System.out.print(i + " ");
			}
			number_of_kind++;
			System.out.println("[" + number_of_kind + "]");

			return; // you can also don't write return here becuase it will
					// automatically return
		}

		for (int col = 0; col < GRID_SIZE; col++) {
			if (checkValid(columns, row, col)) {
				columns[row] = col;
				placeQueens(row + 1, columns, list);
			}
		}
	}
	
	/*
	 * Check if (row, column) is a valid spot for a queen by checking
	 * if there is a queen in the same column or diagonal. We don't
	 * need to check it for queens in the same row because the calling
	 * place Queen only attempts to place one queen at a time. We know this row is empty.
	 */
	public static boolean checkValid(Integer[] columns, int row, int col) {
		for (int i = 0; i < row; i++) {
			int j = columns[i];

			if (j == col)
				return false;

			int disCol = Math.abs(col - j);
			int disRow = row - i;
			if (disCol == disRow)
				return false;
		}
		return true;
	}
    
    // main
	public static void main(String[] args) {
		
		// 9.1
		System.out.println(numOfStepDP(5, 3) + " ways to take steps");
		
		// 9.4
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		
		ArrayList<ArrayList<Integer>> result2 = cracking_9.getSubSet(list);
		System.out.print("all the subsets: ");
		System.out.println(result2);
		
		// 9.5
		int[] num = {1, 3, 2};
		ArrayList<ArrayList<Integer>> result3 = permute(num);
		System.out.print("all the permutations are: ");
		System.out.println(result3);
		
		// 9.6
		ArrayList<String> result = generateParenthesis(3);
		System.out.println("all the parentheses: ");
		System.out.println(result);
		
		// 9.8
        // we should try passing in 25 & 26 to see the diff
        // and also notice that the order of printed map[amount][index] to see how it works recursively
		int amount = 26;
		System.out.println(makeChangeDP(amount));
		
		// 9.9: 8-queen: 92 solutions
		Integer[] cols = { 0, 0, 0, 0, 0, 0, 0, 0 };
		ArrayList<Integer[]> list2 = new ArrayList<Integer[]>();
		placeQueens(0, cols, list2);
		// ****
		
	}
}
