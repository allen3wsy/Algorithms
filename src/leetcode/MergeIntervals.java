package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MergeIntervals {

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

	// REMEMBER how to write this IntervalComparator class !!!
	public class IntervalComparator implements Comparator<Interval> {

		public int compare(Interval i1, Interval i2) {
			return i1.start - i2.start;
		}
	}

	public ArrayList<Interval> merge(ArrayList<Interval> intervals) {

		if (intervals == null || intervals.size() <= 1) // EX: for the algo
														// below, should be at
														// least 2
			return intervals; // intervals !!!

		// sort intervals by using self-defined Comparator
		Collections.sort(intervals, new IntervalComparator()); 
		// Note: ArrayList: Collections.sort(q, q) Arrays: Arrays.sort(q, q)
		ArrayList<Interval> result = new ArrayList<Interval>();

		Interval prev = intervals.get(0); 
		// Just like Insert Interval: prev is like an OUTSIDER !! same as newInterval in Insert Interval
		for (int i = 1; i < intervals.size(); i++) { // Note: start from the
														// second one
			Interval curr = intervals.get(i);

			if (prev.end < curr.start) { // no overlap
				result.add(prev);
				prev = curr;
			} else { // overlap: merge case (prev.end >= curr.start)
				Interval merged = new Interval(prev.start, Math.max(prev.end,
						curr.end));
				prev = merged;
			}
		}
		
		result.add(prev);
		return result;
	}
}
