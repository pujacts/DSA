package com.search;

public class Swap {

	public static void main(String[] args) {

		String[] arr = { "a1", "a2", "a3", "a4", "b1", "b2", "b3", "b4" };

		swap(arr);

		for (String a : arr) {
			System.out.println(a + ",");
		}

	}

	private static void swap(String[] arr) {

		int N = (arr.length) / 2;

		for (int i = 1; i < N; i++) {
			for (int j = 0; j < i; j++) {
				swapch(arr, N - i + 2 * j, N - i + 2 * j + 1);
			}
		}

	}

	private static void swapch(String[] arr, int i, int j) {

		String temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;

	}

}
