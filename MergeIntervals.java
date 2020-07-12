package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class MergeIntervals {

	public static void main(String[] args) {
		ArrayList<Interval> intervals = new ArrayList<>();
		intervals.add(new Interval(6, 7));
		intervals.add(new Interval(1, 2));
		intervals.add(new Interval(4, 5));
		intervals.add(new Interval(8, 11));
		ArrayList<Interval> result = insert2(intervals, new Interval(3, 9));
		System.out.println("AFter merging = "+result);
	}

	public static ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
		Collections.sort(intervals, (Interval a, Interval b) -> {
			return a.start - b.start;
		});
		ArrayList<Integer> breakpoints = new ArrayList<>();
		for (Interval intvl : intervals) {
			breakpoints.add(intvl.start);
			breakpoints.add(intvl.end);
		}
		int indexOfStart = Collections.binarySearch(breakpoints, newInterval.start);
		int indexOfEnd = Collections.binarySearch(breakpoints, newInterval.end);
		int deleteionStartIndex = 0;
		int deleteionEndIndex = 0;
		if (indexOfStart >= 0) {
			if (indexOfStart % 2 == 0) {
				deleteionStartIndex = indexOfStart + 1;
			} else {
				deleteionStartIndex = indexOfStart;
			}

		} else {
			int supposedPosition = (indexOfStart * -1) - 1;
			if (supposedPosition % 2 == 0) {
				breakpoints.set(supposedPosition, newInterval.start);
				deleteionStartIndex = supposedPosition + 1;
			} else {
				deleteionStartIndex = supposedPosition;
			}
		}

		if (indexOfEnd >= 0) {
			if (indexOfEnd % 2 == 0) {
				deleteionEndIndex = indexOfEnd;
			} else {
				deleteionEndIndex = indexOfEnd - 1;
			}
		} else {
			int supposedPostionEnd = (indexOfEnd * -1) - 1;
			if (supposedPostionEnd % 2 == 0) {
				breakpoints.set(supposedPostionEnd - 1, newInterval.end);
				deleteionEndIndex = supposedPostionEnd - 2;
			} else {
				deleteionEndIndex = supposedPostionEnd - 1;
			}
		}

		System.out.println(deleteionStartIndex);
		System.out.println(deleteionEndIndex);
		System.out.println(breakpoints);

		for (int k = deleteionStartIndex; k <= deleteionEndIndex; k++) {
			breakpoints.remove(deleteionStartIndex);
		}
		System.out.println(breakpoints);

		return intervals;
	}

	public static ArrayList<Interval> insert2(ArrayList<Interval> intervals, Interval newInterval) {
		Collections.sort(intervals, (Interval a, Interval b) -> {
			return a.start - b.start;
		});
		System.out.println("After sort = "+intervals);
		List<Interval> impactedIntervals = new ArrayList<>();
		List<Interval> unImpactedBefore = new ArrayList<>();
		List<Interval> unImpactedAfter = new ArrayList<>();
		for(Interval intervl : intervals) {
			classifyImpact(intervl, impactedIntervals, unImpactedBefore, unImpactedAfter, newInterval);
		}
		Interval mergedInterval = merge(impactedIntervals, newInterval);
		ArrayList<Interval> results = new ArrayList<>();
		results.addAll(unImpactedBefore);
		results.add(mergedInterval);
		results.addAll(unImpactedAfter);
		return results;
		
	}

	private static Interval merge(List<Interval> impactedIntervals, Interval newInterval) {
		if(impactedIntervals.size()==0) return newInterval;
		Interval mergedInterval = new Interval();
		Interval firstImpacted = impactedIntervals.get(0);
		Interval lastImpacted = impactedIntervals.get(impactedIntervals.size()-1);
		mergedInterval.start = Math.min(newInterval.start, firstImpacted.start);
		mergedInterval.end = Math.max(newInterval.end, lastImpacted.end);
		return mergedInterval;
	}

	private static void classifyImpact(Interval intervl, List<Interval> impactedIntervals,
			List<Interval> unImpactedBefore, List<Interval> unImpactedAfter, Interval newInterval) {
		if(intervl.end < newInterval.start) {
			unImpactedBefore.add(intervl);
			return;
		}
		if(intervl.start > newInterval.end) {
			unImpactedAfter.add(intervl);
			return;
		}
		impactedIntervals.add(intervl);
		
	}

	
}

class Interval {
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + end;
		result = prime * result + start;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Interval other = (Interval) obj;
		if (end != other.end)
			return false;
		if (start != other.start)
			return false;
		return true;
	}

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

	@Override
	public String toString() {
		return "[" + start + "-" + end + "]";
	}
}