package com.sorting.practice;

public class MinimumSwaps {

	// Minimum swaps required to bring all the elements less than the given value
	// together
	public static void main(String[] args) {

		int[] arr = { 1, 2, 3, 4, 6, 18, 5, 17, 6, 16, 7, 15, 8, 14, 9, 13, 10, 12, 11 };

		sort(arr, 10);
		System.out.println("Array after sorting");
		for (int a : arr) {
			System.out.print(a + ",");
		}

	}

	private static void sort(int[] arr, int value) {

		int start = 0;
		int end = arr.length - 1;
		int swaps = 0;

		while (start < end) {
			if (arr[start] <= value) {
				start++;
			} else if (arr[end] > value) {
				end--;
			} else {
				swap(arr, start, end);
				swaps++;
			}
		}
		
		System.out.println("minimum swaps " + swaps);
	}

	private static void swap(int[] arr, int start, int end) {
		int temp = arr[start];
		arr[start] = arr[end];
		arr[end] = temp;

	}

}
