package com.practice.search.twodarray;

public class IndefiniteArray {

	public static void main(String[] args) {

		System.out.println("test");
		int[] arr = { 3, 5, 7, 9, 10, 90, 100, 130, 140, 160, 170 };
		int target = 200;
		System.out.println(ans(arr, target));

	}

	private static int ans(int[] arr, int target) {

		int start = 0;
		int end = 1;

		// condition for the target to lie in the range
		try {
			while (target > arr[end]) {
				int temp = end + 1; // this is my new start
				// double the box value
				// end = previous end + sizeofbox*2
				end = end + (end - start + 1) * 2;
				start = temp;
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			return -1;
		}

		return binarySearch(arr, start, end, target);
	}

	private static int binarySearch(int[] arr, int low, int high, int target) {
		while (low < high) {
			int mid = low + (high - low) / 2;
			if (arr[mid] == target) {
				return mid;
			}
			if (arr[mid] < target) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return -1;
	}

}
