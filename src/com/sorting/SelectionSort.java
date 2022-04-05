package com.sorting;

public class SelectionSort {

	public static void main(String[] args) {
		int[] arr = { 9, 1, 8, 2, 7, 33, 6, 4, 5 };
		sortFromFront(arr);
		print(arr);
		System.out.println("--------------------");
		int[] arr1 = { 9, 1, 8, 2, 7, 3, 6, 4, 4, 5, 2, 1 };
		sortFromBack(arr1);
		print(arr1);
	}

	private static void sortFromBack(int[] arr) {

		for (int i = 0; i < arr.length; i++) {
			int max_idx = 0;

			for (int j = 1; j < arr.length - i; j++) {
				if (arr[j] > arr[max_idx]) {
					max_idx = j;
				}
				
				int temp = arr[max_idx];
				arr[max_idx] = arr[arr.length-1-i];
				arr[arr.length-1-i] = temp;
			}
		}

	}

	private static void sortFromFront(int[] arr) {

		for (int i = 0; i < arr.length - 1; i++) {
			int min_idx = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < arr[min_idx]) {
					min_idx = j;
				}
			}

			int temp = arr[min_idx];
			arr[min_idx] = arr[i];
			arr[i] = temp;
		}

	}

	private static void print(int[] arr) {
		for (int a : arr) {
			System.out.println(a);
		}

	}

}
