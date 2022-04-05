package com.sorting;

public class InsertionSort {

	public static void sort(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			int current = arr[i];
			int j = i - 1;


			arr[j + 1] = current;
		}
	}

	public static void main(String[] args) {
		int[] arr = { 5, 6, 2, 4, 7, 3, 1 };
		sort(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
}
