package com.search;

public class MajorityBinarySearch {

	public static void main(String[] args) {

		int[] arr = { 1, 2, 2, 3, 4, 5, 10 };
		System.out.println(isMajority(arr));
	}

	private static boolean isMajority(int[] arr) {
		int size = arr.length;
		int majority = arr[size / 2];
		int index = firstIndex(arr, 0, size - 1, majority);

		if ((index + size / 2) <= size - 1 && arr[index + size / 2] == majority) {
			return true;
		}
		return false;
	}

	private static int firstIndex(int[] arr, int low, int high, int value) {

		int mid = 0;
		if (low <= high) {
			mid = (low + high) / 2;
		}
		if ((mid == 0 || arr[mid - 1] < value) && arr[mid] == value) {
			return mid;
		} else if (arr[mid] < value) {
			return firstIndex(arr, mid + 1, high, value);

		} else {
			return firstIndex(arr, 0, mid, value);
		}
	}

}
