package practice;

import java.util.ArrayList;
import java.util.Collections;

public class MergeOverlapping {

	public static void main(String[] args) {
		ArrayList<Interval> input = new ArrayList<>();
		input.add(new Interval(1,3));
		input.add(new Interval(2,6));
		input.add(new Interval(8,10));
		input.add(new Interval(15, 18));
		System.out.println(merge(input));
	}
	 public static ArrayList<Interval> merge(ArrayList<Interval> intervals) {
		 Collections.sort(intervals, (Interval a, Interval b)->{
			 return a.start-b.start;
		 });
		 ArrayList<Interval> result = new ArrayList<>();
		 for(Interval currentInterval : intervals) {
			 if(result.size()==0) {
				 result.add(currentInterval);
			 } else {
				 mergeOrAdd(result, currentInterval);
			 }
		 }
		 return result;
		 
    }
	private static void mergeOrAdd(ArrayList<Interval> result, Interval currentInterval) {
		Interval lastInterval = result.get(result.size()-1);
		if(currentInterval.start>lastInterval.end) {
			result.add(currentInterval);
		}else {
			lastInterval.end = Math.max(lastInterval.end, currentInterval.end);
		}
		
	}
}
