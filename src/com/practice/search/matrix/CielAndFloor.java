package com.practice.search.matrix;

public class CielAndFloor {

	public static void main(String[] args) {

		int[] arr = { 1, 2, 4, 8, 10, 16, 18, 20, 25 };
		System.out.println(findFloor(arr, 9));
		System.out.println(findCeil(arr, 16));
	}

	private static int findCeil(int[] arr, int target) {
		int size = arr.length;
		if (size == 1) {
			return Integer.MIN_VALUE;
		}
		int res = Integer.MIN_VALUE;
		int low = 0;
		int high = size - 1;

		while (low <= high) {
			int mid = (low + high) / 2;
			if (arr[mid] <= target) {
				low = mid + 1;
			} else {
				res = arr[mid];
				high = mid - 1;
			}
		}
		return res;
	}

	private static int findFloor(int[] arr, int target) {

		int size = arr.length;
		if (size == 1) {
			return Integer.MIN_VALUE;
		}
		int res = Integer.MIN_VALUE;
		int low = 0;
		int high = size - 1;

		while (low <= high) {
			int mid = (low + high) / 2;
			if (arr[mid] < target) {
				res = arr[mid];
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return res;
	}

}
