package com.practice.search;

import java.util.Arrays;

public class FindMinDiff {

	public static void main(String[] args) {

		FindMinDiff diff = new FindMinDiff();
		int[] arr = { 1, 6, 4, 19, 17, 20 };
		diff.findMinDiffBySorting(arr);

		int[] first = { 1, 5, 4, 3, 2, 7, 8, 9, 6 };
		int[] third = { 6, 4, 19, 17, 20 };

		diff.findDiff(first, third);

		diff.findDiffUsingSort(first, third);
	}

	// using sorting
	private void findDiffUsingSort(int[] first, int[] third) {

		Arrays.sort(first);
		Arrays.sort(third);
		int size1 = first.length - 1;
		int size2 = third.length - 1;
		int minDiff = Integer.MAX_VALUE;
		int input1 = 0;
		int input2 = 0;
		int firstArr = 0;
		int secondArr = 0;

		while (firstArr < size1 && secondArr < size2) {
			int diff = Math.abs(first[firstArr] - third[secondArr]);
			if (diff < minDiff) {
				minDiff = diff;
				input1 = first[firstArr];
				input2 = third[secondArr];
			}

			if (first[firstArr] < third[secondArr]) {
				firstArr++;
			} else {
				secondArr++;
			}
		}
		System.out.println("minimum difference using sorting: " + input1 + "-" + input2 + ":" + minDiff);
	}

	// using brute force
	private void findDiff(int[] first, int[] third) {
		int size1 = first.length - 1;
		int size2 = third.length - 1;
		int minDiff = Integer.MAX_VALUE;
		int input1 = 0;
		int input2 = 0;
		for (int i = 0; i < size1; i++) {
			for (int j = 0; j < size2; j++) {

				int diff = Math.abs(first[i] - third[j]);
				if (diff < minDiff) {
					minDiff = diff;
					input1 = first[i];
					input2 = third[j];
				}
			}
		}

		System.out.println("minimum difference using two arrays: " + input1 + "-" + input2 + ":" + minDiff);

	}

	private void findMinDiffBySorting(int[] arr) {
		Arrays.sort(arr);
		int size = arr.length;
		int diff = Integer.MAX_VALUE;
		for (int i = 0; i < size - 1; i++) {
			int minDiff = arr[i + 1] - arr[i];
			if (minDiff < diff) {
				diff = minDiff;
			}
		}

		System.out.println(diff);
	}

}
