import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;

public class BitManipulation {
	public static void main(String[] args){
//		String i = "11000000000", j = "11101";
//		BigInteger N = new BigInteger(i, 2);
//		BigInteger M = new BigInteger(j, 2);
//		int result = insertNum(N.intValue(), M.intValue(), 2, 6);
//		System.out.println(Integer.toBinaryString(result));
//		printBinForDecimal(0.625);
//		System.out.println(count1s(7));
		String s = "aaaaaaaa";
		System.out.println(new BigInteger(s, 16).intValue()+" "+Integer.toBinaryString(new BigInteger(s, 16).intValue()));
		int r = swapAdvanced(new BigInteger(s,16).intValue());
		System.out.println(r + ", " + Integer.toBinaryString(r));
		
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		map.put(1, "xx");
		
		HashMap<Integer, String> map2 = (HashMap)map.clone();
		map2.put(2, "www");
		for(Integer i : map.keySet()){
			System.out.print(map.get(i)+" ");
		}
		System.out.println();
		
		for(Integer i : map2.keySet()){
			System.out.print(map2.get(i)+" ");
		}
	}
	
	/**
	 * 5.1
	 */
	public static int insertNum(int N, int M, int i, int j){
		if(i > j) return Integer.MAX_VALUE;
		
		int tmp = (int)Math.pow(2, j-i+1); //important
		//System.out.println(tmp);
		tmp--;
		return (~(tmp<<i) & N) | (M << i);
	} 
	
	/**
	 * 5.2
	 */
	public static void printBinForDecimal(double n){
		if(n<0 || n>1) return;
		int count = 0;
		StringBuilder sb = new StringBuilder();
		sb.append(".");
		while(n != 0 && count++ < 32){
			n *= 2;
			if(n >=1 ){
				sb.append(1);
				n--;
			}else
				sb.append(0);
		}
		if(n == 0){
			System.out.println(sb.toString());
		}else{
			System.out.println("ERROR");
		}
	}
	
	/**
	 * 5.3 with the same num of ones
	 */
	public static int getNext(int n){
		int c = n;
		int c1 = 0;
		int c0 = 0;
		
		while( (c & 1)==0 && c!=0){
			c0++;
			c >>= 1;
		}
		
		while((c & 1)!=0){
			c1++;
			c >>= 1;
		}
		
		if( c0+c1==31 || c0+c1==0)
			return -1;  //error
		//System.out.println(c1 + " " +c0);
		int p = c0+c1;
		n = n | (1<<p);  //set bit
		
		int mask = ~( (1<<p) -1);
		n &= mask;  //clear bits
		
		n |= ( (1<<(c1-1)) - 1);  //set trailing ones
		return n;
	}
	
	public static int getPrev(int n){
		int c = n;
		int c0 = 0;
		int c1 = 0;
		
		while( (c&1)!=0 ){
			c1 ++;
			c>>=1;
		}
		while( (c&1)==0 && c!=0){
			c0++;
			c>>=1;
		}
		int p = c0+c1;
		if(p==31 && p==0){
			return -1; //error
		}
		
		//clear bit
		int mask = ~(1<<p);
		n &= mask;
		
		//clear bits
		mask = ~((1<<p)-1);
		n &= mask;
		
		//set trailing ones, rightmost to p
		mask = ( (1<<(c1+1)) -1 )<<(c0-1);
		n |= mask;
		
		return n;
	}
	
	/**
	 * 5.5
	 */
	public static int numToFlip(int a, int b){
		int c = a^b;
		int count = 0;
		//int time=0;
		while(c!=0){
//			if( (c&1) != 0)
//				count++;
//			c>>>=1;
			count++;
			c = c&(c-1);
		}
		return count;
	}
	
	/**
	 * 5.6
	 */
	public static int swapEvenOdd(int n){
		int a = n>>>1;
		int b = n<<1;
		
		int result = 0;
		int time = 0;
		while(time < 32){
			if(time%2 == 0){
				result += (a&1)*(int)Math.pow(2, time);
			}else{
				result += (b&1)*(int)Math.pow(2, time);
			}
			time++;
			a>>>=1;
			b>>>=1;
		}
		return result;
	}
	
	public static int swapAdvanced(int n){
		return ((n & 0xaaaaaaaa)>>>1) | ((n & 0x55555555)<<1);
	}
	
	/**
	 * 5.7
	 */
	public static int findMissing(ArrayList<BitInteger> input, int column){
		if(column > BitInteger.SIZE)
			return 0;
		
		ArrayList<BitInteger> ones = new ArrayList<BitInteger>();
		ArrayList<BitInteger> zeros = new ArrayList<BitInteger>();
		
		for(BitInteger t : input){
			if(t.fetch(column) == 1){
				ones.add(t);
			}else{
				zeros.add(t);
			}
		}
		
		if(zeros.size() <= ones.size()){
			int v = findMissing(zeros, column+1);  //nice
			return (v<<1) | 0;  //nice
		}else{
			int v = findMissing(ones, column+1);
			return (v<<1) | 1;
		}
	}
	
	//not implement
	static class BitInteger{
		public static int SIZE;
		
		public int fetch(int j){
			return 1;
		}
	}
	
	/**
	 * 5.8
	 */
	public static byte setBitInBytes(byte[] screen, int index, int start, int end){
		if(start < 0 || end > 7 || start>end)
			return 0;
		
		byte b = screen[index]; 
		int mask = (1<<(end-start+1))-1;
		mask <<= (7-end);
		b |= mask;
		return b;
	}
	
	public static void drawHorizontalLine(byte[] screen, int width, int x1, int x2, int y){
		int startPoint = y*width/8;
		int startIndex = x1/8;
		int endIndex = x2/8;
		startIndex += startPoint;
		endIndex += startPoint;
		
		for(int i=startIndex; i<=endIndex; i++){
			if(i==startIndex && i==endIndex){
				screen[i] = setBitInBytes(screen, i, x1%8, x2%8);
			}else if(i == startIndex){
				screen[i] = setBitInBytes(screen, i, x1%8, 7);
			}else if(i == endIndex){
				screen[i] = setBitInBytes(screen, i, 0, x2%8);
			}else{
				screen[i] = setBitInBytes(screen, i, 0, 7);
			}
		}
	}
	
}