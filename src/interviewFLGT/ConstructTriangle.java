package interviewFLGT;

import java.util.ArrayList;

public class ConstructTriangle {
	// Given a array
	// {{ 4,7,3,6,7}}
	//
	// construct a triangle like
	// {{81}}
	// {{40,41}}
	// {{21,19,22}}
	// {{11,10,9,13}}
	// {{ 4,7,3,6,7}}

	public static ArrayList<int[]> constructTriangle(int[] array) {
		ArrayList<int[]> result = new ArrayList<>();
		result.add(array);
		if (array == null || array.length == 0)
			return result;
		helper(result, array);
		return result;
	}

	private static void helper(ArrayList<int[]> result, int[] array) {
		if (array.length == 1)
			return;
		int[] current = new int[array.length - 1];
		for (int i = 0; i < array.length - 1; ++i) {
			current[i] = array[i] + array[i + 1];
		}
		result.add(0, current);
		helper(result, current);
	}

	public static void main(String[] args) {
		int[] array = { 4, 7, 3, 6, 7 };
		ArrayList<int[]> result = constructTriangle(array);
		for (int[] list : result) {
			for (Integer i : list) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}
}
