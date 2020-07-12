package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSort {

	public static void main(String[] args) {
		List arrList = Arrays.asList(5, 6, 8, 3, 1, 4, 2, 65, -90);
		
		List sortedArr = mergeSort(arrList);
		System.out.println(Arrays.toString(sortedArr.toArray()));
	}

	private static List mergeSort(List arrList) {
		if(arrList.size()<=1) return arrList;
		int mid = arrList.size() / 2;
		List list1 = arrList.subList(0, mid);
		List list2 = arrList.subList(mid, arrList.size());
		List sorted1 = mergeSort(list1);
		List sorted2 = mergeSort(list2);
		return merge(sorted1, sorted2);
	}

	private static List merge(List sorted1, List sorted2) {
		List<Integer> result = new ArrayList<Integer>();
		int arr1Idx = 0;
		int arr2Idx = 0;
		while(arr1Idx<sorted1.size() && arr2Idx<sorted2.size()) {
			int arr1Val = (int) sorted1.get(arr1Idx);
			int arr2Val = (int) sorted2.get(arr2Idx);
			if(arr1Val<arr2Val) {
				result.add(arr1Val);
				arr1Idx++;
			} else {
				result.add(arr2Val);
				arr2Idx++;
			}
		}
		if(arr2Idx<sorted2.size()) {
			result.addAll(sorted2.subList(arr2Idx, sorted2.size()));
		}
		if(arr1Idx<sorted1.size()) {
			result.addAll(sorted1.subList(arr1Idx, sorted1.size()));
		}
		return result;
	}
	


}
