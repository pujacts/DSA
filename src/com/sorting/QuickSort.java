package com.sorting;

public class QuickSort {

	public static void main(String[] args) {
		int[] arr = { 10, 80, 30, 90, 40, 50, 70, 40, 20, 66 };
		sort(arr);
		for (int a : arr) {
			System.out.println(a);
		}
	}

	private static void sort(int[] arr) {

		quickSort(arr, 0, arr.length - 1);

	}

	private static void quickSort(int[] arr, int low, int high) {

		if (low < high) {
			int pi = partition(arr, low, high);
			quickSort(arr, low, pi - 1);
			quickSort(arr, pi + 1, high);
		}
		
	}

	private static int partition(int[] arr, int low, int high) {

		int pivot = arr[high];
		int i = low - 1; // o-1=-1 refer Geekforgeeks
		for (int j = low; j < high; j++) {
			if (arr[j] <= pivot) {
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
