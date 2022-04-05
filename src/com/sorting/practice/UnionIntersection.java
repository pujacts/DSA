package com.sorting.practice;

import java.util.Arrays;

public class UnionIntersection {

	public static void main(String[] args) {
		int[] arr1 = { 1, 11, 2, 3, 14, 5, 6, 8, 9 };
		int[] arr2 = { 2, 4, 5, 12, 7, 8, 13, 10 };

		findUnionAndIntersection(arr1, arr2);

	}

	private static void findUnionAndIntersection(int[] arr1, int[] arr2) {
		Arrays.sort(arr1);
		Arrays.sort(arr2);

		int[] unionArr = new int[arr1.length + arr2.length];

		int[] interArr = new int[Math.min(arr1.length, arr2.length)];

		int unionIdx = 0;
		int interIdx = 0;
		int first = 0;
		int second = 0;
		while (first < arr1.length && second < arr2.length) {

			if (arr1[first] == arr2[second]) {
				unionArr[unionIdx++] = arr1[first];
				interArr[interIdx++] = arr1[first];
				first++;
				second++;
			} else if (arr1[first] < arr2[second]) {
				unionArr[unionIdx++] = arr1[first++];
			} else {
				unionArr[unionIdx++] = arr2[second++];
			}
		}

		while (first < arr1.length) {
			unionArr[unionIdx++] = arr1[first++];
		}

		while (second < arr2.length) {
			unionArr[unionIdx++] = arr2[second++];
		}

		printarray(unionArr);
		printarray(interArr);
	}

	private static void printarray(int[] arr) {

		for (int a : arr) {
			System.out.print(a + " ");
		}
		System.out.println();
	}
}
