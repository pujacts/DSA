package com.search.median;

public class MaximumRotated {

	public static void main(String[] args) {

		int[] arr = { 34, 56, 77, 1, 6, 6, 8, 10, 20, 30, 34 };

		System.out.println(findMax(arr, 0, arr.length - 1));

		int maxCount = findMaxIndex(arr, 0, arr.length - 1);
		int count = (maxCount +1) % (arr.length - 1);
		System.out.println(maxCount);
		System.out.println(count);

	}

	private static int findMaxIndex(int[] arr, int low, int high) {

		if (high <= low) {
			return low;
		}

		int mid = (low + high) / 2;

		if (arr[mid] > arr[mid + 1] && arr[mid] > arr[mid - 1]) {
			return mid;
		}

		if (arr[mid] < arr[low]) {
			return findMaxIndex(arr, low, mid - 1);
		} else {
			return findMaxIndex(arr, mid + 1, high);
		}
	}

	private static int findMax(int[] arr, int low, int high) {

		if (high <= low) {
			return arr[low];
		}

		int mid = (low + high) / 2;

		if (arr[mid] > arr[mid + 1] && arr[mid] > arr[mid - 1]) {
			return arr[mid];
		}

		if (arr[mid] < arr[low]) {
			return findMax(arr, low, mid - 1);
		} else {
			return findMax(arr, mid + 1, high);
		}
	}

}
