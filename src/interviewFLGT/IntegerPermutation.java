package interviewFLGT;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Hom's Google Phone Screen
 * 
 * @author AllenNg
 */
public class IntegerPermutation {

	public static HashMap<Integer, Integer> createHashMap(int[] array) {

		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < array.length; i++) {
			if (map.containsKey(array[i])) {
				map.put(array[i], map.get(array[i]) + 1);
			} else {
				map.put(array[i], 1);
			}
		}
		return map;
	}

	public static boolean checkPermutation(ArrayList<int[]> arrayList) {

		Set<HashMap<Integer, Integer>> set = new HashSet<HashMap<Integer, Integer>>();

		for (int[] array : arrayList) {
			HashMap<Integer, Integer> map = createHashMap(array);
			if (set.contains(map))
				return true;
			else
				set.add(map);
		}

		return false; // no array is permutation to each other
	}

	public static void main(String[] args) {
		int[] a = { 1, 2, 3 };
		int[] b = { 1, 2, 2 };
		int[] c = { 1, 3, 2 };

		ArrayList<int[]> arrayList = new ArrayList<int[]>();
		arrayList.add(a);
		arrayList.add(b);
		arrayList.add(c);

		System.out.println(checkPermutation(arrayList));
	}
}
