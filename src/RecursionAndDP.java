import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class RecursionAndDP {
	public static void main(String[] args){
//		int[] arr = new int[100];
//		//System.out.println(numOfPath(1, 2));
//		int[][] matrix = new int[100][100];
//		System.out.println(numPath(5,5));
//		
//		ArrayList<Point> list = new ArrayList<Point>();
//		if(getPath(4,4,list)){
//			for(Point p : list){
//				p.print();
//			}
//		}
//		
//		Point a = new Point(1,1);
//		Point b = new Point(1,1);
//		if(a == b)
//			System.out.println("xxx");
		
//		int[] arr = {-1,5,7,8,8,8,8,8,8,20};
//		int[] arr2 = {0,1,2};
//		System.out.println("magic index: "+magicFast(arr, 0, arr.length-1));
//		
//		combination("abcd");
		
		System.out.println(makeChangeDP(5));
	}
	
	/**
	 * 9.1
	 */
	public static int numOfStep(int n){
		if(n < 0) return 0;
		if(n == 0) return 1;
		
		return numOfStep(n-1)+numOfStep(n-2)+numOfStep(n-3);
	}
	
	public static int numOfStepDP(int n, int[] arr){
		if(n < 0) return 0;
		if(n == 0) return 1;
		
		if(arr[n] != 0) return arr[n];
		arr[n] = numOfStep(n-1)+numOfStep(n-2)+numOfStep(n-3);
		return arr[n];
	}
	
	/**
	 * 9.2
	 */
	public static int factorial(int n){
		if(n == 0) return 0;
		if(n == 1) return 1;
		
		return n*factorial(n-1);
	}
	
	public static int numPath(int x, int y){
		return factorial(x+y)/( factorial(x)*factorial(y) );
	}
	
	public static int numOfPath(int x, int y){
		if(x < 0 || y < 0)
			return 0;
		if(x == 0 && y == 0)
			return 1;
		
		return numOfPath(x, y-1)+numOfPath(x-1, y);
	}
	
	public static int numOfPathDP(int x, int y, int[][] matrix){
		if(x < 0 || y < 0)
			return 0;
		if(x == 0 && y == 0)
			return 1;
		
		if(matrix[x][y] != 0) return matrix[x][y];
		matrix[x][y] = numOfPath(x, y-1)+numOfPath(x-1, y);
		return matrix[x][y];
	}
	
	public static int numOfPathWithLimit(int x, int y, int x1, int y1){
		if(x < 0 || y < 0 || (x == x1 && y == y1))
			return 0;
	
		if(x == 0 && y == 0)
			return 1;
		
		return numOfPathWithLimit(x, y-1, x1, y1)+numOfPathWithLimit(x-1, y, x1, y1);
	}
	
	private static boolean isFree(int x, int y){
		return true;
	}
	
	public static boolean getPath(int x, int y, ArrayList<Point> paths){
		Point p = new Point(x,y);
		
		if(x == 0 && y == 0) return true;
		
		boolean succ = false;
		if(x >=1 && isFree(x-1, y)){   //try left
			succ = getPath(x-1, y, paths);
		}
		if(!succ && y>=1 && isFree(x, y-1)){  //try right
			succ = getPath(x, y-1, paths);
		}
		if(succ){
			paths.add(p);
		}
		return succ;
	}
	
	/**
	 * 9.3
	 */
	public static int findMagicIndex(int[] arr, int left, int right){
		if(left > right)
			return -1;
		int mid = (left+right)/2;
		if(arr[mid] == mid){
			return mid;
		}else if(arr[mid] < mid){
			return findMagicIndex(arr, mid+1, right);
		}else{ //arr[mid] > mid
			return findMagicIndex(arr, left, mid-1);
		}
	}
	
	public static int searchInDepth(int[] arr, int index){
		if(index < 0 || index > arr.length-1){
			return -1;
		}
		if(arr[index] == index) return index;
		return searchInDepth(arr, arr[index]);
	}
	
	public static int findMagicNotDistinct(int[] arr, int left, int right){
		if(left > right)
			return -1;
		int mid = (left+right)/2;
		if(arr[mid] == mid) return mid;
		else{
			int index=searchInDepth(arr, mid);
			if( index != -1){
				return index;
			}else{
				if(arr[mid]<mid)
					return findMagicNotDistinct(arr, mid+1, right);
				else 
					return findMagicNotDistinct(arr, left, mid-1);
			}
		}
	}
	
	//answer
	public static int magicFast(int[] arr, int left, int right){
		if(left > right || left<0 || right >= arr.length)
			return -1;
		int mid = (left+right)/2;
		int midVal = arr[mid];
		if(midVal == mid) return mid;
		//try left
		int leftIndex = Math.min(mid-1, midVal);
		int leftResult = magicFast(arr, left, leftIndex);
		if(leftResult >= 0)
			return leftResult;
		//try right
		int rightIndex = Math.max(mid+1, midVal);
		int rightResult = magicFast(arr, rightIndex, right);
		return rightResult;
	}
	
	/**
	 * 9.4
	 */
	public static ArrayList<ArrayList<Integer>> getSubSet(ArrayList<Integer> set, int index){
		ArrayList<ArrayList<Integer>> allSets;
		if(set.size() == index){
			allSets = new ArrayList<ArrayList<Integer>>();
			allSets.add(new ArrayList<Integer>());
		}else{
			allSets = getSubSet(set, index+1);
			int item = set.get(index);
			ArrayList<ArrayList<Integer>> moreSubset = new ArrayList<ArrayList<Integer>>();
			for(ArrayList<Integer> subset : allSets){
				ArrayList<Integer> newSet = new ArrayList<Integer>();
				newSet.addAll(subset);
				newSet.add(item);
				moreSubset.add(newSet);
			}
			allSets.addAll(moreSubset);
		}
		return allSets;
	}
	
	/**
	 * 9.5
	 */
	public static void permutation(String s, StringBuilder sb, boolean[] rec){
		if(sb.length() == s.length()){
			System.out.println(sb.toString());
			return;
		}
		
		for(int i=0; i<s.length(); i++){
			if(!rec[i]){
				rec[i] = true;
				sb.append(s.charAt(i));
				permutation(s, sb, rec);
				rec[i] = false;
				sb.setLength(sb.length()-1);
			}
		}
	}
	
	public static void permutation(String s){
		StringBuilder sb = new StringBuilder();
		boolean[] rec = new boolean[s.length()];
		permutation(s, sb, rec);
	}
	
	public static void combination(String s, int start, StringBuilder out){
		for(int i=start; i<s.length(); i++){
			out.append(s.charAt(i));
			System.out.println(out);
			//if(i < s.length())
				combination(s, i+1, out);
			out.setLength(out.length() - 1);
		}
	}
	
	public static void combination(String s){
		StringBuilder sb = new StringBuilder();
		combination(s, 0, sb);
	}
	
	/**
	 * 9.6
	 */
	public static Set<String> getParens(int remaining){
		Set<String> set  = new HashSet<String>();
		if(remaining == 0){
			//set = new HashSet<String>();
			set.add("");
			return set;
		}
		
		Set<String> tmp = getParens(remaining-1);

		for(String str:tmp){
			for(int i=0; i<str.length(); i++){
				if(str.charAt(i) == '('){
					String s = insertInside(str, i);
					set.add(s);
				}
			}
			set.add("()"+str);
		}
		return set;
	}
	
	public static String insertInside(String s, int pos){
		String first = s.substring(0, pos+1);
		String end = s.substring(pos+1);
		return first+"()"+end;
	}
	//another method
	public static void addParen(ArrayList<String> list, int leftRem, int rightRem, char[] str, int count){
		if(leftRem < 0 || rightRem < leftRem) return;
		
		if(leftRem == 0 && rightRem == 0){
			String s = String.copyValueOf(str);
			list.add(s);
		}else{
			//add left paren
			if(leftRem > 0){
				str[count] = '(';
				addParen(list, leftRem-1, rightRem, str, count+1);
			}
			
			//add right paren
			if(rightRem > leftRem){
				str[count] = ')';
				addParen(list, leftRem, rightRem-1, str, count+1);
			}
		}
		
	}
	
	public static void addParen(int count){
		ArrayList<String> list = new ArrayList<String>();
		char[] str = new char[count*2];
		addParen(list, count, count, str, 0);
		for(String s : list){
			System.out.println(s);
		}
		System.out.println("parens size: "+list.size());
	}
	
	/**
	 * 9.7
	 */
	enum Color{
		white, black, green, blue, red
	}
	public static boolean paintFill(Color[][] screen, int x, int y, Color ocolor, Color ncolor){
		if(x<0 || y<0 || x>=screen[0].length || y>=screen.length)
			return false;
		
		if(screen[y][x] == ocolor){
			screen[y][x] = ncolor;
			paintFill(screen, x-1, y, ocolor, ncolor);
			paintFill(screen, x, y-1, ocolor, ncolor);
			paintFill(screen, x+1, y, ocolor, ncolor);
			paintFill(screen, x, y+1, ocolor, ncolor);
		}
		return true;
	}
	
	/**
	 * 9.8
	 */
	public static int makeChange(int amount, int[] denoms, int index){
//		if(amount == 0) return 1;
//		if(index >= denoms.length)
//			return 0;
		if(index >= denoms.length-1)
			return 1;
		 
		int denomAmount = denoms[index];
		int ways = 0;
		for(int i=0; i*denomAmount<=amount; i++){
			ways += makeChange(amount - i*denomAmount, denoms, index+1);
		}
		return ways;
	}
	
	public static int makeChange(int amount){
		int[] denoms = {25,10,5,1};
		return makeChange(amount, denoms, 0);
	}
	
	public static int makeChangeDP(int amount, int[] denoms, int index, int[][] map){
		if(index >= denoms.length-1)
			return 1;
		 
		if(map[amount][index] > 0) return map[amount][index];
		int denomAmount = denoms[index];
		int ways = 0;
		for(int i=0; i*denomAmount<=amount; i++){
			ways += makeChange(amount - i*denomAmount, denoms, index+1);
		}
		map[amount][index] = ways; 
		return ways;
	}
	
	public static int makeChangeDP(int amount){
		int[] denoms = {25,10,5,1};
		int[][] map = new int[amount+1][denoms.length];
		return makeChangeDP(amount, denoms, 0, map);
	}
	
	/**
	 * 9.9
	 */
	public static void placeQueens(int row, Integer[] cols, ArrayList<Integer[]> list){
		if(row == 8){
			list.add(cols.clone());
			for(Integer i:cols){
				System.out.print(i+" ");
			}
			return;
		}
		
		for(int i=0; i<8; i++){
			if(checkValid(cols, row, i)){
				cols[row] = i;
				placeQueens(row+1, cols, list);
			}
		}
	}
	
	public static boolean checkValid(Integer[] cols, int row, int col){
		for(int i=0; i<row; i++){
			int col1 = cols[i];
			
			if(col1 == col) return false;
			
			int disCol = Math.abs(col - col1);
			int disRow = row - i;
			if(disCol == disRow) return false;
		}
		return true;
	}
	
	/**
	 * 9.10
	 */
	static int maxHeight=0;
	static ArrayList<Integer> finalResult = new ArrayList<Integer>();
	public static void highestBoxs(Box[] boxs, boolean[] isUsed, Integer[] result, Box prev, int index){
		if(index > boxs.length-1){
			return;
		}
		
		for(int i=0; i<boxs.length; i++){
			Box curr = boxs[i];
			if(!isUsed[i] && checkBoxFit(prev, curr)){
				result[index] = i;
				isUsed[i] = true;
				highestBoxs(boxs, isUsed, result, curr, index+1);
				isUsed[i] = false;
			}
		}
		int height = 0;
		for(int i=0; i<=index; i++){
			height += boxs[result[i]].d;
		}
		if(height > maxHeight){
			maxHeight = height;
			finalResult.clear();
			for(int j=0; j<=index; j++){
				finalResult.add(result[j]);
			}
		}
		
	}
	
	public static boolean checkBoxFit(Box prev, Box curr){
		if(prev.w > curr.w && prev.h>curr.h && prev.d>curr.d){
			return true;
		}
		return false;
	}
	
	public static int stackOfHeight(ArrayList<Box> list){
		int h=0;
		for(Box b : list){
			h += b.d;
		}
		return h;
	}
	
	//answer
	public static ArrayList<Box> createStack(Box[] boxs, Box bottom){
		ArrayList<Box> max_stack = null;
		int max_height = 0;
		for(int i=0; i<boxs.length; i++){
			if(checkBoxFit(bottom, boxs[i])){
				ArrayList<Box> new_stack = createStack(boxs, boxs[i]);
				int curr_height = stackOfHeight(new_stack);
				if(curr_height > max_height){
					max_height = curr_height;
					max_stack = new_stack;
				}
			}
		}
		
		if(max_stack == null){
			return new ArrayList<Box>();
		}
		if(bottom != null){
			max_stack.add(0, bottom);
		}
		return max_stack;
	}
}

class Point{
	int x,y;
	public Point(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public void print(){
		System.out.println("("+x+","+y+")");
	}
}

class Box{
	int w, h, d;
}