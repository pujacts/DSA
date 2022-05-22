package com.search;

import java.util.Arrays;

public class ClosestPair {

	public static void main(String[] args) {

		ClosestPair cp = new ClosestPair();
		int[] arr = { 10, 20, 3, 4, 50, 80 };
		cp.closestByBruteForce(arr, 56);
		cp.closestBySorting(arr, 56);

	}

	private void closestBySorting(int[] arr, int value) {
		Arrays.sort(arr);
		int minsum = Integer.MAX_VALUE;
		int size = arr.length - 1;
		int first = 0;
		int second = 0;
		int start = 0;
		int stop = size;

		while (start < stop) {
			int sum = (value - (arr[start] + arr[stop]));
			if (Math.abs(sum) < minsum) {
				minsum = Math.abs(sum);
				first = arr[start];
				second = arr[stop];
			}

			if (sum == 0) {
				break;
			} else if (sum > 0) {
				start++;
			} else {
				stop--;
			}

		}
		System.out.println("closed pair using sorting: " + first + "," + second);
	}

	private void closestByBruteForce(int[] arr, int value) {

		int minsum = Integer.MAX_VALUE;
		int size = arr.length - 1;
		int first = 0;
		int second = 0;
		for (int i = 0; i < size - 1; i++) {
			for (int j = i + 1; j < size; j++) {
				int sum = Math.abs(value - (arr[i] + arr[j]));
				if (sum < minsum) {
					minsum = sum;
					first = arr[i];
					second = arr[j];
				}
			}
		}

		System.out.println("closed pair using bruteForce: " + first + "," + second);

	}

}
