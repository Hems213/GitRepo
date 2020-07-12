package practice;

import java.util.Arrays;

public class HeapSort {

	public static void main(String[] args) {
		int[] arr = { 5, 6, 8, 3, 1, 4, 2, 65, -90 };
		heapSort(arr);
		System.out.println(Arrays.toString(arr));
	}

	private static void heapSort(int[] arr) {
		int endIndex = arr.length - 1;
		int lastParentIndex = getParentIndex(endIndex);
		for (int i = lastParentIndex; i >= 0; i--) {
			heapify(arr, i, endIndex);
		}
		for(int j=endIndex; j >=1; j--) {
			swap(0, j ,arr);
			heapify(arr, 0, j-1);
		}

	}

	// [4,5,6,3,77,32, 43]
	private static void heapify(int[] arr, int nodeIndex, int endIndex) {
		int leftIndex = getLeftIndex(nodeIndex);
		int rightIndex = getRightIndex(nodeIndex);
		if (leftIndex > endIndex)
			return;
		if (rightIndex > endIndex) {
			int leftValue = arr[leftIndex];
			int currentValue = arr[nodeIndex];
			if (leftValue > currentValue) {
				swap(leftIndex, nodeIndex, arr);
			}
		} else {
			int leftValue = arr[leftIndex];
			int rightValue = arr[rightIndex];
			int currentValue = arr[nodeIndex];
			if(leftValue>currentValue || rightValue>currentValue) {
				if(leftValue>rightValue) {
					swap(leftIndex, nodeIndex, arr);
					heapify(arr, leftIndex, endIndex);
				} else {
					swap(rightIndex, nodeIndex, arr);
					heapify(arr, rightIndex, endIndex);
				}
			}
		}

	}

	private static void swap(int indx1, int indx2, int[] arr) {
		int tempVal = arr[indx1];
		arr[indx1] = arr[indx2];
		arr[indx2] = tempVal;

	}

	private static int getRightIndex(int nodeIndex) {
		// TODO Auto-generated method stub
		return 2 * nodeIndex + 2;
	}

	private static int getLeftIndex(int nodeIndex) {
		// TODO Auto-generated method stub
		return 2 * nodeIndex + 1;
	}

	private static int getParentIndex(int index) {
		return (index - 1) / 2;
	}

}
