package com.sorting;

public class CountSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 23, 24, 22, 21, 26, 25, 27, 28, 21, 21 };
		sort(arr, 20, 30);
		for (int a : arr) {
			System.out.println(a);
		}
	}

	private static void sort(int[] arr, int lower, int upper) {

		int size = arr.length - 1;
		int range = upper - lower;
		int[] count = new int[range];

		for (int i = 0; i <= size; i++) {

			count[arr[i] - lower]++;
		}
		int j = 0;
		for (int i = 0; i < range; i++) {
			while (count[i] > 0) {
				arr[j++] = i + lower;
				count[i]--;
			}
		}
	}

}
