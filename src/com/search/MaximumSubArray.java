package com.search;

import java.util.HashSet;

public class MaximumSubArray {

	public static void main(String[] args) {

		int[] arr = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };

		System.out.println(sum(arr));
		int[] arr1 = { 1, 2, -3, 4, 5, -10, 6, 7 };
		System.out.println(sum(arr1));

		// maximum subarray
		int[] a = { 1, 2, 3, 4, 5, -10, 6, 7, 3 };
		int[] b = { 1, 3 };

		System.out.println(sum(a, b));

	}

	private static int sum(int[] arr, int[] brr) {
		HashSet<Integer> set = new HashSet<>();
		int currMax = 0;
		int max = Integer.MIN_VALUE;
		for (int b : brr)
			set.add(b);

		for (int a : arr) {
			if (set.contains(a)) {
				currMax = 0;
			} else {
				currMax = Math.max(a, currMax + a);
			}
			if (currMax < 0) {
				currMax = 0;
			}
			if (currMax > max) {
				max = currMax;
			}
		}
		return max;
	}

	private static int sum(int[] arr) {

		int size = arr.length;
		int max = Integer.MIN_VALUE;
		int sum;
		for (int i = 0; i < size; i++) {
			sum = 0;
			for (int j = i; j < size; j++) {
				sum = sum + arr[j];
				if (sum > max) {
					max = sum;
				}
			}
		}
		return max;
	}

}
