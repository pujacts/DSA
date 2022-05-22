package com.search;

import java.util.Arrays;
import java.util.HashSet;

public class ApProgression {

	public static void main(String[] args) {

		int[] arr = { 20, 25, 15, 5, 0, 10, 35, 30 };

		System.out.println(check(arr));
		System.out.println(checkHash(arr));
		System.out.println(checkUsingIndex(arr));
	}

	// page 151
	private static boolean checkUsingIndex(int[] arr) {

		int firstMin = Integer.MAX_VALUE;
		int secondMin = Integer.MAX_VALUE;
		int size = arr.length;
		for (int i = 0; i < size; i++) {
			if (arr[i] < firstMin) {
				secondMin = firstMin;
				firstMin = arr[i];
				
			} else if (arr[i] < secondMin) {
				secondMin = arr[i];
			}
		}

		int diff = secondMin - firstMin;
		int[] count = new int[size];
		for (int i = 0; i < size; i++) {
			int index = (arr[i] - firstMin) / diff;

			if (index > size - 1 || count[index] != 0) {
				return false;
			}
			count[index] = 1;
		}

		for (int i = 0; i < size; i++) {
			if (count[i] != 1) {
				return false;
			}
		}
		return true;
	}

	// find first and second minimum , find the difference,
	// add all value in the hashtable and than compare if euqlas firstMin+ i*diff
	private static boolean checkHash(int[] arr) {

		int size = arr.length;
		int firstMin = Integer.MAX_VALUE;
		int secondMin = Integer.MAX_VALUE;

		for (int i = 0; i < size; i++) {
			if (arr[i] < firstMin) {
				secondMin = firstMin;
				firstMin = arr[i];
				
			} else if (arr[i] < secondMin) {
				secondMin = arr[i];
			}
		}

		int diff = secondMin - firstMin;
		HashSet<Integer> set = new HashSet<>();

		for (int a : arr) {
			if (set.contains(a)) {
				return false;
			}
			set.add(a);
		}
		for (int i = 0; i < size; i++) {
			if (!set.contains(firstMin + i * diff)) {
				return false;
			}
		}

		return true;
	}

	private static boolean check(int[] arr) {

		if (arr.length == 1) {
			return false;
		}

		Arrays.sort(arr);

		int diff = arr[1] - arr[0];

		for (int i = 2; i < arr.length; i++) {
			if (arr[i] - arr[i - 1] != diff) {
				return false;
			}
		}

		return true;

	}

}
