package com.search;

import java.util.Arrays;
import java.util.LinkedHashSet;

public class SumOfPairEqualsToRestArray {

	public static void main(String[] args) {

		int[] arr = { 1, 2, 4, 8, 16, 15 };
		System.out.println("---------Brute force ----------");
		sumOfPairSorting(arr);
		System.out.println("---------Sorting ----------");
		sumOfPairBruteForce(arr);
		System.out.println("---------HashTable ----------");
		sumOfPairUsingHashing(arr);

		int arr1[] = { 2, 11, 5, 1, 4, 7 };

		if (sumOfPairUsingHashing(arr1) == false) {
			System.out.printf("No pair found");
		}
	}

	private static boolean sumOfPairUsingHashing(int[] arr) {
		int totalSum = findSum(arr);
		if (totalSum % 2 != 0) {
			return false;
		}
		int value = totalSum / 2;

		LinkedHashSet<Integer> set = new LinkedHashSet<>();

		for (int i = 0; i < arr.length; i++) {
			if (set.contains(value - arr[i])) {
				System.out.println(arr[i] + "," + (value - arr[i]));
				return true;
			}

			set.add(arr[i]);
		}
		return false;

	}

	private static void sumOfPairBruteForce(int[] arr) {
		int totalSum = findSum(arr);
		int value = totalSum / 2;
		int size = arr.length - 1;
		for (int i = 0; i < size - 1; i++) {
			for (int j = i + 1; j < size; j++) {
				int curr = arr[i] + arr[j];
				if (curr == value) {
					System.out.println(arr[i] + "," + arr[j]);
				}
			}
		}
	}

	private static void sumOfPairSorting(int[] arr) {

		int totalSum = findSum(arr);
		int value = totalSum / 2;

		Arrays.sort(arr);
		int start = 0;
		int stop = arr.length - 1;
		while (start < stop) {
			int curr = arr[start] + arr[stop];
			if (curr == value) {
				System.out.println(arr[start] + "," + arr[stop]);
			}

			if (curr < value) {
				start++;
			} else {
				stop--;
			}
		}

	}

	private static int findSum(int[] arr) {
		return Arrays.stream(arr).reduce(0, Integer::sum);

	}

}
