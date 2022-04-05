package com.practice.search;

import java.util.Arrays;

public class ClosestToZero {

	public static void main(String[] args) {

		ClosestToZero close = new ClosestToZero();
		int[] arr = { 1, 5, -10, 3, 2, -6, 8, 9, 6 };

		System.out.println("find closest using brute force");
		close.findCloseBruteForce(arr);

		System.out.println("find closest using sorting");
		close.findCloseUsingSort(arr);

	}

	private void findCloseUsingSort(int[] arr) {

		if (arr.length < 2) {
			System.out.println("invalid input");
			return;
		}
		Arrays.sort(arr);
		int l = 0;
		int r = 0;
		int minFirst = 0;
		int minSecond = arr.length - 1;
		int minsum = Math.abs(arr[minFirst] + arr[minSecond]);

		for (l = 0, r = arr.length - 1; l < r;) {

			int sum = arr[l] + arr[r];
			if (Math.abs(sum) < minsum) {

				minsum = Math.abs(sum);
				minFirst = l;
				minSecond = r;
			}

			if (sum < 0) {
				l++;
			} else if (sum > 0) {
				r--;
			} else
				break;
		}
		System.out.println(arr[minFirst] + "," + arr[minSecond]);
	}

	private void findCloseBruteForce(int[] arr) {

		if (arr.length < 2) {
			System.out.println("invalid input");
			return;
		}

		int minFirst = 0;
		int minSecond = 1;
		int minSum = Math.abs(arr[0] + arr[1]);

		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {

				int sum = Math.abs(arr[i] + arr[j]);
				if (sum < minSum) {
					minSum = sum;
					minFirst = arr[i];
					minSecond = arr[j];

				}
			}
		}

		System.out.println(minFirst + "," + minSecond);

	}

}
