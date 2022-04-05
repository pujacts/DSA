package com.sorting.practice;

public class ZeroOneAndTwos {

	public static void main(String[] args) {
		int[] arr = { 0, 0, 1, 1, 2, 2, 0, 0, 2, 2, 1, 1, 2 };
		sort(arr);
		System.out.println("Array after sorting");
		for (int a : arr) {
			System.out.print(a + ",");
		}
	}

	private static void sort(int[] arr) {

		int left = 0;
		int right = arr.length - 1;
		int i = 0;

		while (i < right) {
			if (arr[i] == 0) {
				swap(arr, i, left);
				i++;
				left++;
			} else if (arr[i] == 2) {
				swap(arr, i, right);
				i++;
				right--;
			} else
				i++;
		}
	}

	private static void swap(int[] arr, int left, int right) {
		int temp = arr[left];
		arr[left] = arr[right];
		arr[right] = temp;

	}

}
