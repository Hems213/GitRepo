package practice;

import java.util.Arrays;
import java.util.HashSet;

public class arraysummingtoK {

	public static void main(String[] args) {
		int[] input = { -9, 15,6, 9, -1 };
		findSumofTwoSort(input, 6);
		findSumofTwoHm(input, 6);
		findSumOfThreeHm(input, 15);

	}

	private static void findSumOfThreeHm(int[] input, int sum) {
		for(int i=0; i<input.length-1; i++) {
			int currentNum = input[i];
			int targetSum = sum - currentNum;
			HashSet<Integer> hs = new HashSet<>();
			for(int j=i;j<input.length; j++) {
				int currentNum2 = input[j];
				int complimentaryNum = targetSum - currentNum2; 
				if(hs.contains(complimentaryNum)) {
					System.out.println("Found the triplet "+currentNum+","+currentNum2+","+complimentaryNum);
					return;
				} else {
					hs.add(currentNum2);
				}
			}
		}
		System.out.println("Unable to find triplet");
	}

	private static void findSumofTwoSort(int[] input, int i) {
		Arrays.sort(input);
		int l = 0;
		int r = input.length - 1;
		while (r > l) {
			int num1 = input[l];
			int num2 = input[r];
			if (num1 + num2 == i) {
				System.out.println("Found numbers" + num1 + "," + num2);
				return;
			}
			if (num1 + num2 < i) {
				l++;
			} else {
				r--;
			}
		}
		System.out.println("unable to find pair");

	}

	private static void findSumofTwoHm(int[] input, int i) {
		HashSet<Integer> hs = new HashSet<>();
		for(int currentNum : input) {
			int complimentNum = i-currentNum;
			if(hs.contains(complimentNum)) {
				System.out.println("Found numbers "+ currentNum+ ","+complimentNum);
				return;
			} else {
				hs.add(currentNum);
			}
		}
		System.out.println("Unable to find");
	}

}
