import java.util.ArrayList;
import java.util.Arrays;

public class ArrayAndString {
	public static void main(String[] args){
		//System.out.println(CompressStr("abbbbcdddqqqqq%"));
		String s = "xxxx23fsd3";
		System.out.println(ifRotated("waterfloat", "erfloatwat"));
		//printMatrix(rotateMatrix(newMatrix(5)));
		
							
	}
	
	
	public static int[][] newMatrix(int n){
		int[][] m = new int[n][n];
		int num = 0;
		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				m[i][j] = ++num;
			}
		}
		return m;
	}
	
	public static void printMatrix(int[][] m){
		for(int i=0; i<m.length; i++){
			for(int j=0; j<m[0].length; j++){
				System.out.printf("%-2d ", m[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}
	
	/**
	 * 1.1
	 * @param s
	 * @return
	 */
	public static boolean isCharsUnique(String s){
		if(s.length() > 256)
			return false;
		int[] arr = new int[256];
		for(char c : s.toCharArray()){
			if(arr[c] !=0)
				return false;
			arr[c]++;
		}
		return true;
	}
	
	/**
	 * 1.2
	 * @param s
	 * @return
	 */
	public static String reverseStr(String s){
		int len = s.length();
		char[] cArr = s.toCharArray();
		for(int i=0; i<(int)(cArr.length/2); i++){
			char tmp = cArr[i];
			cArr[i] = cArr[len-1-i];
			cArr[len-1-i] = tmp;
		}
		return new String(cArr);
	}
	
	/**
	 * 1.3
	 * @param s1
	 * @param s2
	 * @return
	 */
	public static boolean CheckIfPermutation(String s1, String s2){
		if(s1 == null || s2 == null)
			return false;
		// unnecessary though
		if(s1.equals("") && s2.equals(""))
			return true;
		//
		if(s1.length() != s2.length())
			return false;
		
		int[] rec = new int[256];
		for(int i=0; i<s1.length(); i++){
			rec[s1.charAt(i)]++;
		}
		for(int i=0; i<s2.length(); i++){
			//rec[s2.charAt(i)]--;
			if(--rec[s2.charAt(i)] < 0){
				return false;
			}
		}
		return true;
	}
	
	/**
	 * 1.4
	 */
	public static String replaceSpace(String str, int tlen)	{
		char[] cArr = str.toCharArray();
		int index = str.length()-1;
		
		for(int i=tlen-1; i >= 0; i--){
			if(cArr[i] != ' '){
				cArr[index--] = cArr[i];
			}else{
				cArr[index--] = '0';
				cArr[index--] = '2';
				cArr[index--] = '%';
			}
		}
		
		return new String(cArr);
	}
	
	/**
	 * 1.5
	 */
	public static String CompressStr(String str){
		if(str == null)
			return null;
		if(str.length() <= 2)
			return str;
		
		int count = 1;
		char lastChar = str.charAt(0);
		StringBuilder sb = new StringBuilder();
		sb.append(lastChar);
		
		for(int i=1; i < str.length(); i++){
			if(str.charAt(i) == lastChar){
				count++;
			}else{
				sb.append(count);
				count = 1;
				lastChar = str.charAt(i);
				sb.append(lastChar);
			}
		}
		sb.append(count);
		
		if(sb.length() < str.length())
			return sb.toString();
		else 
			return str;
	}
	
	
	/**
	 * 1.6
	 */
	public static int[][] rotateMatrix(int[][] matrix){
		if(matrix.length != matrix[0].length)
			return null;
		
		int N = matrix.length;
		int len = N;
		int layer = 0;
		int tmp=0;
		
		for(; layer < N/2; layer++, len-=2){
			for(int offset=0; offset <= len-2; offset++){ //important len-2
				tmp = matrix[layer][layer+offset];
				matrix[layer][layer+offset] = matrix[N-layer-offset-1][layer];
				matrix[N-layer-offset-1][layer] = matrix[N-1-layer][N-1-layer-offset];
				matrix[N-1-layer][N-1-layer-offset] = matrix[layer+offset][N-1-layer];
				matrix[layer+offset][N-1-layer] = tmp;
			}
		}
		
		return matrix;
	}
	
	/**
	 * 1.7
	 */
	public static void setZero(int[][] matrix){
		int m = matrix.length;
		int n = matrix[0].length;
	
		int[] row = new int[m];
		int[] col = new int[n];
		
		for(int i=0; i<m; i++){
			for(int j=0; j<n; j++){
				if(matrix[i][j] == 0){
					row[i] = 1;
					col[j] = 1;
				}
			}
		}
		
		for(int i=0; i<m; i++){
			if(row[i] == 1){
				for(int j=0; j<n; j++){
					matrix[i][j] = 0;
				}
			}
		}
		
		for(int j=0; j<n; j++){
			if(col[j] == 1){
				for(int i=0; i<m; i++){
					matrix[i][j] = 0;
				}
			}
		}
	}
	
	/**
	 * 1.8
	 */
	public static boolean ifRotated(String s1, String s2){
		if(s1==null || s1.length()<=0 || s1.length() != s2.length())
			return false;
		
		String s = s1+s1;
		return s.contains(s2);
	}
}
