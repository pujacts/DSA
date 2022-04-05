package com.practice.search;

import java.util.Arrays;

public class ZeroSumTriplates {

	public static void main(String[] args) {

		ZeroSumTriplates tri = new ZeroSumTriplates();
		int[] arr = { 0, -1, 2, -3, 1 };
		tri.tripUsingBrute(arr);

		System.out.println("triplate using sorting");
		tri.triplateUsingSorting(arr);

		// A+B=C triplate

		int[] arr1 = { 1, 5, 15, 6, 9, 8 };
		System.out.println("A+B=C triplate using bruteforce");
		tri.triplateUsingBrute1(arr1);

		System.out.println("A+B=C triplate using sorting");
		tri.triplateUsingSort(arr1);

		// smaller than triplate
		int[] arr2 = { -2, -1, 0, 1 };
		System.out.println("Smaller than triplate");
		tri.smallerTriplateusingBruteForce(arr2, 2);
		tri.smallerTriplateusingSorting(arr2, 2);
	}

	private void smallerTriplateusingSorting(int[] arr, int value) {

		Arrays.sort(arr);
		int size = arr.length;
		int count = 0;
		for (int i = 0; i < size; i++) {
			int start = i + 1;
			int stop = size - 1;
			while (start < stop) {
				int sum = arr[i] + arr[start] + arr[stop];
				if (sum >= value) {
					stop--;
				} else {
					count += stop - start;
					start++;

				}
			}
		}
		System.out.println(count);
	}

	private void smallerTriplateusingBruteForce(int[] arr, int value) {
		int size = arr.length;
		int count = 0;
		for (int i = 0; i < size - 2; i++) {
			for (int j = i + 1; j < size - 1; j++) {
				for (int k = j + 1; k < size; k++) {
					int sum = (arr[i] + arr[j] + arr[k]);
					if (sum < value) {
						count++;
					}
				}
			}
		}
		System.out.println(count);

	}

	private void triplateUsingSort(int[] arr) {

		Arrays.sort(arr);
		int size = arr.length;
		for (int i = 0; i < size; i++) {

			int start = 0;
			int stop = size - 1;
			while (start < stop) {

				if (arr[i] == arr[start] + arr[stop]) {
					System.out.println(arr[i] + "," + arr[start] + "," + arr[stop]);
					start++;
					stop--;
				}

				if (arr[i] > arr[start] + arr[stop]) {
					start++;
				} else {
					stop--;
				}
			}
		}
	}

	private void triplateUsingBrute1(int[] arr) {

		int size = arr.length;
		for (int i = 0; i < size - 2; i++) {
			for (int j = i + 1; j < size - 1; j++) {
				for (int k = j + 1; k < size; k++) {
					// second condition
					if (arr[i] + arr[j] == arr[k] || arr[k] + arr[j] == arr[i] || arr[i] + arr[k] == arr[j]) {
						System.out.println(arr[i] + "," + arr[j] + "," + arr[k]);
					}
				}
			}
		}

	}

	private void triplateUsingSorting(int[] arr) {
		Arrays.sort(arr);
		int size = arr.length;
		for (int i = 0; i < size - 2; i++) {

			int start = i + 1;
			int stop = size - 1;
			while (start < stop) {

				if (arr[i] + arr[start] + arr[stop] == 0) {
					System.out.println(arr[i] + "," + arr[start] + "," + arr[stop]);
					start++;
					stop--;
				}

				if (arr[i] + arr[start] + arr[stop] < 0) {
					start++;
				} else {
					stop--;
				}
			}
		}

	}

	private void tripUsingBrute(int[] arr) {

		int size = arr.length;
		for (int i = 0; i < size - 2; i++) {
			for (int j = i + 1; j < size - 1; j++) {
				for (int k = j + 1; k < size; k++) {
					if (arr[i] + arr[j] + arr[k] == 0) {
						System.out.println(arr[i] + "," + arr[j] + "," + arr[k]);
					}
				}
			}
		}

	}

}
