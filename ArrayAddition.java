package practice;

import java.util.Arrays;

public class ArrayAddition {

	public static void main(String[] args) {
		int[] arr1 = {1,1,2,4,5,1,4,8,9,3,1};
		int[] arr2 = {6,8,8,8};
		int resultLen = Math.max(arr1.length, arr2.length)+1;
		int[] resultArr = new int[resultLen];
		int carryOver = 0;
		for(int i=0;i<resultLen;i++) {
			int result = carryOver+getAt(arr1, i)+getAt(arr2, i);
			resultArr[resultLen-1-i] = result%10;
			carryOver = result/10;
		}
		System.out.println(Arrays.toString(resultArr));
	}

	private static int getAt(int[] arr2, int i) {
		// TODO Auto-generated method stub
		int index = arr2.length-1-i;
		if(index<0)return 0;
		return arr2[index];
	}

}
