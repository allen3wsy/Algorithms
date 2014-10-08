package others;

import java.util.HashMap;

public class MaxPointsOnALine {

	class Point {
		int x;
		int y;

		Point() {
			x = 0;
			y = 0;
		}

		Point(int a, int b) {
			x = a;
			y = b;
		}
	}

	public int maxPoints(Point[] points) {
		if (points == null || points.length == 0)
			return 0;

		HashMap<Double, Integer> map = new HashMap<Double, Integer>();
		int max = 1;

		for (int i = 0; i < points.length; i++) {
			// shared point changed, map should be cleared to server new points
			map.clear();
			// maybe all points are same points, the slope is Integer.MIN_VALUE
			map.put(Double.MIN_VALUE, 1);

			int duplicates = 0;
			for (int j = i + 1; j < points.length; j++) {
				double slope;
				if (points[j].x == points[i].x && points[j].y == points[i].y) {
					duplicates++; // same point
					continue;
				} else if (points[j].x - points[i].x == 0) {
					slope = Double.MAX_VALUE; // parallel to y coordinator!
				} else { // 0.0 == -0.0 ! But their hashCodes() are different !
					slope = 0.0 + (double) (points[j].y - points[i].y)
							/ (double) (points[j].x - points[i].x);
				}

				if (map.containsKey(slope)) { // same line
					map.put(slope, map.get(slope) + 1);
				} else {
					map.put(slope, 2);
				}
			}

			for (int temp : map.values()) {
				if (temp + duplicates > max) // duplicate may exist
					max = temp + duplicates;
			}
		}
		return max;
	}

	public static void main(String[] args) {
		Double d1 = 0.0;
		Double d2 = -0.0;
		System.out.println(d1.hashCode() + " " + d2.hashCode());
		System.out.println(0.0 / 3);
		System.out.println((double) (-3 + 3) / 10);
	}
}
