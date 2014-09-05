package others;

import java.util.ArrayList;

public class InsertInterval {

	public class Interval {
		int start;
		int end;

		Interval() {
			start = 0;
			end = 0;
		}

		Interval(int s, int e) {
			start = s;
			end = e;
		}
	}

	public ArrayList<Interval> insert(ArrayList<Interval> intervals,
			Interval newInterval) {

		ArrayList<Interval> result = new ArrayList<Interval>();

		for (Interval interval : intervals) {
			if (interval.end < newInterval.start) { // note: cannot be <= (must
													// be <)
				result.add(interval); // case 1: [interval]__[newInterval]
			} else if (newInterval.end < interval.start) { // case 2:
															// [newInterval]__[Interval]
				result.add(newInterval);
				newInterval = interval;
			} else { // case 3 & 4: (2 overlap cases)
				newInterval = new Interval(Math.min(newInterval.start,
						interval.start),
						Math.max(newInterval.end, interval.end));
			}

		}
		result.add(newInterval);
		return result;
	}
}
