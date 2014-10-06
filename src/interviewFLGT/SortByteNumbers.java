package interviewFLGT;

import java.util.ArrayList;
import java.util.Arrays;

// Google phone screen
public class SortByteNumbers {

	public static ArrayList<Byte> sortBytes(ArrayList<Byte> bytes) {
		ArrayList<Byte> result = new ArrayList<Byte>();
		boolean[] arr = new boolean[256];
		
		for(Byte num : bytes) {
			arr[num + 128] = true;
		}
		for(int i = 0; i < arr.length; i++) {
			if(arr[i]) {
				result.add((byte) (i - 128));
			}
		}
		return result;
	}

	public static void main(String[] args) {
		// 2, 3, -1, 2, -1
		ArrayList<Byte> bytes = new ArrayList<>(Arrays.asList((byte) 2,
				(byte) 3, (byte) -1, (byte) 2, (byte) -1));
		System.out.println(sortBytes(bytes));
	}
}
