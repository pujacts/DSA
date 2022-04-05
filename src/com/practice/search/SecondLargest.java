package com.practice.search;

import java.util.Arrays;

public class SecondLargest {

	public static void main(String[] args) {

		SecondLargest sl = new SecondLargest();
		int[] arr = { 12, 35, 1, 10, 34, 1 };

		sl.find(arr);
		System.out.println("------------------------------------");
		sl.find2(arr);
		System.out.println("------------------------------------");
		sl.find3(arr);
	}

	private void find3(int[] arr) {
		int size = arr.length;
		if (size == 2) {
			System.out.println("invalid input");
			return;
		}
		int max = Arrays.stream(arr).max().getAsInt();
		int secondMax = Integer.MIN_VALUE;
		for (int i = 0; i < size; i++) {
			if (arr[i] != max)
				secondMax = Math.max(secondMax, arr[i]);
		}

		System.out.println("second largest element is :" + secondMax);
	}

	private void find2(int[] arr) {
		int size = arr.length;
		if (size == 2) {
			System.out.println("invalid input");
			return;
		}
		int first = Integer.MIN_VALUE;
		int second = Integer.MIN_VALUE;
		for (int i = 0; i < size; i++) {
			if (arr[i] > first) {
				second = first;
				first = arr[i];
			} else if (arr[i] != first && arr[i] > second) {
				second = arr[i];
			}

		}

		System.out.println("second largest element is :" + second);

	}

	private void find(int[] arr) {

		int size = arr.length;
		if (size == 2) {
			System.out.println("invalid input");
			return;
		}
		Arrays.sort(arr);

		for (int i = size - 2; i >= 0; i--) {
			if (arr[i] != arr[size - 1]) {
				System.out.println("second largest element is :" + arr[i]);
				return;
			}
		}

	}

}
