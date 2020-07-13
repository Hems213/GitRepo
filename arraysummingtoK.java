package practice;

import java.util.Arrays;
import java.util.HashSet;

public class arraysummingtoK {

	public static void main(String[] args) {
		int[] input = { 3, 6, 9, 5, -1, -9 };
		findSumofTwoSort(input, 10);
		findSumofTwoHm(input, 10);

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
