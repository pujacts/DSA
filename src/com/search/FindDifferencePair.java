package com.search;

import java.util.Arrays;

public class FindDifferencePair {

	public static void main(String[] args) {

		int[] arr = { 1, 5, 4, 3, 2, 7, 8, 9, 6 };

		System.out.println("Find pair uing bruteForce");
		findPairBruteForce(arr, 6);

		System.out.println("Find pair uing sorting");
		findPairSorting(arr, 6);

	}

	private static void findPairSorting(int[] arr, int value) {
		Arrays.sort(arr);
		int first = 0;
		int second = 0;

		while (first < arr.length && second < arr.length) {
			int diff = Math.abs(arr[second] - arr[first]);
			if ( diff == value) {
				System.out.println(arr[first] + "," + arr[second]);
			} 
			
			if(diff > value) {
				first++;
			} else {
				second++;
			}
		}
	}

	private static void findPairBruteForce(int[] arr, int value) {

		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (Math.abs(arr[i] - arr[j]) == value) {
					System.out.println(arr[i] + "," + arr[j]);
				}
			}
		}
	}

}
