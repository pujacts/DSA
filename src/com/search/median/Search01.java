package com.search.median;

public class Search01 {

	public static void main(String[] args) {

		int[] arr = { 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1 };

		System.out.println(search(arr, 0, arr.length - 1));

	}

	private static int search(int[] arr, int low, int high) {

		if (low > high) {
			return -1;
		}

		int mid = (low + high) / 2;
		if (arr[mid - 1] == 0 && arr[mid] == 1) {
			return mid;
		}

		if (arr[mid] == 0) {
			return search(arr, mid + 1, high);
		} else {
			return search(arr, low, mid - 1);
		}

	}

}
