package com.sorting.practice;

public class checkReverse {

	public static void main(String[] args) {
		int arr[] = { 1, 2, 6, 5, 4, 7 };
		System.out.println(checkReverseArray(arr));
					// 0  1  2  3  4  5
		int arr1[] = { 1, 2, 6, 8, 4, 7 };
		System.out.println(checkReverseArray(arr1));

	}

	private static boolean checkReverseArray(int[] arr) {
		int start = -1;
		int end = -1;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > arr[i + 1]) {
				start = i;
				break;
			}
		}

		if (start == -1) {
			return true;
		}

		for (int i = start; i < arr.length; i++) {
			if (arr[i] < arr[i + 1]) {
				end = i;
				break;
			}
		}
		if (end == -1) {
			return true;
		}
		
		//increasing property 
		//after reversal the subarray should fit in the array
		if(arr[start-1] > arr[end] ||  arr[end+1]< arr[start]) {
			return false;
		}

		for(int i= end+1; i< arr.length-1; i++) {
			if(arr[i]> arr[i+1]) {
				return false;
			}
			
		}
		return true;
	}

}
