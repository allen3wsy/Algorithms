package others;

import java.util.List;

public class Triangle {

	public int minimumTotal(List<List<Integer>> triangle) {

		// from bottom to up: changing the value of every ArrayList<Integer>
		for (int i = triangle.size() - 2; i >= 0; i--) {
			for (int j = 0; j <= triangle.get(i).size() - 1; j++) {
				int min = Math.min(triangle.get(i + 1).get(j),
						triangle.get(i + 1).get(j + 1));
				int newValue = triangle.get(i).get(j) + min;
				triangle.get(i).set(j, newValue);
			}
		}

		return triangle.get(0).get(0); // return the very first value
	}
}
