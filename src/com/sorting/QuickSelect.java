package com.sorting;

public class QuickSelect {

	public static void main(String[] args) {
		int[] arr = { 5, 6, 2, 4, 7, 3, 1 };
		// 0 1 2 3 4 5 6 7 8 9 10
		// 1 2 3 4 6 7 8 9 10 20
		System.out.println(get(arr, 3));
//		System.out.println(get(arr, 8));
//		System.out.println(get(arr, 4));
	}

	private static int get(int[] arr, int k) {

		quickSelect(arr, 0, arr.length - 1, k);
		return arr[k];

	}

	private static void quickSelect(int[] arr, int low, int high, int k) {

		int pi = partition(arr, low, high);
		if (pi == k) {
			return;
		}
		if (k < pi) {
			quickSelect(arr, low, pi - 1, k);
		}
		if (k > pi) {
			quickSelect(arr, pi + 1, high, k);
		}

	}

	private static int partition(int[] arr, int low, int high) {
		int pivot = arr[high];
		int i = low - 1;
		for (int j = low; j < high; j++) {
			if (arr[j] < pivot) {
				i++;
				swap(arr, i, j);
			}
		}
		swap(arr, i + 1, high);
		return i + 1;
	}

	private static void swap(int[] arr, int first, int second) {
		int temp = arr[second];
		arr[second] = arr[first];
		arr[first] = temp;

	}
}
