package practice;

import java.util.Arrays;
import java.util.HashSet;

public class Longestsconsequitesequence {

	public static void main(String[] args) {
		
		int arr[] = {36, 41, 56, 35, 44, 33, 34, 92, 43, 32, 42 }; 
		findLongestConsecutiveElements(arr);
		int arr2[] = {4, 15,16,17,18,19,20,21,22,1,2,5,9,5,8,9,10,12,13,14,15,16,17,18};
		findLongestConsecutiveSubsequence(arr);
	}

	private static void findLongestConsecutiveSubsequence(int[] arr2) {
		int overallCount=0;
		int count = 0;
		for(int i=0,j=1; j<arr2.length; i++,j++) {
			int num1 = arr2[i];
			int num2 = arr2[j];
			if(isSequence(num1, num2)) {
				count++;
			} else {
				count=0;
			}
			overallCount = Math.max(overallCount, count);			
		}
		System.out.println("overallCount="+(overallCount+1));
	}

	private static boolean isSequence(int num1, int num2) {
		return num1+1==num2;
	}

	private static void findLongestConsecutiveElements(int[] arr) {
		
		HashSet<Integer> hs = new HashSet<>();
		
		for(int n: arr) {
			hs.add(n);
		}
		int ans = Integer.MIN_VALUE;
		for(int num: arr) {
			if(hs.contains(num-1)) {
				//do nothing it is a followup number
			} else {
				int count = 0;
				while(hs.contains(num+count)) {
					System.out.println(num+count);
					count++;
				}
				ans = Math.max(ans, count);
				System.out.println("=========="+count);
			}
		}
		System.out.println("Answer = "+ans);
		
	}

}
