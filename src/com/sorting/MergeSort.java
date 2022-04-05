package com.sorting;

public class MergeSort {

	public static void main(String[] args) {
		int[] arr = { 9, 1, 8, 2, 7, 33, 6, 4, 5 };
		sort(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

	private static void sort(int[] arr) {
		mergeSort(arr, 0, arr.length - 1);

	}

	private static void mergeSort(int[] arr, int low, int high) {

		if (low >= high) {
			return;
		}

		int mid = (low + high) / 2;
		mergeSort(arr, low, mid);
		mergeSort(arr, mid + 1, high);
		merge(arr, low, mid, high);

	}

	private static void merge(int[] arr, int low, int mid, int high) {

		int[] temparr = new int[arr.length];
		int lowerIdx = low;
		int upperIdx = mid + 1;
		int tempIdx = low;
		while (lowerIdx <= mid && upperIdx <= high) {
			if (arr[lowerIdx] < arr[upperIdx]) {
				temparr[tempIdx++] = arr[lowerIdx++];
			} else {
				temparr[tempIdx++] = arr[upperIdx++];
			}
		}

		if (lowerIdx <= mid) {
			while (lowerIdx <= mid) {
				temparr[tempIdx++] = arr[lowerIdx++];
			}
		}

		if (upperIdx <= high) {
			while (upperIdx <= high) {
				temparr[tempIdx++] = arr[upperIdx++];
			}
		}

		for (int i = low; i <= high; i++) {
			arr[i] = temparr[i];
		}
	}

}
